package org.example.search.info.DTO.inside.match;

public class ClassStats {

    private String type;
    private boolean type_open = true;

    private int kills;
    private boolean kills_open = true;

    private int assists;
    private boolean assists_open = true;

    private int deaths;
    private boolean deaths_open = true;

    private int dmg;
    private boolean dmg_open = true;

    private WeaponMap weapon;
    private boolean weapon_open = true;

    private int total_time;
    private boolean total_time_open = true;

    public String getType() { return type; }
    public void setType(String type) {
        if (type_open) {
            this.type = type;
            type_open = false;
        }
    }

    public int getKills() { return kills; }
    public void setKills(int kills) {
        if (kills_open) {
            this.kills = kills;
            kills_open = false;
        }
    }

    public int getAssists() { return assists; }
    public void setAssists(int assists) {
        if (assists_open) {
            this.assists = assists;
            assists_open = false;
        }
    }

    public int getDeaths() { return deaths; }
    public void setDeaths(int deaths) {
        if (deaths_open) {
            this.deaths = deaths;
            deaths_open = false;
        }
    }

    public int getDmg() { return dmg; }
    public void setDmg(int dmg) {
        if (dmg_open) {
            this.dmg = dmg;
            dmg_open = false;
        }
    }

    public WeaponMap getWeapon() { return weapon; }
    public void setWeapon(WeaponMap weapon) {
        if (weapon_open) {
            this.weapon = weapon;
            weapon_open = false;
        }
    }

    public int getTotal_time() { return total_time; }
    public void setTotal_time(int total_time) {
        if (total_time_open) {
            this.total_time = total_time;
            total_time_open = false;
        }
    }
}
