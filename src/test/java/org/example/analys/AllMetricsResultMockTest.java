package org.example.analys;

import org.example.requestResults.RequestResponseMatchResultDataForTests;
import org.example.search.info.*;
import org.example.search.info.objectwrappers.Json;
import org.example.search.info.objectwrappers.SteamID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
class AllMetricsResultMockTest {
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

    @Mock
    private JsonFetcher jsonFetcher;

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

        MatchExtractorService matchExtractorService = new MatchExtractorService(jsonFetcher);
        dataExtractorService = new DataExtractorService(matchExtractorService, jsonFetcher, 50);

        Mockito.when(jsonFetcher.getJsonFromUrl("http://logs.tf/api/v1/log?player=76561197987681768&offset=0&limit=51")).thenReturn(new Json("{\"success\":true,\"results\":51,\"total\":3203,\"parameters\":{\"player\":\"76561197987681768\",\"uploader\":null,\"title\":null,\"map\":null,\"limit\":51,\"offset\":0},\"logs\":[{\"id\":1980809,\"title\":\"PugChamp EU Open #3: RED vs BLU\",\"map\":\"cp_snakewater_final1\",\"date\":1520868091,\"views\":253,\"players\":12},{\"id\":1970141,\"title\":\"PugChamp EU Open #3: RED vs BLU\",\"map\":\"cp_process_final\",\"date\":1519827363,\"views\":140,\"players\":12},{\"id\":1967781,\"title\":\"PugChamp EU Open #1: RED vs BLU\",\"map\":\"cp_snakewater_final1\",\"date\":1519579007,\"views\":149,\"players\":12},{\"id\":1964891,\"title\":\"serveme.tf #761583 - BLU vs RED\",\"map\":\"cp_snakewater_final1\",\"date\":1519335065,\"views\":216,\"players\":12},{\"id\":1964850,\"title\":\"serveme.tf #761583 - BLU vs RED\",\"map\":\"cp_granary_pro_rc8\",\"date\":1519333095,\"views\":177,\"players\":12},{\"id\":1944518,\"title\":\"serveme.tf #753312 - BLU vs RED\",\"map\":\"cp_sunshine\",\"date\":1517429830,\"views\":124,\"players\":12},{\"id\":1939876,\"title\":\"PugChamp EU Open #1: RED vs BLU\",\"map\":\"cp_process_final\",\"date\":1517007473,\"views\":255,\"players\":12},{\"id\":1862499,\"title\":\"serveme.tf #720157 - BLU vs RED\",\"map\":\"cp_sunshine\",\"date\":1508445748,\"views\":406,\"players\":12},{\"id\":1862471,\"title\":\"serveme.tf #720157 - BLU vs RED\",\"map\":\"cp_snakewater_final1\",\"date\":1508443673,\"views\":464,\"players\":12},{\"id\":1862407,\"title\":\"serveme.tf #720106 - BLU vs RED\",\"map\":\"cp_sunshine\",\"date\":1508441143,\"views\":157,\"players\":12},{\"id\":1862346,\"title\":\"serveme.tf #720106 - BLU vs RED\",\"map\":\"cp_snakewater_final1\",\"date\":1508438720,\"views\":324,\"players\":12},{\"id\":1742363,\"title\":\"serveme.tf - aLOLe vs RED\",\"map\":\"cp_gullywash_final1\",\"date\":1496604032,\"views\":389,\"players\":12},{\"id\":1742309,\"title\":\"serveme.tf - BLU vs aaRED\",\"map\":\"cp_reckoner_rc2\",\"date\":1496601868,\"views\":419,\"players\":12},{\"id\":1715675,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_process_final\",\"date\":1493925209,\"views\":182,\"players\":14},{\"id\":1709436,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_Gullywash_Final1\",\"date\":1493233447,\"views\":232,\"players\":12},{\"id\":1709408,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_badlands\",\"date\":1493231822,\"views\":197,\"players\":12},{\"id\":1668736,\"title\":\"nr vs lp\",\"map\":\"cp_badlands\",\"date\":1489358252,\"views\":385,\"players\":12},{\"id\":1668703,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_badlands\",\"date\":1489356024,\"views\":418,\"players\":12},{\"id\":1668650,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_granary_pro_rc4\",\"date\":1489353150,\"views\":469,\"players\":12},{\"id\":1668558,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_badlands\",\"date\":1489350257,\"views\":197,\"players\":12},{\"id\":1668486,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_granary_pro_rc4\",\"date\":1489348301,\"views\":176,\"players\":12},{\"id\":1663542,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_badlands\",\"date\":1488916342,\"views\":194,\"players\":13},{\"id\":1655307,\"title\":\"serveme.tf - BLU vs DAD\",\"map\":\"cp_granary_pro_rc3\",\"date\":1488226396,\"views\":212,\"players\":12},{\"id\":1651959,\"title\":\"PugChamp EU Open #1: RED vs BLU\",\"map\":\"cp_snakewater_u14\",\"date\":1487975728,\"views\":973,\"players\":12},{\"id\":1651887,\"title\":\"PugChamp EU Open #1: RED vs BLU\",\"map\":\"cp_badlands\",\"date\":1487972268,\"views\":209,\"players\":12},{\"id\":1651506,\"title\":\"PugChamp EU Open #3: RED vs BLU\",\"map\":\"cp_granary_pro_rc4\",\"date\":1487946736,\"views\":121,\"players\":12},{\"id\":1649262,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"koth_product_rc8\",\"date\":1487713346,\"views\":335,\"players\":13},{\"id\":1649221,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_gullywash_final1\",\"date\":1487711063,\"views\":294,\"players\":12},{\"id\":1649145,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"koth_product_rc8\",\"date\":1487708192,\"views\":193,\"players\":12},{\"id\":1649101,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_gullywash_final1\",\"date\":1487706382,\"views\":154,\"players\":12},{\"id\":1576029,\"title\":\"PugChamp EU Open #5: RED vs BLU\",\"map\":\"cp_process_final\",\"date\":1480181839,\"views\":164,\"players\":13},{\"id\":1513612,\"title\":\"top5logs - BLU vs RED\",\"map\":\"cp_snakewater_u10\",\"date\":1473107479,\"views\":219,\"players\":12},{\"id\":1513565,\"title\":\"top5logs - BLU vs qzRED\",\"map\":\"cp_badlands\",\"date\":1473105354,\"views\":235,\"players\":12},{\"id\":1513508,\"title\":\"serveme.tf - BLU vs haHAA\",\"map\":\"cp_gullywash_final1\",\"date\":1473102738,\"views\":400,\"players\":12},{\"id\":1513465,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_process_final\",\"date\":1473100662,\"views\":301,\"players\":12},{\"id\":1512728,\"title\":\"serveme.tf - BLU vs baited\",\"map\":\"cp_gullywash_final1\",\"date\":1473022183,\"views\":214,\"players\":12},{\"id\":1512683,\"title\":\"serveme.tf - BLU vs gordon\",\"map\":\"cp_badlands\",\"date\":1473019904,\"views\":254,\"players\":12},{\"id\":1512616,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_process_final\",\"date\":1473017393,\"views\":389,\"players\":12},{\"id\":1512561,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_badlands\",\"date\":1473015318,\"views\":380,\"players\":12},{\"id\":1510784,\"title\":\"PugChamp EU Open #6: RED vs BLU\",\"map\":\"cp_badlands\",\"date\":1472860305,\"views\":241,\"players\":12},{\"id\":1510715,\"title\":\"PugChamp EU Open #6: RED vs BLU\",\"map\":\"cp_reckoner_b2a\",\"date\":1472855303,\"views\":171,\"players\":12},{\"id\":1510670,\"title\":\"PugChamp EU Open #1: RED vs BLU\",\"map\":\"cp_granary_pro_rc3\",\"date\":1472852688,\"views\":123,\"players\":12},{\"id\":1510376,\"title\":\"PugChamp EU Open #1: RED vs BLU\",\"map\":\"cp_badlands\",\"date\":1472829099,\"views\":122,\"players\":12},{\"id\":1510339,\"title\":\"PugChamp EU Open #6: RED vs BLU\",\"map\":\"cp_gullywash_final1\",\"date\":1472826114,\"views\":104,\"players\":12},{\"id\":1510319,\"title\":\"PugChamp EU Open #3: RED vs BLU\",\"map\":\"cp_reckoner_b2a\",\"date\":1472824245,\"views\":193,\"players\":12},{\"id\":1510284,\"title\":\"PugChamp EU Open #2: RED vs BLU\",\"map\":\"cp_badlands\",\"date\":1472822165,\"views\":199,\"players\":12},{\"id\":1509825,\"title\":\"serveme.tf - BLU vs epic\",\"map\":\"cp_gullywash_final1\",\"date\":1472761706,\"views\":259,\"players\":12},{\"id\":1509790,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_badlands\",\"date\":1472759780,\"views\":251,\"players\":12},{\"id\":1509745,\"title\":\"serveme.tf - BLU vs sad\",\"map\":\"cp_process_final\",\"date\":1472757044,\"views\":285,\"players\":12},{\"id\":1509698,\"title\":\"serveme.tf - BLU vs sad\",\"map\":\"cp_snakewater_final1\",\"date\":1472755332,\"views\":232,\"players\":12},{\"id\":1502421,\"title\":\"PugChamp EU Open #5: RED vs BLU\",\"map\":\"cp_process_final\",\"date\":1472051908,\"views\":221,\"players\":12}]}"));
        Map<String, String> reqAndResp = RequestResponseMatchResultDataForTests.getMapFor1To50();
        for(Map.Entry<String, String> entry: reqAndResp.entrySet()){
            Mockito.when(jsonFetcher.getJsonFromUrl(entry.getKey())).thenReturn(new Json(entry.getValue()));
        }

        List<PlayerMatchData> playerMatchDataList = dataExtractorService.getPlayerResults(searchData);
        List<Metric> metricList = analysisService.getAnalysisData(playerMatchDataList);

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
            StringBuilder stringBuilder = new StringBuilder("не хватает теста для: ");
            if(!missingNamesOfMetrics.isEmpty()){
                missingNamesOfMetrics.forEach(nameOfMetric ->{
                    stringBuilder.append(nameOfMetric);
                    stringBuilder.append(" ");
                });
                Assertions.fail(stringBuilder.toString());
            }
        });
    }
}
