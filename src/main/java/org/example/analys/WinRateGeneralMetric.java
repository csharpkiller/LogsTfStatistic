package org.example.analys;
import org.example.search.info.GameResult;
import org.example.search.info.PlayerMatchData;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Метрика процент побед
 */
public class WinRateGeneralMetric implements Metric{

    /**
     * Название метрики
     */
    private final String name = "Win Rate";

    /**
     * Описание метрики
     */
    private final String description = "Общий процент побед";

    /**
     * Общий процент побед
     */
    private Double winRate = 0.;

    /**
     * Процент ничьи
     */
    private Double drawRate = 0.;

    @Override
    public boolean compute(List<PlayerMatchData> results){
        if(results == null){
            return false;
        }

        if(results.isEmpty()){
            return false;
        }

        List<Double> rates  = calculateGeneralWinRate(results);
        winRate = rates.get(0);
        drawRate = rates.get(1);

        return true;
    }

    /**
     * Посчитать общий процент побед/ничей.
     * @param playerMatchData исходные данные
     */
    private List<Double> calculateGeneralWinRate(List<PlayerMatchData> playerMatchData){
        long wins = 0;
        long draws = 0;
        int countOfMatches = playerMatchData.size();

        for (PlayerMatchData data : playerMatchData) {
            GameResult result = data.getBasedPlayerResults().getGameResult();
            if (result == GameResult.WIN) {
                wins++;
            } else if (result == GameResult.DRAW) {
                draws++;
            }
        }
        winRate = (wins * 100.0) / countOfMatches;
        drawRate = (draws * 100.0) / countOfMatches;
        return List.of(winRate, drawRate);
    }

    @Override
    public void print() {
        System.out.println();
        System.out.println(description);
        System.out.printf("Win Rate: %.2f%%%n", winRate);
        System.out.printf("Draw Rate: %.2f%%%n", drawRate);
    }

    public Double getWinRate() {
        return winRate;
    }

    public Double getDrawRate() {
        return drawRate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
