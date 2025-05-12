package org.example.analys;

/**
 * Форматирование название карты
 */
public class GameMapFormat {

    /**
     * Возвращает название карты без версии
     * @param map полное название карты
     * @return название карты без версии
     */
    public String ignoreMapVersion(String map){
        if (map == null || map.isEmpty()) {
            return "";
        }

        String[] parts = map.split("_");
        if (parts.length < 2) {
            return map;
        }

        return parts[0] + "_" + parts[1];
    }
}
