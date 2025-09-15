package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Информация о том кто загрузил результаты матча
 */
public class UploaderDTO {
    private final String id; // steam id игрока
    private final String name; // nickname игрока
    private final String info; // Дополнительная информация

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