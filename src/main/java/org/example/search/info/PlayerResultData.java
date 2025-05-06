package org.example.search.info;

/**
 * DataClass, интересующая нас информация из матча
 */
public class PlayerResultData implements BaseResults{
    private final String steamId;
    private final String nickNameFromMatch;
    private final GameHero gameHero;
    private final Integer kills;
    private final Integer deaths;
    private final Integer assists;
    private final String map;
    private final GameResult isWin;

    public PlayerResultData(String steamId, String nickNameFromMatch,GameHero gameHero ,Integer kills, Integer deaths, Integer assists, String map, GameResult isWin) {
        this.steamId = steamId;
        this.nickNameFromMatch = nickNameFromMatch;
        this.gameHero = gameHero;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.map = map;
        this.isWin = isWin;
    }

    @Override
    public Integer getKills() {
        return kills;
    }

    @Override
    public Integer getDeaths() {
        return deaths;
    }

    @Override
    public Integer getAssists() {
        return assists;
    }

    @Override
    public String getMap() {
        return map;
    }

    @Override
    public GameResult isWin() {
        return isWin;
    }

    @Override
    public GameHero getGameHero() {
        return gameHero;
    }
}
