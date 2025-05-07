package org.example.search.info;

import org.example.search.info.DTO.MatchResultUtils;
import org.example.search.info.DTO.inside.match.MatchRoot;
import org.example.search.info.DTO.inside.match.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Конвертация объектов
 */
public class ObjectMapper {
    private final SteamIdConverter steamIdConverter;
    private final MatchResultUtils matchResultUtils;

    public ObjectMapper(){
        steamIdConverter = new SteamIdConverter();
        matchResultUtils = new MatchResultUtils();
    }

    /**
     * Конвертация результатов матчей в результаты игрока
     * @param steamId id игрока для которого получаем результат
     * @param matchRootList результаты матчей
     * @return результаты игрока
     */
    public List<BasedPlayerResults> convertMatchRootToPlayerResultData(String steamId, List<MatchRoot> matchRootList){
        String shortId = steamIdConverter.convertId64ToShortId(steamId);
        List<BasedPlayerResults> basedPlayerResultData = new ArrayList<>();
        for(MatchRoot matchRoot : matchRootList){

            String nickName_r = matchRoot.getNames().get(shortId);
            Player player = matchRoot.getPlayers().getPlayerMap().get(shortId);

            //TODO
            //GameHero gameHero_r = matchResultUtils.getMainHeroInGame(player.getClass_stats());
            GameHero gameHero_r = matchResultUtils.getMainHeroInGame(matchRoot, player);

            String map_r = matchRoot.getInfo().getMap();

            //GameResult gameResult_r = getGameResult(matchRoot, player);
            GameResult gameResult_r = matchResultUtils.playerWin(matchRoot, player);

            basedPlayerResultData.add(new BasedPlayerResults(
                    steamId, nickName_r, gameHero_r,player.getKills(), player.getDeaths(), player.getAssists(), map_r, gameResult_r
            ));
        }
        return basedPlayerResultData;
    }

    //TODO
    /*private GameResult getGameResult(MatchRoot matchRoot, Player player) {
        int redScore = matchRoot.getTeams().getRed().getScore();
        int blueScore = matchRoot.getTeams().getBlue().getScore();
        boolean isPlayerInRedTeam = "Red".equals(player.getTeam());

        if (redScore == blueScore) {
            return GameResult.DRAW;
        }
        boolean teamWon = isPlayerInRedTeam ? redScore > blueScore : blueScore > redScore;
        return teamWon ? GameResult.WIN : GameResult.LOSE;
    }*/
}
