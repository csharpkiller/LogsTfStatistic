package org.example.analys;

import org.example.Printable;
import org.example.search.info.PlayerMatchData;

import java.util.List;

/**
 * Метрики
 */
public interface Metric extends Printable{
    String getName(); // Получить название метрики
    String getDescription(); //Получить описание метрики

    /**
     * Считает статистики, заполняя поля.
     * @param results исходные данные
     * @return true/false если успешно
     */
    boolean compute(List<PlayerMatchData> results);
}
