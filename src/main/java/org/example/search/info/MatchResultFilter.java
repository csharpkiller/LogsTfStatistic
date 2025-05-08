package org.example.search.info;

import org.example.search.info.DTO.MatchResultUtils;
import org.example.search.info.DTO.inside.match.MatchRoot;
import org.example.search.info.DTO.inside.match.Player;
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
    public List<MatchRoot> getFilteredMatchResults(List<MatchRoot> unfilteredMatchResults, @NotNull SearchData searchData){
        if(!searchData.getPlayerId().isValidId()){
            System.out.println("input steamId is not valid");
            return List.of();
        }
        return filterMatchByHero(unfilteredMatchResults, searchData.getPlayerId(), searchData.getSearchHeroes());
    }

    /**
     * Фильтрация списка результатов матчей по героям
     * @param matchRoots список результатов матча
     * @param steamID id игрока, для которого фильтруем
     * @param searchedGameHeroes список персонажей, по которым ищем
     * @return отфильтрованный список
     */
    private List<MatchRoot> filterMatchByHero(@NotNull List<MatchRoot> matchRoots, SteamID steamID, List<GameHero> searchedGameHeroes){
        return matchRoots.stream()
                .filter(root -> {
                    Player player = root.getPlayers().getPlayerMap().get(steamID.getShortSteamID());
                    try {
                        GameHero gameHero = matchResultUtils.getMainPlayerHeroInMatch(root, player);
                        return searchedGameHeroes.contains(gameHero);
                    }catch (Exception e){
                        return false;
                    }
                })
                .toList();
    }
}
