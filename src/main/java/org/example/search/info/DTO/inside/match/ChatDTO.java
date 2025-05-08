package org.example.search.info.DTO.inside.match;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Чат матча
 */
public class ChatDTO {

    private final String steamid; // steamId игрока
    private final String name; // nickname игрока
    private final String msg; // что написал в игре

    public ChatDTO(
            @JsonProperty("steamid") String steamid,
            @JsonProperty("name") String name,
            @JsonProperty("msg") String msg) {
        this.steamid = steamid;
        this.name = name;
        this.msg = msg;
    }

    public String getSteamid() {
        return steamid;
    }

    public String getName() {
        return name;
    }

    public String getMsg() {
        return msg;
    }
}
