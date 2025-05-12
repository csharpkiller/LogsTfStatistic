package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Информация о том кто загрузил результаты матча
 */
public class UploaderDTO {

    /**
     * Steam id игрока в формате id64
     */
    private final String id;

    /**
     * Nickname игрока в матче
     */
    private final String name;

    /**
     * Дополнительная информация
     */
    private final String info;

    public UploaderDTO(
           @JsonProperty("id") String id,
           @JsonProperty("name") String name,
           @JsonProperty("info") String info
    ) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}