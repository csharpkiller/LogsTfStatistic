package org.example.search.info;

import org.example.search.info.DTO.ParseResult;
import org.example.search.info.DTO.matches.list.MatchDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс предназначенный на извлечение списка id матчей
 */
public class MatchExtractor {

    private final Integer dataError;
    private final ApiLinkCreator apiLinkCreator;
    private final JsonFetcher jsonFetcher;
    private final LogsJsonParser logsJsonParser;

    public MatchExtractor() {
        dataError = 120;
        apiLinkCreator = new ApiLinkCreator();
        jsonFetcher = new JsonFetcher();
        logsJsonParser = new LogsJsonParser();
    }

    /**
     * Возвращает отсортированный список матчей
     * @param ID api value
     * @param offset api value
     * @param limit api value
     * @param searchCategory фильтры
     * @return контейнер ParseResult, с в случае ошибки isMissingData = true
     */
    public ParseResult<List<MatchDTO>> getMatches(String ID, Integer offset, Integer limit, MatchListFilter searchCategory) {
        apiLinkCreator.clear();

        switch (searchCategory.getSearchRangeType()) {
            case MATCH_COUNT -> {
                ParseResult<List<MatchDTO>> res = matchCountSearch(ID, offset, limit, searchCategory);

                if(!res.getMissingData()){
                    if(res.getResultData().size() > limit){
                        int diff = res.getResultData().size() - limit;
                        // удаление расширения
                        switch (diff){
                            case 1 -> {
                                return new ParseResult<>(res.getResultData().subList(0, limit), false);
                            }
                            case 2 -> {
                                return new ParseResult<>(res.getResultData().subList(1, limit), false);
                            }
                        }
                    }
                }
                return res;
            }
            case LAST_TIME, TIME_PERIOD -> {
                // TODO for next realise
                return null;
            }
            default -> {
                return new ParseResult<>(List.of(), true);
            }
        }
    }

    private ParseResult<List<MatchDTO>> matchCountSearch(String ID, Integer offset, Integer limit, MatchListFilter searchCategory) {
        // расширение диапозона, для сравнения крайних матчей
        int supOffset = 0;
        int supLimit = limit + 1;
        if (offset > 0) {
            supOffset = offset - 1;
        }

        String apiLink = apiLinkCreator.setPlayer(ID).setOffset(supOffset).setLimit(supLimit).build();
        if (searchCategory.isOnlyServerMeSearch() && searchCategory.getIgnoreTags().isEmpty()) {
            apiLink = apiLinkCreator.setTitle(BasedTitles.SERVER_ME).setLimit(limit).setOffset(offset).build();
        }

        ParseResult<List<MatchDTO>> loadedMatches = loadData(apiLink);
        if (loadedMatches.getMissingData()) {
            return loadedMatches;
        }

        List<MatchDTO> filteredData = titleFilter(searchCategory.getIgnoreTags(), loadedMatches.getResultData());

        if(searchCategory.isOnlyServerMeSearch()){
            filteredData = servermeFilter(filteredData);
        }

        filteredData = gameModeFilter(filteredData, searchCategory.getGameModes());
        return new ParseResult<List<MatchDTO>>(filteredData, false);
    }

    private ParseResult<List<MatchDTO>> loadData(String api) {
        String jsonData;
        jsonData = jsonFetcher.getJsonFromUrl(api);

        ParseResult<List<MatchDTO>> parseResult = logsJsonParser.getMatchList(jsonData);
        return parseResult;
    }

    private List<MatchDTO> titleFilter(List<String> titlesToIgnore, List<MatchDTO> unfilteredMatches) {

        List<MatchDTO> ignoredMatchResults = unfilteredMatches.stream()
                //.filter(log -> titlesToIgnore.contains(log.getTitle())) TODO refactor
                .filter(log -> titlesToIgnore.stream().anyMatch(
                        ignoreTitle -> log.getTitle().toLowerCase().contains(ignoreTitle.toLowerCase())
                        ))
                .toList();

        return unfilteredMatches.stream()
                .filter(log -> {
                    if (titlesToIgnore.contains(log.getTitle())) {
                        return false;
                    }
                    for (MatchDTO ignoredLog : ignoredMatchResults) {
                        if (Math.abs(log.getDate() - ignoredLog.getDate()) < dataError
                                && log.getMap().equals(ignoredLog.getMap())
                                && (log.getPlayers() == ignoredLog.getPlayers())
                        ) {
                            return false;
                        }
                    }
                    return true;
                })
                .toList();
    }

    private List<MatchDTO> servermeFilter(List<MatchDTO> unfilteredMatches){

        return unfilteredMatches.stream()
                .filter(log -> log.getTitle().contains(BasedTitles.SERVER_ME)).toList();
    }

    private List<MatchDTO> gameModeFilter(List<MatchDTO> unfilteredMatches, List<GameMode> gameModesToFilter){
        return unfilteredMatches.stream()
                .filter(log -> {

                    int countOfPlayers = log.getPlayers();
                    return gameModesToFilter.isEmpty() || gameModesToFilter.contains(GameMode.valueOfPlayersCount(countOfPlayers));
                }).toList();
    }
}
