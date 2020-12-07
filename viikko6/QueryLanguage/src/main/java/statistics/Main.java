package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));
          
        Matcher m = new And( new HasAtLeast(5, "goals"),
                             new HasAtLeast(5, "assists"),
                             new PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("");

        Matcher y = new And(
                new Not( new HasAtLeast(1, "goals") ),
                new PlaysIn("NYR")
        );

        System.out.println("");

        for (Player player : stats.matches(y)) {
            System.out.println(player);
        }

        System.out.println("");

        Matcher x = new And(
                new HasFewerThan(1, "goals"),
                new PlaysIn("NYR")
        );

        for (Player player : stats.matches(x)) {
            System.out.println(player);
        }

        System.out.println("");
        System.out.println(stats.matches(new All()).size());
        System.out.println("");

        Matcher z = new Or( new HasAtLeast(40, "goals"),
                new HasAtLeast(60, "assists")
        );

        for (Player player : stats.matches(z)) {
            System.out.println(player);
        }

        System.out.println("");

        Matcher a = new And(
                new HasAtLeast(50, "points"),
                new Or(
                        new PlaysIn("NYR"),
                        new PlaysIn("NYI"),
                        new PlaysIn("BOS")
                )
        );

        for (Player player : stats.matches(a)) {
            System.out.println(player);
        }

        System.out.println("");

        Statistics stats2 = new Statistics(new PlayerReaderImpl("https://nhlstatisticsforohtu.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();
        Matcher b = query.build();

        for (Player player : stats.matches(b)) {
            System.out.println( player );
        }

        System.out.println("");

        Matcher c = query.playsIn("NYR").build();

        for (Player player : stats.matches(c)) {
            System.out.println( player );
        }

        System.out.println("");

        Matcher d = query.playsIn("NYR")
                .hasAtLeast(5, "goals")
                .hasFewerThan(10, "goals").build();

        for (Player player : stats.matches(d)) {
            System.out.println( player );
        }
    }
}
