package org.example.search.info.DTO.inside.match;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Чат матча
 */
public class ChatDTO {
    /**
     * SteamId игрока в формате id64
     */
    private final String steamid;

    /**
     * Nickname игрока в матче
     */
    private final String name;

    /**
     * Что написал игрок в чате во время матча
     */
    private final String msg;

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
