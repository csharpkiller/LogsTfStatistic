package org.example.search.info.DTO.inside.match;

import java.util.Map;

/**
 * Корневой объект Json'a, содержащий все сервисы
 */
public class MatchRootDTO {

    private boolean success;
    private boolean success_open = true;

    private int version;
    private boolean version_open = true;

    private InfoDTO infoDTO;
    private boolean info_open = true;

    private TeamsDTO teamsDTO;
    private boolean teams_open = true;

    private int length;
    private boolean length_open = true;

    private PlayerMapDTO players;
    private boolean players_open = true;

    private Map<String, String> names;
    private boolean names_open = true;

    private HealSpreadDTO healspread;
    private boolean healspread_open = true;

    private ClassKillsDTO classkills;
    private boolean classkills_open = true;

    private ClassDeathsDTO classdeaths;
    private boolean classdeaths_open = true;

    private ClassKillAssistsDTO classkillassists;
    private boolean classkillassists_open = true;

    private ChatDTO[] chatDTO;
    private boolean chat_open = true;

    private RoundDTO[] roundDTOS;
    private boolean rounds_open = true;

    private KillStreakDTO[] killstreaks;
    private boolean killstreaks_open = true;

    public KillStreakDTO[] getKillstreaks() {
        return killstreaks;
    }

    public void setKillstreaks(KillStreakDTO[] killstreaks) {
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

    public InfoDTO getInfo() { return infoDTO; }
    public void setInfo(InfoDTO infoDTO) {
        if (info_open) {
            this.infoDTO = infoDTO;
            info_open = false;
        }
    }

    public TeamsDTO getTeams() { return teamsDTO; }
    public void setTeams(TeamsDTO teamsDTO) {
        if (teams_open) {
            this.teamsDTO = teamsDTO;
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

    public PlayerMapDTO getPlayers() { return players; }
    public void setPlayers(PlayerMapDTO players) {
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

    public HealSpreadDTO getHealspread() { return healspread; }
    public void setHealspread(HealSpreadDTO healspread) {
        if (healspread_open) {
            this.healspread = healspread;
            healspread_open = false;
        }
    }

    public ClassKillsDTO getClasskills() { return classkills; }
    public void setClasskills(ClassKillsDTO classkills) {
        if (classkills_open) {
            this.classkills = classkills;
            classkills_open = false;
        }
    }

    public ClassDeathsDTO getClassdeaths() { return classdeaths; }
    public void setClassdeaths(ClassDeathsDTO classdeaths) {
        if (classdeaths_open) {
            this.classdeaths = classdeaths;
            classdeaths_open = false;
        }
    }

    public ClassKillAssistsDTO getClasskillassists() { return classkillassists; }
    public void setClasskillassists(ClassKillAssistsDTO classkillassists) {
        if (classkillassists_open) {
            this.classkillassists = classkillassists;
            classkillassists_open = false;
        }
    }

    public ChatDTO[] getChat() { return chatDTO; }
    public void setChat(ChatDTO[] chatDTO) {
        if (chat_open) {
            this.chatDTO = chatDTO;
            chat_open = false;
        }
    }

    public RoundDTO[] getRounds() { return roundDTOS; }
    public void setRounds(RoundDTO[] roundDTOS) {
        if (rounds_open) {
            this.roundDTOS = roundDTOS;
            rounds_open = false;
        }
    }
}