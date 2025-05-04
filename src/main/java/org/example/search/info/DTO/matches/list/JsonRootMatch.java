package org.example.search.info.DTO.matches.list;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Для парсинга с помощью Jackson
 * Корневой объект, который содержит все корневые поля Json,
 * но их нет тк они мне не нужны и не будут нужны
 * использую ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).
 * Как вариант можно было бы полностью запарсить, но в данном случае это излишне (бесполезная инфа).
 */
public class JsonRootMatch {
    @JsonProperty("logs")
    private List<MatchDTO> logs;
    private boolean logs_open = true;

    public List<MatchDTO> getLogs() {
        return logs;
    }

    public void setLogs(List<MatchDTO> logs) {
        if(logs_open) {
            this.logs = logs;
            logs_open = false;
        }
    }
}
