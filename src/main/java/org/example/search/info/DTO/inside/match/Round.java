package org.example.search.info.DTO.inside.match;

public class Round {

    private long start_time;
    private boolean start_time_open = true;

    private String winner;
    private boolean winner_open = true;

    private RoundTeam team;
    private boolean team_open = true;

    private RoundEvent[] events;
    private boolean events_open = true;

    private RoundPlayerMap players;
    private boolean players_open = true;

    private String firstcap;
    private boolean firstcap_open = true;

    private int length;
    private boolean length_open = true;

    public long getStart_time() { return start_time; }
    public void setStart_time(long start_time) {
        if (start_time_open) {
            this.start_time = start_time;
            start_time_open = false;
        }
    }

    public String getWinner() { return winner; }
    public void setWinner(String winner) {
        if (winner_open) {
            this.winner = winner;
            winner_open = false;
        }
    }

    public RoundTeam getTeam() { return team; }
    public void setTeam(RoundTeam team) {
        if (team_open) {
            this.team = team;
            team_open = false;
        }
    }

    public RoundEvent[] getEvents() { return events; }
    public void setEvents(RoundEvent[] events) {
        if (events_open) {
            this.events = events;
            events_open = false;
        }
    }

    public RoundPlayerMap getPlayers() { return players; }
    public void setPlayers(RoundPlayerMap players) {
        if (players_open) {
            this.players = players;
            players_open = false;
        }
    }

    public String getFirstcap() { return firstcap; }
    public void setFirstcap(String firstcap) {
        if (firstcap_open) {
            this.firstcap = firstcap;
            firstcap_open = false;
        }
    }

    public int getLength() { return length; }
    public void setLength(int length) {
        if (length_open) {
            this.length = length;
            length_open = false;
        }
    }
}
