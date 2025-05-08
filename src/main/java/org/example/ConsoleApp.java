package org.example;

import org.example.search.info.*;
import org.example.search.info.objectwrappers.SteamID;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleApp {

    private final Scanner scanner = new Scanner(System.in);
    private final DataExtractorService service = new DataExtractorService();

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

    private SearchData buildSearchData() {
        SteamID steamID = new SteamID(readString("Введите Steam ID игрока: "));

        SearchRangeType rangeType = readEnum("Введите тип диапазона поиска (MATCH_COUNT): ", SearchRangeType.class);

        Boolean isServerMe = readBoolean("Искать только матчи с serveme? (true/false): ");

        List<String> ignoreTitles = readList("Введите игнорируемые заголовки через запятую: ");

        List<GameHero> heroes = readEnumList("Введите имена героев через запятую: ", GameHero.class);

        int count = readInt("Введите количество матчей: ");

        List<GameMode> modes = readEnumList("Введите режимы игры через запятую: ", GameMode.class);

        return new SearchData(steamID, rangeType, isServerMe, ignoreTitles, heroes, count, modes);
    }

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

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    private Boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.println("Ошибка: введите 'true' или 'false'.");
        }
    }

    private List<String> readList(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return Collections.emptyList();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    private <T extends Enum<T>> T readEnum(String prompt, Class<T> enumClass) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                return Enum.valueOf(enumClass, input);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: допустимые значения: " + Arrays.toString(enumClass.getEnumConstants()));
            }
        }
    }

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
