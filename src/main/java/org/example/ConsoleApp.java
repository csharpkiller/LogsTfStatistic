package org.example;

import org.example.search.info.*;
import org.example.search.info.objectwrappers.SteamID;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс для работы с консолью
 */
public class ConsoleApp {

    private final Scanner scanner;
    private final DataExtractorService service;

    public ConsoleApp() {
        scanner = new Scanner(System.in);
        service = new DataExtractorService();
    }

    /**
     * Запуск консольного приложения
     */
    public void run() {
        System.out.println("=== Поиск статистики игрока ===");

        while (true) {
            try {
                SearchData searchData = buildSearchData();
                if(!searchData.getPlayerId().isValidId()){
                    System.out.println("steam id is not valid");
                }
                else {
                    List<BasedPlayerResults> results = service.getPlayerResults(searchData);
                    printResults(results);
                }
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }

            System.out.print("Хотите выполнить еще один поиск? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (!input.equals("yes")) {
                break;
            }
        }

        System.out.println("Завершение работы.");
    }

    /**
     * Конвертация входящих данных в SearchData
     * @return параметры пользователя
     */
    private SearchData buildSearchData() {
        SteamID steamID = new SteamID(readString());

        SearchRangeType rangeType = readEnum();

        Boolean isServerMe = readBoolean();

        List<String> ignoreTitles = readList();

        List<GameHero> heroes = readEnumList("Введите имена героев через запятую: ", GameHero.class);

        int count = readInt();

        List<GameMode> modes = readEnumList("Введите режимы игры через запятую: ", GameMode.class);

        return new SearchData(steamID, rangeType, isServerMe, ignoreTitles, heroes, count, modes);
    }

    /**
     * Вывод результатов в консоль
     * @param results список результатов по запросу
     */
    private void printResults(List<BasedPlayerResults> results) {
        System.out.println("=== Результаты поиска ===");
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
            return;
        }

        for (Printable r : results) {
            r.print();
        }
    }


    /**
     * Чтение с консоли и конвертация
     * @return steam id игрока
     */
    private String readString() {
        System.out.print("Введите Steam ID игрока: ");
        return scanner.nextLine().trim();
    }

    /**
     * Чтение с консоли и конвертация
     * @return кол-во матчей
     */
    private int readInt() {
        while (true) {
            try {
                System.out.print("Введите количество матчей: ");
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    /**
     * Чтение с консоли и конвертация
     * @return isServeme search
     */
    private Boolean readBoolean() {
        while (true) {
            System.out.print("Искать только матчи с serveme? (true/false): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.println("Ошибка: введите 'true' или 'false'.");
        }
    }

    /**
     * Чтение с консоли и конвертация
     * @return список igonredTitle
     */
    private List<String> readList() {
        System.out.print("Введите игнорируемые заголовки через запятую: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return Collections.emptyList();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    /**
     * Чтение с консоли и конвертация
     * @return тип диапозона
     */
    private <T extends Enum<T>> T readEnum() {
        while (true) {
            System.out.print("Введите тип диапазона поиска (MATCH_COUNT): ");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                return Enum.valueOf((Class<T>) SearchRangeType.class, input);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: допустимые значения: " + Arrays.toString(((Class<T>) SearchRangeType.class).getEnumConstants()));
            }
        }
    }

    /**
     * Чтение с консоли и конвертация
     * @param prompt что напечатать в консоль
     * @param enumClass класс Enum'a
     * @return Список персонажей/игровых режимов
     * @param <T> GameHero/GameMode
     */
    private <T extends Enum<T>> List<T> readEnumList(String prompt, Class<T> enumClass) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return Collections.emptyList();

        List<T> result = new ArrayList<>();
        Set<String> validNames = Arrays.stream(enumClass.getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toSet());

        for (String token : input.split(",")) {
            String trimmed = token.trim().toUpperCase();
            try {
                result.add(Enum.valueOf(enumClass, trimmed));
            } catch (IllegalArgumentException e) {
                System.out.printf(
                        "Предупреждение: значение '%s' пропущено, так как оно недопустимо. Допустимые значения: %s%n",
                        trimmed, validNames
                );
            }
        }
        return result;
    }
}
