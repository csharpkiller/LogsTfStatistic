package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Статистика оружия
 */
public class Weapon {
    private final int kills; // убито игроков
    private final int dmg; // нанесенный урон
    private final double avg_dmg; // средний урон
    private final int shots; // кол-во выстрелов
    private final int hits; // кол-во попаданий

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
