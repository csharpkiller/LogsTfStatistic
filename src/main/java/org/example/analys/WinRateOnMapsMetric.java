package org.example.analys;

import org.example.search.info.PlayerMatchData;
import org.example.search.info.GameResult;

import java.util.*;

/**
 * Метрика процент побед на картах
 */
public class WinRateOnMapsMetric implements Metric {

    /**
     * Название метрики
     */
    private final String name = "Win Rate by Maps";

    /**
     * Описание метрики
     */
    private final String description = "Процент побед по картам";

    /**
     * Результат метрики
     * Ключ - название карты
     * Значение - контейнер (кол-во игр, процент побед)
     */
    private Map<String, WinRateStats> mapWinRateMap = new HashMap<>();

    @Override
    public boolean compute(List<PlayerMatchData> results) {
        if(results == null){
            return false;
        }

        if (results.isEmpty()) {
            return false;
        }

        mapWinRateMap = calculateWinRateOnMap(results);
        return true;
    }

    /**
     * Считат кол-во игр и процент побед на карте
     * @param playerMatchData список результатов матча игрока
     * @return результат метрики
     */
    private Map<String, WinRateStats> calculateWinRateOnMap(List<PlayerMatchData> playerMatchData){
        GameMapFormat gameMapFormat = new GameMapFormat();
        Map<String, WinRateStats> mapWinRateMap = new HashMap<>();

        for (PlayerMatchData data : playerMatchData) {
            String mapName = gameMapFormat.ignoreMapVersion(data.getBasedPlayerResults().getMap());
            GameResult result = data.getBasedPlayerResults().getGameResult();

            mapWinRateMap.putIfAbsent(mapName, new WinRateStats());
            WinRateStats stats = mapWinRateMap.get(mapName);

            stats.increaseTotalGames();
            if (result == GameResult.WIN) {
                stats.increaseWins();
            }
        }

        mapWinRateMap.forEach((map, winrate) ->{
            winrate.closeToChange();
        });
        return mapWinRateMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n").append(description).append("\n");

        mapWinRateMap.forEach((map, stats) -> {
            sb.append("Карта: ").append(map).append("\n");
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

    public Map<String, WinRateStats> getMapWinRateMap() {
        return new HashMap<>(mapWinRateMap);
    }
}