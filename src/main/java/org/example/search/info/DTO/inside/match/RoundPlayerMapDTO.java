package org.example.search.info.DTO.inside.match;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;

/**
 * Статистики игроков за раунд
 */
public class RoundPlayerMapDTO {

    /**
     * Ключ: steam id игрока, значение: статистики игрока за раунд
     */
    private Map<String, RoundPlayerDTO> players = new HashMap<>();

    /**
     * lateinit realisation
     */
    private boolean players_open = true;

    /**
     * Для парсинга
     */
    @JsonAnySetter
    public void handlePlayer(String key, RoundPlayerDTO value) {
        players.put(key, value);
    }

    public Map<String, RoundPlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, RoundPlayerDTO> players) {
        if (players_open) {
            this.players = players;
            players_open = false;
        }
    }
}