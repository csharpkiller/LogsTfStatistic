package org.example.search.info.DTO.inside.match;

import java.util.Map;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;

public class HealSpread {

    private Map<String, Map<String, Integer>> healData = new HashMap<>();
    private boolean healData_open = true;

    @JsonAnySetter
    public void handleHeal(String healer, Map<String, Integer> targets) {
        healData.put(healer, targets);
    }

    public Map<String, Map<String, Integer>> getHealData() {
        return healData;
    }

    public void setHealData(Map<String, Map<String, Integer>> healData) {
        if (healData_open) {
            this.healData = healData;
            healData_open = false;
        }
    }
}