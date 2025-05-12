package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * General информация по матчу
 */
public class InfoDTO {

    /**
     * Карта на которой происходил матч
     */
    private final String map;

    /**
     * Является ли запись дополнительной
     */
    private final boolean supplemental;

    /**
     * Общая продолжительность матча в секундах
     */
    private final int total_length;

    /**
     * Есть ли информация о количестве хедшотов (headshots)
     */
    private final boolean hasHS;

    /**
     * Есть ли информация о том, сколько раз игрок целился в голову и попал
     */
    private final boolean hasHS_hit;

    /**
     * Есть ли в логе информация о реальном уроне. Бывает багает сервак и с разминки добавляется урон
     */
    private final boolean hasRealDamage;

    /**
     * Есть ли в логе информация о уроне по типам оружия.
     */
    private final boolean hasWeaponDamage;

    /**
     * Есть ли данные об эффективности стрельбы (проценрты попадания с оружия)
     */
    private final boolean hasAccuracy;

    /**
     * Есть ли данные о здоровье игроков
     */
    private final boolean hasHP;

    /**
     * Есть ли точные данные о здоровье игроков (без добавления с разминки)
     */
    private final boolean hasHP_real;

    /**
     * Есть ли данные о ??BackStabs?? убийств в спину
     */
    private final boolean hasBS;

    /**
     * Есть ли данные о захвате контрольных точек (Control Points)
     */
    private final boolean hasCP;

    /**
     * Есть ли данные о спавнбилдах? Спавнбилд — это когда игроки восстанавливают своё здоровье и боеприпасы при смене респавна
     */
    private final boolean hasSB;

    /**
     * Есть ли данные о времени смерти (Death Time)? То есть когда каждый игрок погибал
     */
    private final boolean hasDT;

    /**
     * Есть ли информация о КРУТЫХ ПОПАДАНИЙ РАКЕТОЙ В ВОЗДУХЕ (Air Shots)
     */
    private final boolean hasAS;

    /**
     * Есть ли данные о лечении (Healing Received) Т.е. сколько здоровья получил игрок от медика или других источников
     */
    private final boolean hasHR;

    /**
     * Есть ли данные о захвате интеллекта (для режима Intelligence)?
     */
    private final boolean hasIntel;

    /**
     * Используется ли система подсчёта очков типа Attack/Defend?
     */
    private final boolean AD_scoring;

    /**
     * Массив уведомлений или ошибок, связанных с логом.
     */
    private final Object[] notifications;

    /**
     * Заголовок матча.
     */
    private final String title;

    /**
     * Число в timestamp
     */
    private final long date;

    /**
     * Кто загрузил log (servme, игрок, другой ресурс...)
     */
    private final UploaderDTO uploaderDTO;

    public InfoDTO(
            @JsonProperty("map") String map,
            @JsonProperty("supplemental") boolean supplemental,
            @JsonProperty("total_length") int total_length,
            @JsonProperty("hasHS") boolean hasHS,
            @JsonProperty("hasHS_hit") boolean hasHS_hit,
            @JsonProperty("hasRealDamage") boolean hasRealDamage,
            @JsonProperty("hasWeaponDamage") boolean hasWeaponDamage,
            @JsonProperty("hasAccuracy") boolean hasAccuracy,
            @JsonProperty("hasHP") boolean hasHP,
            @JsonProperty("hasHP_real") boolean hasHP_real,
            @JsonProperty("hasBS") boolean hasBS,
            @JsonProperty("hasCP") boolean hasCP,
            @JsonProperty("hasSB") boolean hasSB,
            @JsonProperty("hasDT") boolean hasDT,
            @JsonProperty("hasAS") boolean hasAS,
            @JsonProperty("hasHR") boolean hasHR,
            @JsonProperty("hasIntel") boolean hasIntel,
            @JsonProperty("AD_scoring") boolean AD_scoring,
            @JsonProperty("notifications") Object[] notifications,
            @JsonProperty("title") String title,
            @JsonProperty("date") long date,
            @JsonProperty("uploaderDTO") UploaderDTO uploaderDTO
    ) {
        this.map = map;
        this.supplemental = supplemental;
        this.total_length = total_length;
        this.hasHS = hasHS;
        this.hasHS_hit = hasHS_hit;
        this.hasRealDamage = hasRealDamage;
        this.hasWeaponDamage = hasWeaponDamage;
        this.hasAccuracy = hasAccuracy;
        this.hasHP = hasHP;
        this.hasHP_real = hasHP_real;
        this.hasBS = hasBS;
        this.hasCP = hasCP;
        this.hasSB = hasSB;
        this.hasDT = hasDT;
        this.hasAS = hasAS;
        this.hasHR = hasHR;
        this.hasIntel = hasIntel;
        this.AD_scoring = AD_scoring;
        this.notifications = notifications;
        this.title = title;
        this.date = date;
        this.uploaderDTO = uploaderDTO;
    }

    public String getMap() {
        return map;
    }

    public boolean isSupplemental() {
        return supplemental;
    }

    public int getTotal_length() {
        return total_length;
    }

    public boolean isHasHS() {
        return hasHS;
    }

    public boolean isHasHS_hit() {
        return hasHS_hit;
    }

    public boolean isHasRealDamage() {
        return hasRealDamage;
    }

    public boolean isHasWeaponDamage() {
        return hasWeaponDamage;
    }

    public boolean isHasAccuracy() {
        return hasAccuracy;
    }

    public boolean isHasHP() {
        return hasHP;
    }

    public boolean isHasHP_real() {
        return hasHP_real;
    }

    public boolean isHasBS() {
        return hasBS;
    }

    public boolean isHasCP() {
        return hasCP;
    }

    public boolean isHasSB() {
        return hasSB;
    }

    public boolean isHasDT() {
        return hasDT;
    }

    public boolean isHasAS() {
        return hasAS;
    }

    public boolean isHasHR() {
        return hasHR;
    }

    public boolean isHasIntel() {
        return hasIntel;
    }

    public boolean isAD_scoring() {
        return AD_scoring;
    }

    public Object[] getNotifications() {
        return notifications;
    }

    public String getTitle() {
        return title;
    }

    public long getDate() {
        return date;
    }

    public UploaderDTO getUploader() {
        return uploaderDTO;
    }
}