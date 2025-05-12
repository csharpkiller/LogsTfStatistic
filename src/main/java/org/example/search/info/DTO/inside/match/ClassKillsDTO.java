package org.example.search.info.DTO.inside.match;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

/**
 * Сколько и каких персонажей игрок убил
 */
public class ClassKillsDTO {

    /**
     * Ключ: steam id игрока, значение: каких персонажей убил и сколько раз
     */
    private Map<String, ClassKillEntryDTO> entries = new HashMap<>();

    /**
     * lateinit realisation
     */
    private boolean entries_open = true;

    /**
     * Для парсинга
     */
    @JsonAnySetter
    public void handleEntry(String steamid, ClassKillEntryDTO entry) {
        entries.put(steamid, entry);
    }

    public Map<String, ClassKillEntryDTO> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, ClassKillEntryDTO> entries) {
        if (entries_open) {
            this.entries = entries;
            entries_open = false;
        }
    }
}

/**
 * Количество убитых персонажей
 */
class ClassKillEntryDTO {
    /**
     * Сколько раз игрок убил персонажа scout
     */
    private final int scout;

    /**
     * Сколько раз игрок убил персонажа medic
     */
    private final int medic;

    /**
     * Сколько раз игрок убил персонажа soldier
     */
    private final int soldier;

    /**
     * Сколько раз игрок убил персонажа demoman
     */
    private final int demoman;

    /**
     * Сколько раз игрок убил персонажа heavyweapons
     */
    private final int heavyweapons;

    /**
     * Сколько раз игрок убил персонажа pyro
     */
    private final int pyro;

    /**
     * Сколько раз игрок убил персонажа sniper
     */
    private final int sniper;

    /**
     * Сколько раз игрок убил персонажа engineer
     */
    private final int engineer;

    /**
     * Сколько раз игрок убил персонажа spy
     */
    private final int spy;

    public ClassKillEntryDTO(
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