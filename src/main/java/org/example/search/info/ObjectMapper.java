package org.example.search.info;

import org.example.search.info.DTO.MatchResultUtils;
import org.example.search.info.DTO.inside.match.MatchRoot;
import org.example.search.info.DTO.inside.match.Player;
import org.example.search.info.objectwrappers.SteamID;

import java.util.ArrayList;
import java.util.List;

/**
 * Конвертация объектов
 */
public class ObjectMapper {
    private final MatchResultUtils matchResultUtils;

    public ObjectMapper(){
        matchResultUtils = new MatchResultUtils();
    }

    /**
     * Конвертация результатов матчей в результаты игрока
     * @param steamId id игрока для которого получаем результат
     * @param matchRootList результаты матчей
     * @return результаты игрока
     */
    public List<BasedPlayerResults> convertMatchRootToPlayerResultData(SteamID steamId, List<MatchRoot> matchRootList){
        List<BasedPlayerResults> basedPlayerResultData = new ArrayList<>();
        for(MatchRoot matchRoot : matchRootList){

            String nickName_r = matchRoot.getNames().get(steamId.getShortSteamID());
            Player player = matchRoot.getPlayers().getPlayerMap().get(steamId.getShortSteamID());

            GameHero gameHero_r = matchResultUtils.getMainPlayerHeroInMatch(matchRoot, player);

            String map_r = matchRoot.getInfo().getMap();

            GameResult gameResult_r = matchResultUtils.playerWin(matchRoot, player);

            basedPlayerResultData.add(new BasedPlayerResults(
                    steamId.getSteamID64(), nickName_r, gameHero_r,player.getKills(), player.getDeaths(), player.getAssists(), map_r, gameResult_r
            ));
        }
        return basedPlayerResultData;
    }
}
