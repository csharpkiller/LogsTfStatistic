package org.example.analys;

/**
 * Класс для подсчета KDA статистики
 */
public class KDAStats {
    private int totalKills = 0; // общее кол-во киллов
    private int totalDeaths = 0; // общее кол-во смертей
    private int totalAssists = 0; // общее кол-во помощи
    private int totalGames = 0; // общее кол-во матчей
    private boolean isOpenToChange = true;

    /**
     * Закрыть возможность добавления данных.
     */
    public void closeToChange(){
        isOpenToChange=false;
    }

    /**
     * Выдать среднее кол-во убийств за totalGames матчей
     */
    public double getAverageKills() {
        return totalGames == 0 ? 0 : (double) totalKills / totalGames;
    }

    /**
     * Выдать среднее кол-во смертей за totalGames матчей
     */
    public double getAverageDeaths() {
        return totalGames == 0 ? 0 : (double) totalDeaths / totalGames;
    }

    /**
     * Выдать среднее кол-во помощи за totalGames матчей
     */
    public double getAverageAssists() {
        return totalGames == 0 ? 0 : (double) totalAssists / totalGames;
    }

    /**
     * Выдать среднее кол-во убийств/смертям K/D
     */
    public double getKdRatio() {
        if (totalDeaths == 0 && totalKills == 0) return 0;
        if (totalDeaths == 0) return totalKills;
        return (double) totalKills / totalDeaths;
    }

    /**
     * Увеличить кол-во убийств
     */
    public void addKill(int kills) {
        if(isOpenToChange){
            totalKills += kills;
        }
    }

    /**
     * Увеличить кол-во смертей
     */
    public void addDeath(int deaths) {
        if(isOpenToChange){
            totalDeaths += deaths;
        }
    }

    /**
     * Увеличить кол-во помощи
     */
    public void addAssist(int assists) {
        if(isOpenToChange){
            totalAssists += assists;
        }
    }

    /**
     * Увеличить кол-во матчей
     */
    public void incrementGames() {
        if(isOpenToChange){
            totalGames++;
        }
    }

    public int getTotalGames() {
        return totalGames;
    }
}