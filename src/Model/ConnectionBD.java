package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnectionBD {
    
    private String bd = "bd_virtualwaiter";
    private String user = "root";
    private String pwd = "";
    private String url = "jdbc:mysql://localhost:3306/" + bd;
    private Connection con = null;
       
    public Connection getConnection(){
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.pwd);
            JOptionPane.showMessageDialog(null, "Conectado"); 
            
        } catch(SQLException e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Conectado");
            
        } catch (ClassNotFoundException ex){
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
}


