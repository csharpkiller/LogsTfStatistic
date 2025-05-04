package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class PlayerMap {

    private Map<String, Player> playerMap = new HashMap<>();
    private boolean playerMap_open = true;

    @JsonAnySetter
    public void handlePlayer(String key, Player value) {
        playerMap.put(key, value);
    }

    public Map<String, Player> getPlayerMap() {
        return playerMap;
    }

    public void setPlayerMap(Map<String, Player> playerMap) {
        if (playerMap_open) {
            this.playerMap = playerMap;
            playerMap_open = false;
        }
    }
}