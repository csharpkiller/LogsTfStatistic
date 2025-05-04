package org.example.search.info;

import java.util.List;

/**
 * DataClass, критерии по которым мы будем искать, фильтры
 */
public class SearchData implements InMatchSearchCategory, MatchListFilter {
    private final String playerId;
    private final SearchRangeType searchRangeType;
    private final Boolean isServerMeSearch;
    private final List<String> ignoreTags;
    private final List<GameHero> searchHeroes;
    private final Integer count;
    private final List<GameMode> gameModes;

    public SearchData(String playerId, SearchRangeType searchRangeType, Boolean isServerMeSearch, List<String> ignoreTags, List<GameHero> searchHeroes, Integer count, List<GameMode> gameModes) {
        this.playerId = playerId;
        this.searchRangeType = searchRangeType;
        this.isServerMeSearch = isServerMeSearch;
        this.ignoreTags = ignoreTags;
        this.searchHeroes = searchHeroes;
        this.count = count;
        this.gameModes = gameModes;
    }

    @Override
    public String getPlayerId() {
        return playerId;
    }

    @Override
    public List<GameHero> getSearchHeroes() {
        return getSearchHeroes();
    }

    @Override
    public Integer getCount() {
        return count;
    }

    @Override
    public List<GameMode> getGameModes() {
        return gameModes;
    }

    @Override
    public SearchRangeType getSearchRangeType() {
        return searchRangeType;
    }

    @Override
    public Boolean isOnlyServerMeSearch() {
        return isServerMeSearch;
    }

    @Override
    public List<String> getIgnoreTags() {
        return ignoreTags;
    }
}
