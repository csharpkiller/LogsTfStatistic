package org.example.search.info;

import java.util.Arrays;

/**
 * Персонажи
 */
public enum GameHero {
    SCOUT("scout"),
    SOLDIER("soldier"),
    PYRO("pyro"),
    DEMOMAN("demoman"),
    HEAVY("heavyweapons"),
    ENJIE("engineer"),
    MEDIC("medic"),
    SNIPER("sniper"),
    SPY("spy"),
    NULL("null"); // TODO StreamApi

    public final String label;
    public static GameHero valueOfLabel(String label) {
        return Arrays.stream(values())
                .filter(hero -> hero.label.equals(label))
                .findFirst()
                .orElse(NULL);
    }
    GameHero(String label) {
        this.label = label;
    }
}
