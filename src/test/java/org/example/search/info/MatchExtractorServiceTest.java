package org.example.search.info;

import org.example.search.info.objectwrappers.SteamID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchExtractorServiceTest {
    private SteamID steamID;
    private final SearchRangeType searchRangeType = SearchRangeType.MATCH_COUNT;
    private boolean isServemeSearch;
    private List<String> ignoreTitles;
    private List<GameHero> searchHeroes;
    private Integer count;
    private List<GameMode> searchGameModes;

    private MatchExtractorService matchExtractorService;
    private SearchData searchDataTest;

    @BeforeEach
    public void setUp(){
        steamID = new SteamID("76561197987681768");
        isServemeSearch = false;
        ignoreTitles = List.of();
        searchHeroes = List.of();
        count = 10;
        searchGameModes = List.of();
        matchExtractorService = new MatchExtractorService();
    }

    private void uppdateSearchData(){
        searchDataTest = new SearchData(
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
     * передаем count 0
     */
    @Test
    void zeroCountSearch(){
        count = 10;
        uppdateSearchData();

        var result = matchExtractorService.getFilteredMatches(0, 0, searchDataTest);
        assertEquals(List.of(), result.getResultData());
    }

    /**
     * Получение данных за пределами
     */
    @Test
    void dataOutOfRange(){
        uppdateSearchData();

        var result = matchExtractorService.getFilteredMatches(15000, 10, searchDataTest);
        assertEquals(List.of(), result.getResultData());
    }

    /**
     * Получения данных по невалидному steam id
     */
    @Test
    void nonvalidSteamId(){
        steamID = new SteamID("812");
        uppdateSearchData();

        var result = matchExtractorService.getFilteredMatches(0, 20, searchDataTest);
        assertEquals(List.of(), result.getResultData());
    }

    /**
     * Сортировка по GameMode
     */
    @Test
    void gameModeFilterTest(){
        searchGameModes = List.of(GameMode.SIXES);
        uppdateSearchData();
        var sixies = matchExtractorService.getFilteredMatches(0, 10, searchDataTest);
        assertEquals(12, sixies.getResultData().get(0).getPlayers());
        assertEquals(12, sixies.getResultData().get(sixies.getResultData().size() - 1).getPlayers());

        searchGameModes = List.of(GameMode.HIGHLANDER);
        uppdateSearchData();
        var highlander = matchExtractorService.getFilteredMatches(0, 1000, searchDataTest);
        assertEquals(18, highlander.getResultData().get(0).getPlayers());
        assertEquals(18, highlander.getResultData().get(highlander.getResultData().size() - 1).getPlayers());

        searchGameModes = List.of(GameMode.ULTIDUO_BBAL);
        uppdateSearchData();
        var bbal_ulti = matchExtractorService.getFilteredMatches(0, 1500, searchDataTest);
        assertEquals(4, bbal_ulti.getResultData().get(0).getPlayers());
        assertEquals(4, bbal_ulti.getResultData().get(bbal_ulti.getResultData().size() - 1).getPlayers());
    }

    /**
     * Сортировка по ignore Title
     */
    @Test
    void ignoreTitlesTest(){
        ignoreTitles = List.of(BasedTitles.SERVE_ME, BasedTitles.TF2CENTER, "PugChamp");
        uppdateSearchData();

        var result = matchExtractorService.getFilteredMatches(0, 1000, searchDataTest);
        assertEquals(1668736, result.getResultData().get(0).getId());
    }

    /**
     * Сортировка только по serveme upploads
     */
    @Test
    void servemeUpploadsMatchesTest(){
        isServemeSearch = true;
        uppdateSearchData();

        var result = matchExtractorService.getFilteredMatches(0, 10, searchDataTest);
        assertEquals(1964891, result.getResultData().get(0).getId());
        assertEquals(1715675, result.getResultData().get(9).getId());
    }

    /**
     * Првоерка удаления расширителей
     */
    @Test
    void deletedAppendsBoardsTest(){
        uppdateSearchData();

        var result = matchExtractorService.getFilteredMatches(10, 10, searchDataTest);
        assertEquals(10, result.getResultData().size());
        assertEquals(1862407, result.getResultData().get(0).getId());
        assertEquals(1668650, result.getResultData().get(9).getId());
    }

    /**
     * Проверка удаления ignoreTitle, в ситуации когда serverme дублировал запрос,
     * и попал в наш отрезок рассматриваемых значений, а сам IgnoreTitle вне отрезка
     */
    @Test
    void hiddenIgnoredLogOutOfRangeTest(){
        steamID = new SteamID("76561198000569075");
        uppdateSearchData();

        var result = matchExtractorService.getFilteredMatches(75, 8, searchDataTest);
        assertEquals(1585752, result.getResultData().get(result.getResultData().size() - 1 ).getId());
    }
}