package org.example.search.info.DTO.inside.match;

public class UberTypes {

    private int medigun;
    private boolean medigun_open = true;

    public int getMedigun() { return medigun; }
    public void setMedigun(int medigun) {
        if (medigun_open) {
            this.medigun = medigun;
            medigun_open = false;
        }
    }
}
