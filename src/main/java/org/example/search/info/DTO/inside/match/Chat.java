package org.example.search.info.DTO.inside.match;

public class Chat {

    private String steamid;
    private boolean steamid_open = true;

    private String name;
    private boolean name_open = true;

    private String msg;
    private boolean msg_open = true;

    public String getSteamid() { return steamid; }
    public void setSteamid(String steamid) {
        if (steamid_open) {
            this.steamid = steamid;
            steamid_open = false;
        }
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name_open) {
            this.name = name;
            name_open = false;
        }
    }

    public String getMsg() { return msg; }
    public void setMsg(String msg) {
        if (msg_open) {
            this.msg = msg;
            msg_open = false;
        }
    }
}
