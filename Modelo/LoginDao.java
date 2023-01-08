package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn=new Conexion();
    
    
    public login LOHIN (String correo,String pass){
        login l=new login();
        String sql="SELECT * FROM usuario WHERE correo=? and pass=?";
        try {
            con = cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            if(rs.next()){
                l.setId(rs.getInt("id"));
                l.setCorreo(rs.getString("correo"));
                l.setNombre(rs.getString("nombre"));
                l.setPass(rs.getString("pass"));
                l.setRol(rs.getString("rol"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return l;
    }
    
    public boolean Registrar(login reg){
        String sql="Insert into usuario (nombre,correo,pass,rol) values(?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getCorreo());
            ps.setString(3, reg.getPass());
            ps.setString(4, reg.getRol());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            
            System.out.println(e.toString());
            return false;
        }
    }
    
    
}
