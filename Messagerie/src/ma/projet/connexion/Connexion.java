
package ma.projet.connexion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion {
    private static Connection connection;
    static {
        try {
            FileInputStream f = new FileInputStream ("config.properties");
            Properties p = new Properties();
            p.load(f);
            String url = p.getProperty("jdbc.url");
            String login=p.getProperty("jdbc.username");
            String password = p.getProperty("jdbc.password");
            String driver = p.getProperty("jdbc.driver");
            Class.forName(driver);
            connection=DriverManager.getConnection(url,login,password);
   
        } catch (IOException ex) {
           System.out.println(""+getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getConnection(){
        return connection;
    }

    private static String getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
