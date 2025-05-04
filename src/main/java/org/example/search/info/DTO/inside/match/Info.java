package org.example.search.info.DTO.inside.match;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info {

    private String map;
    private boolean map_open = true;

    private boolean supplemental;
    private boolean supplemental_open = true;

    private int total_length;
    private boolean total_length_open = true;

    private boolean hasHS;
    private boolean hasHS_open = true;

    private boolean hasHS_hit;
    private boolean hasHS_hit_open = true;

    private boolean hasRealDamage;
    private boolean hasRealDamage_open = true;

    private boolean hasWeaponDamage;
    private boolean hasWeaponDamage_open = true;

    private boolean hasAccuracy;
    private boolean hasAccuracy_open = true;

    private boolean hasHP;
    private boolean hasHP_open = true;

    private boolean hasHP_real;
    private boolean hasHP_real_open = true;

    private boolean hasBS;
    private boolean hasBS_open = true;

    private boolean hasCP;
    private boolean hasCP_open = true;

    private boolean hasSB;
    private boolean hasSB_open = true;

    private boolean hasDT;
    private boolean hasDT_open = true;

    private boolean hasAS;
    private boolean hasAS_open = true;

    private boolean hasHR;
    private boolean hasHR_open = true;

    private boolean hasIntel;
    private boolean hasIntel_open = true;

    @JsonProperty("AD_scoring")
    private boolean AD_scoring;
    private boolean AD_scoring_open = true;

    private Object[] notifications;
    private boolean notifications_open = true;

    private String title;
    private boolean title_open = true;

    private long date;
    private boolean date_open = true;

    private Uploader uploader;
    private boolean uploader_open = true;

    public String getMap() { return map; }
    public void setMap(String map) {
        if (map_open) {
            this.map = map;
            map_open = false;
        }
    }

    public boolean isSupplemental() { return supplemental; }
    public void setSupplemental(boolean supplemental) {
        if (supplemental_open) {
            this.supplemental = supplemental;
            supplemental_open = false;
        }
    }

    public int getTotal_length() { return total_length; }
    public void setTotal_length(int total_length) {
        if (total_length_open) {
            this.total_length = total_length;
            total_length_open = false;
        }
    }

    public boolean isHasRealDamage() { return hasRealDamage; }
    public void setHasRealDamage(boolean hasRealDamage) {
        if (hasRealDamage_open) {
            this.hasRealDamage = hasRealDamage;
            hasRealDamage_open = false;
        }
    }

    public boolean isHasHS_hit() {
        return hasHS_hit;
    }

    public void setHasHS_hit(boolean hasHS_hit) {
        if (hasHS_hit_open) {
            this.hasHS_hit = hasHS_hit;
            hasHS_hit_open = false;
        }
    }

    public boolean isHasWeaponDamage() { return hasWeaponDamage; }
    public void setHasWeaponDamage(boolean hasWeaponDamage) {
        if (hasWeaponDamage_open) {
            this.hasWeaponDamage = hasWeaponDamage;
            hasWeaponDamage_open = false;
        }
    }

    public boolean isHasAccuracy() { return hasAccuracy; }
    public void setHasAccuracy(boolean hasAccuracy) {
        if (hasAccuracy_open) {
            this.hasAccuracy = hasAccuracy;
            hasAccuracy_open = false;
        }
    }

    public boolean isHasHP() { return hasHP; }
    public void setHasHP(boolean hasHP) {
        if (hasHP_open) {
            this.hasHP = hasHP;
            hasHP_open = false;
        }
    }

    public boolean isHasHP_real() { return hasHP_real; }
    public void setHasHP_real(boolean hasHP_real) {
        if (hasHP_real_open) {
            this.hasHP_real = hasHP_real;
            hasHP_real_open = false;
        }
    }

    public boolean isHasHS() { return hasHS; }
    public void setHasHS(boolean hasHS) {
        if (hasHS_open) {
            this.hasHS = hasHS;
            hasHS_open = false;
        }
    }

    public boolean isHasBS() { return hasBS; }
    public void setHasBS(boolean hasBS) {
        if (hasBS_open) {
            this.hasBS = hasBS;
            hasBS_open = false;
        }
    }

    public boolean isHasCP() { return hasCP; }
    public void setHasCP(boolean hasCP) {
        if (hasCP_open) {
            this.hasCP = hasCP;
            hasCP_open = false;
        }
    }

    public boolean isHasSB() { return hasSB; }
    public void setHasSB(boolean hasSB) {
        if (hasSB_open) {
            this.hasSB = hasSB;
            hasSB_open = false;
        }
    }

    public boolean isHasDT() { return hasDT; }
    public void setHasDT(boolean hasDT) {
        if (hasDT_open) {
            this.hasDT = hasDT;
            hasDT_open = false;
        }
    }

    public boolean isHasAS() { return hasAS; }
    public void setHasAS(boolean hasAS) {
        if (hasAS_open) {
            this.hasAS = hasAS;
            hasAS_open = false;
        }
    }

    public boolean isHasHR() { return hasHR; }
    public void setHasHR(boolean hasHR) {
        if (hasHR_open) {
            this.hasHR = hasHR;
            hasHR_open = false;
        }
    }

    public boolean isHasIntel() { return hasIntel; }
    public void setHasIntel(boolean hasIntel) {
        if (hasIntel_open) {
            this.hasIntel = hasIntel;
            hasIntel_open = false;
        }
    }

    public boolean isAD_scoring() { return AD_scoring; }
    public void setAD_scoring(boolean AD_scoring) {
        if (AD_scoring_open) {
            this.AD_scoring = AD_scoring;
            AD_scoring_open = false;
        }
    }

    public Object[] getNotifications() { return notifications; }
    public void setNotifications(Object[] notifications) {
        if (notifications_open) {
            this.notifications = notifications;
            notifications_open = false;
        }
    }

    public String getTitle() { return title; }
    public void setTitle(String title) {
        if (title_open) {
            this.title = title;
            title_open = false;
        }
    }

    public long getDate() { return date; }
    public void setDate(long date) {
        if (date_open) {
            this.date = date;
            date_open = false;
        }
    }

    public Uploader getUploader() { return uploader; }
    public void setUploader(Uploader uploader) {
        if (uploader_open) {
            this.uploader = uploader;
            uploader_open = false;
        }
    }
}