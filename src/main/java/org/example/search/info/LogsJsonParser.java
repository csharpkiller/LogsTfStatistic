package org.example.search.info;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.search.info.DTO.inside.match.MatchRoot;
import org.example.search.info.DTO.matches.list.JsonRootMatch;
import org.example.search.info.DTO.matches.list.MatchDTO;
import org.example.search.info.DTO.ParseResult;
import org.example.search.info.objectwrappers.Json;

import java.util.List;

/**
 * Класс предназначен для конвертации json файла в объект/список объектов Java из пакета DTO
 * со всеми полями JSON объекта
 */
public class LogsJsonParser {

    private static final ObjectMapper objectMapperForMatchList = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // если нет в data class нужных полей, то игнорим и заполняем те что есть
    private static final ObjectMapper objectMapperForInsideMatch = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // same, на всякий случай

    /**
     * Парсит string json в список матчей
     * @param json json String
     * @return контейнер с json объектом и результатом парсинга.
     */
    public ParseResult<List<MatchDTO>> parseToMatchList(Json json){
        List<MatchDTO> matchDTOList;
        try {
            JsonRootMatch root = objectMapperForMatchList.readValue(json.getValue(), JsonRootMatch.class);
            matchDTOList =  root.getLogs();
            return new ParseResult<>(matchDTOList, false);
        } catch (JsonProcessingException e) {
            return new ParseResult<>(List.of(), true);
        }
    }

    /**
     * Парсит string json в объект Java
     * @param json json String
     * @return Json Obj
     */
    public ParseResult<MatchRoot> parseToMatchResult(Json json){
        MatchRoot matchInfo;
        try {
            matchInfo = objectMapperForInsideMatch.readValue(json.getValue(), MatchRoot.class);
            return new ParseResult<>(matchInfo, false);
        } catch (JsonProcessingException e) {
            return new ParseResult<>(new MatchRoot(), true);
        }
    }
}
