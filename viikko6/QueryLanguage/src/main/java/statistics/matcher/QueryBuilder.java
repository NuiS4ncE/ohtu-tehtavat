package statistics.matcher;

public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder(Matcher matcher) {
        this.matcher = matcher;
    }

    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        return this.matcher;
    }

    public QueryBuilder oneOf(Matcher match1, Matcher match2){
        Matcher x = new Or(match1, match2);
        QueryBuilder qb = new QueryBuilder(x);
        return qb;
    }

    public QueryBuilder playsIn(String t) {
        Matcher x = new And(matcher, new PlaysIn(t));
        QueryBuilder qb = new QueryBuilder(x);
        return qb;
    }

    public QueryBuilder hasAtLeast(int y, String g){
        Matcher x = new And(matcher, new HasAtLeast(y, g));
        QueryBuilder qb = new QueryBuilder(x);
        return qb;
    }

    public QueryBuilder hasFewerThan(int y, String g) {
        Matcher x = new And(matcher, new HasFewerThan(y, g));
        QueryBuilder qb = new QueryBuilder(x);
        return qb;
    }
}
