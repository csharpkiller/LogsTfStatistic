package org.example.search.info;

import org.example.requestResults.RequestResponseMatchListDataForTests;
import org.example.search.info.objectwrappers.Json;
import org.example.search.info.objectwrappers.SteamID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class MatchExtractorServiceMockTest {
    private SteamID steamID;
    private final SearchRangeType searchRangeType = SearchRangeType.MATCH_COUNT;
    private boolean isServemeSearch;
    private List<String> ignoreTitles;
    private List<GameHero> searchHeroes;
    private Integer count;
    private List<GameMode> searchGameModes;

    private MatchExtractorService matchExtractorService;
    private SearchData searchDataTest;

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

        matchExtractorService = new MatchExtractorService(jsonFetcher);
        Mockito.when(jsonFetcher.getJsonFromUrl("http://logs.tf/api/v1/log?player=76561197987681768&offset=14999&limit=11")).thenReturn(new Json(""));

        var result = matchExtractorService.getFilteredMatches(15000, 10, searchDataTest);
        assertEquals(List.of(), result.getResultData());
    }

    /**
     * Получения данных по невалидному steam id
     */
    @Test
    void nonvalidSteamIdTest(){
        steamID = new SteamID("812");
        uppdateSearchData();

        var result = matchExtractorService.getFilteredMatches(0, 20, searchDataTest);
        assertEquals(List.of(), result.getResultData());
    }

    /**
     * Невалидный offset и limit
     */
    @Test
    void nonvalidLimitTest(){
        uppdateSearchData();
        matchExtractorService = new MatchExtractorService(jsonFetcher);
        Mockito.when(jsonFetcher.getJsonFromUrl("http://logs.tf/api/v1/log?player=76561197987681768&offset=0&limit=-4")).thenReturn(new Json(""));
        var result = matchExtractorService.getFilteredMatches(-5, -5, searchDataTest);
        assertEquals(List.of(), result.getResultData());
    }

    /**
     * Сортировка по GameMode
     */
    @Test
    void gameModeFilterTest(){
        searchGameModes = List.of(GameMode.SIXES);
        uppdateSearchData();

        matchExtractorService = new MatchExtractorService(jsonFetcher);
        Mockito.when(jsonFetcher.getJsonFromUrl("http://logs.tf/api/v1/log?player=76561197987681768&offset=0&limit=6")).thenReturn(new Json("{\"success\":true,\"results\":6,\"total\":3203,\"parameters\":{\"player\":\"76561197987681768\",\"uploader\":null,\"title\":null,\"map\":null,\"limit\":6,\"offset\":0},\"logs\":[{\"id\":1980809,\"title\":\"PugChamp EU Open #3: RED vs BLU\",\"map\":\"cp_snakewater_final1\",\"date\":1520868091,\"views\":253,\"players\":12},{\"id\":1970141,\"title\":\"PugChamp EU Open #3: RED vs BLU\",\"map\":\"cp_process_final\",\"date\":1519827363,\"views\":140,\"players\":12},{\"id\":1967781,\"title\":\"PugChamp EU Open #1: RED vs BLU\",\"map\":\"cp_snakewater_final1\",\"date\":1519579007,\"views\":149,\"players\":12},{\"id\":1964891,\"title\":\"serveme.tf #761583 - BLU vs RED\",\"map\":\"cp_snakewater_final1\",\"date\":1519335065,\"views\":216,\"players\":12},{\"id\":1964850,\"title\":\"serveme.tf #761583 - BLU vs RED\",\"map\":\"cp_granary_pro_rc8\",\"date\":1519333095,\"views\":177,\"players\":12},{\"id\":1944518,\"title\":\"serveme.tf #753312 - BLU vs RED\",\"map\":\"cp_sunshine\",\"date\":1517429830,\"views\":124,\"players\":12}]}"));
        var sixies = matchExtractorService.getFilteredMatches(0, 5, searchDataTest);

        sixies.getResultData().forEach(matchDTO -> {
            assertEquals(12, matchDTO.getPlayers());
        });

        searchGameModes = List.of(GameMode.HIGHLANDER);
        uppdateSearchData();
        var highlander = matchExtractorService.getFilteredMatches(0, 5, searchDataTest);
        assertTrue(highlander.getResultData().isEmpty());
        searchGameModes = List.of(GameMode.ULTIDUO_BBAL);
        uppdateSearchData();
        var bbal_ulti = matchExtractorService.getFilteredMatches(0, 5, searchDataTest);
        assertTrue(bbal_ulti.getResultData().isEmpty());
    }

    /**
     * Сортировка по ignore Title
     */
    @Test
    void ignoreTitlesTest(){
        ignoreTitles = List.of(BasedTitles.TF2CENTER, "PugChamp");
        uppdateSearchData();

        matchExtractorService = new MatchExtractorService(jsonFetcher);
        Mockito.when(jsonFetcher.getJsonFromUrl(RequestResponseMatchListDataForTests.request)).thenReturn(new Json(RequestResponseMatchListDataForTests.response));
        var result = matchExtractorService.getFilteredMatches(0, 10, searchDataTest);
        assertEquals(1964891, result.getResultData().get(0).getId());
    }

    /**
     * Сортировка только по serveme upploads
     */
    @Test
    void servemeUpploadsMatchesTest(){
        isServemeSearch = true;
        uppdateSearchData();

        matchExtractorService = new MatchExtractorService(jsonFetcher);
        Mockito.when(jsonFetcher.getJsonFromUrl("http://logs.tf/api/v1/log?player=76561197987681768&offset=0&limit=10&title=serveme.tf")).thenReturn(new Json("{\"success\":true,\"results\":10,\"total\":1018,\"parameters\":{\"player\":\"76561197987681768\",\"uploader\":null,\"title\":\"serveme.tf\",\"map\":null,\"limit\":10,\"offset\":0},\"logs\":[{\"id\":1964891,\"title\":\"serveme.tf #761583 - BLU vs RED\",\"map\":\"cp_snakewater_final1\",\"date\":1519335065,\"views\":216,\"players\":12},{\"id\":1964850,\"title\":\"serveme.tf #761583 - BLU vs RED\",\"map\":\"cp_granary_pro_rc8\",\"date\":1519333095,\"views\":177,\"players\":12},{\"id\":1944518,\"title\":\"serveme.tf #753312 - BLU vs RED\",\"map\":\"cp_sunshine\",\"date\":1517429830,\"views\":124,\"players\":12},{\"id\":1862499,\"title\":\"serveme.tf #720157 - BLU vs RED\",\"map\":\"cp_sunshine\",\"date\":1508445748,\"views\":406,\"players\":12},{\"id\":1862471,\"title\":\"serveme.tf #720157 - BLU vs RED\",\"map\":\"cp_snakewater_final1\",\"date\":1508443673,\"views\":464,\"players\":12},{\"id\":1862407,\"title\":\"serveme.tf #720106 - BLU vs RED\",\"map\":\"cp_sunshine\",\"date\":1508441143,\"views\":157,\"players\":12},{\"id\":1862346,\"title\":\"serveme.tf #720106 - BLU vs RED\",\"map\":\"cp_snakewater_final1\",\"date\":1508438720,\"views\":324,\"players\":12},{\"id\":1742363,\"title\":\"serveme.tf - aLOLe vs RED\",\"map\":\"cp_gullywash_final1\",\"date\":1496604032,\"views\":389,\"players\":12},{\"id\":1742309,\"title\":\"serveme.tf - BLU vs aaRED\",\"map\":\"cp_reckoner_rc2\",\"date\":1496601868,\"views\":419,\"players\":12},{\"id\":1715675,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_process_final\",\"date\":1493925209,\"views\":182,\"players\":14}]}"));

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

        matchExtractorService = new MatchExtractorService(jsonFetcher);
        Mockito.when(jsonFetcher.getJsonFromUrl("http://logs.tf/api/v1/log?player=76561197987681768&offset=9&limit=11")).thenReturn(new Json("{\"success\":true,\"results\":11,\"total\":3203,\"parameters\":{\"player\":\"76561197987681768\",\"uploader\":null,\"title\":null,\"map\":null,\"limit\":11,\"offset\":9},\"logs\":[{\"id\":1862407,\"title\":\"serveme.tf #720106 - BLU vs RED\",\"map\":\"cp_sunshine\",\"date\":1508441143,\"views\":157,\"players\":12},{\"id\":1862346,\"title\":\"serveme.tf #720106 - BLU vs RED\",\"map\":\"cp_snakewater_final1\",\"date\":1508438720,\"views\":324,\"players\":12},{\"id\":1742363,\"title\":\"serveme.tf - aLOLe vs RED\",\"map\":\"cp_gullywash_final1\",\"date\":1496604032,\"views\":389,\"players\":12},{\"id\":1742309,\"title\":\"serveme.tf - BLU vs aaRED\",\"map\":\"cp_reckoner_rc2\",\"date\":1496601868,\"views\":419,\"players\":12},{\"id\":1715675,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_process_final\",\"date\":1493925209,\"views\":182,\"players\":14},{\"id\":1709436,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_Gullywash_Final1\",\"date\":1493233447,\"views\":232,\"players\":12},{\"id\":1709408,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_badlands\",\"date\":1493231822,\"views\":197,\"players\":12},{\"id\":1668736,\"title\":\"nr vs lp\",\"map\":\"cp_badlands\",\"date\":1489358252,\"views\":385,\"players\":12},{\"id\":1668703,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_badlands\",\"date\":1489356024,\"views\":418,\"players\":12},{\"id\":1668650,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_granary_pro_rc4\",\"date\":1489353150,\"views\":469,\"players\":12},{\"id\":1668558,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_badlands\",\"date\":1489350257,\"views\":197,\"players\":12}]}"));
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

        matchExtractorService = new MatchExtractorService(jsonFetcher);
        Mockito.when(jsonFetcher.getJsonFromUrl("http://logs.tf/api/v1/log?player=76561198000569075&offset=74&limit=9")).thenReturn(new Json("{\"success\":true,\"results\":9,\"total\":1192,\"parameters\":{\"player\":\"76561198000569075\",\"uploader\":null,\"title\":null,\"map\":null,\"limit\":9,\"offset\":74},\"logs\":[{\"id\":1588602,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"ultiduo_baloo\",\"date\":1481738547,\"views\":34,\"players\":4},{\"id\":1588013,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"ultiduo_baloo\",\"date\":1481651881,\"views\":47,\"players\":4},{\"id\":1586613,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_granary_pro_rc4\",\"date\":1481470673,\"views\":115,\"players\":12},{\"id\":1586593,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_reckoner_b3a\",\"date\":1481467967,\"views\":93,\"players\":12},{\"id\":1586574,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_gullywash_final1\",\"date\":1481465648,\"views\":39,\"players\":12},{\"id\":1585833,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_gullywash_final1\",\"date\":1481399577,\"views\":75,\"players\":12},{\"id\":1585808,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_badlands\",\"date\":1481398344,\"views\":75,\"players\":12},{\"id\":1585752,\"title\":\"serveme.tf - BLU vs sex\",\"map\":\"cp_process_final\",\"date\":1481395519,\"views\":125,\"players\":12},{\"id\":1585427,\"title\":\"serveme.tf - BLU vs RED\",\"map\":\"cp_badlands\",\"date\":1481363604,\"views\":59,\"players\":12}]}"));
        var result = matchExtractorService.getFilteredMatches(75, 8, searchDataTest);
        assertEquals(1585752, result.getResultData().get(result.getResultData().size() - 1 ).getId());
    }
}
