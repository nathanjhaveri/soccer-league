# Soccer League
Tabulate league standings from match results

## To Run tests and program:
```
mvn install
cat input-sample.txt | java -cp target/soccer-league-1.0-SNAPSHOT.jar net.jhaveri.soccerleague.SoccerLeague
```

## Design 

The main entry point for the program is in `SoccerLeague.main`. Note that
guidance was to parse stdin OR file, I took that to mean pick one and not spend
too much time on i/o, not to implement both.  Program expects well formed input
on stdin.

Code breakdown:

`SoccerLeague` - main class, handles basic input/output and the `formatStandings` function which is the main program logic.
`Game` and `TeamPoints` - Data model for problem domain
`Parser` - Adapts from string to domain objects
`StandingsCalc` - Business logic for tabulating standings

## The rules

In this league, a draw (tie) is worth 1 point and a win is worth 3 points. A
loss is worth 0 points. If two or more teams have the same number of points,
they should have the same rank and be printed in alphabetical order (as in the
tie for 3rd place in the sample data).


