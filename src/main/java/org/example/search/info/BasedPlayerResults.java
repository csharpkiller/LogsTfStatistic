package org.example.search.info;

/**
 * DataClass, интересующая нас информация из матча
 */
public class BasedPlayerResults {
    private final String steamId; // id игрока
    private final String nickNameFromMatch; // никнейм игрока в матче
    private final GameHero gameHero; // персонаж на котором играл
    private final Integer kills; // кол-во фрагов
    private final Integer deaths; // кол-во смертей
    private final Integer assists; // кол-во ассистов
    private final String map; // карта на которой игнрал
    private final GameResult isWin; // победил?

    public BasedPlayerResults(String steamId, String nickNameFromMatch, GameHero gameHero , Integer kills, Integer deaths, Integer assists, String map, GameResult isWin) {
        this.steamId = steamId;
        this.nickNameFromMatch = nickNameFromMatch;
        this.gameHero = gameHero;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.map = map;
        this.isWin = isWin;
    }

    public String getSteamId() {
        return steamId;
    }

    public String getNickNameFromMatch() {
        return nickNameFromMatch;
    }

    public GameHero getGameHero() {
        return gameHero;
    }

    public Integer getKills() {
        return kills;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public Integer getAssists() {
        return assists;
    }

    public String getMap() {
        return map;
    }

    public GameResult getIsWin() {
        return isWin;
    }
}
