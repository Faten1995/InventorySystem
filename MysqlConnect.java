
package finalproject;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author faten
 */
public class MysqlConnect {
    Connection conn=null;
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/storedatabase?autoReconnect=true&useSSL=false", "root", "Faten1995");
            
            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
