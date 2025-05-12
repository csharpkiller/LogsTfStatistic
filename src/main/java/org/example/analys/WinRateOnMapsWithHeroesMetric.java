package org.example.analys;

import org.example.search.info.GameHero;
import org.example.search.info.PlayerMatchData;
import org.example.search.info.GameResult;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Метрика процент побед на карте по персонажам
 */
public class WinRateOnMapsWithHeroesMetric implements Metric {

    /**
     * Название метрики
     */
    private final String name = "Win Rate by Maps and Heroes";

    /**
     * Описание метрики
     */
    private final String description = "Процент побед по картам с разбивкой по героям";

    /**
     * Результат метрики
     * Ключ - название карты
     * Значение -
     *          ключ - персонаж
     *          значение - контейнер (кол-во игр, процент побед)
     */
    private Map<String, Map<GameHero, WinRateStats>> mapHeroWinRateMap = new HashMap<>();

    @Override
    public boolean compute(List<PlayerMatchData> results) {
        if(results == null){
            return false;
        }

        if (results.isEmpty()) {
            return false;
        }

        mapHeroWinRateMap = calculateWinRateOnMapsWithHero(results);
        return true;
    }

    /**
     * Считает кол-во игр и winrate для каждого героя на определенной карте
     * @param playerResults список результатов матча игрока
     * @return результат метрики
     */
    private Map<String, Map<GameHero, WinRateStats>> calculateWinRateOnMapsWithHero(List<PlayerMatchData> playerResults){
        Map<String, Map<GameHero, WinRateStats>> mapHeroWinRateMap = new HashMap<>();
        GameMapFormat gameMapFormat = new GameMapFormat();

        for (PlayerMatchData data : playerResults) {
            String rawMapName = data.getBasedPlayerResults().getMap();
            String mapName = gameMapFormat.ignoreMapVersion(rawMapName);

            GameHero hero = data.getBasedPlayerResults().getGameHero();
            GameResult result = data.getBasedPlayerResults().getGameResult();

            mapHeroWinRateMap.putIfAbsent(mapName, new HashMap<>());

            Map<GameHero, WinRateStats> heroStats = mapHeroWinRateMap.get(mapName);
            heroStats.putIfAbsent(hero, new WinRateStats());
            WinRateStats stats = heroStats.get(hero);

            stats.increaseTotalGames();
            if (result == GameResult.WIN) {
                stats.increaseWins();
            }
        }

        /**
         * TODO я совсем тю-тю?
         * Можно по-нормальному поработать с WinRateStats,
         * после вернуть другой контейнер с финальными результатами без прикола с .closeToChange() )))
         */
        mapHeroWinRateMap.forEach((map, value) -> {
            value.forEach((hero, stat) ->{
                stat.closeToChange();
            });
        });

        return mapHeroWinRateMap;
    }

    @Override
    public void print() {
        System.out.println();
        System.out.println(description);

        for (Map.Entry<String, Map<GameHero, WinRateStats>> mapEntry : mapHeroWinRateMap.entrySet()) {
            String mapName = mapEntry.getKey();
            Map<GameHero, WinRateStats> heroStats = mapEntry.getValue();

            System.out.printf("Карта: %s%n", mapName);

            for (Map.Entry<GameHero, WinRateStats> heroEntry : heroStats.entrySet()) {
                GameHero hero = heroEntry.getKey();
                WinRateStats stats = heroEntry.getValue();

                System.out.printf("\tГерой: %s%n", hero);
                System.out.printf("\t\tИгр: %d%n", stats.getTotalGames());
                System.out.printf("\t\tПобед: %.2f%%%n", stats.getWinRate());
            }
            System.out.println();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Map<String, Map<GameHero, WinRateStats>> getMapHeroWinRateMap() {
        return new HashMap<>(mapHeroWinRateMap);
    }
}