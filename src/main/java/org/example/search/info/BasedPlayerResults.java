package org.example.search.info;

import org.example.Printable;

/**
 * DataClass, интересующая нас информация из матча
 */
public class BasedPlayerResults implements Printable {

    /**
     * Id игрока
     */
    private final String steamId;

    /**
     * Никнейм игрока в матче
     */
    private final String nickNameFromMatch;

    /**
     * Персонаж на котором играл
     */
    private final GameHero gameHero;

    /**
     * Кол-во фрагов
     */
    private final Integer kills;

    /**
     * Кол-во смертей
     */
    private final Integer deaths;

    /**
     * Кол-во ассистов
     */
    private final Integer assists;

    /**
     * Кол-во нанесеного урона
     */
    private final Integer damage;

    /**
     * Карта на которой игнрал
     */
    private final String map;

    /**
     * Результат матча для игрока
     */
    private final GameResult gameResult;

    public BasedPlayerResults(String steamId, String nickNameFromMatch, GameHero gameHero , Integer kills, Integer deaths, Integer assists, Integer damage, String map, GameResult gameResult) {
        this.steamId = steamId;
        this.nickNameFromMatch = nickNameFromMatch;
        this.gameHero = gameHero;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.damage = damage;
        this.map = map;
        this.gameResult = gameResult;
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

    public Integer getDamage() {
        return damage;
    }

    public String getMap() {
        return map;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    @Override
    public void print() {
        System.out.printf(
                "Игрок: %s (%s), Герой: %s, Фраги: %d, Смерти: %d, Ассисты: %d, Урон: %d, Карта: %s, Победа: %s%n",
                this.nickNameFromMatch,
                this.steamId,
                this.gameHero,
                this.kills,
                this.deaths,
                this.assists,
                this.damage,
                this.map,
                this.gameResult
        );
    }
}
