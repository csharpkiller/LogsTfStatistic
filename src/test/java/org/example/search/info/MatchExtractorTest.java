package org.example.search.info;

import junit.framework.TestCase;
import org.example.search.info.DTO.ParseResult;
import org.example.search.info.DTO.matches.list.MatchDTO;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

import java.util.List;

class MatchExtractorTest extends TestCase {
    private final String testId = "76561197987681768";
    private final ApiLinkCreator apiLinkCreator = new ApiLinkCreator();
    private final JsonFetcher jsonFetcher = new JsonFetcher();
    private final MatchExtractor matchExtractor = new MatchExtractor();

    private final SearchData zeroFiltres = new SearchData(testId, SearchRangeType.MATCH_COUNT, false, List.of(), List.of(), 10, List.of());

    /**
     * передаем limit 0
     */
    @Test
    void zeroLimitTest(){
        ParseResult<List<MatchDTO>> res = matchExtractor.getMatches(testId, 0, 0, zeroFiltres);
        assertEquals(Boolean.FALSE, res.getMissingData());
        assertEquals(0, res.getResultData().size());
    }

    /**
     * Сортировка по GameMode
     */
    @Test
    void gameModeFilterTest(){
        SearchData sixes = new SearchData(testId, SearchRangeType.MATCH_COUNT, false, List.of(), List.of(), 10, List.of(GameMode.SIXES));
        SearchData hl = new SearchData(testId, SearchRangeType.MATCH_COUNT, false, List.of(), List.of(), 10, List.of(GameMode.HIGHLANDER));
        SearchData ultiduo_bbal = new SearchData(testId, SearchRangeType.MATCH_COUNT, false, List.of(), List.of(), 10, List.of(GameMode.ULTIDUO_BBAL));

        ParseResult<List<MatchDTO>> res = matchExtractor.getMatches(testId, 0, 10, sixes);
        assertEquals(12, res.getResultData().get(0).getPlayers());

        ParseResult<List<MatchDTO>> res1 = matchExtractor.getMatches(testId, 0, 1000, hl);
        assertEquals(18, res1.getResultData().get(0).getPlayers());

        ParseResult<List<MatchDTO>> res2 = matchExtractor.getMatches(testId, 0, 1000, ultiduo_bbal);
        assertEquals(4, res2.getResultData().get(0).getPlayers());
    }

    /**
     * Сортировка по ignore Title
     */
    @Test
    void ignoreTitlesTest(){
        var searchData = new SearchData(testId, SearchRangeType.MATCH_COUNT, false, List.of(BasedTitles.SERVER_ME, BasedTitles.TF2CENTER, "PugChamp"), List.of(), 10, List.of());
        // заигнорили все тэги дефолтные так что результат должен быть только custom uppload

        var res = matchExtractor.getMatches(testId, 0, 1000, searchData);
        assertEquals(1668736, res.getResultData().get(0).getId());
    }

    /**
     * Сортировка только по server.me upploads
     */
    @Test
    void serverMeUpploadsTest(){
        var serchData = new SearchData(testId, SearchRangeType.MATCH_COUNT, true, List.of(), List.of(), 10, List.of());
        var res = matchExtractor.getMatches(testId, 0, 10, serchData);
        assertEquals(1964891, res.getResultData().get(0).getId());
        assertEquals(1715675, res.getResultData().get(9).getId());
    }

    /**
     * Првоерка удаления крайних значений
     */
    @Test
    void deleteAppendBoardsTest(){

    }

    /**
     * Проверка удаления ignoreTitle, в ситуации когда serverme дублировал запрос,
     * и попал в наш отрезок рассматриваемых значений, а сам IgnoreTitle вне отрезка
     */
    @Test
    void hiddenIgnoredLogOutOfRangeTest(){

    }

}