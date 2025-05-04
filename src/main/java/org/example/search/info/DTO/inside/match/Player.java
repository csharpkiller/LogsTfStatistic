package org.example.search.info.DTO.inside.match;

import java.util.Map;

public class Player {

    private String team;
    private boolean team_open = true;

    private ClassStats[] class_stats;
    private boolean class_stats_open = true;

    private int kills;
    private boolean kills_open = true;

    private int deaths;
    private boolean deaths_open = true;

    private int assists;
    private boolean assists_open = true;

    private int suicides;
    private boolean suicides_open = true;

    private String kapd;
    private boolean kapd_open = true;

    private String kpd;
    private boolean kpd_open = true;

    private int dmg;
    private boolean dmg_open = true;

    private int dmg_real;
    private boolean dmg_real_open = true;

    private int dt;
    private boolean dt_open = true;

    private int dt_real;
    private boolean dt_real_open = true;

    private int hr;
    private boolean hr_open = true;

    private int lks;
    private boolean lks_open = true;

    private int as;
    private boolean as_open = true;

    private int dapd;
    private boolean dapd_open = true;

    private int dapm;
    private boolean dapm_open = true;

    private int ubers;
    private boolean ubers_open = true;

    private UberTypes ubertypes;
    private boolean ubertypes_open = true;

    private int drops;
    private boolean drops_open = true;

    private int medkits;
    private boolean medkits_open = true;

    private int medkits_hp;
    private boolean medkits_hp_open = true;

    private int backstabs;
    private boolean backstabs_open = true;

    private int headshots;
    private boolean headshots_open = true;

    private int headshots_hit;
    private boolean headshots_hit_open = true;

    private int sentries;
    private boolean sentries_open = true;

    private int heal;
    private boolean heal_open = true;

    private int cpc;
    private boolean cpc_open = true;

    private int ic;
    private boolean ic_open = true;

    private MedicStats medicstats;
    private boolean medicstats_open = true;

    public String getTeam() { return team; }
    public void setTeam(String team) {
        if (team_open) {
            this.team = team;
            team_open = false;
        }
    }

    public ClassStats[] getClass_stats() { return class_stats; }
    public void setClass_stats(ClassStats[] class_stats) {
        if (class_stats_open) {
            this.class_stats = class_stats;
            class_stats_open = false;
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

    public int getAssists() { return assists; }
    public void setAssists(int assists) {
        if (assists_open) {
            this.assists = assists;
            assists_open = false;
        }
    }

    public int getSuicides() { return suicides; }
    public void setSuicides(int suicides) {
        if (suicides_open) {
            this.suicides = suicides;
            suicides_open = false;
        }
    }

    public String getKapd() { return kapd; }
    public void setKapd(String kapd) {
        if (kapd_open) {
            this.kapd = kapd;
            kapd_open = false;
        }
    }

    public String getKpd() { return kpd; }
    public void setKpd(String kpd) {
        if (kpd_open) {
            this.kpd = kpd;
            kpd_open = false;
        }
    }

    public int getDmg() { return dmg; }
    public void setDmg(int dmg) {
        if (dmg_open) {
            this.dmg = dmg;
            dmg_open = false;
        }
    }

    public int getDmg_real() { return dmg_real; }
    public void setDmg_real(int dmg_real) {
        if (dmg_real_open) {
            this.dmg_real = dmg_real;
            dmg_real_open = false;
        }
    }

    public int getDt() { return dt; }
    public void setDt(int dt) {
        if (dt_open) {
            this.dt = dt;
            dt_open = false;
        }
    }

    public int getDt_real() { return dt_real; }
    public void setDt_real(int dt_real) {
        if (dt_real_open) {
            this.dt_real = dt_real;
            dt_real_open = false;
        }
    }

    public int getHr() { return hr; }
    public void setHr(int hr) {
        if (hr_open) {
            this.hr = hr;
            hr_open = false;
        }
    }

    public int getLks() { return lks; }
    public void setLks(int lks) {
        if (lks_open) {
            this.lks = lks;
            lks_open = false;
        }
    }

    public int getAs() { return as; }
    public void setAs(int as) {
        if (as_open) {
            this.as = as;
            as_open = false;
        }
    }

    public int getDapd() { return dapd; }
    public void setDapd(int dapd) {
        if (dapd_open) {
            this.dapd = dapd;
            dapd_open = false;
        }
    }

    public int getDapm() { return dapm; }
    public void setDapm(int dapm) {
        if (dapm_open) {
            this.dapm = dapm;
            dapm_open = false;
        }
    }

    public int getUbers() { return ubers; }
    public void setUbers(int ubers) {
        if (ubers_open) {
            this.ubers = ubers;
            ubers_open = false;
        }
    }

    public UberTypes getUbertypes() { return ubertypes; }
    public void setUbertypes(UberTypes ubertypes) {
        if (ubertypes_open) {
            this.ubertypes = ubertypes;
            ubertypes_open = false;
        }
    }

    public int getDrops() { return drops; }
    public void setDrops(int drops) {
        if (drops_open) {
            this.drops = drops;
            drops_open = false;
        }
    }

    public int getMedkits() { return medkits; }
    public void setMedkits(int medkits) {
        if (medkits_open) {
            this.medkits = medkits;
            medkits_open = false;
        }
    }

    public int getMedkits_hp() { return medkits_hp; }
    public void setMedkits_hp(int medkits_hp) {
        if (medkits_hp_open) {
            this.medkits_hp = medkits_hp;
            medkits_hp_open = false;
        }
    }

    public int getBackstabs() { return backstabs; }
    public void setBackstabs(int backstabs) {
        if (backstabs_open) {
            this.backstabs = backstabs;
            backstabs_open = false;
        }
    }

    public int getHeadshots() { return headshots; }
    public void setHeadshots(int headshots) {
        if (headshots_open) {
            this.headshots = headshots;
            headshots_open = false;
        }
    }

    public int getHeadshots_hit() { return headshots_hit; }
    public void setHeadshots_hit(int headshots_hit) {
        if (headshots_hit_open) {
            this.headshots_hit = headshots_hit;
            headshots_hit_open = false;
        }
    }

    public int getSentries() { return sentries; }
    public void setSentries(int sentries) {
        if (sentries_open) {
            this.sentries = sentries;
            sentries_open = false;
        }
    }

    public int getHeal() { return heal; }
    public void setHeal(int heal) {
        if (heal_open) {
            this.heal = heal;
            heal_open = false;
        }
    }

    public int getCpc() { return cpc; }
    public void setCpc(int cpc) {
        if (cpc_open) {
            this.cpc = cpc;
            cpc_open = false;
        }
    }

    public int getIc() { return ic; }
    public void setIc(int ic) {
        if (ic_open) {
            this.ic = ic;
            ic_open = false;
        }
    }

    public MedicStats getMedicstats() { return medicstats; }
    public void setMedicstats(MedicStats medicstats) {
        if (medicstats_open) {
            this.medicstats = medicstats;
            medicstats_open = false;
        }
    }
}