package org.example.search.info;

import org.example.search.info.DTO.ParseResult;
import org.example.search.info.DTO.inside.match.ClassStats;
import org.example.search.info.DTO.inside.match.MatchRoot;
import org.example.search.info.DTO.matches.list.MatchDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс-сборник, здесь идет основная взаимосвязь между всеми классами,
 * отвечающий за вычленение нужной информации из JSON.
 * (ниспадающие программирование начинаю от сюда)
 */
public class DataExtractor {
    private List<PlayerResultData> playerResultDataList;
    private  InMatchSearchCategory inMatchSearchCategory;
    private ParseResult<List<MatchDTO>> parseResultListOfMatches;
    private List<MatchDTO> listOfMatches;
    private List<MatchRoot> matchRootList;

    private final JsonFetcher jsonFetcher;
    private final ApiLinkCreator apiLinkCreator;
    private final LogsJsonParser logsJsonParser;
    private final MatchExtractor matchExtractor;

    private final Integer step;
    private final Integer countOfPossibleErrors;

    public DataExtractor(){
        jsonFetcher = new JsonFetcher();
        apiLinkCreator = new ApiLinkCreator();
        logsJsonParser = new LogsJsonParser();
        matchExtractor = new MatchExtractor();
        step = 50;
        countOfPossibleErrors = 3;
    }

    public List<PlayerResultData> getPlayerResults(SearchData searchData){
        playerResultDataList = new ArrayList<PlayerResultData>();
        inMatchSearchCategory = searchData;

        // интересно попробовать
        List<Runnable> methodList = new ArrayList<>();
        if(!inMatchSearchCategory.getSearchHeroes().isEmpty()){
            //filterByHero(searchData);
            methodList.add(this::filterByHero);
        }
        if(!inMatchSearchCategory.getGameModes().isEmpty()){
            methodList.add(this::filterByGameMode);
        }
        methodList.add(this::fillMatchInfoList);
        methodList.add(this::fillResultData);

        int start = -step;
        int caughtErrors = 0;
        while (true){
            start+= step;

            if(caughtErrors > countOfPossibleErrors){
                break;
            }
            if(playerResultDataList.size() >= inMatchSearchCategory.getCount()){
                break;
            }

            matchRootList = new LinkedList<MatchRoot>();

            parseResultListOfMatches = matchExtractor.getMatches(
                    inMatchSearchCategory.getPlayerId(),
                    start,
                    inMatchSearchCategory.getCount(),
                    searchData);

            if(parseResultListOfMatches.getMissingData()){
                caughtErrors++;
                continue;
            }
            listOfMatches = parseResultListOfMatches.getResultData();

            for(Runnable method : methodList){
                method.run();
            }
        }


        return playerResultDataList.subList(0, inMatchSearchCategory.getCount());
    }

    private void fillMatchInfoList(){
        for(MatchDTO match : listOfMatches){
            String apiUrl = apiLinkCreator.createLinkForInsideMatch(String.valueOf(match.getId()));
            ParseResult<MatchRoot> parseResult = logsJsonParser.getMatchResultsList(apiUrl);
            if(!parseResult.getMissingData()){
                matchRootList.add(parseResult.getResultData());
            }
        }
    }

    private void filterByHero(InMatchSearchCategory searchCategory) {
    }

    private void filterByHero(){
        String pleyer = inMatchSearchCategory.getPlayerId();

        Iterator<MatchRoot> iterator = matchRootList.iterator();
        while (iterator.hasNext()) {
            MatchRoot matchResult = iterator.next();
            ClassStats[] classStats = matchResult.getPlayers().getPlayerMap().get(pleyer).getClass_stats();
            GameHero gameHero = getMainHeroInGame(classStats);

            if (!inMatchSearchCategory.getSearchHeroes().contains(gameHero)) {
                iterator.remove();
            }
        }

    }

    //TODO возвращать dataclass со всеми классами, чтобы учитывать offclass (next time)
    private GameHero getMainHeroInGame(ClassStats[] classStats){
        GameHero gameHero = null;
        int timePlayed = 0;

        for (ClassStats classStat : classStats) {
            int currentTime = classStat.getTotal_time();
            if (currentTime > timePlayed) {
                gameHero = GameHero.valueOf(classStat.getType());
            }
        }
        return gameHero;
    }


    private void filterByGameMode(){
        //TODO в MatchExtractor
    }

    private void fillResultData(){
        String pleyer = inMatchSearchCategory.getPlayerId();
        for(MatchRoot matchRoot : matchRootList){

        }
    }

}
