package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Информация о серии убийств
 */
public class KillStreakDTO {
    private final String steamid; // steam id игрока
    private final int streak; // кол-во убийств за одну жизнь
    private final int time; // время, которое держался streak (до первой смерти)

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
