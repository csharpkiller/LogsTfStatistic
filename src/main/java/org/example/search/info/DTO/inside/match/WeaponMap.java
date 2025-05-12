package org.example.search.info.DTO.inside.match;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;

/**
 * Статистики оружия
 */
public class WeaponMap {

    /**
     * Ключ - название оружия, значение - статистика оружия
     */
    private Map<String, Weapon> weapons = new HashMap<>();

    /**
     * lateinit realisation
     */
    private boolean weapons_open = true;

    /**
     * Для парсинга
     */
    @JsonAnySetter
    public void handleWeapon(String key, Weapon value) {
        weapons.put(key, value);
    }

    public Map<String, Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(Map<String, Weapon> weapons) {
        if (weapons_open) {
            this.weapons = weapons;
            weapons_open = false;
        }
    }
}