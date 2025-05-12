package org.example.analys;

import org.example.search.info.PlayerMatchData;

import java.util.List;

/**
 * Метрики
 */
public interface Metric{
    /**
     * Получить название метрики
     * @return название метрики
     */
    String getName();

    /**
     * Получить описание метрики
     * @return описание
     */
    String getDescription();

    /**
     * Считает статистики, заполняя поля.
     * @param results исходные данные
     * @return true/false если успешно
     */
    boolean compute(List<PlayerMatchData> results);
}
