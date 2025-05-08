package org.example.search.info;

import org.example.search.info.DTO.MatchResultUtils;
import org.example.search.info.DTO.inside.match.MatchRootDTO;
import org.example.search.info.DTO.inside.match.PlayerDTO;
import org.example.search.info.objectwrappers.SteamID;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Класс для фильтрации результатов матча
 */
public class MatchResultFilter {

    private final MatchResultUtils matchResultUtils;

    public MatchResultFilter(){
        matchResultUtils = new MatchResultUtils();
    }

    /**
     * Возвращает отфильтрованный список результатов матчей по входящему запросу пользователя
     * @param unfilteredMatchResults неотфильтрованный список результатов матча
     * @param searchData user input (фильтры)
     * @return отфильтрованный список результатов матчей
     */
    public List<MatchRootDTO> getFilteredMatchResults(List<MatchRootDTO> unfilteredMatchResults, @NotNull SearchData searchData){
        if(!searchData.getPlayerId().isValidId()){
            System.out.println("input steamId is not valid");
            return List.of();
        }
        return filterMatchByHero(unfilteredMatchResults, searchData.getPlayerId(), searchData.getSearchHeroes());
    }

    /**
     * Фильтрация списка результатов матчей по героям
     * @param matchRootDTOS список результатов матча
     * @param steamID id игрока, для которого фильтруем
     * @param searchedGameHeroes список персонажей, по которым ищем
     * @return отфильтрованный список
     */
    private List<MatchRootDTO> filterMatchByHero(@NotNull List<MatchRootDTO> matchRootDTOS, SteamID steamID, List<GameHero> searchedGameHeroes){
        return matchRootDTOS.stream()
                .filter(root -> {
                    PlayerDTO playerDTO = root.getPlayers().getPlayerMap().get(steamID.getShortSteamID());
                    try {
                        GameHero gameHero = matchResultUtils.getMainPlayerHeroInMatch(root, playerDTO);
                        return searchedGameHeroes.contains(gameHero);
                    }catch (Exception e){
                        return false;
                    }
                })
                .toList();
    }
}
