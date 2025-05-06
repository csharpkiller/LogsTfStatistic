package org.example.search.info;

import java.util.List;

/**
 * Фильтры которые мы накладываем на список матчей, до захода внутрь матча
 */
public interface MatchListFilter {
    SearchRangeType getSearchRangeType();
    Boolean isOnlyServerMeSearch();
    List<String> getIgnoreTags();
    List<GameMode> getGameModes();
}
