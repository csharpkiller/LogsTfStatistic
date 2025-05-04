package org.example.search.info;

import org.example.search.info.DTO.matches.list.MatchDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс предназначенный на извлечение списка id матчей
 */
public class MatchExtractor {

    private List<MatchDTO> matchesResultList;

    public List<MatchDTO> getMatches(String ID, Integer offset, Integer limit, GeneralSearchCategory searchCategory){
        matchesResultList = new ArrayList<>();
        switch (searchCategory.getSearchRangeType()){
            case MATCH_COUNT:{
                matchCountSearch(ID, offset, limit, searchCategory);
            }
            case LAST_TIME:{
                break;
            }
            case TIME_PERIOD:{
                break;
            }
        }
        return matchesResultList;
    }

    private void matchCountSearch(String ID, Integer offset, Integer limit, GeneralSearchCategory searchCategory){

    }
}
