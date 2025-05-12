package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Общая, вся, статистика игрока за матч.
 */
public class PlayerDTO {

    /**
     * Название команды
     */
    private final String team;

    /**
     * Статистики по персонажам
     */
    private final ClassStatsDTO[] class_stats;

    /**
     * Кол-во убийств
     */
    private final int kills;

    /**
     * Кол-во смертей
     */
    private final int deaths;

    /**
     * Кол-во помощи
     */
    private final int assists;

    /**
     * Кол-во самоубийств
     */
    private final int suicides;

    /**
     * Kills + assist на смерть
     */
    private final String kapd;

    /**
     * Убийств на одну смерть
     */
    private final String kpd;

    /**
     * Нанесенный урон
     */
    private final int dmg;

    /**
     * Реальный нанесенный урон
     */
    private final int dmg_real;

    /**
     * Полученный урон
     */
    private final int dt;

    /**
     * Реально полученный урон
     */
    private final int dt_real;

    /**
     * Полученное лечение
     */
    private final int hr;

    /**
     * Ластхит, кол-во финальных выстрелов? по умирающим игрокам
     */
    private final int lks;

    /**
     * Сколько секунд игрок был активен в игре
     */
    private final int as;

    /**
     * Урона на одну смерть
     */
    private final int dapd;

    /**
     * Урон в минуту
     */
    private final int dapm;

    /**
     * Кол-во уберзарядов
     */
    private final int ubers;

    /**
     * Типы уберзарядов (криты, убер)
     */
    private final UberTypesDTO ubertypes;

    /**
     * Кол-во дропов (когда есть убер 100% и ты умираешь)
     */
    private final int drops;

    /**
     * Сколько подобрано аптечек
     */
    private final int medkits;

    /**
     * Сколько подобранные аптечки восстановили здоровья
     */
    private final int medkits_hp;

    /**
     * Кол-во убийств в спину (за героя SPY)
     */
    private final int backstabs;

    /**
     * Кол-во убийств в голову
     */
    private final int headshots;

    /**
     * Кол-во попаданий в голову
     */
    private final int headshots_hit;

    /**
     * Кол-во построек (за класс ENJIE)
     */
    private final int sentries;

    /**
     * Общее кол-во лечения, оказанного другим игрокам
     */
    private final int heal;

    /**
     * Кол-во захваченных точек
     */
    private final int cpc;

    /**
     * Кол-во захваченных флагов
     */
    private final int ic;

    /**
     * Подробная информация по уберзарядам
     */
    private final MedicStatsDTO medicstats;

    public PlayerDTO(
            @JsonProperty("team") String team,
            @JsonProperty("class_stats") ClassStatsDTO[] class_stats,
            @JsonProperty("kills") int kills,
            @JsonProperty("deaths") int deaths,
            @JsonProperty("assists") int assists,
            @JsonProperty("suicides") int suicides,
            @JsonProperty("kapd") String kapd,
            @JsonProperty("kpd") String kpd,
            @JsonProperty("dmg") int dmg,
            @JsonProperty("dmg_real") int dmg_real,
            @JsonProperty("dt") int dt,
            @JsonProperty("dt_real") int dt_real,
            @JsonProperty("hr") int hr,
            @JsonProperty("lks") int lks,
            @JsonProperty("as") int as,
            @JsonProperty("dapd") int dapd,
            @JsonProperty("dapm") int dapm,
            @JsonProperty("ubers") int ubers,
            @JsonProperty("ubertypes") UberTypesDTO ubertypes,
            @JsonProperty("drops") int drops,
            @JsonProperty("medkits") int medkits,
            @JsonProperty("medkits_hp") int medkits_hp,
            @JsonProperty("backstabs") int backstabs,
            @JsonProperty("headshots") int headshots,
            @JsonProperty("headshots_hit") int headshots_hit,
            @JsonProperty("sentries") int sentries,
            @JsonProperty("heal") int heal,
            @JsonProperty("cpc") int cpc,
            @JsonProperty("ic") int ic,
            @JsonProperty("medicstats") MedicStatsDTO medicstats
    ) {
        this.team = team;
        this.class_stats = class_stats;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.suicides = suicides;
        this.kapd = kapd;
        this.kpd = kpd;
        this.dmg = dmg;
        this.dmg_real = dmg_real;
        this.dt = dt;
        this.dt_real = dt_real;
        this.hr = hr;
        this.lks = lks;
        this.as = as;
        this.dapd = dapd;
        this.dapm = dapm;
        this.ubers = ubers;
        this.ubertypes = ubertypes;
        this.drops = drops;
        this.medkits = medkits;
        this.medkits_hp = medkits_hp;
        this.backstabs = backstabs;
        this.headshots = headshots;
        this.headshots_hit = headshots_hit;
        this.sentries = sentries;
        this.heal = heal;
        this.cpc = cpc;
        this.ic = ic;
        this.medicstats = medicstats;
    }

    public String getTeam() {
        return team;
    }

    public ClassStatsDTO[] getClass_stats() {
        return class_stats;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssists() {
        return assists;
    }

    public int getSuicides() {
        return suicides;
    }

    public String getKapd() {
        return kapd;
    }

    public String getKpd() {
        return kpd;
    }

    public int getDmg() {
        return dmg;
    }

    public int getDmg_real() {
        return dmg_real;
    }

    public int getDt() {
        return dt;
    }

    public int getDt_real() {
        return dt_real;
    }

    public int getHr() {
        return hr;
    }

    public int getLks() {
        return lks;
    }

    public int getAs() {
        return as;
    }

    public int getDapd() {
        return dapd;
    }

    public int getDapm() {
        return dapm;
    }

    public int getUbers() {
        return ubers;
    }

    public UberTypesDTO getUbertypes() {
        return ubertypes;
    }

    public int getDrops() {
        return drops;
    }

    public int getMedkits() {
        return medkits;
    }

    public int getMedkits_hp() {
        return medkits_hp;
    }

    public int getBackstabs() {
        return backstabs;
    }

    public int getHeadshots() {
        return headshots;
    }

    public int getHeadshots_hit() {
        return headshots_hit;
    }

    public int getSentries() {
        return sentries;
    }

    public int getHeal() {
        return heal;
    }

    public int getCpc() {
        return cpc;
    }

    public int getIc() {
        return ic;
    }

    public MedicStatsDTO getMedicstats() {
        return medicstats;
    }
}