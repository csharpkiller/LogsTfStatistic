package org.example.search.info.DTO.inside.match;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class RoundPlayerMap {

    private Map<String, RoundPlayer> players = new HashMap<>();
    private boolean players_open = true;

    @JsonAnySetter
    public void handlePlayer(String key, RoundPlayer value) {
        players.put(key, value);
    }

    public Map<String, RoundPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, RoundPlayer> players) {
        if (players_open) {
            this.players = players;
            players_open = false;
        }
    }
}