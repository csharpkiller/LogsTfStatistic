package org.example.search.info;

/**
 * Персонаж, либо все персонажи,
 * либо набор персонажей (scout + soldier) - скорее всего не будет реализовано (на будущее)
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
    SPY("spy");

    public final String label;
    public static GameHero valueOfLabel(String label) {
        for (GameHero e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return null;
    }
    private GameHero(String label) {
        this.label = label;
    }
}
