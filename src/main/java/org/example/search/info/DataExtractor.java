package org.example.search.info;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-сборник, здесь идет основная взаимосвязь между всеми классами,
 * отвечающий за вычленение нужной информации из JSON.
 * (ниспадающие программирование начинаю от сюда)
 */
public class DataExtractor {
    private List<PlayerResultData> playerResultDataList;

    public List<PlayerResultData> getPlayerResults(SearchData searchData){
        playerResultDataList = new ArrayList<PlayerResultData>();

        // TODO

        if(!searchData.getSearchHeroes().isEmpty()){
            filterByHero(searchData);
        }

        return playerResultDataList;
    }

    private void filterByHero(InMatchSearchCategory searchCategory) {

    }

}
