package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pampado
 */

// Classe de configuração da conexão com o BD

public class DBConf {
    
        private Connection con;     
        private final String driver="com.mysql.cj.jdbc.Driver";
        private final String url="jdbc:mysql://localhost/infoJogos";
        private final String user="BotJogos";
        private final String pass="";
        
        //Conecta o banco de dados
        
        public Connection ConnectDB() { 
            try {
                Class.forName(driver);
                con = (Connection) DriverManager.getConnection(url, user, pass);
                //System.out.println("Banco de dados conectado");
                return con;
            } catch (SQLException ex) {
                System.out.println("Erro de conexao com o banco de dados");
                return null;
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro no driver");
                return null;
            }
        }
        
        //Desconecta o banco de dados
        
        public Connection DiscDB() { 
            try {
                con.close();
                //System.out.println("Banco de dados desconectado");
            } catch (SQLException ex) {
                System.out.println("Erro ao desconectar do banco de dados");
            }
            return con;
        }
}
