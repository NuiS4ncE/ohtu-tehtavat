
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private String team;
    private String assists;
    private String goals;
    private String penalties;
    private String games;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getTeam() {
        return team;
    }

    public String getAssists() {
        return assists;
    }

    public String getGoals() {
        return goals;
    }

    public String getPenalties() {
        return penalties;
    }

    public String getGames() {
        return games;
    }

    @Override
    public String toString() {
        return name;
    }
      
}
