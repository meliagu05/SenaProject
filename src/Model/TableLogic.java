
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TableLogic extends ConnectionBD {
    
    // METODO AGREGAR
    
    public boolean add (Table table){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "INSERT INTO eaterytable (number, capacity, status) VALUES (?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, table.getNumber());
            ps.setString(2, table.getCapacity());
            ps.setByte(3, table.getStatus());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
    // METODO MODIFICAR
    
    public boolean update (Table table){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "UPDATE eaterytable SET number=?, capacity=?, status=? WHERE id=?";
        
        try{        
            ps = con.prepareStatement(sql);
            ps.setInt(1, table.getNumber());
            ps.setString(2, table.getCapacity());
            ps.setByte(3, table.getStatus());
            ps.setInt(4, table.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
    // METODO ELIMINAR
    
    public boolean delete (Table table){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "DELETE FROM eaterytable WHERE id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, table.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
    // METODO BUSCAR
    
    public boolean searchs (Table table){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        ResultSet rs = null;
        String sql = "SELECT * FROM eaterytable WHERE id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, table.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                table.setId(Integer.parseInt(rs.getString("id")));
                table.setNumber(Integer.parseInt(rs.getString("number")));
                table.setCapacity(rs.getString("capacity"));
                table.setStatus(Byte.parseByte(rs.getString("status")));
                return true;
            } 
            return false;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
}
