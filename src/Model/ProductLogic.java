
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ProductLogic extends ConnectionBD {
    
    // METODO AGREGAR
    
    public boolean add (Product p){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "INSERT INTO products (name, Description, price) VALUES (?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setFloat(3, p.getPrice());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
    // METODO MODIFICAR
    
    public boolean update (Product p){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "UPDATE products SET name=?, Description=?, price=? WHERE id=?";
        
        try{        
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setFloat(3, p.getPrice());
            ps.setInt(4, p.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
    // METODO ELIMINAR
    
    public boolean delete (Product p){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "DELETE FROM products WHERE id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
    // METODO BUSCAR
    
    public boolean searchs (Product p){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        ResultSet rs = null;
        String sql = "SELECT * FROM products WHERE id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                p.setId(Integer.parseInt(rs.getString("id")));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(Float.parseFloat(rs.getString("price")));
                return true;
            } 
            return false;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
}
