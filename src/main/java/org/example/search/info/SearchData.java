package org.example.search.info;

import org.example.search.info.objectwrappers.SteamID;

import java.util.List;

/**
 * DataClass, user input
 * критерии по которым мы будем искать, фильтры
 */
public class SearchData{

    /**
     * SteamId для которого нужно вернуть результат
     */
    private final SteamID playerId;

    /**
     * Тип поиска по range (сейчас только кол-во матчей)
     */
    private final SearchRangeType searchRangeType;

    /**
     * Матчи только с upploads with serveme?
     */
    private final Boolean isServerMeSearch;

    /**
     * Список игнорируемых Title's
     */
    private final List<String> ignoreTitles;

    /**
     * Список персонажей по которым венруть результат
     */
    private final List<GameHero> searchHeroes;

    /**
     * Кол-во матчей которое нужно вернуть
     */
    private final Integer count;

    /**
     * Игровые режимы которые нужно вернуть
     */
    private final List<GameMode> gameModes;

    public SearchData(SteamID playerId, SearchRangeType searchRangeType, Boolean isServerMeSearch, List<String> ignoreTitles, List<GameHero> searchHeroes, Integer count, List<GameMode> gameModes) {
        this.playerId = playerId;
        this.searchRangeType = searchRangeType;
        this.isServerMeSearch = isServerMeSearch;
        this.ignoreTitles = ignoreTitles;
        this.searchHeroes = searchHeroes;
        if(count < 0){
            this.count = 0;
        }else {
            this.count = count;
        }
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
