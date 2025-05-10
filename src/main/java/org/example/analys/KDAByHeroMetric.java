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

    private final String name = "KDA by Heroes"; //На
    private final String description = "Средние значения K/D/A по героям";

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
    public void print() {
        System.out.println(description);
        for (Map.Entry<GameHero, KDAStats> entry : heroKdaMap.entrySet()) {
            GameHero hero = entry.getKey();
            KDAStats stats = entry.getValue();

            double avgKills = stats.getAverageKills();
            double avgDeaths = stats.getAverageDeaths();
            double avgAssists = stats.getAverageAssists();
            double kd = stats.getKdRatio();
            int games = stats.getTotalGames();

            System.out.printf("Герой: %s%n", hero);
            System.out.printf("\tИгр: %d%n", games);
            System.out.printf("\taverage (KDA): %.1f / %.1f / %.1f%n", avgKills, avgDeaths, avgAssists);
            System.out.printf("\taverage (K/D): %.2f%n", kd);
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

    public Map<GameHero, KDAStats> getHeroKdaMap() {
        return new HashMap<>(heroKdaMap);
    }
}