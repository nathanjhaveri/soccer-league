## Soccer League
Tabulate league standings from match results

### To Run
```
mvn install
cat input-sample.txt | java -cp target/soccer-league-1.0-SNAPSHOT.jar net.jhaveri.soccerleague.SoccerLeague
```

### The rules

In this league, a draw (tie) is worth 1 point and a win is worth 3 points. A
loss is worth 0 points. If two or more teams have the same number of points,
they should have the same rank and be printed in alphabetical order (as in the
tie for 3rd place in the sample data).


