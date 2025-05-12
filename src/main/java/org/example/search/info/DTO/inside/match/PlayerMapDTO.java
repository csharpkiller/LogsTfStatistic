package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Подробная информация игроков за матч
 */
public class PlayerMapDTO {

    /**
     * Ключ: steam id игрока, значение: подробная информация за матч
     */
    private Map<String, PlayerDTO> playerMap = new HashMap<>();

    /**
     * lateinit realisation
     */
    private boolean playerMap_open = true;

    /**
     * Для парсинга))
     */
    @JsonAnySetter
    public void handlePlayer(String key, PlayerDTO value) {
        playerMap.put(key, value);
    }

    public Map<String, PlayerDTO> getPlayerMap() {
        return playerMap;
    }

    public void setPlayerMap(Map<String, PlayerDTO> playerMap) {
        if (playerMap_open) {
            this.playerMap = playerMap;
            playerMap_open = false;
        }
    }
}