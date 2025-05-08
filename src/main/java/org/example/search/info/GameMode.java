package org.example.search.info;

/**
 * Игровой режимы
 */
public enum GameMode {
    SIXES(12),
    HIGHLANDER(18),
    ULTIDUO_BBAL(4),
    NULL(-1); // TODO добавил для streamAPI, мб как-то по-другмоу можно решить

    public final Integer playersCountInGameMode;

    public static GameMode valueOfPlayersCount(Integer count) {
        for (GameMode e : values()) {
            if (e.playersCountInGameMode.equals(count)) {
                return e;
            }
        }
        return NULL;
    }

    GameMode(Integer playersCountInGameMode){
        this.playersCountInGameMode = playersCountInGameMode;
    }
}
