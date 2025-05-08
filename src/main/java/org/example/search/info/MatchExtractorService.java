package org.example.search.info;

import org.example.search.info.DTO.ParseResult;
import org.example.search.info.DTO.matches.list.MatchDTO;
import org.example.search.info.objectwrappers.Json;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Класс предназначенный на извлечение списка id матчей с примененными фильтрами.
 */
public class MatchExtractorService {

    private final Integer dataError; // погрешность времени

    private final ApiLinkCreator apiLinkCreator;
    private final JsonFetcher jsonFetcher;
    private final LogsJsonParser logsJsonParser;

    public MatchExtractorService() {
        dataError = 120;
        apiLinkCreator = new ApiLinkCreator();
        jsonFetcher = new JsonFetcher();
        logsJsonParser = new LogsJsonParser();
    }

    /**
     * Возвращает отсортированный список матчей
     * @param offset смещение, logs.tf api value
     * @param limit количество матчей, logs.tf api value
     * @param searchCategory фильтры
     * @return контейнер ParseResult, с в случае ошибки isMissingData = true
     */
    public ParseResult<List<MatchDTO>> getFilteredMatches(Integer offset, Integer limit, @NotNull SearchData searchCategory) {
        apiLinkCreator.clear();
        if(!searchCategory.getPlayerId().isValidId()){
            System.out.println("steam id is not valid");
            return new ParseResult<>(List.of(), false);
        }

        switch (searchCategory.getSearchRangeType()) {
            case MATCH_COUNT -> {
                ParseResult<List<MatchDTO>> res = matchCountSearch(offset, limit, searchCategory);

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

    /**
     * Подгружает матчи и возвращает отфильтрованные
     * @param offset смещение, logs.tf api value
     * @param limit количество матчей, logs.tf api value
     * @param searchCategory фильтры
     * @return контейнер с результатом
     */
    @NotNull
    private ParseResult<List<MatchDTO>> matchCountSearch(Integer offset, Integer limit, SearchData searchCategory) {
        // расширение диапозона, для сравнения крайних матчей
        int supOffset = 0;
        int supLimit = limit + 1;
        if (offset > 0) {
            supOffset = offset - 1;
        }

        String apiLink = apiLinkCreator.setPlayer(searchCategory.getPlayerId()).setOffset(supOffset).setLimit(supLimit).build();

        if (searchCategory.isOnlyServerMeSearch() && searchCategory.getIgnoreTitles().isEmpty()) {
            apiLink = apiLinkCreator.setTitle(BasedTitles.SERVE_ME).setLimit(limit).setOffset(offset).build();
        }

        ParseResult<List<MatchDTO>> loadedMatches = loadData(apiLink);
        if (loadedMatches.getMissingData()) {
            return loadedMatches;
        }

        List<MatchDTO> filteredData = titleFilter(searchCategory.getIgnoreTitles(), loadedMatches.getResultData());

        if(searchCategory.isOnlyServerMeSearch()){
            filteredData = getOnlyServemeMatches(filteredData);
        }

        filteredData = gameModeFilter(filteredData, searchCategory.getGameModes());
        return new ParseResult<>(filteredData, false);
    }

    /**
     * Подгружает данные через запрос к api
     * @param apiLink запрос
     * @return контейнер с результатом
     */
    private ParseResult<List<MatchDTO>> loadData(String apiLink) {
        Json jsonData = jsonFetcher.getJsonFromUrl(apiLink);
        return logsJsonParser.parseToMatchList(jsonData);
    }

    /**
     * Фильтрует список матчей по Title учитывая, что матч может быть дублирован под другим Title и его тоже нужно удалить.
     * @param titlesToIgnore title которые нужно отсечь
     * @param unfilteredMatches неотфильтрованный список матчей
     * @return отфильтрованный список матчей
     */
    private List<MatchDTO> titleFilter(List<String> titlesToIgnore, @NotNull List<MatchDTO> unfilteredMatches) {

        List<MatchDTO> ignoredMatchResults = unfilteredMatches.stream()
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

    /**
     * Возвращает только матчи загруженные с serveme
     * @param unfilteredMatches неотфильтрованный список мачтей
     * @return матчи загруженные с хоста serveme
     */
    private List<MatchDTO> getOnlyServemeMatches(@NotNull List<MatchDTO> unfilteredMatches){
        return unfilteredMatches.stream()
                .filter(log -> log.getTitle().contains(BasedTitles.SERVE_ME)).toList();
    }

    /**
     * Фильтрует матчи по режиму игры
     * @param unfilteredMatches неотфильтрованный список мачтей
     * @param gameModesToFilter список искомых игровых режимов
     * @return отфильтрованный список матчей
     */
    private List<MatchDTO> gameModeFilter(@NotNull List<MatchDTO> unfilteredMatches, List<GameMode> gameModesToFilter){
        return unfilteredMatches.stream()
                .filter(log -> {
                    int countOfPlayers = log.getPlayers();
                    return gameModesToFilter.isEmpty() || gameModesToFilter.contains(GameMode.valueOfPlayersCount(countOfPlayers));
                }).toList();
    }
}
