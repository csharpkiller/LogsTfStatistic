package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Teams {

    @JsonProperty("Red")
    private Team Red;
    private boolean red_open = true;

    @JsonProperty("Blue")
    private Team Blue;
    private boolean blue_open = true;

    public Team getRed() { return Red; }
    public void setRed(Team Red) {
        if (red_open) {
            this.Red = Red;
            red_open = false;
        }
    }

    public Team getBlue() { return Blue; }
    public void setBlue(Team Blue) {
        if (blue_open) {
            this.Blue = Blue;
            blue_open = false;
        }
    }
}