package org.example.search.info;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApiLinkCreator {
    private static final String BASE_URL = "http://logs.tf/api/v1/log"; //будет выдавать все логи
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

    public ApiLinkCreator setPlayer(String player) {
        parameters.put("player", player);
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

    public ApiLinkCreator clear(){
        parameters.clear();
        return this;
    }

    public String build() {
        if (parameters.isEmpty()) {
            return BASE_URL;
        }
        StringBuilder sb = new StringBuilder(BASE_URL);
        sb.append("?");
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String createLinkForInsideMatch(String matchId){
        return "http://logs.tf/api/v1/log/"+matchId;
    }
}
