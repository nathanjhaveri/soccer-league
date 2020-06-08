package net.jhaveri.soccerleague;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParserTest {
    @Test
    public void parsesGameLine() {
        Game g = Parser.parseGame("Robots 3, Spammers 2");
        Assert.assertEquals(g.team1.team, "Robots");
        Assert.assertEquals(g.team1.points, 3);
        Assert.assertEquals(g.team2.team, "Spammers");
        Assert.assertEquals(g.team2.points, 2);
    }

    @Test
    public void convertsLinesToGames() {
        String in = "Robots 3, Spammers 3\n" +
                "Thieves 1, FC Fraudsters 0\n" +
                "Robots 1, FC Fraudsters 1\n" +
                "Thieves 3, Spammers 1\n" +
                "Robots 4, Grandparents 0";
        List<String> lines = Arrays.asList(in.split("\n"));
        List<Game> games = Parser.parseGames(lines);
        Assert.assertEquals("Robots", games.get(0).team1.team);
        Assert.assertEquals(3, games.get(0).team1.points);
        Assert.assertEquals("Spammers", games.get(0).team2.team);
        Assert.assertEquals(3, games.get(0).team2.points);
        Assert.assertEquals("Robots", games.get(4).team1.team);
        Assert.assertEquals("Grandparents", games.get(4).team2.team);
    }

    @Test(expected = RuntimeException.class)
    public void parseInvalidGame() {
        Parser.parseGame("A");
    }
}