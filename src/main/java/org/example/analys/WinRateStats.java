package org.example.analys;

/**
 * Контейнер для удобства вычисления статистики во всех WinRate....
 * TODO возможно я вообще не прав
 */
public class WinRateStats {
    private Integer wins = 0; // число побед
    private Integer totalGames = 0; // число игр
    private Double winRate = 0.; // процент побед
    private boolean isOpenToChange = true; // открыт для изменения

    /**
     * Закрыть для изменения
     */
    public void closeToChange(){
        isOpenToChange=false;
    }

    /**
     * Увеличить число побед
     */
    public void increaseWins(){
        if(isOpenToChange){
            wins++;
            winRate = calculateWinRate();
        }
    }

    public void increaseTotalGames(){
        if(isOpenToChange){
            totalGames++;
            winRate = calculateWinRate();
        }
    }

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
