package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Статистика уберзаряда.
 * Кароч есть такой персонаж MEDIC, вот он не стреляет, а своей пушкой может подцепиться к игроку
 * и восстанавливать условно 15 hp в секунду. (Хп у тиммейтов от 125 до 200) Когда он лечит союзника у него накапливается уберзаряд.
 * Обычно это занимает 40 секунд неприрывного лечения. Активация этого уберзаряда дает бессмертие игроку которого он лечит,
 * длится примерно 6-8 секунд, быстрее если переключает на другого союзника.
 */
public class MedicStatsDTO {
    private final int advantages_lost; // Сколько раз умер медик когда у него был убер или почти был
    private final int biggest_advantage_lost; // Размер самого большого потерянного преимущества. Допустим умер с готовым убером 100% или с почти готовым 80%.
    private final int deaths_within_20s_after_uber; // Сколько раз умер союзник, на которого использовали убер, в течение 20 секунд после окончания.
    private final int avg_time_before_using; // Среднее кол-во времени которое ждал медик до использования убера, уже имея его.

    public MedicStatsDTO(
           @JsonProperty("advantages_lost") int advantages_lost,
           @JsonProperty("biggest_advantage_lost") int biggest_advantage_lost,
           @JsonProperty("deaths_within_20s_after_uber") int deaths_within_20s_after_uber,
           @JsonProperty("avg_time_before_using") int avg_time_before_using
    ) {
        this.advantages_lost = advantages_lost;
        this.biggest_advantage_lost = biggest_advantage_lost;
        this.deaths_within_20s_after_uber = deaths_within_20s_after_uber;
        this.avg_time_before_using = avg_time_before_using;
    }

    public int getAdvantages_lost() {
        return advantages_lost;
    }

    public int getBiggest_advantage_lost() {
        return biggest_advantage_lost;
    }

    public int getDeaths_within_20s_after_uber() {
        return deaths_within_20s_after_uber;
    }

    public int getAvg_time_before_using() {
        return avg_time_before_using;
    }
}
