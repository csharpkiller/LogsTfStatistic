package org.example.search.info.DTO.inside.match;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class ClassKillAssists {

    private Map<String, ClassKillAssistEntry> entries = new HashMap<>();
    private boolean entries_open = true;

    @JsonAnySetter
    public void handleEntry(String steamid, ClassKillAssistEntry entry) {
        entries.put(steamid, entry);
    }

    public Map<String, ClassKillAssistEntry> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, ClassKillAssistEntry> entries) {
        if (entries_open) {
            this.entries = entries;
            entries_open = false;
        }
    }
}

class ClassKillAssistEntry {

    private int scout;
    private boolean scout_open = true;

    private int medic;
    private boolean medic_open = true;

    private int soldier;
    private boolean soldier_open = true;

    private int demoman;
    private boolean demoman_open = true;

    private int heavyweapons;
    private boolean heavyweapons_open = true;

    private int pyro;
    private boolean pyro_open = true;

    private int sniper;
    private boolean sniper_open = true;

    private int engineer;
    private boolean engineer_open = true;

    private int spy;
    private boolean spy_open = true;

    // Геттеры + сеттеры
    public int getScout() { return scout; }
    public void setScout(int scout) {
        if (scout_open) {
            this.scout = scout;
            scout_open = false;
        }
    }

    public int getMedic() { return medic; }
    public void setMedic(int medic) {
        if (medic_open) {
            this.medic = medic;
            medic_open = false;
        }
    }

    public int getSoldier() { return soldier; }
    public void setSoldier(int soldier) {
        if (soldier_open) {
            this.soldier = soldier;
            soldier_open = false;
        }
    }

    public int getDemoman() { return demoman; }
    public void setDemoman(int demoman) {
        if (demoman_open) {
            this.demoman = demoman;
            demoman_open = false;
        }
    }

    public int getHeavyweapons() { return heavyweapons; }
    public void setHeavyweapons(int heavyweapons) {
        if (heavyweapons_open) {
            this.heavyweapons = heavyweapons;
            heavyweapons_open = false;
        }
    }

    public int getPyro() { return pyro; }
    public void setPyro(int pyro) {
        if (pyro_open) {
            this.pyro = pyro;
            pyro_open = false;
        }
    }

    public int getSniper() { return sniper; }
    public void setSniper(int sniper) {
        if (sniper_open) {
            this.sniper = sniper;
            sniper_open = false;
        }
    }

    public int getEngineer() { return engineer; }
    public void setEngineer(int engineer) {
        if (engineer_open) {
            this.engineer = engineer;
            engineer_open = false;
        }
    }

    public int getSpy() { return spy; }
    public void setSpy(int spy) {
        if (spy_open) {
            this.spy = spy;
            spy_open = false;
        }
    }
}
