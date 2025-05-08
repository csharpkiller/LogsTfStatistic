package org.example.search.info;

/**
 * Персонаж
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
        for (GameHero e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return NULL;
    }
    GameHero(String label) {
        this.label = label;
    }
}
