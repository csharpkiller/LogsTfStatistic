package org.example.search.info.DTO.matches.list;

public class MatchDTO {
    // lateinit ;)
    private int id;
    private boolean id_open = true;
    private String title;
    private boolean title_open = true;
    private String map;
    private boolean map_open = true;
    private long date;
    private boolean date_open = true;
    private int views;
    private boolean views_open = true;
    private int players;
    private boolean players_open = true;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMap() {
        return map;
    }

    public long getDate() {
        return date;
    }

    public int getViews() {
        return views;
    }

    public int getPlayers() {
        return players;
    }

    public void setId(int id) {
        if(id_open) {
            this.id = id;
            id_open=false;
        }
    }

    public void setTitle(String title) {
        if(title_open) {
            this.title = title;
            title_open=false;
        }
    }

    public void setMap(String map) {
        if(map_open) {
            this.map = map;
            map_open = false;
        }
    }

    public void setDate(long date) {
        if(date_open) {
            this.date = date;
            date_open = false;
        }
    }

    public void setViews(int views) {
        if(views_open) {
            this.views = views;
            views_open = false;
        }
    }

    public void setPlayers(int players) {
        if(players_open) {
            this.players = players;
            players_open = false;
        }
    }
}
