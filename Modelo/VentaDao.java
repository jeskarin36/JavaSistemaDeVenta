/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author morochas
 */
public class VentaDao {
    
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int idVentas(){
        int id=0;
        String sql="SELECT MAX(id) FROM ventas";
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
           if(rs.next()){
               id=rs.getInt(1);
           }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
           
        }
        
        return id;
    }
    
    
    
    
     public int RegistrarVenta(Venta v){
        String sql="INSERT INTO ventas (cliente,Vendedor,total,fecha) VALUES(?,?,?,?)";
        
        try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setString(2, v.getVendedor());
            ps.setDouble(3, v.getTotal());
            ps.setString(4, v.getFecha());
            ps.execute();
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
           
        }
        return r;
    }
     
     
     public int RegistrarDetalle(Detalle d){
         String sql="INSERT INTO detalle (cod_pro,cantidad,precio,id_Venta) VALUES(?,?,?,?)";
         
         try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, d.getCod_pro());
            ps.setInt(2, d.getCantida());
            ps.setDouble(3, d.getPrecio());
            ps.setInt(4, d.getId_Venta());
            ps.execute();
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
           
        }
         return r;
     }
     
     public boolean ActualizarStock(int cant,String cod){
         String sql="Update productos Set stock=? where codigo=?";
         try {
            con = cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
           return false;
        }
     }

    public List listarVentas(){
                List<Venta> ListaVenta=new ArrayList();

                String sql = "SELECT * FROM ventas";

                try {

                    con= cn.getConnection();
                    ps= con.prepareCall(sql);
                    rs=ps.executeQuery();
                    while(rs.next()){
                        Venta v=new Venta();
                        v.setId(rs.getInt("id"));
                        v.setCliente(rs.getString("cliente"));
                        v.setVendedor(rs.getString("vendedor"));
                        v.setTotal(rs.getInt("total"));
                       

                       ListaVenta.add(v);
                    }


                } catch (SQLException e) {
                    System.out.println(e.toString()+"gggg");
                }
            return ListaVenta;
        }



}
