package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Информация о серии убийств
 */
public class KillStreakDTO {

    /**
     * Steam id игрока в формате id64
     */
    private final String steamid;

    /**
     * Кол-во убийств за одну жизнь
     */
    private final int streak;

    /**
     * Время, которое держался streak (до первой смерти)
     */
    private final int time;

    public KillStreakDTO(
            @JsonProperty("steamid") String steamid,
            @JsonProperty("streak") int streak,
            @JsonProperty("time") int time
    ) {
        this.steamid = steamid;
        this.streak = streak;
        this.time = time;
    }

    public String getSteamid() {
        return steamid;
    }

    public int getStreak() {
        return streak;
    }

    public int getTime() {
        return time;
    }
}
