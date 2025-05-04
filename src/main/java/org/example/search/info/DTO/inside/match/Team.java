package org.example.search.info.DTO.inside.match;

public class Team {

    private int score;
    private boolean score_open = true;

    private int kills;
    private boolean kills_open = true;

    private int deaths;
    private boolean deaths_open = true;

    private int dmg;
    private boolean dmg_open = true;

    private int charges;
    private boolean charges_open = true;

    private int drops;
    private boolean drops_open = true;

    private int firstcaps;
    private boolean firstcaps_open = true;

    private int caps;
    private boolean caps_open = true;

    public int getScore() { return score; }
    public void setScore(int score) {
        if (score_open) {
            this.score = score;
            score_open = false;
        }
    }

    public int getKills() { return kills; }
    public void setKills(int kills) {
        if (kills_open) {
            this.kills = kills;
            kills_open = false;
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

    public int getCharges() { return charges; }
    public void setCharges(int charges) {
        if (charges_open) {
            this.charges = charges;
            charges_open = false;
        }
    }

    public int getDrops() { return drops; }
    public void setDrops(int drops) {
        if (drops_open) {
            this.drops = drops;
            drops_open = false;
        }
    }

    public int getFirstcaps() { return firstcaps; }
    public void setFirstcaps(int firstcaps) {
        if (firstcaps_open) {
            this.firstcaps = firstcaps;
            firstcaps_open = false;
        }
    }

    public int getCaps() { return caps; }
    public void setCaps(int caps) {
        if (caps_open) {
            this.caps = caps;
            caps_open = false;
        }
    }

    private int ubers;
    private boolean ubers_open = true;

    public int getUbers() {
        return ubers;
    }

    public void setUbers(int ubers) {
        if(ubers_open){
            this.ubers = ubers;
            ubers_open = false;
        }
    }
}