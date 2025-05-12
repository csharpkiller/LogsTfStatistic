package org.example.search.info;

import org.example.search.info.objectwrappers.SteamID;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Генерация API URL
 */
public class ApiLinkCreator {

    /**
     * logs.tf api link без добавочных параметров
     */
    private static final String BASED_WORKED_API_LINK_FOR_MATCHES = "http://logs.tf/api/v1/log";

    /**
     * Добавочные параметры для BASED_WORKED_API_LINK_FOR_MATCHES
     */
    private final Map<String, String> parameters = new LinkedHashMap<>();

    public ApiLinkCreator setTitle(String title) {
        parameters.put("title", title);
        return this;

    }

    public ApiLinkCreator setMap(String map) {
        parameters.put("map", map);
        return this;
    }

    public ApiLinkCreator setUploader(String uploader) {
        parameters.put("uploader", uploader);
        return this;
    }

    public ApiLinkCreator setPlayer(SteamID player) {
        parameters.put("player", player.getSteamID64());
        return this;
    }

    public ApiLinkCreator setLimit(int limit) {
        parameters.put("limit", String.valueOf(limit));
        return this;
    }

    public ApiLinkCreator setOffset(int offset) {
        parameters.put("offset", String.valueOf(offset));
        return this;
    }

    /**
     * Удалить все параметры для создания новой ссылки.
     * @return ApiLinkCreator
     */
    public ApiLinkCreator clear(){
        parameters.clear();
        return this;
    }

    /**
     * Собрать/создать ссылку для вывода списка матчей
     * @return string logs.tf api link
     */
    public String build() {
        if (parameters.isEmpty()) {
            return BASED_WORKED_API_LINK_FOR_MATCHES;
        }
        StringBuilder sb = new StringBuilder(BASED_WORKED_API_LINK_FOR_MATCHES);
        sb.append("?");
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * Создать ссылку для вывода результата матча
     * @param matchId id матча
     * @return string logs.tf api link
     */
    public String createLinkForInsideMatch(String matchId){
        return "http://logs.tf/api/v1/log/"+matchId;
    }
}
