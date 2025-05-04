package org.example.search.info.DTO.inside.match;

public class RoundPlayer {

    private String team;
    private boolean team_open = true;

    private int kills;
    private boolean kills_open = true;

    private int dmg;
    private boolean dmg_open = true;

    public String getTeam() { return team; }
    public void setTeam(String team) {
        if (team_open) {
            this.team = team;
            team_open = false;
        }
    }

    public int getKills() { return kills; }
    public void setKills(int kills) {
        if (kills_open) {
            this.kills = kills;
            kills_open = false;
        }
    }

    public int getDmg() { return dmg; }
    public void setDmg(int dmg) {
        if (dmg_open) {
            this.dmg = dmg;
            dmg_open = false;
        }
    }
}