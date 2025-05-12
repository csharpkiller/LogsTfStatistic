package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Контейнер команд за раунд
 */
public class RoundTeamDTO {

    /**
     * Общая сводка информации в RED TEAM
     */
    private final TeamDTO red;

    /**
     * Общая сводка информации BLUE TEAM
     */
    private final TeamDTO blue;

    public RoundTeamDTO(
            @JsonProperty("Red") TeamDTO red,
            @JsonProperty("Blue") TeamDTO blue) {
        this.red = red;
        this.blue = blue;
    }

    public TeamDTO getRed() {
        return red;
    }

    public TeamDTO getBlue() {
        return blue;
    }
}