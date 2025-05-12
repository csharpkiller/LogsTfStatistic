package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Статистика по персонажу
 */
public class ClassStatsDTO {

    /**
     * Название персонажа
     */
    private final String hero_str;

    /**
     * Кол-во убийств, играя за hero_str
     */
    private final int kills;

    /**
     * Кол-во помощи, играя за hero_str
     */
    private final int assists;

    /**
     * Кол-во смертей, играя за hero_str
     */
    private final int deaths;

    /**
     * Кол-во урона, нанесенное, играя за hero_str
     */
    private final int dmg;

    /**
     * Оружия, которые использовал играя на hero_str
     */
    private final WeaponMap weapon;

    /**
     * Кол-во времени проведенное в матче на hero_str
     */
    private final int total_time;

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
