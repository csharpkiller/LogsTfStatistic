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
     * ключ: SteamId игрока, значения: персонажи от которых он умер в матче
     */
    private Map<String, ClassDeathEntryDTO> entries = new HashMap<>();
    private boolean entries_open = true; // lateinit realisation

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
     * Имя переменной - персонаж, значение - сколько раз игрок от него умер
     */
    private final int scout;
    private final int medic;
    private final int soldier;
    private final int demoman;
    private final int heavyweapons;
    private final int pyro;
    private final int sniper;
    private final int engineer;
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
