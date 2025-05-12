package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Общая сводка информации по команде
 */
public class TeamDTO {

    /**
     * Сколько выйграла раундов
     */
    private final int score;

    /**
     * Общее кол-во убийств всех игроков
     */
    private final int kills;

    /**
     * Общее кол-во смертей всех игроков
     */
    private final int deaths;

    /**
     * Общее кол-во нанесенного урона всех игроков
     */
    private final int dmg;

    /**
     * Общее кол-во накопленных убер-зарядов
     */
    private final int charges;

    /**
     * Общее кол-во потерянных убер-зарядов
     */
    private final int drops; //

    /**
     * Сколько раз получилось захватить точку первыми (в начале раунда)
     */
    private final int firstcaps;

    /**
     * Общее кол-во захваченных точек
     */
    private final int caps;

    public TeamDTO(
           @JsonProperty("score") int score,
           @JsonProperty("kills") int kills,
           @JsonProperty("deaths") int deaths,
           @JsonProperty("dmg") int dmg,
           @JsonProperty("charges") int charges,
           @JsonProperty("drops") int drops,
           @JsonProperty("firstcaps") int firstcaps,
           @JsonProperty("caps") int caps
    ) {
        this.score = score;
        this.kills = kills;
        this.deaths = deaths;
        this.dmg = dmg;
        this.charges = charges;
        this.drops = drops;
        this.firstcaps = firstcaps;
        this.caps = caps;
    }

    public int getScore() {
        return score;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getDmg() {
        return dmg;
    }

    public int getCharges() {
        return charges;
    }

    public int getDrops() {
        return drops;
    }

    public int getFirstcaps() {
        return firstcaps;
    }

    public int getCaps() {
        return caps;
    }
}