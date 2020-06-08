package net.jhaveri.soccerleague;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StandingsCalc {
    private static final int WIN_POINTS = 3;
    private static final int TIE_POINTS = 1;

    public static Map<String, Integer> tallyPoints(List<Game> games) {
        Map<String, Integer> points = new HashMap<>();
        for (Game game : games) {
            int team1Points = points.getOrDefault(game.team1.team, 0);
            int team2Points = points.getOrDefault(game.team2.team, 0);
            if (game.team1.points > game.team2.points) {
                team1Points += WIN_POINTS;
            } else if (game.team2.points > game.team1.points) {
                team2Points += WIN_POINTS;
            } else { // tie
                team1Points += TIE_POINTS;
                team2Points += TIE_POINTS;
            }

            points.put(game.team1.team, team1Points);
            points.put(game.team2.team, team2Points);
        }

        return points;
    }

    public static List<TeamPoints> rankTeams(Map<String, Integer> teamTotals) {
        return teamTotals
                .entrySet()
                .stream()
                .map(e -> new TeamPoints(e.getKey(), e.getValue()))
                .sorted((a, b) -> {
                    if (a.points != b.points) {
                        return b.points - a.points;
                    }

                    return a.team.compareTo(b.team);
                })
                .collect(Collectors.toList());
    }

    public static String printStandings(List<TeamPoints> teams) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int position = 0;
        int last = -1;
        for (TeamPoints teamPoints : teams) {
            count++;
            if (teamPoints.points != last) {
                position = count;
            }

            String line = position + ". " + teamPoints.team + ", " + ptString(teamPoints.points) + "\n";
            sb.append(line);

            last = teamPoints.points;
        }

        return sb.toString();
    }

    private static String ptString(int points) {
        String ptStr = points == 1 ? " pt" : " pts";
        return points + ptStr;
    }
}
