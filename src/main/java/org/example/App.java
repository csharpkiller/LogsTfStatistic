package org.example;

import org.example.search.info.*;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*System.out.println( "Hello World!" );
        JsonFetcher jsonFetcher = new JsonFetcher();
        ApiLinkCreator apiLinkCreator = new ApiLinkCreator();
        apiLinkCreator.setPlayer("76561197987681768");
        String str = jsonFetcher.getJsonFromUrl(apiLinkCreator.build());
        System.out.println("sdas");
        LogsJsonParser logsJsonParser = new LogsJsonParser();
        var res = logsJsonParser.getMatchList(str);
        var res1 = logsJsonParser.getMatchResultsList(jsonFetcher.getJsonFromUrl(apiLinkCreator.createLinkForInsideMatch("1980809")));
        System.out.println("sdas");*/

        //76561198146466689 ya
        // 76561197987681768
        SearchData searchData = new SearchData(
                "76561197987681768",
                SearchRangeType.MATCH_COUNT,
                false,
                List.of("PugChamp", "TF2Center"),
                List.of(GameHero.SCOUT),
                10,
                List.of(GameMode.SIXES)
        );
        MatchExtractor matchExtractor = new MatchExtractor();
        var e = matchExtractor.getMatches(searchData.getPlayerId(), 0, 10, searchData);
        System.out.println("done");

        DataExtractor dataExtractor = new DataExtractor();
        List<PlayerResultData> playerResultData = dataExtractor.getPlayerResults(searchData);
        System.out.printf("done 2");
    }
}
