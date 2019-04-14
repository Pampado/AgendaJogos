package Model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pampado
 */

// Classe que gera thread de gravação dos dados no BD

public final class DBRCaller extends Thread {
    
    private Game game;
    
    public DBRCaller (Game game) {
        this.setGame(game);
        start();
    }
    
    @Override
    public void run() {
        DBReq db = new DBReq();
        try {
            db.InsertGame(this.game);
        } catch (SQLException ex) {
            Logger.getLogger(DBRCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
