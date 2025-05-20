package org.example.search.info;

import org.example.requestResults.RequestResponseMatchListDataForTests;
import org.example.requestResults.RequestResponseMatchResultDataForTests;
import org.example.search.info.objectwrappers.Json;
import org.example.search.info.objectwrappers.SteamID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class DataExtractorServiceMockTest {

    @Mock
    private JsonFetcher jsonFetcher;

    private MatchExtractorService matchExtractorService;

    private DataExtractorService dataExtractorService;

    private SteamID steamID;
    private final SearchRangeType searchRangeType = SearchRangeType.MATCH_COUNT;
    private boolean isServemeSearch;
    private List<String> ignoreTitles;
    private List<GameHero> searchHeroes;
    private Integer count;
    private List<GameMode> searchGameModes;

    private SearchData searchData;

    @BeforeEach
    public void setUp(){
        steamID = new SteamID("76561197987681768");
        isServemeSearch = false;
        ignoreTitles = List.of();
        searchHeroes = List.of();
        count = 10;
        searchGameModes = List.of();
        dataExtractorService = new DataExtractorService();
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
     * Невалидный Steam ID
     */
    @Test
    void nonValidSteamIdTest(){
        steamID = new SteamID("Вячеслав Пыжьянов");
        count = 1;
        uppdateSearchData();
        var result = dataExtractorService.getPlayerResults(searchData);
        assertEquals(List.of(), result);
    }

    /**
     * Число запрашиваемых матчей = 0
     */
    @Test
    void zeroFindMatchTest(){
        count = 0;
        uppdateSearchData();

        var result = dataExtractorService.getPlayerResults(searchData);
        assertEquals(List.of(), result);
    }

    /**
     * Отрицательное число запрашиваемых матчей
     */
    @Test
    void negativeCountOfMatchTest(){
        count = -5;
        uppdateSearchData();

        var result = dataExtractorService.getPlayerResults(searchData);
        assertEquals(List.of(), result);
    }

    /**
     * Число запрашиваемых матчей соответствует числу возвращаемых матчей
     * если это возможно
     */
    @Test
    void requestCountEqualsResultCountInGeneralSituationTest(){
        count = 5;
        uppdateSearchData();

        matchExtractorService = new MatchExtractorService(jsonFetcher);
        dataExtractorService = new DataExtractorService(matchExtractorService, jsonFetcher, 10);

        Mockito.when(jsonFetcher.getJsonFromUrl(RequestResponseMatchListDataForTests.request)).thenReturn(new Json(RequestResponseMatchListDataForTests.response));
        Map<String, String> reqAndResp = RequestResponseMatchResultDataForTests.getMapFor1To10();
        for(Map.Entry<String, String> entry: reqAndResp.entrySet()){
            Mockito.when(jsonFetcher.getJsonFromUrl(entry.getKey())).thenReturn(new Json(entry.getValue()));
        }

        var result = dataExtractorService.getPlayerResults(searchData);
        assertEquals(5, result.size());
    }

    /**
     * Получение данных по одному классу
     */
    @Test
    void oneFindHeroTest(){
        searchHeroes = List.of(GameHero.SCOUT);
        count = 1;
        uppdateSearchData();

        matchExtractorService = new MatchExtractorService(jsonFetcher);
        dataExtractorService = new DataExtractorService(matchExtractorService, jsonFetcher, 10);

        Mockito.when(jsonFetcher.getJsonFromUrl(RequestResponseMatchListDataForTests.request)).thenReturn(new Json(RequestResponseMatchListDataForTests.response));
        Map<String, String> reqAndResp = RequestResponseMatchResultDataForTests.getMapFor1To10();
        for(Map.Entry<String, String> entry: reqAndResp.entrySet()){
            Mockito.when(jsonFetcher.getJsonFromUrl(entry.getKey())).thenReturn(new Json(entry.getValue()));
        }

        var result = dataExtractorService.getPlayerResults(searchData);
        result.forEach(gameRes -> assertEquals(GameHero.SCOUT, gameRes.getBasedPlayerResults().getGameHero()));
    }

    /**
     * Получение данных по нескольким героям
     */
    @Test
    void mixOfHeroesTest(){
        searchHeroes = List.of(GameHero.SCOUT, GameHero.SOLDIER);
        count = 10;
        uppdateSearchData();

        matchExtractorService = new MatchExtractorService(jsonFetcher);
        dataExtractorService = new DataExtractorService(matchExtractorService, jsonFetcher, 10);

        Mockito.when(jsonFetcher.getJsonFromUrl(RequestResponseMatchListDataForTests.request)).thenReturn(new Json(RequestResponseMatchListDataForTests.response));
        Map<String, String> reqAndResp = RequestResponseMatchResultDataForTests.getMapFor1To10();
        for(Map.Entry<String, String> entry: reqAndResp.entrySet()){
            Mockito.when(jsonFetcher.getJsonFromUrl(entry.getKey())).thenReturn(new Json(entry.getValue()));
        }

        var result = dataExtractorService.getPlayerResults(searchData);
        boolean containsScout = false;
        boolean containsSoldier = false;
        for(var matchRes : result){
            if(matchRes.getBasedPlayerResults().getGameHero() == GameHero.SCOUT){
                containsScout = true;
            }else if(matchRes.getBasedPlayerResults().getGameHero() == GameHero.SOLDIER){
                containsSoldier = true;
            }
            else {
                // мб лишнее
                containsScout = false;
                containsSoldier = false;
                break;
            }
        }
        assertTrue(containsScout);
        assertTrue(containsSoldier);
        uppdateSearchData();
    }
}
