package net.jhaveri.soccerleague;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
    public static Game parseGame(String gameLine) {
        String[] teams = gameLine.split(", ");
        TeamPoints team1 = parseTeamPoints(teams[0]);
        TeamPoints team2 = parseTeamPoints(teams[1]);

        return new Game(team1, team2);
    }

    public static List<Game> parseGames(List<String> gameLines) {
        return gameLines.stream().map(Parser::parseGame).collect(Collectors.toList());
    }

    private static TeamPoints parseTeamPoints(String in) {
        String pattern = "\\s*(.+) (\\d+)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(in);
        if (!matcher.find()) {
            throw new RuntimeException("Failed to parse team points input: " + in);
        }

        String team = matcher.group(1);
        int points = Integer.parseInt(matcher.group(2));

        return new TeamPoints(team, points);
    }
}
