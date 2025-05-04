package org.example.search.info.DTO.inside.match;

public class KillStreak {

    private String steamid;
    private boolean steamid_open = true;

    private int streak;
    private boolean streak_open = true;

    private int time;
    private boolean time_open = true;

    public String getSteamid() {
        return steamid;
    }

    public void setSteamid(String steamid) {
        if (steamid_open) {
            this.steamid = steamid;
            steamid_open = false;
        }
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        if (streak_open) {
            this.streak = streak;
            streak_open = false;
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        if (time_open) {
            this.time = time;
            time_open = false;
        }
    }
}
