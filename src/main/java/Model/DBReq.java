package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pampado
 */

// Classe que envia os dados ao BD

public class DBReq {
    
    private PreparedStatement pstm;
    private Connection con;
    private final DBConf conn = new DBConf();
    private String sqlcmd;
    
    public void InsertGame(Game game) throws SQLException {
        
        con = conn.ConnectDB();
        sqlcmd = "INSERT INTO Jogos (time_date, home_team, away_team, champ_name) VALUES (?,?,?,?)";
        pstm = (PreparedStatement) con.prepareStatement(sqlcmd);
        pstm.setString(1, game.getGameDate());
        pstm.setString(2, game.getHomeTeam());
        pstm.setString(3, game.getAwayTeam());
        pstm.setString(4, game.getChampName());
        
        if(pstm.executeUpdate() > 0) {
            //System.out.println("Dados inseridos no banco");
        }
        else {
            System.out.println("Erro ao inserir dados no banco");
        }
        
        con = conn.DiscDB();
    }
}
