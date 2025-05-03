package org.example.search.info;

import org.example.search.info.DTO.MatchDTO;
import org.example.search.info.DTO.MatchResultDTO;

import java.util.List;

/**
 * Класс предназначен для конвертации json файла в объект/список объектов Java из пакета DTO
 * со всеми полями JSON объекта
 */
public class LogsJsonParser {

    public List<MatchDTO> getMatchList(String apiLink){
        List<MatchDTO> matchDTOList = null;
        //TODO
        return matchDTOList;
    }

    public List<MatchResultDTO> getMatchResultsList(String apiLink){
        List<MatchResultDTO> matchResultDTOList = null;
        //TODO
        return matchResultDTOList;
    }
}
