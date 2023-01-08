/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author morochas
 */
public class Venta {
    
   private int id;
   private String Cliente;
   private String Vendedor;
   private double total;
   private String fecha;

    public Venta() {
    }

    public Venta(int id, String Cliente, String Vendedor, double total,String fecha) {
        this.id = id;
        this.Cliente = Cliente;
        this.Vendedor = Vendedor;
        this.total = total;
        this.fecha=fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   
   
}
