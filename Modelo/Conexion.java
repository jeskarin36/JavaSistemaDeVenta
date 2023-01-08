package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    Connection con;
    
    public Connection getConnection(){
        
        String myBD="jdbc:mysql://localhost:3306/sistemaventa?serverTimezone=UTC";
        try {
            con = DriverManager.getConnection(myBD,"root","");
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return null;
    }
    
}
