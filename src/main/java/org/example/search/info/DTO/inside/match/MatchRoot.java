package org.example.search.info.DTO.inside.match;

import java.util.Map;

public class MatchRoot {

    private boolean success;
    private boolean success_open = true;

    private int version;
    private boolean version_open = true;

    private Info info;
    private boolean info_open = true;

    private Teams teams;
    private boolean teams_open = true;

    private int length;
    private boolean length_open = true;

    private PlayerMap players;
    private boolean players_open = true;

    private Map<String, String> names;
    private boolean names_open = true;

    private HealSpread healspread;
    private boolean healspread_open = true;

    private ClassKills classkills;
    private boolean classkills_open = true;

    private ClassDeaths classdeaths;
    private boolean classdeaths_open = true;

    private ClassKillAssists classkillassists;
    private boolean classkillassists_open = true;

    private Chat[] chat;
    private boolean chat_open = true;

    private Round[] rounds;
    private boolean rounds_open = true;

    private KillStreak[] killstreaks;
    private boolean killstreaks_open = true;

    public KillStreak[] getKillstreaks() {
        return killstreaks;
    }

    public void setKillstreaks(KillStreak[] killstreaks) {
        if (killstreaks_open) {
            this.killstreaks = killstreaks;
            killstreaks_open = false;
        }
    }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) {
        if (success_open) {
            this.success = success;
            success_open = false;
        }
    }

    public int getVersion() { return version; }
    public void setVersion(int version) {
        if (version_open) {
            this.version = version;
            version_open = false;
        }
    }

    public Info getInfo() { return info; }
    public void setInfo(Info info) {
        if (info_open) {
            this.info = info;
            info_open = false;
        }
    }

    public Teams getTeams() { return teams; }
    public void setTeams(Teams teams) {
        if (teams_open) {
            this.teams = teams;
            teams_open = false;
        }
    }

    public int getLength() { return length; }
    public void setLength(int length) {
        if (length_open) {
            this.length = length;
            length_open = false;
        }
    }

    public PlayerMap getPlayers() { return players; }
    public void setPlayers(PlayerMap players) {
        if (players_open) {
            this.players = players;
            players_open = false;
        }
    }

    public Map<String, String> getNames() { return names; }
    public void setNames(Map<String, String> names) {
        if (names_open) {
            this.names = names;
            names_open = false;
        }
    }

    public HealSpread getHealspread() { return healspread; }
    public void setHealspread(HealSpread healspread) {
        if (healspread_open) {
            this.healspread = healspread;
            healspread_open = false;
        }
    }

    public ClassKills getClasskills() { return classkills; }
    public void setClasskills(ClassKills classkills) {
        if (classkills_open) {
            this.classkills = classkills;
            classkills_open = false;
        }
    }

    public ClassDeaths getClassdeaths() { return classdeaths; }
    public void setClassdeaths(ClassDeaths classdeaths) {
        if (classdeaths_open) {
            this.classdeaths = classdeaths;
            classdeaths_open = false;
        }
    }

    public ClassKillAssists getClasskillassists() { return classkillassists; }
    public void setClasskillassists(ClassKillAssists classkillassists) {
        if (classkillassists_open) {
            this.classkillassists = classkillassists;
            classkillassists_open = false;
        }
    }

    public Chat[] getChat() { return chat; }
    public void setChat(Chat[] chat) {
        if (chat_open) {
            this.chat = chat;
            chat_open = false;
        }
    }

    public Round[] getRounds() { return rounds; }
    public void setRounds(Round[] rounds) {
        if (rounds_open) {
            this.rounds = rounds;
            rounds_open = false;
        }
    }
}