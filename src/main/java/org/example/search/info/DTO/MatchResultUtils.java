package org.example.search.info.DTO;

import org.example.search.info.DTO.inside.match.ClassStatsDTO;
import org.example.search.info.DTO.inside.match.MatchRootDTO;
import org.example.search.info.DTO.inside.match.PlayerDTO;
import org.example.search.info.GameHero;
import org.example.search.info.GameResult;

/**
 * Утилита для получения данных из MatchRootDTO
 */
public class MatchResultUtils {

    /**
     * Вернуть Main Персонажа игрока (персонаж имеет максимальное кол-во времени за матч)
     * @param matchRootDTO матч
     * @param playerDTO игрок
     * @return основной персонаж
     */
    public GameHero getMainPlayerHeroInMatch(MatchRootDTO matchRootDTO, PlayerDTO playerDTO){
        GameHero gameHero = null;
        int timePlayed = 0;
        ClassStatsDTO[] classStatDTOS = playerDTO.getClass_stats();
        for (ClassStatsDTO classStat : classStatDTOS) {
            int currentTime = classStat.getTotal_time();
            if (currentTime > timePlayed) {
                timePlayed = currentTime;
                gameHero = GameHero.valueOfLabel(classStat.getHero_str());
            }
        }
        return gameHero;
    }

    /**
     * Результат матча для игрока, победил или нет
     * @param matchRootDTO матч
     * @param playerDTO игрок
     * @return результат матча
     */
    public GameResult playerWin(MatchRootDTO matchRootDTO, PlayerDTO playerDTO) {
        int redScore = matchRootDTO.getTeams().getRed().getScore();
        int blueScore = matchRootDTO.getTeams().getBlue().getScore();
        boolean isPlayerInRedTeam = "Red".equals(playerDTO.getTeam());

        if (redScore == blueScore) {
            return GameResult.DRAW;
        }
        boolean teamWon = isPlayerInRedTeam ? redScore > blueScore : blueScore > redScore;
        return teamWon ? GameResult.WIN : GameResult.LOSE;
    }
}
