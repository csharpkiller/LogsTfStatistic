package org.example.search.info;

import org.example.search.info.DTO.MatchResultUtils;
import org.example.search.info.DTO.inside.match.MatchRootDTO;
import org.example.search.info.DTO.inside.match.PlayerDTO;
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
     * @param matchRootDTOList результаты матчей
     * @return результаты игрока
     */
    public List<BasedPlayerResults> convertMatchRootToPlayerResultData(SteamID steamId, List<MatchRootDTO> matchRootDTOList){
        List<BasedPlayerResults> basedPlayerResultData = new ArrayList<>();
        for(MatchRootDTO matchRootDTO : matchRootDTOList){

            String nickName_r = matchRootDTO.getNames().get(steamId.getShortSteamID());
            PlayerDTO playerDTO = matchRootDTO.getPlayers().getPlayerMap().get(steamId.getShortSteamID());

            GameHero gameHero_r = matchResultUtils.getMainPlayerHeroInMatch(matchRootDTO, playerDTO);

            String map_r = matchRootDTO.getInfo().getMap();

            GameResult gameResult_r = matchResultUtils.playerWin(matchRootDTO, playerDTO);

            basedPlayerResultData.add(new BasedPlayerResults(
                    steamId.getSteamID64(), nickName_r, gameHero_r, playerDTO.getKills(), playerDTO.getDeaths(), playerDTO.getAssists(), map_r, gameResult_r
            ));
        }
        return basedPlayerResultData;
    }
}
