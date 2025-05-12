package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Описывает конкретное событие Раунда.
 * В зависимости от эвента поле может быть пустое.
 */
public class RoundEventDTO {

    /**
     * Тип эвента (charge, medic_death, pointcap etc.)
     */
    private final String type;

    /**
     * Время после начала раунда когда случился эвент
     */
    private final int time;

    /**
     * Название команды
     */
    private final String team;

    /**
     * Steam id игрока в формате id64
     */
    private final String steamid;

    /**
     * Steam id игрока в формате id64, кто убил медика при эвенте "medic_death"
     */
    private final String killer;

    /**
     * Навзание medigun при эвенте "charge"
     */
    private final String medigun;

    public RoundEventDTO(
            @JsonProperty("type") String type,
            @JsonProperty("time") int time,
            @JsonProperty("team") String team,
            @JsonProperty("steamid") String steamid,
            @JsonProperty("killer") String killer,
            @JsonProperty("medigun") String medigun
    ){
        this.type = type;
        this.time = time;
        this.team = team;
        this.steamid = steamid;
        this.killer = killer;
        this.medigun = medigun;
    }

    public String getType() {
        return type;
    }

    public int getTime() {
        return time;
    }

    public String getTeam() {
        return team;
    }

    public String getSteamid() {
        return steamid;
    }

    public String getKiller() {
        return killer;
    }

    public String getMedigun() {
        return medigun;
    }
}