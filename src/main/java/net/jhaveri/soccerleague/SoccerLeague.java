package net.jhaveri.soccerleague;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SoccerLeague {
    public static void main(String[] args) {
        List<String> input = readStdIn();
        String out = formatStandings(input);

        System.out.print(out);
    }

    public static String formatStandings(List<String> inLines) {
        List<Game> games = Parser.parseGames(inLines);
        Map<String, Integer> totals = StandingsCalc.tallyPoints(games);
        List<TeamPoints> ranked = StandingsCalc.rankTeams(totals);

        return StandingsCalc.printStandings(ranked);
    }

    private static List<String> readStdIn() {
        Scanner in = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        while (in.hasNextLine()) {
            lines.add(in.nextLine());
        }

        return lines;
    }
}
