package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Контейнер для TeamDTO
 */
public class TeamsDTO {

    /**
     * Общая сводка информации по команде Red
     */
    private final TeamDTO Red;

    /**
     * Общая сводка информации по команде Blue
     */
    private final TeamDTO Blue;

    public TeamsDTO(
           @JsonProperty("Red") TeamDTO red,
           @JsonProperty("Blue") TeamDTO blue
    ) {
        Red = red;
        Blue = blue;
    }

    public TeamDTO getRed() {
        return Red;
    }

    public TeamDTO getBlue() {
        return Blue;
    }
}