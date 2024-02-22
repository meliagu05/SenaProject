
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class CustomerLogic extends ConnectionBD {
    
    // METODO AGREGAR
    
    public boolean add (Customer c){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "INSERT INTO customers (names, surnames, identificationDocument, phone, birthdate, email) VALUES (?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getSurname());
            ps.setString(3, c.getIdentificationDocument());
            ps.setString(4, c.getPhone());
            ps.setString(5, c.getBirthdate());
            ps.setString(6, c.getEmail());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
    // METODO MODIFICAR
    
    public boolean update (Customer c){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "UPDATE customers SET names=?, surnames=?, identificationDocument=?, phone=?, birthdate=?, email=? WHERE id=?";
        
        try{        
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getSurname());
            ps.setString(3, c.getIdentificationDocument());
            ps.setString(4, c.getPhone());
            ps.setString(5, c.getBirthdate());
            ps.setString(6, c.getEmail());
            ps.setInt(7, c.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
    // METODO ELIMINAR
    
    public boolean delete (Customer c){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "DELETE FROM customers WHERE id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
    // METODO BUSCAR
    
    public boolean searchs (Customer c){
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        ResultSet rs = null;
        String sql = "SELECT * FROM customers WHERE id=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                c.setId(Integer.parseInt(rs.getString("id")));
                c.setName(rs.getString("names"));
                c.setSurname(rs.getString("surnames"));
                c.setIdentificationDocument(rs.getString("identificationDocument"));
                c.setPhone(rs.getString("phone"));
                c.setBirthdate(rs.getString("birthdate"));
                c.setEmail(rs.getString("email"));
                return true;
            } 
            return false;
            
        } catch (SQLException e){
            System.err.println(e);
            return false;
        }
    } 
    
}
