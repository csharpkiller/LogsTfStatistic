package org.example.search.info;

/**
 * DataClass, интересующая нас информация из матча
 */
public class PlayerResultData implements BaseResults{

    @Override
    public Integer getKills() {
        return 0;
    }

    @Override
    public Integer getDeaths() {
        return 0;
    }

    @Override
    public Integer getAssists() {
        return 0;
    }

    @Override
    public String getMap() {
        return "";
    }

    @Override
    public Boolean isWin() {
        return null;
    }
}
