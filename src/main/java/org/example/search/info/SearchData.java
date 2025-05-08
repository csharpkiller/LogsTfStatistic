package org.example.search.info;

import org.example.search.info.objectwrappers.SteamID;

import java.util.List;

/**
 * DataClass, user input
 * критерии по которым мы будем искать, фильтры
 */
public class SearchData{
    private final SteamID playerId; // id игрока для которого нужно вернуть результат
    private final SearchRangeType searchRangeType; // тип поиска по range (сейчас только кол-во матчей)
    private final Boolean isServerMeSearch; // матчи только с upploads with serveme?
    private final List<String> ignoreTitles; // список игнорируемых Title's
    private final List<GameHero> searchHeroes; // список персонажей по которым венруть результат
    private final Integer count; // кол-во матчей которое нужно вернуть
    private final List<GameMode> gameModes; // игровые режимы которые нужно вернуть

    public SearchData(SteamID playerId, SearchRangeType searchRangeType, Boolean isServerMeSearch, List<String> ignoreTitles, List<GameHero> searchHeroes, Integer count, List<GameMode> gameModes) {
        this.playerId = playerId;
        this.searchRangeType = searchRangeType;
        this.isServerMeSearch = isServerMeSearch;
        this.ignoreTitles = ignoreTitles;
        this.searchHeroes = searchHeroes;
        this.count = count;
        this.gameModes = gameModes;
    }

    public SteamID getPlayerId() {
        return playerId;
    }

    public List<GameHero> getSearchHeroes() {
        return searchHeroes;
    }

    public Integer getCount() {
        return count;
    }

    public List<GameMode> getGameModes() {
        return gameModes;
    }

    public SearchRangeType getSearchRangeType() {
        return searchRangeType;
    }

    public Boolean isOnlyServerMeSearch() {
        return isServerMeSearch;
    }

    public List<String> getIgnoreTitles() {
        return ignoreTitles;
    }
}
