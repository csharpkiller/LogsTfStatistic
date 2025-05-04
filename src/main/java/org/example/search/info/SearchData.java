package org.example.search.info;

import java.util.List;

/**
 * DataClass, критерии по которым мы будем искать, фильтры
 */
public class SearchData implements InMatchSearchCategory, GeneralSearchCategory{

    @Override
    public SearchRangeType getSearchRangeType() {
        return null;
    }

    @Override
    public Boolean isServerMeSearch() {
        return null;
    }

    @Override
    public List<String> getIgnoreTags() {
        return null;
    }

    @Override
    public List<HeroFilter> getSearchHeroes() {
        return null;
    }
}
