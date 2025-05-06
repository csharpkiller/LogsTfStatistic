package org.example.search.info;

import java.util.List;

public interface InMatchSearchCategory {
    String getPlayerId();
    List<GameHero> getSearchHeroes();
    Integer getCount();
}
