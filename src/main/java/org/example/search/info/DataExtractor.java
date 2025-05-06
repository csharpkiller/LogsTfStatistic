package org.example.search.info;

import org.example.search.info.DTO.ParseResult;
import org.example.search.info.DTO.inside.match.ClassStats;
import org.example.search.info.DTO.inside.match.MatchRoot;
import org.example.search.info.DTO.inside.match.Player;
import org.example.search.info.DTO.matches.list.MatchDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Класс-сборник, здесь идет основная взаимосвязь между всеми классами,
 * отвечающий за вычленение нужной информации из JSON.
 * (ниспадающие программирование начинаю здесь)
 */
public class DataExtractor {
    private final JsonFetcher jsonFetcher;
    private final ApiLinkCreator apiLinkCreator;
    private final LogsJsonParser logsJsonParser;
    private final MatchExtractor matchExtractor;
    private final SteamIdConverter steamIdConverter;

    private final Integer step;
    private final Integer countOfPossibleErrors;

    public DataExtractor(){
        jsonFetcher = new JsonFetcher();
        apiLinkCreator = new ApiLinkCreator();
        logsJsonParser = new LogsJsonParser();
        matchExtractor = new MatchExtractor();
        steamIdConverter = new SteamIdConverter();
        step = 50;
        countOfPossibleErrors = 3;
    }

    public List<PlayerResultData> getPlayerResults(SearchData searchData){
        List<PlayerResultData> resultData = new ArrayList<PlayerResultData>();
        InMatchSearchCategory filters = searchData;
        /*// интересно попробовать
        List<Function<List<MatchRoot>, List<MatchRoot>>> methods = new ArrayList<>();

       *//* if(!filters.getSearchHeroes().isEmpty()){
            methods.add((roots, list) -> filterMatchByHero(roots, filters.getPlayerId(), list)); //TODO
        }*//*
        //methods.add(this::fillMatchInfoList);
        //methods.add(this::fillResultData);*/


        int start = -step;
        int caughtErrors = 0;
        int deep = 5000; // TODO to delete? можно в теории передавать сколько максимум запросов будем обрабатывать

        while (resultData.size() < filters.getCount() && caughtErrors <= countOfPossibleErrors){
            start+=step;
            if(start >= deep) break; // TODO to delete?
            ParseResult<List<MatchDTO>> parseResultMatchDTOList = matchExtractor.getMatches(filters.getPlayerId(), start, step, searchData);

            if(parseResultMatchDTOList.getMissingData()){
                caughtErrors++;
                continue;
            }

            List<MatchDTO> listOfMatches = parseResultMatchDTOList.getResultData();
            List<MatchRoot> listOfMatchInfo = fillMatchInfoList(listOfMatches);

            if(!filters.getSearchHeroes().isEmpty()){
                listOfMatchInfo = filterMatchByHero(listOfMatchInfo,filters.getPlayerId(), filters.getSearchHeroes());
            }

            List<PlayerResultData> playerResultData = fillResultData(filters.getPlayerId(), listOfMatchInfo);
            resultData.addAll(playerResultData);
        }

        if(resultData.size() > filters.getCount()){
            return resultData.subList(0, filters.getCount());
        }
        return resultData;
    }

    private List<MatchRoot> fillMatchInfoList(List<MatchDTO> listOfMatches){
        List<MatchRoot> matchRootList = new ArrayList<>();
        for(MatchDTO match : listOfMatches){
            String apiUrl = apiLinkCreator.createLinkForInsideMatch(String.valueOf(match.getId()));
            //ParseResult<MatchRoot> parseResult = logsJsonParser.getMatchResultsList(apiUrl); //TODO вот тут возникла проблема, что Json в формате String, и можно подскользнуться
            ParseResult<MatchRoot> parseResult = logsJsonParser.getMatchResultsList(jsonFetcher.getJsonFromUrl(apiUrl));
            if(!parseResult.getMissingData()){
                matchRootList.add(parseResult.getResultData());
            }
        }
        return matchRootList;
    }

    private List<MatchRoot> filterMatchByHero(List<MatchRoot> matchRoots, String pleyer, List<GameHero> searchGameHeroes){
        String steamid3 = steamIdConverter.convertId64ToShortId(pleyer);
        return matchRoots.stream()
                .filter(root -> {

                    ClassStats[] classStats = root.getPlayers().getPlayerMap().get(steamid3).getClass_stats();
                    GameHero gameHero = getMainHeroInGame(classStats);

                    // return !searchGameHeroes.contains(gameHero); TODO
                    return searchGameHeroes.contains(gameHero);
                })
                .toList();
    }

    //TODO for next realise
    //TODO возвращать dataclass со всеми классами, чтобы учитывать offclass (next time)
    private GameHero getMainHeroInGame(ClassStats[] classStats){
        GameHero gameHero = null;
        int timePlayed = 0;

        for (ClassStats classStat : classStats) {
            int currentTime = classStat.getTotal_time();
            if (currentTime > timePlayed) {
                timePlayed = currentTime;
                gameHero = GameHero.valueOfLabel(classStat.getType());
            }
        }
        return gameHero;
    }

    // TODO мб в отдельный класс???
    private List<PlayerResultData> fillResultData(String steamId, List<MatchRoot> matchRootList){
        String shortId = steamIdConverter.convertId64ToShortId(steamId);
        List<PlayerResultData> playerResultData = new ArrayList<>();
        for(MatchRoot matchRoot : matchRootList){
            String nickName_r = matchRoot.getNames().get(shortId);
            Player player = matchRoot.getPlayers().getPlayerMap().get(shortId);
            GameHero gameHero_r = getMainHeroInGame(player.getClass_stats());
            String map_r = matchRoot.getInfo().getMap();
            GameResult gameResult_r = getGameResult(matchRoot, player);
            playerResultData.add(new PlayerResultData(
                    steamId, nickName_r, gameHero_r,player.getKills(), player.getDeaths(), player.getAssists(), map_r, gameResult_r
            ));
        }
        return playerResultData;
    }

    private GameResult getGameResult(MatchRoot matchRoot, Player player) {
        int redScore = matchRoot.getTeams().getRed().getScore();
        int blueScore = matchRoot.getTeams().getBlue().getScore();
        boolean isPlayerInRedTeam = "Red".equals(player.getTeam());

        if (redScore == blueScore) {
            return GameResult.DRAW;
        }

        boolean teamWon = isPlayerInRedTeam ? redScore > blueScore : blueScore > redScore;
        return teamWon ? GameResult.WIN : GameResult.LOSE;
    }

}
