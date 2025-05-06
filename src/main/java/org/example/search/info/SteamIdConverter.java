package org.example.search.info;

/**
 * Конвертация steamId в разные форматы
 * TODO пока верим в верность входящих данных
 */
public class SteamIdConverter {
    public String convertId64ToShortId(String input) {
        long steamid64ident = 76561197960265728L;
        String start = "[U:1:";

        // оставим буфер, про потоки еще нужно будет подумать
        StringBuffer stringBuffer = new StringBuffer(start);
        long res = Long.parseLong(input) - steamid64ident;
        stringBuffer.append(res);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
