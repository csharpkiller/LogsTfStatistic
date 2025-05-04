package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoundTeam {

    @JsonProperty("Red")
    private Team red;
    private boolean red_open = true;

    @JsonProperty("Blue")
    private Team blue;
    private boolean blue_open = true;

    public Team getRed() {
        return red;
    }

    public void setRed(Team red) {
        if (red_open) {
            this.red = red;
            red_open = false;
        }
    }

    public Team getBlue() {
        return blue;
    }

    public void setBlue(Team blue) {
        if (blue_open) {
            this.blue = blue;
            blue_open = false;
        }
    }
}