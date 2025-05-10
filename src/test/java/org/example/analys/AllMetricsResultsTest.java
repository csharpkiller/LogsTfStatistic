package org.example.analys;

import org.example.search.info.*;
import org.example.search.info.objectwrappers.SteamID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AllMetricsResultsTest {
    private SteamID steamID;
    private final SearchRangeType searchRangeType = SearchRangeType.MATCH_COUNT;
    private boolean isServemeSearch;
    private List<String> ignoreTitles;
    private List<GameHero> searchHeroes;
    private Integer count;
    private List<GameMode> searchGameModes;

    private DataExtractorService dataExtractorService;
    private SearchData searchData;
    private AnalysisService analysisService;
    private final List<Metric> allMetrics = List.of(
            new KDAByHeroMetric(),
            new WinRateGeneralMetric(),
            new WinRateOnMapsMetric(),
            new WinRateOnHeroesMetric(),
            new WinRateOnMapsWithHeroesMetric()
    );

    @BeforeEach
    public void setUp(){
        steamID = new SteamID("76561197987681768");
        isServemeSearch = false;
        ignoreTitles = List.of();
        searchHeroes = List.of();
        count = 10;
        searchGameModes = List.of();
        dataExtractorService = new DataExtractorService();
        analysisService = new AnalysisService();
    }

    private void uppdateSearchData(){
        searchData = new SearchData(
                steamID,
                searchRangeType,
                isServemeSearch,
                ignoreTitles,
                searchHeroes,
                count,
                searchGameModes
        );
    }

    /**
     * Передача null
     */
    @Test
    void nullProblemTest(){
        allMetrics.forEach(metric -> {
            assertFalse(metric.compute(null));
        });
    }

    /**
     * Передача пустого списка
     */
    @Test
    void emptyListProblemTest(){
        allMetrics.forEach(metric -> {
            assertFalse(metric.compute(List.of()));
        });
    }

    /**
     * Ожидаемые значения
     */
    @Test
    void expectedValuesFromTheProblemStatementTest() {
        searchHeroes = List.of(GameHero.SOLDIER, GameHero.SCOUT);
        count = 20;
        uppdateSearchData();

        List<Metric> metricList = analysisService.getAnalysisData(dataExtractorService.getPlayerResults(searchData));
        double error = 0.05;
        List<String> missingNamesOfMetrics = new ArrayList<>();

        metricList.forEach(metric -> {
            if (metric instanceof KDAByHeroMetric) {
                Map<GameHero, KDAStats> resMap = ((KDAByHeroMetric) metric).getHeroKdaMap();
                assertEquals(16.0, resMap.get(GameHero.SCOUT).getAverageKills(), error);
                assertEquals(19.5, resMap.get(GameHero.SCOUT).getAverageDeaths(), error);
                assertEquals(7.0, resMap.get(GameHero.SCOUT).getAverageAssists(), error);
                assertEquals(0.82, resMap.get(GameHero.SCOUT).getKdRatio(), error);
                assertEquals(2, resMap.get(GameHero.SCOUT).getTotalGames());

                assertEquals(15.4, resMap.get(GameHero.SOLDIER).getAverageKills(), error);
                assertEquals(16.6, resMap.get(GameHero.SOLDIER).getAverageDeaths(), error);
                assertEquals(6.2, resMap.get(GameHero.SOLDIER).getAverageAssists(), error);
                assertEquals(0.93, resMap.get(GameHero.SOLDIER).getKdRatio(), error);
                assertEquals(18, resMap.get(GameHero.SOLDIER).getTotalGames());
            }

            else if (metric instanceof WinRateGeneralMetric generalMetric) {
                assertEquals(35.0, generalMetric.getWinRate(), error);
                assertEquals(5.0, generalMetric.getDrawRate(), error);
            }

            else if (metric instanceof WinRateOnHeroesMetric winRateOnHeroesMetric) {
                Map<GameHero, WinRateStats> resMap = winRateOnHeroesMetric.getHeroStatsMap();
                assertEquals(50.0, resMap.get(GameHero.SCOUT).getWinRate(), error);
                assertEquals(2, resMap.get(GameHero.SCOUT).getTotalGames());

                assertEquals(33.33, resMap.get(GameHero.SOLDIER).getWinRate(), error);
                assertEquals(18, resMap.get(GameHero.SOLDIER).getTotalGames());
            }

            else if (metric instanceof WinRateOnMapsMetric winRateOnMapsMetric) {
                Map<String, WinRateStats> resMap = winRateOnMapsMetric.getMapWinRateMap();

                assertEquals(60.0, resMap.get("cp_snakewater").getWinRate(), error);
                assertEquals(5, resMap.get("cp_snakewater").getTotalGames());

                assertEquals(33.33, resMap.get("cp_sunshine").getWinRate(), error);
                assertEquals(3, resMap.get("cp_sunshine").getTotalGames());

                assertEquals(0.0, resMap.get("cp_reckoner").getWinRate(), error);
                assertEquals(1, resMap.get("cp_reckoner").getTotalGames());

                assertEquals(66.67, resMap.get("cp_granary").getWinRate(), error);
                assertEquals(3, resMap.get("cp_granary").getTotalGames());

                assertEquals(0.0, resMap.get("cp_process").getWinRate(), error);
                assertEquals(2, resMap.get("cp_process").getTotalGames());

                assertEquals(100.0, resMap.get("cp_gullywash").getWinRate(), error);
                assertEquals(1, resMap.get("cp_gullywash").getTotalGames());

                assertEquals(0.0, resMap.get("cp_Gullywash").getWinRate(), error);
                assertEquals(1, resMap.get("cp_Gullywash").getTotalGames());

                assertEquals(0.0, resMap.get("cp_badlands").getWinRate(), error);
                assertEquals(4, resMap.get("cp_badlands").getTotalGames());
            }
            else if (metric instanceof WinRateOnMapsWithHeroesMetric) {
                Map<String, Map<GameHero, WinRateStats>> resMap
                        = ((WinRateOnMapsWithHeroesMetric) metric).getMapHeroWinRateMap();

                assertEquals(50.0, resMap.get("cp_snakewater").get(GameHero.SOLDIER).getWinRate(), error);
                assertEquals(4, resMap.get("cp_snakewater").get(GameHero.SOLDIER).getTotalGames());

                assertEquals(100.0, resMap.get("cp_snakewater").get(GameHero.SCOUT).getWinRate(), error);
                assertEquals(1, resMap.get("cp_snakewater").get(GameHero.SCOUT).getTotalGames());

                assertEquals(50.0, resMap.get("cp_sunshine").get(GameHero.SOLDIER).getWinRate(), error);
                assertEquals(2, resMap.get("cp_sunshine").get(GameHero.SOLDIER).getTotalGames());

                assertEquals(0.0, resMap.get("cp_sunshine").get(GameHero.SCOUT).getWinRate(), error);
                assertEquals(1, resMap.get("cp_sunshine").get(GameHero.SCOUT).getTotalGames());

                assertEquals(0.0, resMap.get("cp_reckoner").get(GameHero.SOLDIER).getWinRate(), error);
                assertEquals(1, resMap.get("cp_reckoner").get(GameHero.SOLDIER).getTotalGames());

                assertEquals(66.67, resMap.get("cp_granary").get(GameHero.SOLDIER).getWinRate(), error);
                assertEquals(3, resMap.get("cp_granary").get(GameHero.SOLDIER).getTotalGames());

                assertEquals(0.0, resMap.get("cp_process").get(GameHero.SOLDIER).getWinRate(), error);
                assertEquals(2, resMap.get("cp_process").get(GameHero.SOLDIER).getTotalGames());

                assertEquals(100.0, resMap.get("cp_gullywash").get(GameHero.SOLDIER).getWinRate(), error);
                assertEquals(1, resMap.get("cp_gullywash").get(GameHero.SOLDIER).getTotalGames());

                assertEquals(0.0, resMap.get("cp_Gullywash").get(GameHero.SOLDIER).getWinRate(), error);
                assertEquals(1, resMap.get("cp_Gullywash").get(GameHero.SOLDIER).getTotalGames());

                assertEquals(0.0, resMap.get("cp_badlands").get(GameHero.SOLDIER).getWinRate(), error);
                assertEquals(4, resMap.get("cp_badlands").get(GameHero.SOLDIER).getTotalGames());
            }else
            {
                missingNamesOfMetrics.add(metric.getName());
            }

            if(!missingNamesOfMetrics.isEmpty()){
                missingNamesOfMetrics.forEach(nameOfMetric ->{
                    System.out.println("не хватает теста для " + nameOfMetric);
                });
                assertTrue(false);
            }
        });
    }
}