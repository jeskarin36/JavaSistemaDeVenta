package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class ProductoDao {
    
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProducto(Producto pr){
        String sql="INSERT INTO productos (codigo,nombre,proveedor,stock,precio) VALUES(?,?,?,?,?)";
        
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getCodigo());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getProveedor());
            ps.setInt(4, pr.getStock());
            ps.setDouble(5, pr.getPrecio());
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

    
    public void ConsultarProveedores(JComboBox proveedor){
        String sql="SELECT nombre From proveedor";
        
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
      
            while(rs.next()){
                proveedor.addItem(rs.getString("Nombre"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        
    }

    public List listarProductos(){
        List<Producto> ListaPr=new ArrayList();
       
        String sql = "SELECT * FROM productos";
        
        try {
            
            con= cn.getConnection();
            ps= con.prepareCall(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pr=new Producto();
                pr.setId(rs.getInt("id"));
                pr.setCodigo(rs.getString("codigo"));
                pr.setNombre(rs.getString("nombre"));
                pr.setPrecio(rs.getInt("precio"));
                pr.setProveedor(rs.getString("proveedor"));
                pr.setStock(rs.getInt("stock"));
                
               ListaPr.add(pr);
            }
            
            
        } catch (SQLException e) {
            System.out.println(e.toString()+"gggg");
        }
        return ListaPr;
    }

    
    public boolean EliminarProducto(int id){
        String sql="DELETE FROM productos WHERE id=?";
        
        try {
           ps= con.prepareStatement(sql);
           ps.setInt(1, id);
           ps.execute();
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

    public boolean ModificarProducto(Producto pd){
        
        String sql="UPDATE productos set codigo=?,nombre=?, proveedor=?,stock=?, precio=? where id=?" ;
        
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, pd.getCodigo());
            ps.setString(2, pd.getNombre());
            ps.setString(3 ,pd.getProveedor());
            ps.setInt(4, pd.getStock());
            ps.setDouble(5, pd.getPrecio());
            ps.setInt(6, pd.getId());
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

    public Producto BuscarProductos(String cod){
        
        Producto Producto=new Producto();
        String sql= "SELECT * FROM productos WHERE codigo=?";
         try {
           con= cn.getConnection();
           ps= con.prepareStatement(sql);
           ps.setString(1, cod);
           rs= ps.executeQuery();
           if(rs.next()){
               Producto.setNombre(rs.getString("nombre"));
               Producto.setPrecio(rs.getDouble("precio"));
               Producto.setStock(rs.getInt("stock"));
           }
           
        } catch (SQLException e) {
            System.out.println(e.toString());
            
        }
         return Producto;
    }

    
    
      public boolean ModificarDatos(Config config){
        
        String sql="UPDATE config set ruc=?,nombre=?, telefono=?,direccion=?, razon=? where id=?" ;
        
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1, config.getRuc());
            ps.setString(2, config.getNombre());
            ps.setInt(3 ,config.getTelefono());
            ps.setString(4, config.getDireccion());
            ps.setString(5, config.getRazon());
            ps.setInt(6 ,config.getId());
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
