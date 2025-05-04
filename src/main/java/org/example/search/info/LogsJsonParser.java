package org.example.search.info;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.search.info.DTO.inside.match.MatchRoot;
import org.example.search.info.DTO.matches.list.JsonRootMatch;
import org.example.search.info.DTO.matches.list.MatchDTO;
import org.example.search.info.DTO.ParseResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс предназначен для конвертации json файла в объект/список объектов Java из пакета DTO
 * со всеми полями JSON объекта
 */
public class LogsJsonParser {

    // сказано так лучше, потокобезопасно для чтения и записи
    private static final ObjectMapper objectMapperForMatchList = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // если нет в data class нужных полей, то игнорим и заполняем те что есть
    private static final ObjectMapper objectMapperForInsideMatch = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // ладно добавил на всякий случай

    public ParseResult<List<MatchDTO>> getMatchList(String json){
        List<MatchDTO> matchDTOList;
        try {
            JsonRootMatch root = objectMapperForMatchList.readValue(json, JsonRootMatch.class);
            matchDTOList =  root.getLogs();
            return new ParseResult<List<MatchDTO>>(matchDTOList, false);
        } catch (JsonProcessingException e) {
            return new ParseResult<List<MatchDTO>>(new ArrayList<MatchDTO>(), true);
            //throw new RuntimeException("Ошибка при парсинге JSON", e);
        }
    }

    public ParseResult<MatchRoot> getMatchResultsList(String json){
        MatchRoot matchInfo;
        try {
            matchInfo = objectMapperForInsideMatch.readValue(json, MatchRoot.class);
            return new ParseResult<MatchRoot>(matchInfo, false);
        } catch (JsonProcessingException e) {
            //throw new RuntimeException("Ошибка при парсинге JSON", e);
            return new ParseResult<MatchRoot>(new MatchRoot(), true);
        }
    }
}
