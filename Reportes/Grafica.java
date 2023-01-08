/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author morochas
 */
public class Grafica {
   
    
    public static void Graficar(String fecha){
        Connection con;
        Conexion cn= new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        try {
            String sql="Select total from ventas where fecha=?";
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,fecha);
            rs=ps.executeQuery();
            
            DefaultPieDataset dateset=new DefaultPieDataset();
            while(rs.next()){
                dateset.setValue(rs.getString("total"),rs.getDouble("total"));
   
                System.out.println(rs.getString("total"));
            }
            
            JFreeChart jf=ChartFactory.createPieChart("Reporte de venta", dateset);
            ChartFrame f= new ChartFrame("Total de ventas",jf);
            f.setSize(1000,500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
