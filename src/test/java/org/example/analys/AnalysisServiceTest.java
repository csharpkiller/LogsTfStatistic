package org.example.analys;

import org.example.search.info.*;
import org.example.search.info.objectwrappers.SteamID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AnalysisServiceTest {
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
    private final Integer generalCountOfMetrics = 5;

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
     * Поиск по одному персонажу
     */
    @Test
    void singleHeroSearch(){
        searchHeroes = List.of(GameHero.SOLDIER);
        uppdateSearchData();

        List<Metric> metricList = analysisService.getAnalysisData(dataExtractorService.getPlayerResults(searchData));
        AtomicBoolean findWrongMetric = new AtomicBoolean(false);
        metricList.forEach(metric -> {
            if((metric instanceof WinRateOnHeroesMetric) || (metric instanceof WinRateOnMapsWithHeroesMetric)){
                findWrongMetric.set(true);
            }
        });
        assertFalse(findWrongMetric.get());
    }

    /**
     * Поиск по всем персонажам
     */
    @Test
    void moreThenOneHeroSearch(){
        uppdateSearchData();

        List<Metric> metricList = analysisService.getAnalysisData(dataExtractorService.getPlayerResults(searchData));
        assertEquals(generalCountOfMetrics, metricList.size());

        searchHeroes = List.of(GameHero.ENJIE, GameHero.SCOUT);
        uppdateSearchData();

        metricList = analysisService.getAnalysisData(dataExtractorService.getPlayerResults(searchData));
        assertEquals(generalCountOfMetrics, metricList.size());
    }
}