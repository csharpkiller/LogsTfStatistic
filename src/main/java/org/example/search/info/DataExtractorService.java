package org.example.search.info;

import org.example.search.info.DTO.ParseResult;
import org.example.search.info.DTO.inside.match.MatchRoot;
import org.example.search.info.DTO.matches.list.MatchDTO;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для получения результатов матчей по запросу пользователя
 */
public class DataExtractorService {
    private final MatchResultFilter matchResultFilter;
    private final MatchExtractorService matchExtractorService;
    private final ObjectMapper objectMapper;
    private final JsonFetcher jsonFetcher;
    private final ApiLinkCreator apiLinkCreator;
    private final LogsJsonParser logsJsonParser;

    /**
     * countOfMatchesToParse
     * Кратко:
     *  Кол-во матчей которое мы будем получать при запросе к API logs.tf
     * Подробнее:
     *  Представим, что у нас список матчей содержит примерно 10000 записей.
     *  Мы можем с помощью logs.tf API получить json всех этих матчей.
     *  Но в этом случае:
     *      1) Большая вероятность словить ошибку парсинга Json -> Java Obj, если в каком-то месте Json пришел битым.
     *      2) Не все данные нам понадобятся, мы можем получить результат на первых 300 матчей.
     *  Так что мы будем разбивать список на батчи длинной countOfMatchesToParse, проверять достигли ли мы результата,
     *  если нет, то рассматривать следующий батч и тд.
     */
    private final Integer countOfMatchesToParse;

    /**
     * countOfPossibleErrors
     * Кратко:
     *  Кол-во допустимых ошибок парсинга списка матчей
     * Подробнее:
     *  Представим, также, что у нас 10000 записей.
     *  Мы их парсим и либо успешно, либо нет.
     *  Ситуация когда нет:
     *      1) Битый исходящий Json
     *      2) Мы пытаемся обратится к 10001+ элементам
     *  При первой ситуации мы уже ничего не сделаем, в теории можно сужать countOfMatchesToParse для вычленения остаточных
     *  возможно не битых Json'ов, но это не имеет смысла (дополнительные условно 10 матчей погоды не поменяют)
     *  Вторая ситуация будет поводом закончить вечный цикл, даже если мы не достигли ожидаемого результата и вывести, то что получили.
     */
    private final Integer countOfPossibleErrors;

    /**
     * Хранилище матчей, в случае ошибки получения результата матча по id матча.
     */
    private List<MatchDTO> generalMissingMatchesAfterParse;

    public DataExtractorService(){
        matchResultFilter = new MatchResultFilter();
        matchExtractorService = new MatchExtractorService();
        objectMapper = new ObjectMapper();
        generalMissingMatchesAfterParse = List.of();
        jsonFetcher = new JsonFetcher();
        apiLinkCreator = new ApiLinkCreator();
        logsJsonParser = new LogsJsonParser();
        countOfMatchesToParse = 50;
        countOfPossibleErrors = 3;
    }

    /**
     * Обрабатывает запрос пользователя и возвращает результаты матчей.
     * @param searchData user input
     * @return список результатов
     */
    public List<BasedPlayerResults> getPlayerResults(@NotNull SearchData searchData){
        if(!searchData.getPlayerId().isValidId()){
            System.out.println("input steam id is not valid");
            return List.of();
        }
        List<BasedPlayerResults> resultData = new ArrayList<>();
        generalMissingMatchesAfterParse = new ArrayList<>();

        int start = -countOfMatchesToParse;
        int caughtErrors = 0;
        int deep = 5000; // TODO to delete? можно в теории передавать сколько максимум запросов будем обрабатывать

        while (resultData.size() < searchData.getCount() && caughtErrors <= countOfPossibleErrors){
            start+= countOfMatchesToParse;
            if(start >= deep) break; // TODO to delete?

            ParseResult<List<MatchDTO>> parseResultMatchDTOList = matchExtractorService.getFilteredMatches(start, countOfMatchesToParse, searchData);

            if(parseResultMatchDTOList.getMissingData()){
                caughtErrors++;
                continue;
            }

            List<MatchDTO> filteredListOfMatches = parseResultMatchDTOList.getResultData();

            /*List<MatchRoot> unfilteredListOfMatchResults = fillMatchResultsList(filteredListOfMatches);
            List<MatchRoot> listOfMatchResults = matchResultFilter.getFilteredMatchResults(unfilteredListOfMatchResults, searchData);
            if(!searchData.getSearchHeroes().isEmpty()){
                listOfMatchResults = matchResultFilter.getFilteredMatchResults(unfilteredListOfMatchResults, searchData);
            }*/
            List<MatchRoot> listOfMatchResults = fillMatchResultsList(filteredListOfMatches);
            if(!searchData.getSearchHeroes().isEmpty()){
                listOfMatchResults = matchResultFilter.getFilteredMatchResults(listOfMatchResults, searchData);
            }

            List<BasedPlayerResults> basedPlayerResultData = objectMapper.convertMatchRootToPlayerResultData(searchData.getPlayerId(), listOfMatchResults);
            resultData.addAll(basedPlayerResultData);
        }

        if(resultData.size() > searchData.getCount()){
            return resultData.subList(0, searchData.getCount());
        }
        return resultData;
    }

    /**
     * Возвращает список ID матчей, которые мы не смогли рассмотреть./
     * @return список ID матчей.
     */
    public List<Integer> getMissingMatchesIDs(){
        return generalMissingMatchesAfterParse.stream().map(MatchDTO::getId).collect(Collectors.toList());
    }

    /**
     * Загружает результаты матчей по id матча
     * @param listOfMatches список матчей
     * @return список результатов матчей
     */
    @NotNull
    private List<MatchRoot> fillMatchResultsList(@NotNull List<MatchDTO> listOfMatches){
        List<MatchRoot> matchRootList = new ArrayList<>();
        for(MatchDTO match : listOfMatches){
            String apiUrl = apiLinkCreator.createLinkForInsideMatch(String.valueOf(match.getId()));
            ParseResult<MatchRoot> parseResult = logsJsonParser.parseToMatchResult(jsonFetcher.getJsonFromUrl(apiUrl));
            if(!parseResult.getMissingData()){
                matchRootList.add(parseResult.getResultData());
            }else {
                generalMissingMatchesAfterParse.add(match);
            }
        }
        return matchRootList;
    }
}
