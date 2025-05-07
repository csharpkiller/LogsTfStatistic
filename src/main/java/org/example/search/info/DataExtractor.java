package org.example.search.info;

import org.example.search.info.DTO.MatchResultUtils;
import org.example.search.info.DTO.inside.match.ClassStats;
import org.example.search.info.DTO.inside.match.MatchRoot;
import org.example.search.info.DTO.inside.match.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DataExtractor {

    private final SteamIdConverter steamIdConverter;
    private final MatchResultUtils matchResultUtils;

    public DataExtractor(){
        steamIdConverter = new SteamIdConverter();
        matchResultUtils = new MatchResultUtils();
    }

    /**
     * Возвращает отфильтрованный список результатов матчей по входящему запросу пользователя
     * @param unfilteredMatchResults неотфильтрованный список результатов матча
     * @param searchData user input (фильтры)
     * @return отфильтрованный список результатов матчей
     */
    public List<MatchRoot> getFilteredMatchResults(List<MatchRoot> unfilteredMatchResults, @NotNull SearchData searchData){
        return filterMatchByHero(unfilteredMatchResults, searchData.getPlayerId(), searchData.getSearchHeroes());
    }

    /**
     * Фильтрация списка результатов матчей по героям
     * @param matchRoots список результатов матча
     * @param searchedPlayerID id игрока, для которого фильтруем
     * @param searchedGameHeroes список персонажей, по которым ищем
     * @return отфильтрованный список
     */
    private List<MatchRoot> filterMatchByHero(@NotNull List<MatchRoot> matchRoots, String searchedPlayerID, List<GameHero> searchedGameHeroes){
        String shortId = steamIdConverter.convertId64ToShortId(searchedPlayerID);
        return matchRoots.stream()
                .filter(root -> {
                    //TODO
                    ClassStats[] classStats = root.getPlayers().getPlayerMap().get(shortId).getClass_stats();
                    //GameHero gameHero = matchResultUtils.getMainHeroInGame(classStats);

                    Player player = root.getPlayers().getPlayerMap().get(shortId);
                    GameHero gameHero = matchResultUtils.getMainHeroInGame(root, player);

                    return searchedGameHeroes.contains(gameHero);
                })
                .toList();
    }
}
