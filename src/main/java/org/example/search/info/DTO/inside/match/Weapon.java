package org.example.search.info.DTO.inside.match;

public class Weapon {

    private int kills;
    private boolean kills_open = true;

    private int dmg;
    private boolean dmg_open = true;

    private double avg_dmg;
    private boolean avg_dmg_open = true;

    private int shots;
    private boolean shots_open = true;

    private int hits;
    private boolean hits_open = true;

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

    public double getAvg_dmg() { return avg_dmg; }
    public void setAvg_dmg(double avg_dmg) {
        if (avg_dmg_open) {
            this.avg_dmg = avg_dmg;
            avg_dmg_open = false;
        }
    }

    public int getShots() { return shots; }
    public void setShots(int shots) {
        if (shots_open) {
            this.shots = shots;
            shots_open = false;
        }
    }

    public int getHits() { return hits; }
    public void setHits(int hits) {
        if (hits_open) {
            this.hits = hits;
            hits_open = false;
        }
    }
}
