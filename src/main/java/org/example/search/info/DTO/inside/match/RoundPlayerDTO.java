package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Статистика игрока за раунд
 */
public class RoundPlayerDTO {
    private final String team; // название команды (Red, Blue)
    private final int kills; // кол-во убийств за раунд
    private final int dmg; // нанесенный damage за раунд

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