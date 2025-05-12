package org.example.analys;

import org.example.search.info.BasedPlayerResults;
import org.example.search.info.GameHero;
import org.example.search.info.PlayerMatchData;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Метрика average kills, deaths, assists, k/d
 */
public class KDAByHeroMetric implements Metric {

    /**
     * Название метрики
     */
    private final String name = "KDA by Heroes";

    /**
     * Описание метрики
     */
    private final String description = "Средние значения K/D/A по героям";

    /**
     * Словарь, ключ-персонаж, значение - контейнер с Average Kills Deaths Assists
     */
    private Map<GameHero, KDAStats> heroKdaMap = new HashMap<>();

    @Override
    public boolean compute(List<PlayerMatchData> results) {
        if(results == null){
            return false;
        }

        if (results.isEmpty()) {
            return false;
        }
        heroKdaMap = calculateKdaForGameHeroInGames(results);
        return true;
    }

    /**
     * Посчитать значения kills deaths assists для каждого персонажа
     * @param results результаты матча игрока
     * @return словарь, ключ - персонаж, значение - kdaStats с возможностью получить average k/d/a через .get
     */
    private Map<GameHero, KDAStats> calculateKdaForGameHeroInGames(List<PlayerMatchData> results){
        Map<GameHero, KDAStats> heroKdaMap = new HashMap<>();
        for (PlayerMatchData data : results) {
            BasedPlayerResults stats = data.getBasedPlayerResults();
            GameHero hero = data.getBasedPlayerResults().getGameHero();

            heroKdaMap.putIfAbsent(hero, new KDAStats());
            KDAStats kdaStats = heroKdaMap.get(hero);

            kdaStats.addKill(stats.getKills());
            kdaStats.addDeath(stats.getDeaths());
            kdaStats.addAssist(stats.getAssists());
            kdaStats.incrementGames();
        }
        return heroKdaMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(description).append("\n");

        for (Map.Entry<GameHero, KDAStats> entry : heroKdaMap.entrySet()) {
            GameHero hero = entry.getKey();
            KDAStats stats = entry.getValue();

            double avgKills = stats.getAverageKills();
            double avgDeaths = stats.getAverageDeaths();
            double avgAssists = stats.getAverageAssists();
            double kd = stats.getKdRatio();
            int games = stats.getTotalGames();

            sb.append("Герой: ").append(hero.toString()).append("\n");
            sb.append("\tИгр: ").append(games).append("\n");
            sb.append("\taverage (KDA): ")
                    .append(String.format("%.1f / %.1f / %.1f", avgKills, avgDeaths, avgAssists))
                    .append("\n");
            sb.append("\taverage (K/D): ")
                    .append(String.format("%.2f", kd))
                    .append("\n");
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Map<GameHero, KDAStats> getHeroKdaMap() {
        return new HashMap<>(heroKdaMap);
    }
}