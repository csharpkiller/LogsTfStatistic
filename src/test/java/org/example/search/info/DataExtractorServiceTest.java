package org.example.search.info;

import org.example.search.info.objectwrappers.SteamID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataExtractorServiceTest {
    private SteamID steamID;
    private final SearchRangeType searchRangeType = SearchRangeType.MATCH_COUNT;
    private boolean isServemeSearch;
    private List<String> ignoreTitles;
    private List<GameHero> searchHeroes;
    private Integer count;
    private List<GameMode> searchGameModes;

    private DataExtractorService dataExtractorService;
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
        count = 21;
        uppdateSearchData();
        var result = dataExtractorService.getPlayerResults(searchData);
        assertEquals(21, result.size());
    }

    /**
     * Получение данных по одному классу
     */
    @Test
    void oneFindHeroTest(){
        searchHeroes = List.of(GameHero.SCOUT);
        uppdateSearchData();

        var result = dataExtractorService.getPlayerResults(searchData);
        result.forEach(gameRes -> assertEquals(GameHero.SCOUT, gameRes.getBasedPlayerResults().getGameHero()));
    }

    /**
     * Получение данных по нескольким героям
     */
    @Test
    void mixOfHeroesTest(){
        searchHeroes = List.of(GameHero.SCOUT, GameHero.SOLDIER);
        count = 50;
        uppdateSearchData();

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

    /**
     * Число запрашиваемых матчей превышает фактический результат.
     * Запрашиваю 100 игр на снайпере, а он играл только 20 etc.
     */
    @Test
    void outOfRangeTest(){
        steamID = new SteamID("76561198072338507");
        searchHeroes = List.of(GameHero.SNIPER);
        count=1500;
        uppdateSearchData();

        var result = dataExtractorService.getPlayerResults(searchData);
        assertEquals(2, result.size());
    }
}