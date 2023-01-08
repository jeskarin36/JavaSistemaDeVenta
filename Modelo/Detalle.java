
package Modelo;


public class Detalle {
    
    private int id;
    private  String cod_pro;
    private int cantida;
    private double precio;
    private int id_Venta;

    public Detalle() {
    }

    public Detalle(int id, String cod_pro, int cantida, double precio, int id_Venta) {
        this.id = id;
        this.cod_pro = cod_pro;
        this.cantida = cantida;
        this.precio = precio;
        this.id_Venta = id_Venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod_pro() {
        return cod_pro;
    }

    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }

    public int getCantida() {
        return cantida;
    }

    public void setCantida(int cantida) {
        this.cantida = cantida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(int id_Venta) {
        this.id_Venta = id_Venta;
    }
    
    
}
