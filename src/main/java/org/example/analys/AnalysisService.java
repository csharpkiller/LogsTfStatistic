package org.example.analys;

import org.example.search.info.PlayerMatchData;
import org.example.search.info.SearchData;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс предназначен для вычисления статистик на основе входящих данных
 */
public class AnalysisService {
    private final List<Metric> allMetrics; // список всех метрик

    public AnalysisService(){
        allMetrics = List.of(
                new KDAByHeroMetric(),
                new WinRateGeneralMetric(),
                new WinRateOnMapsMetric(),
                new WinRateOnHeroesMetric(),
                new WinRateOnMapsWithHeroesMetric()
        );
    }

    /**
     * Возвращает только ту аналитическую работу, которую имело смысл проводить.
     * @param playerMatchData исходные данные для аналитики
     * @return список метрик
     */
    public List<Metric> getAnalysisData(List<PlayerMatchData> playerMatchData){
        List<Metric> usableMetrics = new ArrayList<>();

        if(isSingleHeroSearch(playerMatchData.get(0).getSearchData())){
            allMetrics.forEach(metric -> {
                if(!isMetricForNotSingleHeroSearch(metric)){
                    if(metric.compute(playerMatchData)){
                        usableMetrics.add(metric);
                    }
                }
            });
        }else {
            allMetrics.forEach(metric -> {
                if(metric.compute(playerMatchData)){
                    usableMetrics.add(metric);
                }
            });
        }

        return usableMetrics;
    }

    /**
     * Проверка на результаты по одному персонажу
     * @param searchData запрос пользователя
     * @return true если запрос по одному персонажу
     */
    private boolean isSingleHeroSearch(SearchData searchData){
        return searchData.getSearchHeroes().size() == 1;
    }

    /**
     * Проверить является ли метрика для результатов более чем одного персонажа
     * @param metric metric class
     * @return true если для результата нужно более чем один персонаж
     */
    private boolean isMetricForNotSingleHeroSearch(Metric metric){
        return (metric instanceof WinRateOnHeroesMetric) || (metric instanceof WinRateOnMapsWithHeroesMetric);
    }
}
