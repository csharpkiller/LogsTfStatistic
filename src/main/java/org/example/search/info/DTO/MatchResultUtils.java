package org.example.search.info.DTO;

import org.example.search.info.DTO.inside.match.ClassStats;
import org.example.search.info.DTO.inside.match.MatchRoot;
import org.example.search.info.DTO.inside.match.Player;
import org.example.search.info.GameHero;
import org.example.search.info.GameResult;

/**
 * Утилита для получения данных из MatchRoot
 */
public class MatchResultUtils {

    /**
     * Получить персонажа на котором дольше всего играли во время матча.
     * @param classStats
     * @return
     */
    public GameHero getMainPlayerHeroInMatch(ClassStats[] classStats){
        GameHero gameHero = null;
        int timePlayed = 0;

        for (ClassStats classStat : classStats) {
            int currentTime = classStat.getTotal_time();
            if (currentTime > timePlayed) {
                timePlayed = currentTime;
                gameHero = GameHero.valueOfLabel(classStat.getType());
            }
        }
        return gameHero;
    }

    public GameHero getMainPlayerHeroInMatch(MatchRoot matchRoot, Player player){
        GameHero gameHero = null;
        int timePlayed = 0;
        ClassStats[] classStats = player.getClass_stats();
        for (ClassStats classStat : classStats) {
            int currentTime = classStat.getTotal_time();
            if (currentTime > timePlayed) {
                timePlayed = currentTime;
                gameHero = GameHero.valueOfLabel(classStat.getType());
            }
        }
        return gameHero;
    }

    public GameResult playerWin(MatchRoot matchRoot, Player player) {
        int redScore = matchRoot.getTeams().getRed().getScore();
        int blueScore = matchRoot.getTeams().getBlue().getScore();
        boolean isPlayerInRedTeam = "Red".equals(player.getTeam());

        if (redScore == blueScore) {
            return GameResult.DRAW;
        }
        boolean teamWon = isPlayerInRedTeam ? redScore > blueScore : blueScore > redScore;
        return teamWon ? GameResult.WIN : GameResult.LOSE;
    }
}
