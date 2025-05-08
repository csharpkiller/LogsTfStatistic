package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Общая сводка информации по команде
 */
public class TeamDTO {
    private final int score; // Сколько выйграла раундов
    private final int kills; // Общее кол-во киллов всех игроков
    private final int deaths; // Общее кол-во смертей всех игроков
    private final int dmg; // Общее кол-во нанесенного урона всех игроков
    private final int charges; // Общее кол-во накопленных убер-зарядов
    private final int drops; // Общее кол-во потерянных убер-зарядов
    private final int firstcaps; // Сколько раз получилось захватить точку первыми (в начале раунда)
    private final int caps; // Общее кол-во захваченных точек

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