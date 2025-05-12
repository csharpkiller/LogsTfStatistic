package org.example.analys;

import org.example.search.info.GameHero;
import org.example.search.info.GameResult;
import org.example.search.info.PlayerMatchData;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Метрика процент побед на персонажах
 */
public class WinRateOnHeroesMetric implements Metric {

    /**
     * Название метрики
     */
    private final String name = "Win Rate by Heroes";

    /**
     * Описание метрики
     */
    private final String description = "Процент побед по каждому герою";

    /**
     * Результаты метрики:
     * Ключ - Персонаж
     * Значение - контейнер (кол-во игр, процент побед)
     */
    private Map<GameHero, WinRateStats> heroStatsMap = new HashMap<>();

    @Override
    public boolean compute(List<PlayerMatchData> results) {
        if(results == null){
            return false;
        }

        if (results.isEmpty()) {
            return false;
        }

        heroStatsMap = calculateHeroWinRate(results);
        return true;
    }

    /**
     * Посчитать процент побед по каждому герою.
     * @param playerMatchData список результатов матча игрока
     * @return результат метрики
     */
    private Map<GameHero, WinRateStats> calculateHeroWinRate(List<PlayerMatchData> playerMatchData) {
        Map<GameHero, WinRateStats> heroStatsMap = new HashMap<>();
        for (PlayerMatchData data : playerMatchData) {
            GameHero hero = data.getBasedPlayerResults().getGameHero();
            GameResult result = data.getBasedPlayerResults().getGameResult();

            heroStatsMap.putIfAbsent(hero, new WinRateStats());
            WinRateStats stats = heroStatsMap.get(hero);

            stats.increaseTotalGames();

            if (result == GameResult.WIN) {
                stats.increaseWins();
            }
        }

        heroStatsMap.forEach((hero, winrates) ->{
            winrates.closeToChange();
        });
        return heroStatsMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n").append(description).append("\n");

        heroStatsMap.forEach((hero, stats) -> {
            sb.append("Герой: ").append(hero.toString()).append("\n");
            sb.append("\tИгр: ").append(stats.getTotalGames()).append("\n");
            sb.append("\tWin Rate: ").append(String.format("%.2f", stats.getWinRate())).append("%\n");
        });

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

    public Map<GameHero, WinRateStats> getHeroStatsMap() {
        return new HashMap<>(heroStatsMap);
    }
}