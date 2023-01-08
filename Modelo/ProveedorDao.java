package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ProveedorDao {
    
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
     public boolean RegistrarProveedor(Proveedor pr){
        String sql="INSERT INTO proveedor (ruc,nombre,telefono,direccion,razon) VALUES(?,?,?,?,?)";
        
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, pr.getRuc());
            ps.setString(2, pr.getNombre());
            ps.setInt(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getRazon());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
     
     
     public List listarProveedor(){
        List<Proveedor> ListaPr=new ArrayList();
       
        String sql = "SELECT * FROM proveedor";
        
        try {
            
            con= cn.getConnection();
            ps= con.prepareCall(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Proveedor pr=new Proveedor();
                pr.setId(rs.getInt("id"));
                pr.setRuc(rs.getInt("ruc"));
                pr.setNombre(rs.getString("nombre"));
                pr.setTelefono(rs.getInt("telefono"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setRazon(rs.getString("razon"));
                
               ListaPr.add(pr);
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaPr;
    }

     
     public boolean EliminarProveedor(int id){
         String sql= "DELETE FROM proveedor WHERE id=?";
         
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            
            return true;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
            
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
         
     }
     
     
      public boolean ModificarProveedor(Proveedor pr){
        
        String sql="UPDATE proveedor set ruc=?, nombre=?, telefono=?,direccion=?, razon=? where id=?" ;
        
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1, pr.getRuc());
            ps.setString(2, pr.getNombre());
            ps.setInt(3 ,pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getRazon());
            ps.setInt(6, pr.getId());
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        
    
}

}



