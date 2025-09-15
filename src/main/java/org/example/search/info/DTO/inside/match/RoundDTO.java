package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Информация о раунде в матче
 */
public class RoundDTO {
    private final long start_time; // дата начала в timestamp
    private final String winner; // название команды которая победила
    private final RoundTeamDTO team; // информацию о командах участвующих в раунде
    private final RoundEventDTO[] events; // основные события раунда
    private final RoundPlayerMapDTO players; // контейнер, связывающий SteamID игрока с его статистикой в этом раунде
    private final String firstcap; // команда которая первой захватила контрольную точку в раунде
    private final int length; // Длительность раунда в секундах .

    public RoundDTO(
           @JsonProperty("start_time") long start_time,
           @JsonProperty("winner") String winner,
           @JsonProperty("team") RoundTeamDTO team,
           @JsonProperty("events") RoundEventDTO[] events,
           @JsonProperty("players") RoundPlayerMapDTO players,
           @JsonProperty("firstcap") String firstcap,
           @JsonProperty("length") int length
    ) {
        this.start_time = start_time;
        this.winner = winner;
        this.team = team;
        this.events = events;
        this.players = players;
        this.firstcap = firstcap;
        this.length = length;
    }

    public long getStart_time() {
        return start_time;
    }

    public String getWinner() {
        return winner;
    }

    public RoundTeamDTO getTeam() {
        return team;
    }

    public RoundEventDTO[] getEvents() {
        return events;
    }

    public RoundPlayerMapDTO getPlayers() {
        return players;
    }

    public String getFirstcap() {
        return firstcap;
    }

    public int getLength() {
        return length;
    }
}
