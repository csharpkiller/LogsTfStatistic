package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Статистика по персонажу
 */
public class ClassStatsDTO {
    private final String hero_str; // название персонажа
    private final int kills; // кол-во убийств, которое сделал на этом персонаже
    private final int assists; // кол-во помощи, ...
    private final int deaths; // кол-во смертей, ...
    private final int dmg; // нанесенный урон, ...
    private final WeaponMap weapon; // оружия, которые использовал на этом персонаже
    private final int total_time; // кол-во времени проведенное в матче на этом персонаже

    public ClassStatsDTO(
            @JsonProperty("type") String hero_str,
            @JsonProperty("kills") int kills,
            @JsonProperty("assists") int assists,
            @JsonProperty("deaths") int deaths,
            @JsonProperty("dmg") int dmg,
            @JsonProperty("weapon") WeaponMap weapon,
            @JsonProperty("total_time") int total_time
    ) {
        this.hero_str = hero_str;
        this.kills = kills;
        this.assists = assists;
        this.deaths = deaths;
        this.dmg = dmg;
        this.weapon = weapon;
        this.total_time = total_time;
    }

    public String getHero_str() {
        return hero_str;
    }

    public int getKills() {
        return kills;
    }

    public int getAssists() {
        return assists;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getDmg() {
        return dmg;
    }

    public WeaponMap getWeapon() {
        return weapon;
    }

    public int getTotal_time() {
        return total_time;
    }

}
