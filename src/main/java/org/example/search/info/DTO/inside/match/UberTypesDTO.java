package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Кол-во зарядов для каждого типа убер-пушки
 */
public class UberTypesDTO {

    /**
     * Кол-во зарядов для стандартной пушки
     */
    private final int medigun;

    /**
     * Кол-во для критов (quad damage)
     */
    private final int kritzkrieg;

    //TODO добавить остальные медиганы, мб добавят в whitelist

    public UberTypesDTO(@JsonProperty("medigun") int medigun, @JsonProperty("kritzkrieg") int kritzkrieg) {
        this.medigun = medigun;
        this.kritzkrieg = kritzkrieg;
    }

    public int getMedigun() {
        return medigun;
    }

    public int getKritzkrieg() {
        return kritzkrieg;
    }
}
