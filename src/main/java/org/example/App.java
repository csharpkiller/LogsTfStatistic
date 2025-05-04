package org.example;

import org.example.search.info.DTO.ParseResult;
import org.example.search.info.DTO.inside.match.MatchRoot;
import org.example.search.info.LogsJsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
    private static String str = "{\n" +
            "  \"version\": 3,\n" +
            "  \"teams\": {\n" +
            "    \"Red\": {\n" +
            "      \"score\": 2,\n" +
            "      \"kills\": 108,\n" +
            "      \"deaths\": 0,\n" +
            "      \"dmg\": 39147,\n" +
            "      \"charges\": 11,\n" +
            "      \"drops\": 0,\n" +
            "      \"firstcaps\": 2,\n" +
            "      \"caps\": 9\n" +
            "    },\n" +
            "    \"Blue\": {\n" +
            "      \"score\": 4,\n" +
            "      \"kills\": 126,\n" +
            "      \"deaths\": 0,\n" +
            "      \"dmg\": 44653,\n" +
            "      \"charges\": 8,\n" +
            "      \"drops\": 2,\n" +
            "      \"firstcaps\": 5,\n" +
            "      \"caps\": 16\n" +
            "    }\n" +
            "  },\n" +
            "  \"length\": 1769,\n" +
            "  \"players\": {\n" +
            "    \"[U:1:9083523]\": {\n" +
            "      \"team\": \"Blue\",\n" +
            "      \"class_stats\": [\n" +
            "        {\n" +
            "          \"type\": \"scout\",\n" +
            "          \"kills\": 31,\n" +
            "          \"assists\": 15,\n" +
            "          \"deaths\": 23,\n" +
            "          \"dmg\": 8848,\n" +
            "          \"weapon\": {\n" +
            "            \"scattergun\": {\n" +
            "              \"kills\": 30,\n" +
            "              \"dmg\": 8798,\n" +
            "              \"avg_dmg\": 28.1086261980831,\n" +
            "              \"shots\": 401,\n" +
            "              \"hits\": 293\n" +
            "            },\n" +
            "            \"the_winger\": {\n" +
            "              \"kills\": 1,\n" +
            "              \"dmg\": 50,\n" +
            "              \"avg_dmg\": 16.6666666666667,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 1765\n" +
            "        }\n" +
            "      ],\n" +
            "      \"kills\": 31,\n" +
            "      \"deaths\": 23,\n" +
            "      \"assists\": 15,\n" +
            "      \"suicides\": 0,\n" +
            "      \"kapd\": \"2.0\",\n" +
            "      \"kpd\": \"1.3\",\n" +
            "      \"dmg\": 8848,\n" +
            "      \"dmg_real\": 769,\n" +
            "      \"dt\": 6489,\n" +
            "      \"dt_real\": 715,\n" +
            "      \"hr\": 4383,\n" +
            "      \"lks\": 5,\n" +
            "      \"as\": 0,\n" +
            "      \"dapd\": 384,\n" +
            "      \"dapm\": 300,\n" +
            "      \"ubers\": 0,\n" +
            "      \"ubertypes\": {\n" +
            "\n" +
            "      },\n" +
            "      \"drops\": 0,\n" +
            "      \"medkits\": 23,\n" +
            "      \"medkits_hp\": 596,\n" +
            "      \"backstabs\": 0,\n" +
            "      \"headshots\": 0,\n" +
            "      \"headshots_hit\": 0,\n" +
            "      \"sentries\": 0,\n" +
            "      \"heal\": 0,\n" +
            "      \"cpc\": 7,\n" +
            "      \"ic\": 0\n" +
            "    },\n" +
            "    \"[U:1:27416040]\": {\n" +
            "      \"team\": \"Blue\",\n" +
            "      \"class_stats\": [\n" +
            "        {\n" +
            "          \"type\": \"soldier\",\n" +
            "          \"kills\": 16,\n" +
            "          \"assists\": 12,\n" +
            "          \"deaths\": 23,\n" +
            "          \"dmg\": 7428,\n" +
            "          \"weapon\": {\n" +
            "            \"quake_rl\": {\n" +
            "              \"kills\": 16,\n" +
            "              \"dmg\": 7428,\n" +
            "              \"avg_dmg\": 55.4328358208955,\n" +
            "              \"shots\": 290,\n" +
            "              \"hits\": 122\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 1709\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"spy\",\n" +
            "          \"kills\": 0,\n" +
            "          \"assists\": 0,\n" +
            "          \"deaths\": 1,\n" +
            "          \"dmg\": 0,\n" +
            "          \"weapon\": {\n" +
            "\n" +
            "          },\n" +
            "          \"total_time\": 32\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"engineer\",\n" +
            "          \"kills\": 1,\n" +
            "          \"assists\": 0,\n" +
            "          \"deaths\": 0,\n" +
            "          \"dmg\": 113,\n" +
            "          \"weapon\": {\n" +
            "            \"obj_sentrygun\": {\n" +
            "              \"kills\": 0,\n" +
            "              \"dmg\": 36,\n" +
            "              \"avg_dmg\": 18,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            },\n" +
            "            \"shotgun_primary\": {\n" +
            "              \"kills\": 1,\n" +
            "              \"dmg\": 77,\n" +
            "              \"avg_dmg\": 38.5,\n" +
            "              \"shots\": 2,\n" +
            "              \"hits\": 2\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 27\n" +
            "        }\n" +
            "      ],\n" +
            "      \"kills\": 17,\n" +
            "      \"deaths\": 24,\n" +
            "      \"assists\": 12,\n" +
            "      \"suicides\": 0,\n" +
            "      \"kapd\": \"1.2\",\n" +
            "      \"kpd\": \"0.7\",\n" +
            "      \"dmg\": 7541,\n" +
            "      \"dmg_real\": 501,\n" +
            "      \"dt\": 7910,\n" +
            "      \"dt_real\": 999,\n" +
            "      \"hr\": 5489,\n" +
            "      \"lks\": 3,\n" +
            "      \"as\": 0,\n" +
            "      \"dapd\": 314,\n" +
            "      \"dapm\": 255,\n" +
            "      \"ubers\": 0,\n" +
            "      \"ubertypes\": {\n" +
            "\n" +
            "      },\n" +
            "      \"drops\": 0,\n" +
            "      \"medkits\": 71,\n" +
            "      \"medkits_hp\": 2652,\n" +
            "      \"backstabs\": 0,\n" +
            "      \"headshots\": 0,\n" +
            "      \"headshots_hit\": 0,\n" +
            "      \"sentries\": 0,\n" +
            "      \"heal\": 0,\n" +
            "      \"cpc\": 6,\n" +
            "      \"ic\": 0\n" +
            "    },\n" +
            "    \"[U:1:33573908]\": {\n" +
            "      \"team\": \"Blue\",\n" +
            "      \"class_stats\": [\n" +
            "        {\n" +
            "          \"type\": \"soldier\",\n" +
            "          \"kills\": 28,\n" +
            "          \"assists\": 8,\n" +
            "          \"deaths\": 17,\n" +
            "          \"dmg\": 9924,\n" +
            "          \"weapon\": {\n" +
            "            \"tf_projectile_rocket\": {\n" +
            "              \"kills\": 27,\n" +
            "              \"dmg\": 9924,\n" +
            "              \"avg_dmg\": 60.8834355828221,\n" +
            "              \"shots\": 336,\n" +
            "              \"hits\": 150\n" +
            "            },\n" +
            "            \"world\": {\n" +
            "              \"kills\": 1,\n" +
            "              \"dmg\": 0,\n" +
            "              \"avg_dmg\": 0,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 1769\n" +
            "        }\n" +
            "      ],\n" +
            "      \"kills\": 28,\n" +
            "      \"deaths\": 17,\n" +
            "      \"assists\": 8,\n" +
            "      \"suicides\": 0,\n" +
            "      \"kapd\": \"2.1\",\n" +
            "      \"kpd\": \"1.6\",\n" +
            "      \"dmg\": 9924,\n" +
            "      \"dmg_real\": 1071,\n" +
            "      \"dt\": 7662,\n" +
            "      \"dt_real\": 458,\n" +
            "      \"hr\": 8364,\n" +
            "      \"lks\": 4,\n" +
            "      \"as\": 1,\n" +
            "      \"dapd\": 583,\n" +
            "      \"dapm\": 336,\n" +
            "      \"ubers\": 0,\n" +
            "      \"ubertypes\": {\n" +
            "\n" +
            "      },\n" +
            "      \"drops\": 0,\n" +
            "      \"medkits\": 52,\n" +
            "      \"medkits_hp\": 1980,\n" +
            "      \"backstabs\": 0,\n" +
            "      \"headshots\": 0,\n" +
            "      \"headshots_hit\": 0,\n" +
            "      \"sentries\": 0,\n" +
            "      \"heal\": 0,\n" +
            "      \"cpc\": 3,\n" +
            "      \"ic\": 0\n" +
            "    },\n" +
            "    \"[U:1:34989139]\": {\n" +
            "      \"team\": \"Red\",\n" +
            "      \"class_stats\": [\n" +
            "        {\n" +
            "          \"type\": \"demoman\",\n" +
            "          \"kills\": 20,\n" +
            "          \"assists\": 7,\n" +
            "          \"deaths\": 16,\n" +
            "          \"dmg\": 7841,\n" +
            "          \"weapon\": {\n" +
            "            \"tf_projectile_pipe_remote\": {\n" +
            "              \"kills\": 12,\n" +
            "              \"dmg\": 5100,\n" +
            "              \"avg_dmg\": 52.0408163265306,\n" +
            "              \"shots\": 522,\n" +
            "              \"hits\": 94\n" +
            "            },\n" +
            "            \"iron_bomber\": {\n" +
            "              \"kills\": 8,\n" +
            "              \"dmg\": 2741,\n" +
            "              \"avg_dmg\": 74.0810810810811,\n" +
            "              \"shots\": 193,\n" +
            "              \"hits\": 36\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 1769\n" +
            "        }\n" +
            "      ],\n" +
            "      \"kills\": 20,\n" +
            "      \"deaths\": 16,\n" +
            "      \"assists\": 7,\n" +
            "      \"suicides\": 0,\n" +
            "      \"kapd\": \"1.7\",\n" +
            "      \"kpd\": \"1.3\",\n" +
            "      \"dmg\": 7841,\n" +
            "      \"dmg_real\": 905,\n" +
            "      \"dt\": 8625,\n" +
            "      \"dt_real\": 450,\n" +
            "      \"hr\": 8003,\n" +
            "      \"lks\": 6,\n" +
            "      \"as\": 1,\n" +
            "      \"dapd\": 490,\n" +
            "      \"dapm\": 265,\n" +
            "      \"ubers\": 0,\n" +
            "      \"ubertypes\": {\n" +
            "\n" +
            "      },\n" +
            "      \"drops\": 0,\n" +
            "      \"medkits\": 48,\n" +
            "      \"medkits_hp\": 1695,\n" +
            "      \"backstabs\": 0,\n" +
            "      \"headshots\": 0,\n" +
            "      \"headshots_hit\": 0,\n" +
            "      \"sentries\": 0,\n" +
            "      \"heal\": 0,\n" +
            "      \"cpc\": 2,\n" +
            "      \"ic\": 0\n" +
            "    },\n" +
            "    \"[U:1:106391137]\": {\n" +
            "      \"team\": \"Blue\",\n" +
            "      \"class_stats\": [\n" +
            "        {\n" +
            "          \"type\": \"scout\",\n" +
            "          \"kills\": 28,\n" +
            "          \"assists\": 16,\n" +
            "          \"deaths\": 15,\n" +
            "          \"dmg\": 7294,\n" +
            "          \"weapon\": {\n" +
            "            \"scattergun\": {\n" +
            "              \"kills\": 22,\n" +
            "              \"dmg\": 6945,\n" +
            "              \"avg_dmg\": 26.9186046511628,\n" +
            "              \"shots\": 342,\n" +
            "              \"hits\": 233\n" +
            "            },\n" +
            "            \"the_winger\": {\n" +
            "              \"kills\": 3,\n" +
            "              \"dmg\": 275,\n" +
            "              \"avg_dmg\": 19.6428571428571,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            },\n" +
            "            \"scout_sword\": {\n" +
            "              \"kills\": 1,\n" +
            "              \"dmg\": 74,\n" +
            "              \"avg_dmg\": 24.6666666666667,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            },\n" +
            "            \"world\": {\n" +
            "              \"kills\": 1,\n" +
            "              \"dmg\": 0,\n" +
            "              \"avg_dmg\": 0,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            },\n" +
            "            \"bleed_kill\": {\n" +
            "              \"kills\": 1,\n" +
            "              \"dmg\": 0,\n" +
            "              \"avg_dmg\": 0,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 1411\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"sniper\",\n" +
            "          \"kills\": 7,\n" +
            "          \"assists\": 2,\n" +
            "          \"deaths\": 3,\n" +
            "          \"dmg\": 2239,\n" +
            "          \"weapon\": {\n" +
            "            \"awper_hand\": {\n" +
            "              \"kills\": 7,\n" +
            "              \"dmg\": 2239,\n" +
            "              \"avg_dmg\": 124.388888888889,\n" +
            "              \"shots\": 52,\n" +
            "              \"hits\": 18\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 355\n" +
            "        }\n" +
            "      ],\n" +
            "      \"kills\": 35,\n" +
            "      \"deaths\": 18,\n" +
            "      \"assists\": 18,\n" +
            "      \"suicides\": 0,\n" +
            "      \"kapd\": \"2.9\",\n" +
            "      \"kpd\": \"1.9\",\n" +
            "      \"dmg\": 9533,\n" +
            "      \"dmg_real\": 1482,\n" +
            "      \"dt\": 6374,\n" +
            "      \"dt_real\": 732,\n" +
            "      \"hr\": 4250,\n" +
            "      \"lks\": 6,\n" +
            "      \"as\": 0,\n" +
            "      \"dapd\": 529,\n" +
            "      \"dapm\": 323,\n" +
            "      \"ubers\": 0,\n" +
            "      \"ubertypes\": {\n" +
            "\n" +
            "      },\n" +
            "      \"drops\": 0,\n" +
            "      \"medkits\": 33,\n" +
            "      \"medkits_hp\": 752,\n" +
            "      \"backstabs\": 0,\n" +
            "      \"headshots\": 6,\n" +
            "      \"headshots_hit\": 7,\n" +
            "      \"sentries\": 0,\n" +
            "      \"heal\": 0,\n" +
            "      \"cpc\": 8,\n" +
            "      \"ic\": 0\n" +
            "    },\n" +
            "    \"[U:1:94770515]\": {\n" +
            "      \"team\": \"Red\",\n" +
            "      \"class_stats\": [\n" +
            "        {\n" +
            "          \"type\": \"medic\",\n" +
            "          \"kills\": 2,\n" +
            "          \"assists\": 17,\n" +
            "          \"deaths\": 14,\n" +
            "          \"dmg\": 557,\n" +
            "          \"weapon\": {\n" +
            "            \"crusaders_crossbow\": {\n" +
            "              \"kills\": 2,\n" +
            "              \"dmg\": 427,\n" +
            "              \"avg_dmg\": 53.375,\n" +
            "              \"shots\": 144,\n" +
            "              \"hits\": 69\n" +
            "            },\n" +
            "            \"ubersaw\": {\n" +
            "              \"kills\": 0,\n" +
            "              \"dmg\": 130,\n" +
            "              \"avg_dmg\": 65,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 1769\n" +
            "        }\n" +
            "      ],\n" +
            "      \"kills\": 2,\n" +
            "      \"deaths\": 14,\n" +
            "      \"assists\": 17,\n" +
            "      \"suicides\": 0,\n" +
            "      \"kapd\": \"1.4\",\n" +
            "      \"kpd\": \"0.1\",\n" +
            "      \"dmg\": 557,\n" +
            "      \"dmg_real\": 28,\n" +
            "      \"dt\": 4941,\n" +
            "      \"dt_real\": 429,\n" +
            "      \"hr\": 0,\n" +
            "      \"lks\": 1,\n" +
            "      \"as\": 0,\n" +
            "      \"dapd\": 39,\n" +
            "      \"dapm\": 18,\n" +
            "      \"ubers\": 11,\n" +
            "      \"ubertypes\": {\n" +
            "        \"medigun\": 11\n" +
            "      },\n" +
            "      \"drops\": 0,\n" +
            "      \"medkits\": 15,\n" +
            "      \"medkits_hp\": 530,\n" +
            "      \"backstabs\": 0,\n" +
            "      \"headshots\": 0,\n" +
            "      \"headshots_hit\": 0,\n" +
            "      \"sentries\": 0,\n" +
            "      \"heal\": 29444,\n" +
            "      \"cpc\": 5,\n" +
            "      \"ic\": 0,\n" +
            "      \"medicstats\": {\n" +
            "        \"advantages_lost\": 0,\n" +
            "        \"biggest_advantage_lost\": 0,\n" +
            "        \"deaths_within_20s_after_uber\": 3,\n" +
            "        \"avg_time_before_using\": 0\n" +
            "      }\n" +
            "    },\n" +
            "    \"[U:1:71713376]\": {\n" +
            "      \"team\": \"Red\",\n" +
            "      \"class_stats\": [\n" +
            "        {\n" +
            "          \"type\": \"scout\",\n" +
            "          \"kills\": 16,\n" +
            "          \"assists\": 10,\n" +
            "          \"deaths\": 21,\n" +
            "          \"dmg\": 5473,\n" +
            "          \"weapon\": {\n" +
            "            \"scattergun\": {\n" +
            "              \"kills\": 11,\n" +
            "              \"dmg\": 5202,\n" +
            "              \"avg_dmg\": 22.7161572052402,\n" +
            "              \"shots\": 302,\n" +
            "              \"hits\": 211\n" +
            "            },\n" +
            "            \"pistol_scout\": {\n" +
            "              \"kills\": 5,\n" +
            "              \"dmg\": 271,\n" +
            "              \"avg_dmg\": 15.9411764705882,\n" +
            "              \"shots\": 71,\n" +
            "              \"hits\": 16\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 1459\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pyro\",\n" +
            "          \"kills\": 3,\n" +
            "          \"assists\": 1,\n" +
            "          \"deaths\": 2,\n" +
            "          \"dmg\": 1510,\n" +
            "          \"weapon\": {\n" +
            "            \"flamethrower\": {\n" +
            "              \"kills\": 2,\n" +
            "              \"dmg\": 600,\n" +
            "              \"avg_dmg\": 6.97674418604651,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            },\n" +
            "            \"detonator\": {\n" +
            "              \"kills\": 1,\n" +
            "              \"dmg\": 798,\n" +
            "              \"avg_dmg\": 5.86764705882353,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            },\n" +
            "            \"tf_projectile_rocket\": {\n" +
            "              \"kills\": 0,\n" +
            "              \"dmg\": 61,\n" +
            "              \"avg_dmg\": 61,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            },\n" +
            "            \"tf_projectile_pipe\": {\n" +
            "              \"kills\": 0,\n" +
            "              \"dmg\": 51,\n" +
            "              \"avg_dmg\": 51,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 168\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"sniper\",\n" +
            "          \"kills\": 1,\n" +
            "          \"assists\": 0,\n" +
            "          \"deaths\": 1,\n" +
            "          \"dmg\": 350,\n" +
            "          \"weapon\": {\n" +
            "            \"awper_hand\": {\n" +
            "              \"kills\": 1,\n" +
            "              \"dmg\": 350,\n" +
            "              \"avg_dmg\": 70,\n" +
            "              \"shots\": 12,\n" +
            "              \"hits\": 5\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 142\n" +
            "        }\n" +
            "      ],\n" +
            "      \"kills\": 20,\n" +
            "      \"deaths\": 24,\n" +
            "      \"assists\": 11,\n" +
            "      \"suicides\": 0,\n" +
            "      \"kapd\": \"1.3\",\n" +
            "      \"kpd\": \"0.8\",\n" +
            "      \"dmg\": 7333,\n" +
            "      \"dmg_real\": 585,\n" +
            "      \"dt\": 7060,\n" +
            "      \"dt_real\": 906,\n" +
            "      \"hr\": 4223,\n" +
            "      \"lks\": 4,\n" +
            "      \"as\": 0,\n" +
            "      \"dapd\": 305,\n" +
            "      \"dapm\": 248,\n" +
            "      \"ubers\": 0,\n" +
            "      \"ubertypes\": {\n" +
            "\n" +
            "      },\n" +
            "      \"drops\": 0,\n" +
            "      \"medkits\": 26,\n" +
            "      \"medkits_hp\": 673,\n" +
            "      \"backstabs\": 0,\n" +
            "      \"headshots\": 1,\n" +
            "      \"headshots_hit\": 1,\n" +
            "      \"sentries\": 0,\n" +
            "      \"heal\": 0,\n" +
            "      \"cpc\": 4,\n" +
            "      \"ic\": 0\n" +
            "    },\n" +
            "    \"[U:1:76482484]\": {\n" +
            "      \"team\": \"Blue\",\n" +
            "      \"class_stats\": [\n" +
            "        {\n" +
            "          \"type\": \"medic\",\n" +
            "          \"kills\": 1,\n" +
            "          \"assists\": 7,\n" +
            "          \"deaths\": 15,\n" +
            "          \"dmg\": 574,\n" +
            "          \"weapon\": {\n" +
            "            \"crusaders_crossbow\": {\n" +
            "              \"kills\": 0,\n" +
            "              \"dmg\": 444,\n" +
            "              \"avg_dmg\": 63.4285714285714,\n" +
            "              \"shots\": 146,\n" +
            "              \"hits\": 72\n" +
            "            },\n" +
            "            \"ubersaw\": {\n" +
            "              \"kills\": 1,\n" +
            "              \"dmg\": 130,\n" +
            "              \"avg_dmg\": 65,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 1769\n" +
            "        }\n" +
            "      ],\n" +
            "      \"kills\": 1,\n" +
            "      \"deaths\": 15,\n" +
            "      \"assists\": 7,\n" +
            "      \"suicides\": 0,\n" +
            "      \"kapd\": \"0.5\",\n" +
            "      \"kpd\": \"0.1\",\n" +
            "      \"dmg\": 574,\n" +
            "      \"dmg_real\": 35,\n" +
            "      \"dt\": 4750,\n" +
            "      \"dt_real\": 527,\n" +
            "      \"hr\": 0,\n" +
            "      \"lks\": 1,\n" +
            "      \"as\": 0,\n" +
            "      \"dapd\": 38,\n" +
            "      \"dapm\": 19,\n" +
            "      \"ubers\": 8,\n" +
            "      \"ubertypes\": {\n" +
            "        \"medigun\": 8\n" +
            "      },\n" +
            "      \"drops\": 2,\n" +
            "      \"medkits\": 13,\n" +
            "      \"medkits_hp\": 455,\n" +
            "      \"backstabs\": 0,\n" +
            "      \"headshots\": 0,\n" +
            "      \"headshots_hit\": 0,\n" +
            "      \"sentries\": 0,\n" +
            "      \"heal\": 30099,\n" +
            "      \"cpc\": 3,\n" +
            "      \"ic\": 0,\n" +
            "      \"medicstats\": {\n" +
            "        \"advantages_lost\": 0,\n" +
            "        \"biggest_advantage_lost\": 0,\n" +
            "        \"deaths_within_20s_after_uber\": 1,\n" +
            "        \"avg_time_before_using\": 0\n" +
            "      }\n" +
            "    },\n" +
            "    \"[U:1:44306791]\": {\n" +
            "      \"team\": \"Red\",\n" +
            "      \"class_stats\": [\n" +
            "        {\n" +
            "          \"type\": \"soldier\",\n" +
            "          \"kills\": 29,\n" +
            "          \"assists\": 7,\n" +
            "          \"deaths\": 22,\n" +
            "          \"dmg\": 8438,\n" +
            "          \"weapon\": {\n" +
            "            \"tf_projectile_rocket\": {\n" +
            "              \"kills\": 17,\n" +
            "              \"dmg\": 7240,\n" +
            "              \"avg_dmg\": 60.3333333333333,\n" +
            "              \"shots\": 311,\n" +
            "              \"hits\": 113\n" +
            "            },\n" +
            "            \"shotgun_soldier\": {\n" +
            "              \"kills\": 11,\n" +
            "              \"dmg\": 1198,\n" +
            "              \"avg_dmg\": 23.4901960784314,\n" +
            "              \"shots\": 66,\n" +
            "              \"hits\": 48\n" +
            "            },\n" +
            "            \"world\": {\n" +
            "              \"kills\": 1,\n" +
            "              \"dmg\": 0,\n" +
            "              \"avg_dmg\": 0,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 1768\n" +
            "        }\n" +
            "      ],\n" +
            "      \"kills\": 29,\n" +
            "      \"deaths\": 22,\n" +
            "      \"assists\": 7,\n" +
            "      \"suicides\": 0,\n" +
            "      \"kapd\": \"1.6\",\n" +
            "      \"kpd\": \"1.3\",\n" +
            "      \"dmg\": 8438,\n" +
            "      \"dmg_real\": 709,\n" +
            "      \"dt\": 7736,\n" +
            "      \"dt_real\": 811,\n" +
            "      \"hr\": 8659,\n" +
            "      \"lks\": 5,\n" +
            "      \"as\": 1,\n" +
            "      \"dapd\": 383,\n" +
            "      \"dapm\": 286,\n" +
            "      \"ubers\": 0,\n" +
            "      \"ubertypes\": {\n" +
            "\n" +
            "      },\n" +
            "      \"drops\": 0,\n" +
            "      \"medkits\": 38,\n" +
            "      \"medkits_hp\": 1322,\n" +
            "      \"backstabs\": 0,\n" +
            "      \"headshots\": 0,\n" +
            "      \"headshots_hit\": 0,\n" +
            "      \"sentries\": 0,\n" +
            "      \"heal\": 0,\n" +
            "      \"cpc\": 4,\n" +
            "      \"ic\": 0\n" +
            "    },\n" +
            "    \"[U:1:89086738]\": {\n" +
            "      \"team\": \"Blue\",\n" +
            "      \"class_stats\": [\n" +
            "        {\n" +
            "          \"type\": \"demoman\",\n" +
            "          \"kills\": 14,\n" +
            "          \"assists\": 10,\n" +
            "          \"deaths\": 11,\n" +
            "          \"dmg\": 8233,\n" +
            "          \"weapon\": {\n" +
            "            \"tf_projectile_pipe_remote\": {\n" +
            "              \"kills\": 4,\n" +
            "              \"dmg\": 4286,\n" +
            "              \"avg_dmg\": 51.0238095238095,\n" +
            "              \"shots\": 447,\n" +
            "              \"hits\": 80\n" +
            "            },\n" +
            "            \"iron_bomber\": {\n" +
            "              \"kills\": 10,\n" +
            "              \"dmg\": 3947,\n" +
            "              \"avg_dmg\": 61.671875,\n" +
            "              \"shots\": 213,\n" +
            "              \"hits\": 61\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 1769\n" +
            "        }\n" +
            "      ],\n" +
            "      \"kills\": 14,\n" +
            "      \"deaths\": 11,\n" +
            "      \"assists\": 10,\n" +
            "      \"suicides\": 0,\n" +
            "      \"kapd\": \"2.2\",\n" +
            "      \"kpd\": \"1.3\",\n" +
            "      \"dmg\": 8233,\n" +
            "      \"dmg_real\": 598,\n" +
            "      \"dt\": 5962,\n" +
            "      \"dt_real\": 748,\n" +
            "      \"hr\": 7613,\n" +
            "      \"lks\": 4,\n" +
            "      \"as\": 5,\n" +
            "      \"dapd\": 748,\n" +
            "      \"dapm\": 279,\n" +
            "      \"ubers\": 0,\n" +
            "      \"ubertypes\": {\n" +
            "\n" +
            "      },\n" +
            "      \"drops\": 0,\n" +
            "      \"medkits\": 51,\n" +
            "      \"medkits_hp\": 1833,\n" +
            "      \"backstabs\": 0,\n" +
            "      \"headshots\": 0,\n" +
            "      \"headshots_hit\": 0,\n" +
            "      \"sentries\": 0,\n" +
            "      \"heal\": 0,\n" +
            "      \"cpc\": 3,\n" +
            "      \"ic\": 0\n" +
            "    },\n" +
            "    \"[U:1:96208544]\": {\n" +
            "      \"team\": \"Red\",\n" +
            "      \"class_stats\": [\n" +
            "        {\n" +
            "          \"type\": \"scout\",\n" +
            "          \"kills\": 11,\n" +
            "          \"assists\": 6,\n" +
            "          \"deaths\": 18,\n" +
            "          \"dmg\": 4417,\n" +
            "          \"weapon\": {\n" +
            "            \"scattergun\": {\n" +
            "              \"kills\": 4,\n" +
            "              \"dmg\": 4010,\n" +
            "              \"avg_dmg\": 27.6551724137931,\n" +
            "              \"shots\": 245,\n" +
            "              \"hits\": 132\n" +
            "            },\n" +
            "            \"pistol_scout\": {\n" +
            "              \"kills\": 4,\n" +
            "              \"dmg\": 407,\n" +
            "              \"avg_dmg\": 17.695652173913,\n" +
            "              \"shots\": 177,\n" +
            "              \"hits\": 21\n" +
            "            },\n" +
            "            \"world\": {\n" +
            "              \"kills\": 3,\n" +
            "              \"dmg\": 0,\n" +
            "              \"avg_dmg\": 0,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 1291\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"sniper\",\n" +
            "          \"kills\": 2,\n" +
            "          \"assists\": 1,\n" +
            "          \"deaths\": 4,\n" +
            "          \"dmg\": 990,\n" +
            "          \"weapon\": {\n" +
            "            \"the_classic\": {\n" +
            "              \"kills\": 2,\n" +
            "              \"dmg\": 990,\n" +
            "              \"avg_dmg\": 198,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            },\n" +
            "            \"smg\": {\n" +
            "              \"kills\": 0,\n" +
            "              \"dmg\": 0,\n" +
            "              \"avg_dmg\": 0,\n" +
            "              \"shots\": 12,\n" +
            "              \"hits\": 0\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 255\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"heavyweapons\",\n" +
            "          \"kills\": 2,\n" +
            "          \"assists\": 4,\n" +
            "          \"deaths\": 3,\n" +
            "          \"dmg\": 1060,\n" +
            "          \"weapon\": {\n" +
            "            \"family_business\": {\n" +
            "              \"kills\": 2,\n" +
            "              \"dmg\": 823,\n" +
            "              \"avg_dmg\": 28.3793103448276,\n" +
            "              \"shots\": 46,\n" +
            "              \"hits\": 29\n" +
            "            },\n" +
            "            \"tomislav\": {\n" +
            "              \"kills\": 0,\n" +
            "              \"dmg\": 237,\n" +
            "              \"avg_dmg\": 9.11538461538462,\n" +
            "              \"shots\": 0,\n" +
            "              \"hits\": 0\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 223\n" +
            "        }\n" +
            "      ],\n" +
            "      \"kills\": 15,\n" +
            "      \"deaths\": 25,\n" +
            "      \"assists\": 11,\n" +
            "      \"suicides\": 0,\n" +
            "      \"kapd\": \"1.0\",\n" +
            "      \"kpd\": \"0.6\",\n" +
            "      \"dmg\": 6467,\n" +
            "      \"dmg_real\": 627,\n" +
            "      \"dt\": 8250,\n" +
            "      \"dt_real\": 1065,\n" +
            "      \"hr\": 4362,\n" +
            "      \"lks\": 4,\n" +
            "      \"as\": 0,\n" +
            "      \"dapd\": 258,\n" +
            "      \"dapm\": 219,\n" +
            "      \"ubers\": 0,\n" +
            "      \"ubertypes\": {\n" +
            "\n" +
            "      },\n" +
            "      \"drops\": 0,\n" +
            "      \"medkits\": 22,\n" +
            "      \"medkits_hp\": 628,\n" +
            "      \"backstabs\": 0,\n" +
            "      \"headshots\": 1,\n" +
            "      \"headshots_hit\": 1,\n" +
            "      \"sentries\": 0,\n" +
            "      \"heal\": 0,\n" +
            "      \"cpc\": 2,\n" +
            "      \"ic\": 0\n" +
            "    },\n" +
            "    \"[U:1:85127652]\": {\n" +
            "      \"team\": \"Red\",\n" +
            "      \"class_stats\": [\n" +
            "        {\n" +
            "          \"type\": \"soldier\",\n" +
            "          \"kills\": 16,\n" +
            "          \"assists\": 1,\n" +
            "          \"deaths\": 21,\n" +
            "          \"dmg\": 6272,\n" +
            "          \"weapon\": {\n" +
            "            \"quake_rl\": {\n" +
            "              \"kills\": 16,\n" +
            "              \"dmg\": 6272,\n" +
            "              \"avg_dmg\": 57.0181818181818,\n" +
            "              \"shots\": 315,\n" +
            "              \"hits\": 103\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 1441\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"sniper\",\n" +
            "          \"kills\": 6,\n" +
            "          \"assists\": 0,\n" +
            "          \"deaths\": 4,\n" +
            "          \"dmg\": 2149,\n" +
            "          \"weapon\": {\n" +
            "            \"sniperrifle\": {\n" +
            "              \"kills\": 5,\n" +
            "              \"dmg\": 2018,\n" +
            "              \"avg_dmg\": 118.705882352941,\n" +
            "              \"shots\": 38,\n" +
            "              \"hits\": 17\n" +
            "            },\n" +
            "            \"smg\": {\n" +
            "              \"kills\": 1,\n" +
            "              \"dmg\": 131,\n" +
            "              \"avg_dmg\": 14.5555555555556,\n" +
            "              \"shots\": 15,\n" +
            "              \"hits\": 5\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 281\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"heavyweapons\",\n" +
            "          \"kills\": 0,\n" +
            "          \"assists\": 2,\n" +
            "          \"deaths\": 0,\n" +
            "          \"dmg\": 90,\n" +
            "          \"weapon\": {\n" +
            "            \"shotgun_hwg\": {\n" +
            "              \"kills\": 0,\n" +
            "              \"dmg\": 90,\n" +
            "              \"avg_dmg\": 18,\n" +
            "              \"shots\": 7,\n" +
            "              \"hits\": 5\n" +
            "            }\n" +
            "          },\n" +
            "          \"total_time\": 47\n" +
            "        }\n" +
            "      ],\n" +
            "      \"kills\": 22,\n" +
            "      \"deaths\": 25,\n" +
            "      \"assists\": 3,\n" +
            "      \"suicides\": 0,\n" +
            "      \"kapd\": \"1.0\",\n" +
            "      \"kpd\": \"0.9\",\n" +
            "      \"dmg\": 8511,\n" +
            "      \"dmg_real\": 1325,\n" +
            "      \"dt\": 8041,\n" +
            "      \"dt_real\": 795,\n" +
            "      \"hr\": 4197,\n" +
            "      \"lks\": 4,\n" +
            "      \"as\": 1,\n" +
            "      \"dapd\": 340,\n" +
            "      \"dapm\": 288,\n" +
            "      \"ubers\": 0,\n" +
            "      \"ubertypes\": {\n" +
            "\n" +
            "      },\n" +
            "      \"drops\": 0,\n" +
            "      \"medkits\": 39,\n" +
            "      \"medkits_hp\": 1318,\n" +
            "      \"backstabs\": 0,\n" +
            "      \"headshots\": 3,\n" +
            "      \"headshots_hit\": 5,\n" +
            "      \"sentries\": 0,\n" +
            "      \"heal\": 0,\n" +
            "      \"cpc\": 2,\n" +
            "      \"ic\": 0\n" +
            "    }\n" +
            "  },\n" +
            "  \"names\": {\n" +
            "    \"[U:1:9083523]\": \"cookye\",\n" +
            "    \"[U:1:27416040]\": \"zoob\",\n" +
            "    \"[U:1:33573908]\": \"mu\",\n" +
            "    \"[U:1:34989139]\": \"Hildreth\",\n" +
            "    \"[U:1:106391137]\": \"nation_idiot\",\n" +
            "    \"[U:1:94770515]\": \"shampain\",\n" +
            "    \"[U:1:71713376]\": \"Ignis\",\n" +
            "    \"[U:1:76482484]\": \"Menty\",\n" +
            "    \"[U:1:44306791]\": \"Crayon\",\n" +
            "    \"[U:1:89086738]\": \"Yohn\",\n" +
            "    \"[U:1:96208544]\": \"Pred\",\n" +
            "    \"[U:1:85127652]\": \"hems\"\n" +
            "  },\n" +
            "  \"rounds\": [\n" +
            "    {\n" +
            "      \"start_time\": 1520862685,\n" +
            "      \"winner\": \"Blue\",\n" +
            "      \"team\": {\n" +
            "        \"Blue\": {\n" +
            "          \"score\": 1,\n" +
            "          \"kills\": 15,\n" +
            "          \"dmg\": 4590,\n" +
            "          \"ubers\": 1\n" +
            "        },\n" +
            "        \"Red\": {\n" +
            "          \"score\": 0,\n" +
            "          \"kills\": 7,\n" +
            "          \"dmg\": 3930,\n" +
            "          \"ubers\": 1\n" +
            "        }\n" +
            "      },\n" +
            "      \"events\": [\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 34,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:44306791]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 44,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:33573908]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 68,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 3\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 143,\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"team\": \"Blue\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 144,\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"team\": \"Red\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 157,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:9083523]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 162,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 4\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 177,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 5\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"round_win\",\n" +
            "          \"time\": 177,\n" +
            "          \"team\": \"Blue\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"players\": {\n" +
            "        \"[U:1:71713376]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 510\n" +
            "        },\n" +
            "        \"[U:1:9083523]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 598\n" +
            "        },\n" +
            "        \"[U:1:85127652]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 3,\n" +
            "          \"dmg\": 1081\n" +
            "        },\n" +
            "        \"[U:1:106391137]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 815\n" +
            "        },\n" +
            "        \"[U:1:34989139]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 669\n" +
            "        },\n" +
            "        \"[U:1:27416040]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 1017\n" +
            "        },\n" +
            "        \"[U:1:96208544]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 703\n" +
            "        },\n" +
            "        \"[U:1:33573908]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 6,\n" +
            "          \"dmg\": 1225\n" +
            "        },\n" +
            "        \"[U:1:44306791]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 967\n" +
            "        },\n" +
            "        \"[U:1:89086738]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 3,\n" +
            "          \"dmg\": 935\n" +
            "        },\n" +
            "        \"[U:1:94770515]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 0\n" +
            "        },\n" +
            "        \"[U:1:76482484]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 0\n" +
            "        }\n" +
            "      },\n" +
            "      \"firstcap\": \"Blue\",\n" +
            "      \"length\": 177\n" +
            "    },\n" +
            "    {\n" +
            "      \"start_time\": 1520862867,\n" +
            "      \"winner\": \"Red\",\n" +
            "      \"team\": {\n" +
            "        \"Blue\": {\n" +
            "          \"score\": 1,\n" +
            "          \"kills\": 6,\n" +
            "          \"dmg\": 2931,\n" +
            "          \"ubers\": 1\n" +
            "        },\n" +
            "        \"Red\": {\n" +
            "          \"score\": 1,\n" +
            "          \"kills\": 10,\n" +
            "          \"dmg\": 3158,\n" +
            "          \"ubers\": 1\n" +
            "        }\n" +
            "      },\n" +
            "      \"events\": [\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 238,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"point\": 3\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 246,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"point\": 2\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 263,\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"team\": \"Blue\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 280,\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"team\": \"Red\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 322,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"point\": 1\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"round_win\",\n" +
            "          \"time\": 322,\n" +
            "          \"team\": \"Red\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"players\": {\n" +
            "        \"[U:1:9083523]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 595\n" +
            "        },\n" +
            "        \"[U:1:71713376]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 3,\n" +
            "          \"dmg\": 1043\n" +
            "        },\n" +
            "        \"[U:1:106391137]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 436\n" +
            "        },\n" +
            "        \"[U:1:89086738]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 925\n" +
            "        },\n" +
            "        \"[U:1:34989139]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 342\n" +
            "        },\n" +
            "        \"[U:1:96208544]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 482\n" +
            "        },\n" +
            "        \"[U:1:85127652]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 493\n" +
            "        },\n" +
            "        \"[U:1:27416040]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 570\n" +
            "        },\n" +
            "        \"[U:1:44306791]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 5,\n" +
            "          \"dmg\": 760\n" +
            "        },\n" +
            "        \"[U:1:33573908]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 290\n" +
            "        },\n" +
            "        \"[U:1:94770515]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 38\n" +
            "        },\n" +
            "        \"[U:1:76482484]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 115\n" +
            "        }\n" +
            "      },\n" +
            "      \"firstcap\": \"Red\",\n" +
            "      \"length\": 140\n" +
            "    },\n" +
            "    {\n" +
            "      \"start_time\": 1520863012,\n" +
            "      \"winner\": \"Blue\",\n" +
            "      \"team\": {\n" +
            "        \"Blue\": {\n" +
            "          \"score\": 2,\n" +
            "          \"kills\": 16,\n" +
            "          \"dmg\": 4724,\n" +
            "          \"ubers\": 0\n" +
            "        },\n" +
            "        \"Red\": {\n" +
            "          \"score\": 1,\n" +
            "          \"kills\": 8,\n" +
            "          \"dmg\": 3432,\n" +
            "          \"ubers\": 0\n" +
            "        }\n" +
            "      },\n" +
            "      \"events\": [\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 382,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:106391137]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 390,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 3\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"drop\",\n" +
            "          \"time\": 422,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 422,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:71713376]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 433,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:106391137]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 453,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 4\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 499,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:106391137]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 501,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 5\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"round_win\",\n" +
            "          \"time\": 501,\n" +
            "          \"team\": \"Blue\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"players\": {\n" +
            "        \"[U:1:89086738]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 453\n" +
            "        },\n" +
            "        \"[U:1:9083523]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 3,\n" +
            "          \"dmg\": 1255\n" +
            "        },\n" +
            "        \"[U:1:71713376]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 481\n" +
            "        },\n" +
            "        \"[U:1:106391137]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 6,\n" +
            "          \"dmg\": 1136\n" +
            "        },\n" +
            "        \"[U:1:85127652]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 853\n" +
            "        },\n" +
            "        \"[U:1:96208544]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 454\n" +
            "        },\n" +
            "        \"[U:1:27416040]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 545\n" +
            "        },\n" +
            "        \"[U:1:33573908]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 4,\n" +
            "          \"dmg\": 1263\n" +
            "        },\n" +
            "        \"[U:1:34989139]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 893\n" +
            "        },\n" +
            "        \"[U:1:44306791]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 592\n" +
            "        },\n" +
            "        \"[U:1:94770515]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 159\n" +
            "        },\n" +
            "        \"[U:1:76482484]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 72\n" +
            "        }\n" +
            "      },\n" +
            "      \"firstcap\": \"Blue\",\n" +
            "      \"length\": 174\n" +
            "    },\n" +
            "    {\n" +
            "      \"start_time\": 1520863191,\n" +
            "      \"winner\": \"Red\",\n" +
            "      \"team\": {\n" +
            "        \"Blue\": {\n" +
            "          \"score\": 2,\n" +
            "          \"kills\": 28,\n" +
            "          \"dmg\": 10672,\n" +
            "          \"ubers\": 1\n" +
            "        },\n" +
            "        \"Red\": {\n" +
            "          \"score\": 2,\n" +
            "          \"kills\": 32,\n" +
            "          \"dmg\": 10680,\n" +
            "          \"ubers\": 3\n" +
            "        }\n" +
            "      },\n" +
            "      \"events\": [\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 539,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:85127652]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 541,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:33573908]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 564,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 3\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 598,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:85127652]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 635,\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"team\": \"Red\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 658,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"point\": 3\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 666,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:33573908]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 678,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:71713376]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 760,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:44306791]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 761,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:33573908]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 801,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:34989139]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 849,\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"team\": \"Red\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 857,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"point\": 2\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 909,\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"team\": \"Blue\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 912,\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"team\": \"Red\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 922,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:96208544]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 931,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"point\": 1\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"round_win\",\n" +
            "          \"time\": 931,\n" +
            "          \"team\": \"Red\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"players\": {\n" +
            "        \"[U:1:89086738]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 2391\n" +
            "        },\n" +
            "        \"[U:1:96208544]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 5,\n" +
            "          \"dmg\": 2518\n" +
            "        },\n" +
            "        \"[U:1:9083523]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 6,\n" +
            "          \"dmg\": 2053\n" +
            "        },\n" +
            "        \"[U:1:106391137]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 10,\n" +
            "          \"dmg\": 2114\n" +
            "        },\n" +
            "        \"[U:1:71713376]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 4,\n" +
            "          \"dmg\": 1331\n" +
            "        },\n" +
            "        \"[U:1:34989139]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 6,\n" +
            "          \"dmg\": 2060\n" +
            "        },\n" +
            "        \"[U:1:44306791]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 8,\n" +
            "          \"dmg\": 2256\n" +
            "        },\n" +
            "        \"[U:1:27416040]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 5,\n" +
            "          \"dmg\": 2216\n" +
            "        },\n" +
            "        \"[U:1:85127652]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 8,\n" +
            "          \"dmg\": 2465\n" +
            "        },\n" +
            "        \"[U:1:33573908]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 5,\n" +
            "          \"dmg\": 1898\n" +
            "        },\n" +
            "        \"[U:1:94770515]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 50\n" +
            "        },\n" +
            "        \"[U:1:76482484]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 0\n" +
            "        }\n" +
            "      },\n" +
            "      \"firstcap\": \"Blue\",\n" +
            "      \"length\": 425\n" +
            "    },\n" +
            "    {\n" +
            "      \"start_time\": 1520863621,\n" +
            "      \"winner\": \"Blue\",\n" +
            "      \"team\": {\n" +
            "        \"Blue\": {\n" +
            "          \"score\": 3,\n" +
            "          \"kills\": 34,\n" +
            "          \"dmg\": 12192,\n" +
            "          \"ubers\": 2\n" +
            "        },\n" +
            "        \"Red\": {\n" +
            "          \"score\": 2,\n" +
            "          \"kills\": 25,\n" +
            "          \"dmg\": 9824,\n" +
            "          \"ubers\": 4\n" +
            "        }\n" +
            "      },\n" +
            "      \"events\": [\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 990,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:96208544]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 1003,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"point\": 3\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 1037,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"point\": 2\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 1047,\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"team\": \"Red\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 1052,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:96208544]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 1136,\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"team\": \"Blue\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 1138,\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"team\": \"Red\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 1177,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:33573908]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 1203,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 2\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"drop\",\n" +
            "          \"time\": 1218,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 1218,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:85127652]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 1281,\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"team\": \"Red\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 1305,\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"team\": \"Blue\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 1319,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 3\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 1349,\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"team\": \"Red\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 1349,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:44306791]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 1355,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:106391137]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 1360,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 4\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 1411,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 5\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"round_win\",\n" +
            "          \"time\": 1411,\n" +
            "          \"team\": \"Blue\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"players\": {\n" +
            "        \"[U:1:89086738]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 4,\n" +
            "          \"dmg\": 1921\n" +
            "        },\n" +
            "        \"[U:1:9083523]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 10,\n" +
            "          \"dmg\": 2263\n" +
            "        },\n" +
            "        \"[U:1:96208544]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 4,\n" +
            "          \"dmg\": 1304\n" +
            "        },\n" +
            "        \"[U:1:106391137]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 10,\n" +
            "          \"dmg\": 2671\n" +
            "        },\n" +
            "        \"[U:1:71713376]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 5,\n" +
            "          \"dmg\": 1577\n" +
            "        },\n" +
            "        \"[U:1:85127652]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 5,\n" +
            "          \"dmg\": 2515\n" +
            "        },\n" +
            "        \"[U:1:34989139]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 5,\n" +
            "          \"dmg\": 2324\n" +
            "        },\n" +
            "        \"[U:1:27416040]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 3,\n" +
            "          \"dmg\": 1909\n" +
            "        },\n" +
            "        \"[U:1:33573908]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 7,\n" +
            "          \"dmg\": 3173\n" +
            "        },\n" +
            "        \"[U:1:44306791]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 6,\n" +
            "          \"dmg\": 1987\n" +
            "        },\n" +
            "        \"[U:1:76482484]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 255\n" +
            "        },\n" +
            "        \"[U:1:94770515]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 117\n" +
            "        }\n" +
            "      },\n" +
            "      \"firstcap\": \"Red\",\n" +
            "      \"length\": 475\n" +
            "    },\n" +
            "    {\n" +
            "      \"start_time\": 1520864101,\n" +
            "      \"winner\": \"Blue\",\n" +
            "      \"team\": {\n" +
            "        \"Blue\": {\n" +
            "          \"score\": 4,\n" +
            "          \"kills\": 10,\n" +
            "          \"dmg\": 2601,\n" +
            "          \"ubers\": 1\n" +
            "        },\n" +
            "        \"Red\": {\n" +
            "          \"score\": 2,\n" +
            "          \"kills\": 3,\n" +
            "          \"dmg\": 1648,\n" +
            "          \"ubers\": 0\n" +
            "        }\n" +
            "      },\n" +
            "      \"events\": [\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 1447,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:27416040]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 1473,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 3\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 1497,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 4\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 1501,\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"team\": \"Blue\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 1511,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:76482484]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 1517,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 5\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"round_win\",\n" +
            "          \"time\": 1517,\n" +
            "          \"team\": \"Blue\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"players\": {\n" +
            "        \"[U:1:71713376]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 450\n" +
            "        },\n" +
            "        \"[U:1:9083523]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 340\n" +
            "        },\n" +
            "        \"[U:1:89086738]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 504\n" +
            "        },\n" +
            "        \"[U:1:106391137]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 507\n" +
            "        },\n" +
            "        \"[U:1:27416040]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 3,\n" +
            "          \"dmg\": 534\n" +
            "        },\n" +
            "        \"[U:1:44306791]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 418\n" +
            "        },\n" +
            "        \"[U:1:85127652]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 483\n" +
            "        },\n" +
            "        \"[U:1:33573908]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 2,\n" +
            "          \"dmg\": 651\n" +
            "        },\n" +
            "        \"[U:1:34989139]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 232\n" +
            "        },\n" +
            "        \"[U:1:94770515]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 65\n" +
            "        },\n" +
            "        \"[U:1:76482484]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 65\n" +
            "        },\n" +
            "        \"[U:1:96208544]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 0\n" +
            "        }\n" +
            "      },\n" +
            "      \"firstcap\": \"Blue\",\n" +
            "      \"length\": 101\n" +
            "    },\n" +
            "    {\n" +
            "      \"start_time\": 1520864207,\n" +
            "      \"winner\": \"Blue\",\n" +
            "      \"team\": {\n" +
            "        \"Blue\": {\n" +
            "          \"score\": 4,\n" +
            "          \"kills\": 17,\n" +
            "          \"dmg\": 6943,\n" +
            "          \"ubers\": 2\n" +
            "        },\n" +
            "        \"Red\": {\n" +
            "          \"score\": 2,\n" +
            "          \"kills\": 23,\n" +
            "          \"dmg\": 6475,\n" +
            "          \"ubers\": 2\n" +
            "        }\n" +
            "      },\n" +
            "      \"events\": [\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 1569,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 3\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 1596,\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"team\": \"Blue\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 1598,\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"team\": \"Red\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 1621,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:44306791]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 1713,\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"team\": \"Red\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"charge\",\n" +
            "          \"medigun\": \"medigun\",\n" +
            "          \"time\": 1717,\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"team\": \"Blue\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 1721,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"point\": 4\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 1724,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:33573908]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 1750,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:44306791]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"pointcap\",\n" +
            "          \"time\": 1776,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"point\": 4\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 1782,\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"steamid\": \"[U:1:76482484]\",\n" +
            "          \"killer\": \"[U:1:34989139]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"medic_death\",\n" +
            "          \"time\": 1786,\n" +
            "          \"team\": \"Red\",\n" +
            "          \"steamid\": \"[U:1:94770515]\",\n" +
            "          \"killer\": \"[U:1:9083523]\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"type\": \"round_win\",\n" +
            "          \"time\": 1799,\n" +
            "          \"team\": \"Blue\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"players\": {\n" +
            "        \"[U:1:89086738]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 1104\n" +
            "        },\n" +
            "        \"[U:1:9083523]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 6,\n" +
            "          \"dmg\": 1744\n" +
            "        },\n" +
            "        \"[U:1:34989139]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 6,\n" +
            "          \"dmg\": 1321\n" +
            "        },\n" +
            "        \"[U:1:71713376]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 7,\n" +
            "          \"dmg\": 1941\n" +
            "        },\n" +
            "        \"[U:1:106391137]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 6,\n" +
            "          \"dmg\": 1854\n" +
            "        },\n" +
            "        \"[U:1:27416040]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 750\n" +
            "        },\n" +
            "        \"[U:1:96208544]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 3,\n" +
            "          \"dmg\": 1006\n" +
            "        },\n" +
            "        \"[U:1:44306791]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 6,\n" +
            "          \"dmg\": 1458\n" +
            "        },\n" +
            "        \"[U:1:85127652]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 1,\n" +
            "          \"dmg\": 621\n" +
            "        },\n" +
            "        \"[U:1:33573908]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 4,\n" +
            "          \"dmg\": 1424\n" +
            "        },\n" +
            "        \"[U:1:76482484]\": {\n" +
            "          \"team\": \"Blue\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 67\n" +
            "        },\n" +
            "        \"[U:1:94770515]\": {\n" +
            "          \"team\": \"Red\",\n" +
            "          \"kills\": 0,\n" +
            "          \"dmg\": 128\n" +
            "        }\n" +
            "      },\n" +
            "      \"firstcap\": \"Blue\",\n" +
            "      \"length\": 277\n" +
            "    }\n" +
            "  ],\n" +
            "  \"healspread\": {\n" +
            "    \"[U:1:76482484]\": {\n" +
            "      \"[U:1:89086738]\": 7613,\n" +
            "      \"[U:1:9083523]\": 4383,\n" +
            "      \"[U:1:27416040]\": 5489,\n" +
            "      \"[U:1:106391137]\": 4250,\n" +
            "      \"[U:1:33573908]\": 8364\n" +
            "    },\n" +
            "    \"[U:1:94770515]\": {\n" +
            "      \"[U:1:85127652]\": 4197,\n" +
            "      \"[U:1:44306791]\": 8659,\n" +
            "      \"[U:1:96208544]\": 4362,\n" +
            "      \"[U:1:71713376]\": 4223,\n" +
            "      \"[U:1:34989139]\": 8003\n" +
            "    }\n" +
            "  },\n" +
            "  \"classkills\": {\n" +
            "    \"[U:1:9083523]\": {\n" +
            "      \"scout\": 10,\n" +
            "      \"medic\": 2,\n" +
            "      \"soldier\": 10,\n" +
            "      \"demoman\": 5,\n" +
            "      \"heavyweapons\": 2,\n" +
            "      \"pyro\": 1,\n" +
            "      \"sniper\": 1\n" +
            "    },\n" +
            "    \"[U:1:34989139]\": {\n" +
            "      \"scout\": 9,\n" +
            "      \"soldier\": 4,\n" +
            "      \"sniper\": 2,\n" +
            "      \"medic\": 2,\n" +
            "      \"demoman\": 2,\n" +
            "      \"spy\": 1\n" +
            "    },\n" +
            "    \"[U:1:33573908]\": {\n" +
            "      \"demoman\": 6,\n" +
            "      \"soldier\": 8,\n" +
            "      \"medic\": 6,\n" +
            "      \"sniper\": 3,\n" +
            "      \"scout\": 4,\n" +
            "      \"pyro\": 1\n" +
            "    },\n" +
            "    \"[U:1:44306791]\": {\n" +
            "      \"medic\": 5,\n" +
            "      \"soldier\": 11,\n" +
            "      \"scout\": 12,\n" +
            "      \"demoman\": 1\n" +
            "    },\n" +
            "    \"[U:1:89086738]\": {\n" +
            "      \"soldier\": 5,\n" +
            "      \"scout\": 7,\n" +
            "      \"demoman\": 1,\n" +
            "      \"heavyweapons\": 1\n" +
            "    },\n" +
            "    \"[U:1:96208544]\": {\n" +
            "      \"scout\": 4,\n" +
            "      \"demoman\": 1,\n" +
            "      \"soldier\": 7,\n" +
            "      \"medic\": 3\n" +
            "    },\n" +
            "    \"[U:1:27416040]\": {\n" +
            "      \"scout\": 6,\n" +
            "      \"soldier\": 8,\n" +
            "      \"demoman\": 2,\n" +
            "      \"medic\": 1\n" +
            "    },\n" +
            "    \"[U:1:85127652]\": {\n" +
            "      \"soldier\": 7,\n" +
            "      \"scout\": 7,\n" +
            "      \"medic\": 3,\n" +
            "      \"demoman\": 5\n" +
            "    },\n" +
            "    \"[U:1:106391137]\": {\n" +
            "      \"scout\": 12,\n" +
            "      \"soldier\": 12,\n" +
            "      \"medic\": 4,\n" +
            "      \"sniper\": 5,\n" +
            "      \"demoman\": 2\n" +
            "    },\n" +
            "    \"[U:1:71713376]\": {\n" +
            "      \"soldier\": 10,\n" +
            "      \"scout\": 5,\n" +
            "      \"medic\": 2,\n" +
            "      \"sniper\": 1,\n" +
            "      \"demoman\": 2\n" +
            "    },\n" +
            "    \"[U:1:94770515]\": {\n" +
            "      \"soldier\": 1,\n" +
            "      \"scout\": 1\n" +
            "    },\n" +
            "    \"[U:1:76482484]\": {\n" +
            "      \"medic\": 1\n" +
            "    }\n" +
            "  },\n" +
            "  \"classdeaths\": {\n" +
            "    \"[U:1:71713376]\": {\n" +
            "      \"scout\": 13,\n" +
            "      \"demoman\": 4,\n" +
            "      \"soldier\": 7\n" +
            "    },\n" +
            "    \"[U:1:106391137]\": {\n" +
            "      \"demoman\": 7,\n" +
            "      \"soldier\": 6,\n" +
            "      \"scout\": 4,\n" +
            "      \"sniper\": 1\n" +
            "    },\n" +
            "    \"[U:1:34989139]\": {\n" +
            "      \"soldier\": 8,\n" +
            "      \"scout\": 7,\n" +
            "      \"demoman\": 1\n" +
            "    },\n" +
            "    \"[U:1:85127652]\": {\n" +
            "      \"soldier\": 10,\n" +
            "      \"demoman\": 4,\n" +
            "      \"scout\": 9,\n" +
            "      \"sniper\": 2\n" +
            "    },\n" +
            "    \"[U:1:76482484]\": {\n" +
            "      \"soldier\": 8,\n" +
            "      \"sniper\": 1,\n" +
            "      \"scout\": 4,\n" +
            "      \"demoman\": 2\n" +
            "    },\n" +
            "    \"[U:1:44306791]\": {\n" +
            "      \"demoman\": 1,\n" +
            "      \"soldier\": 6,\n" +
            "      \"scout\": 12,\n" +
            "      \"engineer\": 1,\n" +
            "      \"sniper\": 2\n" +
            "    },\n" +
            "    \"[U:1:9083523]\": {\n" +
            "      \"scout\": 5,\n" +
            "      \"sniper\": 1,\n" +
            "      \"soldier\": 11,\n" +
            "      \"demoman\": 4,\n" +
            "      \"medic\": 1,\n" +
            "      \"pyro\": 1\n" +
            "    },\n" +
            "    \"[U:1:96208544]\": {\n" +
            "      \"soldier\": 6,\n" +
            "      \"demoman\": 4,\n" +
            "      \"scout\": 12,\n" +
            "      \"sniper\": 3\n" +
            "    },\n" +
            "    \"[U:1:94770515]\": {\n" +
            "      \"soldier\": 7,\n" +
            "      \"scout\": 6,\n" +
            "      \"medic\": 1\n" +
            "    },\n" +
            "    \"[U:1:33573908]\": {\n" +
            "      \"sniper\": 2,\n" +
            "      \"soldier\": 8,\n" +
            "      \"medic\": 1,\n" +
            "      \"demoman\": 1,\n" +
            "      \"scout\": 4,\n" +
            "      \"pyro\": 1\n" +
            "    },\n" +
            "    \"[U:1:27416040]\": {\n" +
            "      \"sniper\": 2,\n" +
            "      \"scout\": 7,\n" +
            "      \"soldier\": 8,\n" +
            "      \"demoman\": 4,\n" +
            "      \"heavyweapons\": 2,\n" +
            "      \"pyro\": 1\n" +
            "    },\n" +
            "    \"[U:1:89086738]\": {\n" +
            "      \"scout\": 3,\n" +
            "      \"soldier\": 4,\n" +
            "      \"demoman\": 2,\n" +
            "      \"sniper\": 2\n" +
            "    }\n" +
            "  },\n" +
            "  \"classkillassists\": {\n" +
            "    \"[U:1:9083523]\": {\n" +
            "      \"scout\": 18,\n" +
            "      \"demoman\": 8,\n" +
            "      \"medic\": 3,\n" +
            "      \"soldier\": 12,\n" +
            "      \"heavyweapons\": 2,\n" +
            "      \"pyro\": 2,\n" +
            "      \"sniper\": 1\n" +
            "    },\n" +
            "    \"[U:1:106391137]\": {\n" +
            "      \"scout\": 18,\n" +
            "      \"soldier\": 18,\n" +
            "      \"sniper\": 6,\n" +
            "      \"medic\": 5,\n" +
            "      \"demoman\": 5,\n" +
            "      \"pyro\": 1\n" +
            "    },\n" +
            "    \"[U:1:34989139]\": {\n" +
            "      \"scout\": 11,\n" +
            "      \"soldier\": 9,\n" +
            "      \"sniper\": 2,\n" +
            "      \"medic\": 2,\n" +
            "      \"demoman\": 2,\n" +
            "      \"spy\": 1\n" +
            "    },\n" +
            "    \"[U:1:33573908]\": {\n" +
            "      \"demoman\": 7,\n" +
            "      \"soldier\": 11,\n" +
            "      \"medic\": 7,\n" +
            "      \"sniper\": 4,\n" +
            "      \"scout\": 6,\n" +
            "      \"pyro\": 1\n" +
            "    },\n" +
            "    \"[U:1:44306791]\": {\n" +
            "      \"medic\": 5,\n" +
            "      \"soldier\": 13,\n" +
            "      \"scout\": 14,\n" +
            "      \"demoman\": 3,\n" +
            "      \"sniper\": 1\n" +
            "    },\n" +
            "    \"[U:1:89086738]\": {\n" +
            "      \"soldier\": 7,\n" +
            "      \"medic\": 3,\n" +
            "      \"scout\": 11,\n" +
            "      \"demoman\": 2,\n" +
            "      \"heavyweapons\": 1\n" +
            "    },\n" +
            "    \"[U:1:27416040]\": {\n" +
            "      \"soldier\": 12,\n" +
            "      \"scout\": 9,\n" +
            "      \"medic\": 3,\n" +
            "      \"heavyweapons\": 1,\n" +
            "      \"demoman\": 4\n" +
            "    },\n" +
            "    \"[U:1:96208544]\": {\n" +
            "      \"scout\": 7,\n" +
            "      \"soldier\": 13,\n" +
            "      \"demoman\": 1,\n" +
            "      \"medic\": 5\n" +
            "    },\n" +
            "    \"[U:1:94770515]\": {\n" +
            "      \"scout\": 8,\n" +
            "      \"soldier\": 8,\n" +
            "      \"demoman\": 2,\n" +
            "      \"medic\": 1\n" +
            "    },\n" +
            "    \"[U:1:85127652]\": {\n" +
            "      \"soldier\": 8,\n" +
            "      \"scout\": 8,\n" +
            "      \"medic\": 3,\n" +
            "      \"demoman\": 6\n" +
            "    },\n" +
            "    \"[U:1:71713376]\": {\n" +
            "      \"soldier\": 15,\n" +
            "      \"scout\": 8,\n" +
            "      \"medic\": 4,\n" +
            "      \"sniper\": 1,\n" +
            "      \"demoman\": 3\n" +
            "    },\n" +
            "    \"[U:1:76482484]\": {\n" +
            "      \"scout\": 2,\n" +
            "      \"soldier\": 4,\n" +
            "      \"heavyweapons\": 1,\n" +
            "      \"medic\": 1\n" +
            "    }\n" +
            "  },\n" +
            "  \"chat\": [\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:44306791]\",\n" +
            "      \"name\": \"Crayon\",\n" +
            "      \"msg\": \"rr\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:85127652]\",\n" +
            "      \"name\": \"hems\",\n" +
            "      \"msg\": \"rrw\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:85127652]\",\n" +
            "      \"name\": \"hems\",\n" +
            "      \"msg\": \"right meds trolling on first mid\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:34989139]\",\n" +
            "      \"name\": \"Hildreth\",\n" +
            "      \"msg\": \"tfw ur not healed on rollout :/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:44306791]\",\n" +
            "      \"name\": \"Crayon\",\n" +
            "      \"msg\": \"tfw aids medic\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:89086738]\",\n" +
            "      \"name\": \"Yohn\",\n" +
            "      \"msg\": \"shampain?\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:44306791]\",\n" +
            "      \"name\": \"Crayon\",\n" +
            "      \"msg\": \"i think lupus is playing on her pc\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:89086738]\",\n" +
            "      \"name\": \"Yohn\",\n" +
            "      \"msg\": \"xd\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:85127652]\",\n" +
            "      \"name\": \"hems\",\n" +
            "      \"msg\": \"my meds just levitating in lobby\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:85127652]\",\n" +
            "      \"name\": \"hems\",\n" +
            "      \"msg\": \"!GG\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:85127652]\",\n" +
            "      \"name\": \"hems\",\n" +
            "      \"msg\": \"DAT SAC\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:44306791]\",\n" +
            "      \"name\": \"Crayon\",\n" +
            "      \"msg\": \"EGBXDHSGVEDB FS\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:44306791]\",\n" +
            "      \"name\": \"Crayon\",\n" +
            "      \"msg\": \"byebye\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:9083523]\",\n" +
            "      \"name\": \"cookye\",\n" +
            "      \"msg\": \"ns\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:9083523]\",\n" +
            "      \"name\": \"cookye\",\n" +
            "      \"msg\": \"lmao\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:85127652]\",\n" +
            "      \"name\": \"hems\",\n" +
            "      \"msg\": \"OLD BANNY\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:85127652]\",\n" +
            "      \"name\": \"hems\",\n" +
            "      \"msg\": \"LOL\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:106391137]\",\n" +
            "      \"name\": \"nation_idiot\",\n" +
            "      \"msg\": \"mode = in the zone (ง'̀-'́)ง\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:71713376]\",\n" +
            "      \"name\": \"Ignis\",\n" +
            "      \"msg\": \"iatgink : yep i win those\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:71713376]\",\n" +
            "      \"name\": \"Ignis\",\n" +
            "      \"msg\": \"TU LA FERMER TA PUTIN\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:27416040]\",\n" +
            "      \"name\": \"zoob\",\n" +
            "      \"msg\": \"rip\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:89086738]\",\n" +
            "      \"name\": \"Yohn\",\n" +
            "      \"msg\": \"racecar spelled backwards is racecar\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:89086738]\",\n" +
            "      \"name\": \"Yohn\",\n" +
            "      \"msg\": \"lmao\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:33573908]\",\n" +
            "      \"name\": \"mu\",\n" +
            "      \"msg\": \"y\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:89086738]\",\n" +
            "      \"name\": \"Yohn\",\n" +
            "      \"msg\": \"lmao wtf\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:44306791]\",\n" +
            "      \"name\": \"Crayon\",\n" +
            "      \"msg\": \"fuck off nation\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:44306791]\",\n" +
            "      \"name\": \"Crayon\",\n" +
            "      \"msg\": \"useless player\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:106391137]\",\n" +
            "      \"name\": \"nation_idiot\",\n" +
            "      \"msg\": \"im killin mens\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:96208544]\",\n" +
            "      \"name\": \"Pred\",\n" +
            "      \"msg\": \"l8r zoop\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:71713376]\",\n" +
            "      \"name\": \"Ignis\",\n" +
            "      \"msg\": \"2v1 easy\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:27416040]\",\n" +
            "      \"name\": \"zoob\",\n" +
            "      \"msg\": \"fat scout :|\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:96208544]\",\n" +
            "      \"name\": \"Pred\",\n" +
            "      \"msg\": \"gg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:89086738]\",\n" +
            "      \"name\": \"Yohn\",\n" +
            "      \"msg\": \"rofl\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:89086738]\",\n" +
            "      \"name\": \"Yohn\",\n" +
            "      \"msg\": \"wtf\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:96208544]\",\n" +
            "      \"name\": \"Pred\",\n" +
            "      \"msg\": \"lopl  ez\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:89086738]\",\n" +
            "      \"name\": \"Yohn\",\n" +
            "      \"msg\": \"g\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:89086738]\",\n" +
            "      \"name\": \"Yohn\",\n" +
            "      \"msg\": \"g\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:34989139]\",\n" +
            "      \"name\": \"Hildreth\",\n" +
            "      \"msg\": \"gg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:85127652]\",\n" +
            "      \"name\": \"hems\",\n" +
            "      \"msg\": \"gg wp\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:76482484]\",\n" +
            "      \"name\": \"Menty\",\n" +
            "      \"msg\": \"gg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:27416040]\",\n" +
            "      \"name\": \"zoob\",\n" +
            "      \"msg\": \"very gg\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"info\": {\n" +
            "    \"map\": \"cp_snakewater_final1\",\n" +
            "    \"supplemental\": true,\n" +
            "    \"total_length\": 1769,\n" +
            "    \"hasRealDamage\": true,\n" +
            "    \"hasWeaponDamage\": true,\n" +
            "    \"hasAccuracy\": true,\n" +
            "    \"hasHP\": true,\n" +
            "    \"hasHP_real\": true,\n" +
            "    \"hasHS\": true,\n" +
            "    \"hasHS_hit\": true,\n" +
            "    \"hasBS\": false,\n" +
            "    \"hasCP\": true,\n" +
            "    \"hasSB\": false,\n" +
            "    \"hasDT\": true,\n" +
            "    \"hasAS\": true,\n" +
            "    \"hasHR\": true,\n" +
            "    \"hasIntel\": false,\n" +
            "    \"AD_scoring\": false,\n" +
            "    \"notifications\": [],\n" +
            "    \"title\": \"PugChamp EU Open #3: RED vs BLU\",\n" +
            "    \"date\": 1520868091,\n" +
            "    \"uploader\": {\n" +
            "      \"id\": \"76561198015569189\",\n" +
            "      \"name\": \"erynn\",\n" +
            "      \"info\": \"LogsTF 2.3.0\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"killstreaks\": [\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:33573908]\",\n" +
            "      \"streak\": 3,\n" +
            "      \"time\": 31\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:44306791]\",\n" +
            "      \"streak\": 3,\n" +
            "      \"time\": 316\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:106391137]\",\n" +
            "      \"streak\": 3,\n" +
            "      \"time\": 367\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:106391137]\",\n" +
            "      \"streak\": 4,\n" +
            "      \"time\": 1346\n" +
            "    },\n" +
            "    {\n" +
            "      \"steamid\": \"[U:1:71713376]\",\n" +
            "      \"streak\": 3,\n" +
            "      \"time\": 1751\n" +
            "    }\n" +
            "  ],\n" +
            "  \"success\": true\n" +
            "}";
    public static void main( String[] args )
    {
        LogsJsonParser logsJsonParser = new LogsJsonParser();
        ParseResult<MatchRoot> result = logsJsonParser.getMatchResultsList(str);
        System.out.println( "Hello World!" );
    }
}
