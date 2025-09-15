package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Кол-во зарядов для каждого типа убер-пушки
 */
public class UberTypesDTO {
    private final int medigun; // кол-во для стандартной пушки
    private final int kritzkrieg; // кол-во для критов (quad damage)

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
