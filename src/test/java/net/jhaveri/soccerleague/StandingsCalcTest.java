package net.jhaveri.soccerleague;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandingsCalcTest {

    @Test
    public void pointTotalsTie() {
        List<Game> games = new ArrayList<>();
        TeamPoints t1 = new TeamPoints("t1", 5);
        TeamPoints t2 = new TeamPoints("t2", 5);
        games.add(new Game(t1, t2));
        Map<String, Integer> totals = StandingsCalc.tallyPoints(games);
        Assert.assertEquals(1, (int)totals.get("t1"));
        Assert.assertEquals(1, (int)totals.get("t2"));
    }

    @Test
    public void pointTotalsT1Wins() {
        List<Game> games = new ArrayList<>();
        TeamPoints t1 = new TeamPoints("t1", 5);
        TeamPoints t2 = new TeamPoints("t2", 0);
        games.add(new Game(t1, t2));
        Map<String, Integer> totals = StandingsCalc.tallyPoints(games);
        Assert.assertEquals(3, (int)totals.get("t1"));
        Assert.assertEquals(0, (int)totals.get("t2"));
    }

    @Test
    public void pointTotalsT2Wins() {
        List<Game> games = new ArrayList<>();
        TeamPoints t1 = new TeamPoints("t1", 0);
        TeamPoints t2 = new TeamPoints("t2", 1);
        games.add(new Game(t1, t2));
        Map<String, Integer> totals = StandingsCalc.tallyPoints(games);
        Assert.assertEquals(0, (int)totals.get("t1"));
        Assert.assertEquals(3, (int)totals.get("t2"));
    }

    @Test
    public void rankTeams() {
        Map<String, Integer> totals = new HashMap<>();
        totals.put("team2", 3);
        totals.put("team1", 1);

        List<TeamPoints> teamPoints = StandingsCalc.rankTeams(totals);
        Assert.assertEquals(2, teamPoints.size());
        Assert.assertEquals("team2", teamPoints.get(0).team);
        Assert.assertEquals(3, teamPoints.get(0).points);
    }

    @Test
    public void rankTeamsEmpty() {
        List<TeamPoints> teamPoints = StandingsCalc.rankTeams(Collections.emptyMap());
        Assert.assertEquals(0, teamPoints.size());
    }
}