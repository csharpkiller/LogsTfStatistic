package org.example.analys;

/**
 * Контейнер для удобства вычисления статистики во всех WinRate....
 * TODO возможно я вообще не прав
 */
public class WinRateStats {

    /**
     * Число побед
     */
    private Integer wins = 0;

    /**
     * Число игр
     */
    private Integer totalGames = 0;

    /**
     * Процент побед
     */
    private Double winRate = 0.;

    /**
     * Открыт для изменения
     */
    private boolean isOpenToChange = true;

    /**
     * Закрыть для изменения
     */
    public void closeToChange(){
        isOpenToChange=false;
    }

    /**
     * Увеличить число побед и пересчитать winrate
     */
    public void increaseWins(){
        if(isOpenToChange){
            wins++;
            winRate = calculateWinRate();
        }
    }

    /**
     * Увеличить число игр и пересчитать winrate
     */
    public void increaseTotalGames(){
        if(isOpenToChange){
            totalGames++;
            winRate = calculateWinRate();
        }
    }

    /**
     * Расчитать winrate
     * @return winrate
     */
    private Double calculateWinRate(){
        return totalGames == 0 ? 0 : (wins * 100.0) / totalGames;
    }

    public Double getWinRate() {
        return winRate;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getTotalGames() {
        return totalGames;
    }
}
