package org.example.search.info.DTO.inside.match;

public class RoundEvent {

    private String type;
    private boolean type_open = true;

    private int time;
    private boolean time_open = true;

    private String team;
    private boolean team_open = true;

    private String steamid;
    private boolean steamid_open = true;

    private String killer;
    private boolean killer_open = true;

    private String medigun;
    private boolean medigun_open = true;

    public String getType() { return type; }
    public void setType(String type) {
        if (type_open) {
            this.type = type;
            type_open = false;
        }
    }

    public int getTime() { return time; }
    public void setTime(int time) {
        if (time_open) {
            this.time = time;
            time_open = false;
        }
    }

    public String getTeam() { return team; }
    public void setTeam(String team) {
        if (team_open) {
            this.team = team;
            team_open = false;
        }
    }

    public String getSteamid() { return steamid; }
    public void setSteamid(String steamid) {
        if (steamid_open) {
            this.steamid = steamid;
            steamid_open = false;
        }
    }

    public String getKiller() { return killer; }
    public void setKiller(String killer) {
        if (killer_open) {
            this.killer = killer;
            killer_open = false;
        }
    }

    public String getMedigun() { return medigun; }
    public void setMedigun(String medigun) {
        if (medigun_open) {
            this.medigun = medigun;
            medigun_open = false;
        }
    }

    private int point;
    private boolean point_open = true;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        if(point_open){
            this.point = point;
            point_open=false;
        }
    }
}