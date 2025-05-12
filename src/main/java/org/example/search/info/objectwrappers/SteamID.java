package org.example.search.info.objectwrappers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Обертка над steamId
 */
public class SteamID {

    /**
     * Формат [U:1:27416040]
     */
    private final String shortSteamID;

    /**
     * Формат 76561197987681768
     */
    private final String steamID64;

    /**
     * Передали валидный id?
     */
    private final boolean isValidId;

    public SteamID(String input) {
        if (isValidSteamID64(input)) {
            this.steamID64 = input;
            this.shortSteamID = convertToShortID(input);
        } else if (isValidShortID(input)) {
            this.shortSteamID = input;
            this.steamID64 = convertToSteamID64(input);
        } else {
            this.shortSteamID = "not Valid steam id";
            this.steamID64 = "not Valid steam id";
            this.isValidId = false;
            return;
        }
        this.isValidId = true;
    }

    /**
     * Проверка валидации steam id для формата SteamID64
     * @param id steamid
     * @return правильная валидация?
     */
    private boolean isValidSteamID64(String id) {
        if (id == null || id.length() != 17) return false;
        return id.matches("\\d+");
    }

    /**
     * Проверка валидации steam id для формата ShortSteamID
     * @param id steamid
     * @return правильная валидация?
     */
    private boolean isValidShortID(String id) {
        if (id == null) return false;
        String regex = "\\[U:1:\\d+\\]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    /**
     * Конвертация из ShortSteamId в SteamID64
     * @param shortID ShortSteamId
     * @return SteamID64
     */
    private String convertToSteamID64(String shortID) {
        String[] parts = shortID.substring(1, shortID.length() - 1).split(":");
        if (parts.length >= 3 && parts[2].matches("\\d+")) {
            long accountId = Long.parseLong(parts[2]);
            long base = 76561197960265728L;
            return String.valueOf(base + accountId);
        }
        return "not Valid steam id";
    }

    /**
     * Конвертация из SteamID64 в ShortSteamId
     * @param steamID64 steamId64
     * @return ShortSteamId
     */
    private String convertToShortID(String steamID64) {
        long base = 76561197960265728L;
        try {
            long accountId = Long.parseLong(steamID64) - base;
            return "[U:1:" + accountId + "]";
        } catch (NumberFormatException e) {
            return "not Valid steam id";
        }
    }

    public String getShortSteamID() {
        return shortSteamID;
    }

    public String getSteamID64() {
        return steamID64;
    }

    public boolean isValidId() {
        return isValidId;
    }
}
