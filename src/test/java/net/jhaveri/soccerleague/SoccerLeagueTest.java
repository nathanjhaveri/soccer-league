package net.jhaveri.soccerleague;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SoccerLeagueTest {
    @Test
    public void formatStandings() {
        String exampleInput = "Robots 3, Spammers 3\n" +
                "Thieves 1, FC Fraudsters 0\n" +
                "Robots 1, FC Fraudsters 1\n" +
                "Thieves 3, Spammers 1\n" +
                "Robots 4, Grandparents 0\n";
        String exampleOutput = "1. Thieves, 6 pts\n" +
                "2. Robots, 5 pts\n" +
                "3. FC Fraudsters, 1 pt\n" +
                "3. Spammers, 1 pt\n" +
                "5. Grandparents, 0 pts\n";
        List<String> lines = Arrays.asList(exampleInput.split("\n"));

        String out = SoccerLeague.formatStandings(lines);
        Assert.assertEquals(exampleOutput, out);
    }

}