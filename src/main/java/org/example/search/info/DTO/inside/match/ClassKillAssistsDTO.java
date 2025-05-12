package org.example.search.info.DTO.inside.match;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

/**
 * Участие в помощи убийства
 */
public class ClassKillAssistsDTO {

    /**
     * Ключ: steam id игрока, значение: На каких персонажах помог и сколько раз
     */
    private Map<String, ClassKillAssistEntryDTO> entries = new HashMap<>();

    /**
     * lateinit realisation
     */
    private boolean entries_open = true;

    /**
     *Для парсинга в entries
     */
    @JsonAnySetter
    public void handleEntry(String steamid, ClassKillAssistEntryDTO entry) {
        entries.put(steamid, entry);
    }

    public Map<String, ClassKillAssistEntryDTO> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, ClassKillAssistEntryDTO> entries) {
        if (entries_open) {
            this.entries = entries;
            entries_open = false;
        }
    }
}

/**
 * Статистика помощи в убийствах (ассистов) в убийствах, разбитый
 * по персонажам, за которые была оказана помощь.
 * Каждый экземпляр этого класса обычно отражает, сколько раз игрок оказывал помощь в убийствах за определённый период времени,
 * разбитой по классам, за которые была оказана эта помощь.
 */
class ClassKillAssistEntryDTO {

    /**
     * Кол-во помощи при убийствах на scout
     */
    private final int scout;

    /**
     * Кол-во помощи при убийствах на medic
     */
    private final int medic;

    /**
     * Кол-во помощи при убийствах на soldier
     */
    private final int soldier;

    /**
     * Кол-во помощи при убийствах на demoman
     */
    private final int demoman;

    /**
     * Кол-во помощи при убийствах на heavyweapons
     */
    private final int heavyweapons;

    /**
     * Кол-во помощи при убийствах на pyro
     */
    private final int pyro;

    /**
     * Кол-во помощи при убийствах на sniper
     */
    private final int sniper;

    /**
     * Кол-во помощи при убийствах на engineer
     */
    private final int engineer;

    /**
     * Кол-во помощи при убийствах на spy
     */
    private final int spy;

    public ClassKillAssistEntryDTO(
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
