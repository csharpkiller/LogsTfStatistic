package org.example.search.info;

import org.example.search.info.DTO.inside.match.MatchRootDTO;
/**
 * Некоторая обертка над basedPlayerResults,
 * чтобы сохранять не только результаты игрока,
 * но и запрос и результат матча, в котором участвовал игрок,
 * для дальнейших более сложных метрик.
 */
public class PlayerMatchData {
    private final SearchData searchData; // игрок
    private final MatchRootDTO matchInfo; // полная информация о матче
    private final BasedPlayerResults basedPlayerResults; // основная статистика игрока

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
