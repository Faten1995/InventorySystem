
package finalproject;

/**
 *
 * @author faten
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;

public class DBClass {
    
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Statement st=null;
    //String ImgPath=null;
    //INSERT INTO DB
    /*ublic Boolean add(String name) {
        //SQL STMT
        String sql = "INSERT INTO playerstb(Name) VALUES('" + name + "')";
        try {
            //CONNECTION"
             conn = MysqlConnect.ConnectDB();
            //STATEMENT
            st = conn.prepareStatement(sql);
            //EXECUTE
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
             return false;
        }
    }*/
    //RETRIEVE DATA
    public DefaultComboBoxModel retrieve()
    {
        //combo box model
        DefaultComboBoxModel dm=new DefaultComboBoxModel();
        //SQL
        String sql="SELECT itemName FROM inventory";
        try
        {
            //CONNECTION"
             conn = MysqlConnect.ConnectDB();
            //STATEMENT
            st = conn.prepareStatement(sql);
            rs= st.executeQuery(sql);
            //LOOP THRU GETTING ALL VALUES
            while(rs.next())
            {
                //GET VALUES
                String name=rs.getString(1);
                dm.addElement(name);
            }
            return dm;
        }catch (SQLException ex) {
            ex.printStackTrace();
             return null;
        }
    }
    
    //UPDATE DATA
    /*public Boolean update(String id,String value)
    {
        String sql="UPDATE playerstb SET Name ='" + value + "' WHERE Name='" + id + "'";
        try
        {
            //GET COONECTION
            Connection con=DriverManager.getConnection(conString, username, password);
            //STATEMENT
            Statement s=con.prepareStatement(sql);
            //EXECUTE
            s.execute(sql);
            return true;
        }catch (SQLException ex) {
            ex.printStackTrace();
             return false;
        }
    }
    //DELETE
    /*public Boolean delete(String id)
    {
        String sql="DELETE FROM playerstb WHERE Name ='"+id+"'";
        try
        {
            //GET COONECTION
            Connection con=DriverManager.getConnection(conString, username, password);
             //STATEMENT
            Statement s=con.prepareStatement(sql);
            //EXECUTE
            s.execute(sql);
            return true;
        }catch (SQLException ex) {
            ex.printStackTrace();
             return false;
        }
    }*/
}
