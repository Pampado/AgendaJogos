package Model;
/**
 *
 * @author pampado
 */

// Classe entidade

public class Game {

    private String homeTeam;
    private String awayTeam;
    private String gameDate;
    private String champName;
    
    public String getChampName() {
        return champName;
    }

    public void setChampName(String champName) {
        this.champName = champName;
    }
    
    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }
}
