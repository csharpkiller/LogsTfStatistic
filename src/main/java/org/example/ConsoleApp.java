package org.example;

import org.example.analys.Metric;
import org.example.analys.AnalysisService;
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
                if (!searchData.getPlayerId().isValidId()) {
                    System.out.println("steam id is not valid");
                } else {
                    startLoadingAnimation(); //Включаем анимацию

                    List<PlayerMatchData> playerMatchData = service.getPlayerResults(searchData);

                    stopLoadingAnimation(); //Останавливаем анимацию

                    List<BasedPlayerResults> results = playerMatchData.stream()
                            .map(PlayerMatchData::getBasedPlayerResults)
                            .collect(Collectors.toList());

                    printResults(results);

                    AnalysisService analysisService = new AnalysisService();
                    List<Metric> metricList = analysisService.getAnalysisData(playerMatchData);
                    metricList.forEach(Printable::print);
                }
            } catch (Exception e) {
                stopLoadingAnimation(); // если произошла ошибка — всё равно останавливаем
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
        SearchRangeType rangeType = SearchRangeType.MATCH_COUNT;
        Boolean isServerMe = readBoolean();
        List<String> ignoreTitles = readList();
        List<GameHero> heroes = readEnumList("Введите имена героев через запятую, доступные имена [SCOUT, SOLDIER, DEMOMAN, HEAVY, ENJIE, MEDIC, SNIPER, SPY]: ", GameHero.class);
        int count = readInt();
        List<GameMode> modes = readEnumList("Введите режимы игры через запятую, доступные режимы [SIXES, HIGHLANDER, ULTIDUO_BBAL]: ", GameMode.class);
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
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
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
        System.out.print("Введите игнорируемые заголовки через запятую, например, tf2center: ");
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

    /**
     * поток загрузки
     */
    private volatile Thread loadingThread;

    /**
     * в процессе загрузки
     */
    private volatile boolean isLoading = true;

    /**
     * Начать анимацию загрузки
     */
    private void startLoadingAnimation() {
        final char[] wheel = {'-', '\\', '|', '/'};
        isLoading = true;

        loadingThread = new Thread(() -> {
            int i = 0;
            try {
                while (isLoading && !Thread.currentThread().isInterrupted()) {
                    System.out.print("\r[" + wheel[i] + "] Загрузка данных... ");
                    i = (i + 1) % wheel.length;
                    Thread.sleep(200); // скорость анимации
                }
            } catch (InterruptedException ignored) {
            } finally {
                System.out.println("\r[✔] Данные загружены.");
            }
        });

        loadingThread.setDaemon(true);
        loadingThread.start();
    }

    /**
     * Закончить анимацию загрузки
     */
    private void stopLoadingAnimation() {
        isLoading = false;
        if (loadingThread != null && loadingThread.isAlive()) {
            loadingThread.interrupt();
        }
    }
}
