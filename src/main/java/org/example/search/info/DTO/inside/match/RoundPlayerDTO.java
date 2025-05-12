package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Статистика игрока за раунд
 */
public class RoundPlayerDTO {

    /**
     * Название команды (Red, Blue)
     */
    private final String team;

    /**
     * Кол-во убийств за раунд
     */
    private final int kills;

    /**
     * Нанесенный damage за раунд
     */
    private final int dmg;

    public RoundPlayerDTO(
          @JsonProperty("team") String team,
          @JsonProperty("kills")  int kills,
          @JsonProperty("dmg")  int dmg
    ) {
        this.team = team;
        this.kills = kills;
        this.dmg = dmg;
    }

    public String getTeam() {
        return team;
    }

    public int getKills() {
        return kills;
    }

    public int getDmg() {
        return dmg;
    }
}