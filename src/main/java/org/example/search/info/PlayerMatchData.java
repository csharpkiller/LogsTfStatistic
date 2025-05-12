package org.example.search.info;

import org.example.search.info.DTO.inside.match.MatchRootDTO;
/**
 * Некоторая обертка над basedPlayerResults,
 * чтобы сохранять не только результаты игрока,
 * но и запрос и результат матча, в котором участвовал игрок,
 * для дальнейших более сложных метрик.
 */
public class PlayerMatchData {

    /**
     * Запрос пользователя
     */
    private final SearchData searchData;

    /**
     * Полная информация о матче
     */
    private final MatchRootDTO matchInfo;

    /**
     * Основная статистика игрока
     */
    private final BasedPlayerResults basedPlayerResults;

    public PlayerMatchData(SearchData searchData, MatchRootDTO matchInfo, BasedPlayerResults basedPlayerResults) {
        this.searchData = searchData;
        this.matchInfo = matchInfo;
        this.basedPlayerResults = basedPlayerResults;
    }

    public SearchData getSearchData() {
        return searchData;
    }

    public MatchRootDTO getMatchInfo() {
        return matchInfo;
    }

    public BasedPlayerResults getBasedPlayerResults() {
        return basedPlayerResults;
    }
}
