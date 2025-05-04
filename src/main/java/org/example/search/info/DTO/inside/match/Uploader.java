package org.example.search.info.DTO.inside.match;

public class Uploader {

    private String id;
    private boolean id_open = true;

    private String name;
    private boolean name_open = true;

    private String info;
    private boolean info_open = true;

    public String getId() { return id; }
    public void setId(String id) {
        if (id_open) {
            this.id = id;
            id_open = false;
        }
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name_open) {
            this.name = name;
            name_open = false;
        }
    }

    public String getInfo() { return info; }
    public void setInfo(String info) {
        if (info_open) {
            this.info = info;
            info_open = false;
        }
    }
}