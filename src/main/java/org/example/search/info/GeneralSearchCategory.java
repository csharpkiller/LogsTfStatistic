package org.example.search.info;

import java.util.List;

/**
 * Фильтры которые мы накладываем на список матчей, до захода внутрь матча
 */
public interface GeneralSearchCategory {
    SearchRangeType getSearchRangeType();
    Boolean isServerMeSearch();
    List<String> getIgnoreTags();
}
