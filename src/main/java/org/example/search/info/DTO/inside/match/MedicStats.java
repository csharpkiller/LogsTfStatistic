package org.example.search.info.DTO.inside.match;

public class MedicStats {

    private int advantages_lost;
    private boolean advantages_lost_open = true;

    private int biggest_advantage_lost;
    private boolean biggest_advantage_lost_open = true;

    private int deaths_within_20s_after_uber;
    private boolean deaths_within_20s_after_uber_open = true;

    private int avg_time_before_using;
    private boolean avg_time_before_using_open = true;

    public int getAdvantages_lost() { return advantages_lost; }
    public void setAdvantages_lost(int advantages_lost) {
        if (advantages_lost_open) {
            this.advantages_lost = advantages_lost;
            advantages_lost_open = false;
        }
    }

    public int getBiggest_advantage_lost() { return biggest_advantage_lost; }
    public void setBiggest_advantage_lost(int biggest_advantage_lost) {
        if (biggest_advantage_lost_open) {
            this.biggest_advantage_lost = biggest_advantage_lost;
            biggest_advantage_lost_open = false;
        }
    }

    public int getDeaths_within_20s_after_uber() { return deaths_within_20s_after_uber; }
    public void setDeaths_within_20s_after_uber(int deaths_within_20s_after_uber) {
        if (deaths_within_20s_after_uber_open) {
            this.deaths_within_20s_after_uber = deaths_within_20s_after_uber;
            deaths_within_20s_after_uber_open = false;
        }
    }

    public int getAvg_time_before_using() { return avg_time_before_using; }
    public void setAvg_time_before_using(int avg_time_before_using) {
        if (avg_time_before_using_open) {
            this.avg_time_before_using = avg_time_before_using;
            avg_time_before_using_open = false;
        }
    }
}
