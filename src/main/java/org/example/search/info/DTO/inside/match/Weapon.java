package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Статистика оружия
 */
public class Weapon {

    /**
     * Убито игроков
     */
    private final int kills;

    /**
     * Нанесенный урон
     */
    private final int dmg;

    /**
     * Средний урон
     */
    private final double avg_dmg;

    /**
     * Кол-во выстрелов
     */
    private final int shots;

    /**
     * Кол-во попаданий
     */
    private final int hits;

    public Weapon(
           @JsonProperty("kills") int kills,
           @JsonProperty("dmg") int dmg,
           @JsonProperty("avg_dmg") double avg_dmg,
           @JsonProperty("shots") int shots,
           @JsonProperty("hits") int hits
    ) {
        this.kills = kills;
        this.dmg = dmg;
        this.avg_dmg = avg_dmg;
        this.shots = shots;
        this.hits = hits;
    }

    public int getKills() {
        return kills;
    }

    public int getDmg() {
        return dmg;
    }

    public double getAvg_dmg() {
        return avg_dmg;
    }

    public int getShots() {
        return shots;
    }

    public int getHits() {
        return hits;
    }
}
