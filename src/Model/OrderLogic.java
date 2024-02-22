
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class OrderLogic extends ConnectionBD {
    
    // METODO AGREGAR
    
    public boolean add (Order ord){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "INSERT INTO orders (creationDate, observations, price, status, idClient, idTable) VALUES (?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, ord.getDate());
            ps.setString(2, ord.getObservations());
            ps.setFloat(3, ord.getPrice());
            ps.setByte(4, ord.getStatus());
            ps.setInt(5, ord.getIdClient());
            ps.setInt(6, ord.getIdTable());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
    // METODO MODIFICAR
    
    public boolean update (Order ord){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "UPDATE orders SET creationDate=?, observations=?, price=?, status=?, idClient=?, idTable=? WHERE id=?";
        
        try{        
            ps = con.prepareStatement(sql);
            ps.setString(1, ord.getDate());
            ps.setString(2, ord.getObservations());
            ps.setFloat(3, ord.getPrice());
            ps.setByte(4, ord.getStatus());
            ps.setInt(5, ord.getIdClient());
            ps.setInt(6, ord.getIdTable());
            ps.setInt(7, ord.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
    // METODO ELIMINAR
    
    public boolean delete (Order ord){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "DELETE FROM orders WHERE id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, ord.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
    // METODO BUSCAR
    
    public boolean searchs (Order ord){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        ResultSet rs = null;
        String sql = "SELECT * FROM orders WHERE id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, ord.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                ord.setId(Integer.parseInt(rs.getString("id")));
                ord.setDate(rs.getString("creationDate"));
                ord.setObservations(rs.getString("observations"));
                ord.setPrice(Float.parseFloat(rs.getString("price")));
                ord.setStatus(Byte.parseByte(rs.getString("status")));
                ord.setIdClient(Integer.parseInt(rs.getString("idCLient")));
                ord.setIdTable(Integer.parseInt(rs.getString("idTable")));
                return true;
            } 
            return false;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
}
