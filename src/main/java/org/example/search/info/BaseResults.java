package org.example.search.info;

public interface BaseResults {
    Integer getKills();
    Integer getDeaths();
    Integer getAssists();
    String getMap();
    GameResult isWin();
    GameHero getGameHero();
}
