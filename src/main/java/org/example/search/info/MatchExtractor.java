package org.example.search.info;

import org.example.search.info.DTO.ParseResult;
import org.example.search.info.DTO.matches.list.MatchDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс предназначенный на извлечение списка id матчей
 */
public class MatchExtractor {

    private List<MatchDTO> matchesResultList;
    private ParseResult<List<MatchDTO>> parseResult;

    private final Integer dataError;
    private final ApiLinkCreator apiLinkCreator;
    private final JsonFetcher jsonFetcher;
    private final LogsJsonParser logsJsonParser;

    public MatchExtractor(){
        dataError = 120;
        apiLinkCreator = new ApiLinkCreator();
        jsonFetcher = new JsonFetcher();
        logsJsonParser = new LogsJsonParser();
    }

    public ParseResult<List<MatchDTO>> getMatches(String ID, Integer offset, Integer limit, MatchListFilter searchCategory){
        matchesResultList = new ArrayList<>();
        apiLinkCreator.clear();

        switch (searchCategory.getSearchRangeType()){
            case MATCH_COUNT:{
                matchCountSearch(ID, offset, limit, searchCategory);
            }
            case LAST_TIME:{
                break;
            }
            case TIME_PERIOD:{
                break;
            }
        }
        return parseResult;
    }

    private void matchCountSearch(String ID, Integer offset, Integer limit, MatchListFilter searchCategory){
        int supOffset = 0;
        int supLimit = limit + 1;
        if(offset > 0){
            supOffset = offset - 1;
        }

        String apiLink = apiLinkCreator.setPlayer(ID).setOffset(supOffset).setLimit(supLimit).build();
        if(searchCategory.isOnlyServerMeSearch() && searchCategory.getIgnoreTags().isEmpty()){
            apiLink = apiLinkCreator.setTitle(BasedTitles.SERVER_ME).setLimit(limit).setOffset(offset).build();
        }

        loadData(apiLink);
        if(parseResult.getMissingData()){
            return;
        }

        for (String ignoreTitle : searchCategory.getIgnoreTags()){
            titleFilter(ignoreTitle);
        }

        parseResult = new ParseResult<List<MatchDTO>>(matchesResultList, parseResult.getMissingData());
    }

    private void loadData(String api){
        String jsonData;
        jsonData = jsonFetcher.getJsonFromUrl(api);

        ParseResult<List<MatchDTO>> parseResult = logsJsonParser.getMatchList(jsonData);
        if(parseResult.getMissingData()){

        }else{
            //matchesResultList = parseResult.getResultData();
            this.parseResult = parseResult;
            matchesResultList = this.parseResult.getResultData();
        }
    }

    private void titleFilter(String ignoreTitle){
        List<MatchDTO> ignored = matchesResultList.stream()
                .filter(log -> log.getTitle().contains(ignoreTitle))
                .toList();

        matchesResultList = matchesResultList.stream()
                .filter(log -> {
                    if(log.getTitle().contains(ignoreTitle)){
                        return false;
                    }
                    for(MatchDTO ignoredLog : ignored){
                        if(Math.abs(log.getDate() - ignoredLog.getDate()) < dataError
                                && log.getMap().equals(ignoredLog.getMap())
                                && (log.getPlayers() == ignoredLog.getPlayers())
                        ){
                            return false;
                        }
                    }
                    return true;
                }).collect(Collectors.toList());
    }
}
