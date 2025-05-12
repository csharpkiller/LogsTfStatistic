package org.example.search.info.DTO.inside.match;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

/**
 * Содержит информацию о смертях в матче
 */
public class ClassDeathsDTO {

    /**
     * Ключ: SteamId игрока, значения: персонажи от которых он умер в матче
     */
    private Map<String, ClassDeathEntryDTO> entries = new HashMap<>();

    /**
     * lateinit realisation
     */
    private boolean entries_open = true;

    /**
     * Для того чтобы Jackson смог запарсить нормально
     */
    @JsonAnySetter
    public void handleEntry(String steamid, ClassDeathEntryDTO entry) {
        entries.put(steamid, entry);
    }

    public Map<String, ClassDeathEntryDTO> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, ClassDeathEntryDTO> entries) {
        if (entries_open) {
            this.entries = entries;
            entries_open = false;
        }
    }
}

/**
 * Персонажи от которых умер игрок
 */
class ClassDeathEntryDTO {
    /**
     * Сколько раз умер от scout
     */
    private final int scout;

    /**
     * Сколько раз умер от medic
     */
    private final int medic;

    /**
     * Сколько раз умер от soldier
     */
    private final int soldier;

    /**
     * Сколько раз умер от demoman
     */
    private final int demoman;

    /**
     * Сколько раз умер от heavyweapons
     */
    private final int heavyweapons;

    /**
     * Сколько раз умер от pyro
     */
    private final int pyro;

    /**
     * Сколько раз умер от sniper
     */
    private final int sniper;

    /**
     * Сколько раз умер от engineer
     */
    private final int engineer;

    /**
     * Сколько раз умер от spy
     */
    private final int spy;

    public ClassDeathEntryDTO(
            @JsonProperty("scout") int scout,
            @JsonProperty("medic") int medic,
            @JsonProperty("soldier") int soldier,
            @JsonProperty("demoman") int demoman,
            @JsonProperty("heavyweapons") int heavyweapons,
            @JsonProperty("pyro") int pyro,
            @JsonProperty("sniper") int sniper,
            @JsonProperty("engineer") int engineer,
            @JsonProperty("spy") int spy
    ) {
        this.scout = scout;
        this.medic = medic;
        this.soldier = soldier;
        this.demoman = demoman;
        this.heavyweapons = heavyweapons;
        this.pyro = pyro;
        this.sniper = sniper;
        this.engineer = engineer;
        this.spy = spy;
    }

    public int getScout() {
        return scout;
    }

    public int getMedic() {
        return medic;
    }

    public int getSoldier() {
        return soldier;
    }

    public int getDemoman() {
        return demoman;
    }

    public int getHeavyweapons() {
        return heavyweapons;
    }

    public int getPyro() {
        return pyro;
    }

    public int getSniper() {
        return sniper;
    }

    public int getEngineer() {
        return engineer;
    }

    public int getSpy() {
        return spy;
    }
}
