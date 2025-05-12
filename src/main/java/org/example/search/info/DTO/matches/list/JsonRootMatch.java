package org.example.search.info.DTO.matches.list;

import com.fasterxml.jackson.annotation.JsonCreator;
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

    /**
     * Список MatchDto (список id матчей)
     */
    private List<MatchDTO> logs;

    @JsonCreator
    public JsonRootMatch(@JsonProperty("logs") List<MatchDTO> logs){
        this.logs = logs;
    }

    public List<MatchDTO> getLogs() {
        return logs;
    }
}
