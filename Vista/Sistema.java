/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;



import Modelo.Cliente;
import Modelo.ClienteDao;
import Modelo.Config;
import Modelo.Detalle;
import Modelo.Eventos;
import Modelo.Producto;
import Modelo.ProductoDao;
import Modelo.Proveedor;
import Modelo.ProveedorDao;
import Modelo.Venta;
import Modelo.VentaDao;
import Modelo.login;
import Reportes.Excel;
import Reportes.Grafica;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author morochas
 */
public class Sistema extends javax.swing.JFrame {

    
    Date fechaVenta=new Date();
    String fechaActual= new SimpleDateFormat("dd/MM/yyyy").format(fechaVenta);
    
    Cliente cl=new Cliente();
    ClienteDao cliDato=new ClienteDao();
    DefaultTableModel modelo=new DefaultTableModel();
    DefaultTableModel tmp=new DefaultTableModel();
    
    
    Proveedor pr=new Proveedor();
    ProveedorDao prDao=new ProveedorDao();
    
    Producto pd=new Producto();
    ProductoDao pdDao=new ProductoDao();
    
    Venta v=new Venta();
    VentaDao vDao=new VentaDao();
    
    Detalle d=new Detalle();
    
    Eventos event=new Eventos();
    
    Config config=new Config();
    
    int item;
    double Totalpagar=0.00;
    /**
     * Creates new form Sistema
     */
    public Sistema() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public Sistema(login priv){
        initComponents();
        
        this.setLocationRelativeTo(null);
        AutoCompleteDecorator.decorate(cbxProvedorProducto);
        pdDao.ConsultarProveedores(cbxProvedorProducto);
        if(priv.getRol().equals("Asistente")){
            btnproduc.setEnabled(false);
            btnprovee.setEnabled(false);
            LabelVendedor.setText(priv.getNombre());
        }else{
            LabelVendedor.setText(priv.getNombre());
        }
    }

    
    public void ListarCliente(){
        List<Cliente> Listaclie= cliDato.listarCliente();
        
        modelo=(DefaultTableModel) TablaCliente.getModel();
        Object[] ob=new Object[6];
        for(int i=0; i<Listaclie.size();i++){
            ob[0]=Listaclie.get(i).getId();
            ob[1]=Listaclie.get(i).getIdn();
            ob[2]=Listaclie.get(i).getNombre();
            ob[3]=Listaclie.get(i).getTelefono();
            ob[4]=Listaclie.get(i).getDireccion();
            ob[5]=Listaclie.get(i).getRazon();
            modelo.addRow(ob);
        }
        
        TablaCliente.setModel(modelo);
    }
    
    
    
    public void ListarProveedor(){
        List<Proveedor> ListaPr= prDao.listarProveedor();
        
        modelo=(DefaultTableModel) TablaProveedor.getModel();
        Object[] ob=new Object[6];
        for(int i=0; i<ListaPr.size();i++){
            ob[0]=ListaPr.get(i).getId();
            ob[1]=ListaPr.get(i).getRuc();
            ob[2]=ListaPr.get(i).getNombre();
            ob[3]=ListaPr.get(i).getTelefono();
            ob[4]=ListaPr.get(i).getDireccion();
            ob[5]=ListaPr.get(i).getRazon();
            modelo.addRow(ob);
        }
        
        TablaProveedor.setModel(modelo);
    }
    
    public void ListarProducto(){
        List<Producto> ListaPd= pdDao.listarProductos();
        
        modelo=(DefaultTableModel) TablaProducto.getModel();
        Object[] ob=new Object[6];
        for(int i=0; i<ListaPd.size();i++){
            ob[0]=ListaPd.get(i).getId();
            ob[1]=ListaPd.get(i).getCodigo();
            ob[2]=ListaPd.get(i).getNombre();
            ob[3]=ListaPd.get(i).getProveedor();
            ob[4]=ListaPd.get(i).getStock();
            ob[5]=ListaPd.get(i).getPrecio();
            modelo.addRow(ob);
        }
        
        TablaProducto.setModel(modelo);
    }
    
    
     public void ListarVentas(){
        List<Venta> ListaVenta= vDao.listarVentas();
        
        modelo=(DefaultTableModel) TablasVentas.getModel();
        Object[] ob=new Object[6];
        for(int i=0; i<ListaVenta.size();i++){
            ob[0]=ListaVenta.get(i).getId();
            ob[1]=ListaVenta.get(i).getCliente();
            ob[2]=ListaVenta.get(i).getVendedor();
            ob[3]=ListaVenta.get(i).getTotal();
            modelo.addRow(ob);
        }
        
        TablasVentas.setModel(modelo);
    }
    
    
    
    
    
    
    public void LimpiarTabla(){
        
        for(int i=0; i<modelo.getRowCount();i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnprovee = new javax.swing.JButton();
        btnproduc = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        LabelVendedor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVenta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnEliminarVenta = new javax.swing.JLabel();
        txtCodigoVenta = new javax.swing.JTextField();
        txtDescripcionVenta = new javax.swing.JTextField();
        txtCantidadVenta = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtStockVenta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtRucVenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNombreVenta = new javax.swing.JTextField();
        btnGenerarVenta = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        txtIdVenta = new javax.swing.JTextField();
        btnGrafica = new javax.swing.JButton();
        Midate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtRucCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        txtRazonSociCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaCliente = new javax.swing.JTable();
        btnGuardarCliente = new javax.swing.JButton();
        btnActualizarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        txtIDCliente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtRucProveedor = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtNombreProveedor = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTelefonoProveedor = new javax.swing.JTextField();
        txtDireccionProveedor = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtRazonSocialProveedor = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaProveedor = new javax.swing.JTable();
        txtGuardarProveedor = new javax.swing.JButton();
        btnActualizarProveedor = new javax.swing.JButton();
        btnElimarProveedor = new javax.swing.JButton();
        btnNuevaProveedor = new javax.swing.JButton();
        txtIdProveerdor = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtDescripcionProducto = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        txtPrecioProducto = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaProducto = new javax.swing.JTable();
        cbxProvedorProducto = new javax.swing.JComboBox<>();
        btnGuadarProducto = new javax.swing.JButton();
        btnActualizarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnNuevaProducto = new javax.swing.JButton();
        btnExcelPro = new javax.swing.JButton();
        txtIDProducto = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablasVentas = new javax.swing.JTable();
        btnPdfVentas = new javax.swing.JButton();
        txtIdVentas = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtRucDatos = new javax.swing.JTextField();
        txtNombreDatos = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtTelefonoDatos = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtDireccionDatos = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtRazonDatos = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txtIdDatos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nventa.png"))); // NOI18N
        jButton1.setText("Nueva Venta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Clientes.png"))); // NOI18N
        jButton2.setText("Clientes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnprovee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/proveedor.png"))); // NOI18N
        btnprovee.setText("Proovedor");
        btnprovee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproveeActionPerformed(evt);
            }
        });

        btnproduc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        btnproduc.setText("Productos");
        btnproduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproducActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/compras.png"))); // NOI18N
        jButton5.setText("Ventas");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/config.png"))); // NOI18N
        jButton6.setText("Config");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        LabelVendedor.setText("Vida Informatica");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnprovee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnproduc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(LabelVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnprovee, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnproduc, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 690));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/encabezado.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 890, 170));

        TablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad", "Precio", "Precio Total"
            }
        ));
        jScrollPane1.setViewportView(TablaVenta);
        if (TablaVenta.getColumnModel().getColumnCount() > 0) {
            TablaVenta.getColumnModel().getColumn(0).setPreferredWidth(30);
            TablaVenta.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaVenta.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Codigo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Descripcion");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Cantidad");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Precio");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Stock Disponible");

        btnEliminarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarVentaMouseClicked(evt);
            }
        });

        txtCodigoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoVentaActionPerformed(evt);
            }
        });
        txtCodigoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoVentaKeyTyped(evt);
            }
        });

        txtDescripcionVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionVentaKeyTyped(evt);
            }
        });

        txtCantidadVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("DNI/RUC");

        txtRucVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucVentaKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("NOMBRE");

        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/print.png"))); // NOI18N
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/money.png"))); // NOI18N
        jLabel11.setText("Total a Pagar:");

        LabelTotal.setText("--------");

        btnGrafica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/torta.png"))); // NOI18N
        btnGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficaActionPerformed(evt);
            }
        });

        jLabel8.setText("Seleccionar: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtRucVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtNombreVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerarVenta)
                .addGap(64, 64, 64)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(LabelTotal)
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(txtStockVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnEliminarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(Midate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Midate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGrafica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtStockVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRucVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(LabelTotal))
                            .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("DNC/RUC:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Nombre:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Telefono:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Direccion:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Razon Social:");

        txtDireccionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionClienteActionPerformed(evt);
            }
        });

        TablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "DNI/RUc", "Nombre", "Telefono", "Direccion", "Razon Social"
            }
        ));
        TablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaCliente);
        if (TablaCliente.getColumnModel().getColumnCount() > 0) {
            TablaCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
            TablaCliente.getColumnModel().getColumn(1).setPreferredWidth(50);
            TablaCliente.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablaCliente.getColumnModel().getColumn(3).setPreferredWidth(50);
            TablaCliente.getColumnModel().getColumn(4).setPreferredWidth(90);
        }

        btnGuardarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        btnActualizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDireccionCliente)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRazonSociCliente)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnEliminarCliente)
                                    .addComponent(btnGuardarCliente))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnActualizarCliente)
                                    .addComponent(btnNuevoCliente)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtRucCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIDCliente)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtRucCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtRazonSociCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardarCliente)
                    .addComponent(btnActualizarCliente))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminarCliente)
                    .addComponent(btnNuevoCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("RUC:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Nombre:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Telefono:");

        txtDireccionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionProveedorActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Direccion:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Razon Social:");

        TablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RUC", "Nombre", "Telefono", "Direccion", "Razon Social"
            }
        ));
        TablaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaProveedor);
        if (TablaProveedor.getColumnModel().getColumnCount() > 0) {
            TablaProveedor.getColumnModel().getColumn(0).setPreferredWidth(50);
            TablaProveedor.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablaProveedor.getColumnModel().getColumn(3).setPreferredWidth(50);
            TablaProveedor.getColumnModel().getColumn(4).setPreferredWidth(60);
            TablaProveedor.getColumnModel().getColumn(5).setPreferredWidth(90);
        }

        txtGuardarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        txtGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuardarProveedorActionPerformed(evt);
            }
        });

        btnActualizarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProveedorActionPerformed(evt);
            }
        });

        btnElimarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnElimarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimarProveedorActionPerformed(evt);
            }
        });

        btnNuevaProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N
        btnNuevaProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRazonSocialProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtRucProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdProveerdor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnElimarProveedor)
                            .addComponent(txtGuardarProveedor))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevaProveedor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnActualizarProveedor, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtRucProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProveerdor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtRazonSocialProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarProveedor)
                            .addComponent(txtGuardarProveedor))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnElimarProveedor)
                            .addComponent(btnNuevaProveedor))
                        .addGap(12, 12, 12))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Codigo:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Descripcion: ");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Cantidad:");

        txtPrecioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProductoKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Precio:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Proveedor:");

        TablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Codigo", "Descripcion", "Proveedor", "Stock", "Precio"
            }
        ));
        TablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaProducto);
        if (TablaProducto.getColumnModel().getColumnCount() > 0) {
            TablaProducto.getColumnModel().getColumn(0).setPreferredWidth(50);
            TablaProducto.getColumnModel().getColumn(1).setPreferredWidth(50);
            TablaProducto.getColumnModel().getColumn(2).setPreferredWidth(100);
            TablaProducto.getColumnModel().getColumn(3).setPreferredWidth(70);
            TablaProducto.getColumnModel().getColumn(4).setPreferredWidth(50);
            TablaProducto.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        cbxProvedorProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvedorProductoActionPerformed(evt);
            }
        });

        btnGuadarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuadarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuadarProductoActionPerformed(evt);
            }
        });

        btnActualizarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnNuevaProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N

        btnExcelPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel.png"))); // NOI18N
        btnExcelPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuadarProducto)
                            .addComponent(jLabel26)
                            .addComponent(btnNuevaProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbxProvedorProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(33, 33, 33))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(btnActualizarProducto)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnEliminarProducto))
                                        .addComponent(btnExcelPro)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCantidadProducto)
                                    .addComponent(txtPrecioProducto)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescripcionProducto)))
                        .addGap(659, 659, 659))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(688, 688, 688))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(cbxProvedorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuadarProducto)
                            .addComponent(btnActualizarProducto)
                            .addComponent(btnEliminarProducto))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevaProducto)
                            .addComponent(btnExcelPro)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel5);

        TablasVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Vendedor", "Total"
            }
        ));
        TablasVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablasVentasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TablasVentas);
        if (TablasVentas.getColumnModel().getColumnCount() > 0) {
            TablasVentas.getColumnModel().getColumn(0).setPreferredWidth(50);
            TablasVentas.getColumnModel().getColumn(1).setPreferredWidth(50);
            TablasVentas.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablasVentas.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        btnPdfVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnPdfVentas)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPdfVentas)
                    .addComponent(txtIdVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel6);

        jLabel27.setText("RUC:");

        jLabel28.setText("NOMBRE:");

        jLabel29.setText("TELEFONO:");

        jLabel30.setText("DIRECCION:");

        jLabel31.setText("RAZON SOCIAL:");

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        jButton23.setText("ACTUALIZAR");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel32.setText("Datos de la Empresa");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jButton23))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(txtDireccionDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(txtRazonDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(txtRucDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel28)
                                            .addComponent(txtNombreDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(66, 66, 66)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29)
                                            .addComponent(txtTelefonoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel32))))))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel32)
                .addGap(47, 47, 47)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(jLabel29)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRucDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefonoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(txtDireccionDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(txtRazonDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jButton23)
                .addGap(78, 78, 78))
        );

        jTabbedPane1.addTab("tab6", jPanel7);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 890, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDireccionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionClienteActionPerformed

    private void txtDireccionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionProveedorActionPerformed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
       
        if(!"".equals(txtRucCliente.getText()) || !"".equals(txtNombreCliente.getText())  || !"".equals(txtTelefonoCliente.getText()) ||  !"".equals(txtDireccionCliente.getText())  ){
            cl.setIdn(Integer.parseInt(txtRucCliente.getText()));
            cl.setNombre(txtNombreCliente.getText());
            cl.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
            cl.setDireccion(txtDireccionCliente.getText());
            cl.setRazon(txtRazonSociCliente.getText());
            
            cliDato.RegistrarCliente(cl);
            LimpiarTabla();
            LimpiarCliente();
                ListarCliente();
            JOptionPane.showMessageDialog(null,"Cliente Registrado");
        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan Vacios");
        }
        
        
        
        
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      LimpiarTabla();
        ListarCliente();
      jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClienteMouseClicked
       
        
        int fila= TablaCliente.rowAtPoint(evt.getPoint());
        txtIDCliente.setText(TablaCliente.getValueAt(fila,0).toString());
        txtRucCliente.setText(TablaCliente.getValueAt(fila,1).toString());
        txtNombreCliente.setText(TablaCliente.getValueAt(fila,2).toString());
        txtTelefonoCliente.setText(TablaCliente.getValueAt(fila,3).toString());
        txtDireccionCliente.setText(TablaCliente.getValueAt(fila,4).toString());
        txtRazonSociCliente.setText(TablaCliente.getValueAt(fila,5).toString());
        
    }//GEN-LAST:event_TablaClienteMouseClicked

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
     
        if(!"".equals(txtIDCliente.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar esto?");
            
            if(pregunta==0){
                int id= Integer.parseInt(txtIDCliente.getText());
                cliDato.EliminarCliente(id);
                LimpiarTabla();
                LimpiarCliente();
                ListarCliente();
            }
        
        
        }
        
        
        
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        if("".equals(txtIDCliente.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            cl.setIdn(Integer.parseInt(txtRucCliente.getText()));
            cl.setNombre(txtNombreCliente.getText());
            cl.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
            cl.setDireccion(txtDireccionCliente.getText());
            cl.setRazon(txtRazonSociCliente.getText());
            cl.setId(Integer.parseInt(txtIDCliente.getText()));
            if(!"".equals(txtRucCliente.getText()) || !"".equals(txtNombreCliente.getText())  || !"".equals(txtTelefonoCliente.getText()) ||  !"".equals(txtDireccionCliente.getText())){
                cliDato.ModificarCliente(cl);
                LimpiarTabla();
                LimpiarCliente();
                ListarCliente();
            }
        }
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
       LimpiarCliente();
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void txtGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuardarProveedorActionPerformed
        if(!"".equals(txtRucProveedor.getText()) || !"".equals(txtNombreProveedor.getText())  || !"".equals(txtTelefonoProveedor.getText()) ||  !"".equals(txtDireccionProveedor.getText())  ){
            pr.setRuc(Integer.parseInt(txtRucProveedor.getText()));
            pr.setNombre(txtNombreProveedor.getText());
            pr.setTelefono(Integer.parseInt(txtTelefonoProveedor.getText()));
            pr.setDireccion(txtDireccionProveedor.getText());
            pr.setRazon(txtRazonSocialProveedor.getText());
            prDao.RegistrarProveedor(pr);
            LimpiarTabla();
            LimpiarProveedor();
            ListarProveedor();
        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_txtGuardarProveedorActionPerformed

    private void btnproveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproveeActionPerformed
        LimpiarTabla();
        ListarProveedor();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnproveeActionPerformed

    private void TablaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProveedorMouseClicked
       int fila = TablaProveedor.rowAtPoint(evt.getPoint());
       
       txtIdProveerdor.setText(TablaProveedor.getValueAt(fila, 0).toString());
       txtRucProveedor.setText(TablaProveedor.getValueAt(fila, 1).toString());
       txtNombreProveedor.setText(TablaProveedor.getValueAt(fila, 2).toString());
       txtTelefonoProveedor.setText(TablaProveedor.getValueAt(fila, 3).toString());
       txtDireccionProveedor.setText(TablaProveedor.getValueAt(fila, 4).toString());
       txtRazonSocialProveedor.setText(TablaProveedor.getValueAt(fila, 5).toString());
       
    }//GEN-LAST:event_TablaProveedorMouseClicked

    private void btnElimarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimarProveedorActionPerformed
      
        if(!"".equals(txtIdProveerdor.getText())){
            int confirmacion= JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar este registro?");
            
            if(confirmacion==0){
                int id=Integer.parseInt(txtIdProveerdor.getText());
                prDao.EliminarProveedor(id);
                LimpiarTabla();
                LimpiarProveedor();
                ListarProveedor();
              
            }
        }else{
                JOptionPane.showMessageDialog(null, "Seleccione una fila pór favor");
            }
        
        
    }//GEN-LAST:event_btnElimarProveedorActionPerformed

    private void btnActualizarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProveedorActionPerformed
          if("".equals(txtIdProveerdor.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            pr.setRuc(Integer.parseInt(txtRucProveedor.getText()));
            pr.setNombre(txtNombreProveedor.getText());
            pr.setTelefono(Integer.parseInt(txtTelefonoProveedor.getText()));
            pr.setDireccion(txtDireccionProveedor.getText());
            pr.setRazon(txtRazonSocialProveedor.getText());
            pr.setId(Integer.parseInt(txtIdProveerdor.getText()));
            if(!"".equals(txtRucProveedor.getText()) || !"".equals(txtNombreProveedor.getText())  || !"".equals(txtTelefonoProveedor.getText()) ||  !"".equals(txtDireccionProveedor.getText())){
                prDao.ModificarProveedor(pr);
                LimpiarTabla();
                LimpiarProveedor();
                ListarProveedor();
            }
        }
    }//GEN-LAST:event_btnActualizarProveedorActionPerformed

    private void btnNuevaProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaProveedorActionPerformed
        LimpiarProveedor();
    }//GEN-LAST:event_btnNuevaProveedorActionPerformed

    private void btnGuadarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuadarProductoActionPerformed
       if(!"".equals(txtCodigoProducto.getText()) || !"".equals(txtDescripcionProducto.getText())  ||   !"".equals(txtCantidadProducto.getText()) ||  !"".equals(txtPrecioProducto.getText()) ||  !"".equals(cbxProvedorProducto.getSelectedItem())  ){
            pd.setCodigo(txtCodigoProducto.getText());
            pd.setNombre(txtDescripcionProducto.getText());
            pd.setStock(Integer.parseInt(txtCantidadProducto.getText()));
            pd.setPrecio(Integer.parseInt(txtPrecioProducto.getText()));
            pd.setProveedor(cbxProvedorProducto.getSelectedItem().toString());
            pdDao.RegistrarProducto(pd);
            JOptionPane.showMessageDialog(null, "Producto Registrado");
            LimpiarTabla();
            LimpiarProducto();
            ListarProducto();
        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnGuadarProductoActionPerformed

    private void cbxProvedorProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvedorProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProvedorProductoActionPerformed

    private void btnproducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproducActionPerformed
        LimpiarTabla();
        ListarProducto();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnproducActionPerformed

    private void TablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductoMouseClicked
     
         int fila = TablaProducto.rowAtPoint(evt.getPoint());
       
       txtIDProducto.setText(TablaProducto.getValueAt(fila, 0).toString());
       txtCodigoProducto.setText(TablaProducto.getValueAt(fila, 1).toString());
       txtDescripcionProducto.setText(TablaProducto.getValueAt(fila, 2).toString());
       cbxProvedorProducto.setSelectedItem(TablaProducto.getValueAt(fila,3).toString());
       txtCantidadProducto.setText(TablaProducto.getValueAt(fila, 4).toString());
       txtPrecioProducto.setText(TablaProducto.getValueAt(fila, 5).toString());
      
       
        
        
    }//GEN-LAST:event_TablaProductoMouseClicked

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
       
         if(!"".equals(txtIDProducto.getText())){
            int confirmacion= JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar este registro?");
            
            if(confirmacion==0){
                int id=Integer.parseInt(txtIDProducto.getText());
                pdDao.EliminarProducto(id);
                LimpiarTabla();
                LimpiarProducto();
                ListarProducto();
              
            }
        }else{
                JOptionPane.showMessageDialog(null, "Seleccione una fila pór favor");
            }
        
        
        
        
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProductoActionPerformed
       if("".equals(txtIDProducto.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            pd.setCodigo(txtCodigoProducto.getText());
            pd.setNombre(txtDescripcionProducto.getText());
            pd.setProveedor(cbxProvedorProducto.getSelectedItem().toString());
            pd.setStock(Integer.parseInt(txtCantidadProducto.getText()));
            pd.setPrecio(Double.parseDouble(txtPrecioProducto.getText()));
            pd.setId(Integer.parseInt(txtIDProducto.getText()));
            if(!"".equals(txtCodigoProducto.getText()) || !"".equals(txtDescripcionProducto.getText())  || !"".equals(txtCantidadProducto.getText()) ||  !"".equals(txtPrecioProducto.getText())){
                pdDao.ModificarProducto(pd);
                LimpiarTabla();
                LimpiarProducto();
                ListarProducto();
            }
        }
    }//GEN-LAST:event_btnActualizarProductoActionPerformed

    private void btnExcelProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelProActionPerformed
      Excel.reporte();
    }//GEN-LAST:event_btnExcelProActionPerformed

    private void txtCodigoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVentaActionPerformed
       
    }//GEN-LAST:event_txtCodigoVentaActionPerformed

    private void txtCodigoVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVentaKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
           if(!"".equals(txtCodigoVenta.getText())){
               String cod= txtCodigoVenta.getText();
               pd=pdDao.BuscarProductos(cod);
               if(pd.getNombre()!=null){
                   txtDescripcionVenta.setText(""+pd.getNombre());
                   txtPrecioVenta.setText(""+pd.getPrecio());
                   txtStockVenta.setText(""+pd.getStock());
                   txtCantidadVenta.requestFocus();
               }else{
                    LimpiarVenta();
                   txtCodigoVenta.requestFocus();
               }
           }else{
               JOptionPane.showMessageDialog(null, "Ingrese el codigo del Producto");
              txtCodigoVenta.requestFocus();
           }
       }
    }//GEN-LAST:event_txtCodigoVentaKeyPressed

    private void txtCantidadVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
           if(!"".equals(txtCantidadVenta.getText())){
               String cod= txtCodigoVenta.getText();
               String descrip=txtDescripcionVenta.getText();
               int cant= Integer.parseInt(txtCantidadVenta.getText());
               double precio= Double.parseDouble(txtPrecioVenta.getText());
               double total= cant * precio;
               
               int stock = Integer.parseInt(txtCantidadVenta.getText());
               if(stock >= cant){
                   item= item + 1;
                   tmp = (DefaultTableModel) TablaVenta.getModel();
                   
                   for(int i=0;i<TablaVenta.getRowCount();i++){
                       if(TablaVenta.getValueAt(i, 1).equals(txtDescripcionVenta.getText())){
                           JOptionPane.showMessageDialog(null, "El producto ya esta registrado");
                           return;
                       }
                   }
                   
                   ArrayList lista=new ArrayList();
                   lista.add(item);
                   lista.add(cod);
                   lista.add(descrip);
                   lista.add(cant);
                   lista.add(precio);
                   lista.add(total);
                   
                   Object[] O=new Object[5];
                   O[0]=lista.get(1);
                   O[1]=lista.get(2);
                   O[2]=lista.get(3);
                   O[3]=lista.get(4);
                   O[4]=lista.get(5);
                   
                   tmp.addRow(O);
                   TablaVenta.setModel(tmp);
                   Totalapagar();
                   LimpiarVenta();
                   txtCodigoVenta.requestFocus();
               }else{
                   JOptionPane.showMessageDialog(null, "Stock no disponible");
               }
           }else{
                   JOptionPane.showMessageDialog(null, "Ingrese Cantidad");
               }
       }
        
        
    }//GEN-LAST:event_txtCantidadVentaKeyPressed

    private void btnEliminarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarVentaMouseClicked
      
        modelo= (DefaultTableModel) TablaVenta.getModel();
        modelo.removeRow(TablaVenta.getSelectedRow());
        Totalapagar();
        txtCodigoVenta.requestFocus();
        
        
    }//GEN-LAST:event_btnEliminarVentaMouseClicked

    private void txtRucVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucVentaKeyPressed
      if(evt.getKeyCode()== KeyEvent.VK_ENTER){
           if(!"".equals(txtRucVenta.getText())){
               int dni= Integer.parseInt(txtRucVenta.getText());
               cl=cliDato.BuscarCliente(dni);
               if(cl.getNombre()!=null){
                   txtNombreCliente.setText(""+cl.getNombre());
                   txtDireccionCliente.setText(""+cl.getDireccion());
                   txtTelefonoCliente.setText(""+cl.getTelefono());
                   txtRazonSociCliente.setText(""+cl.getRazon());
               }else{
                   txtRucCliente.setText("");
                   JOptionPane.showMessageDialog(null, "El cliente no existe");
               }
           }
       }
    }//GEN-LAST:event_txtRucVentaKeyPressed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
     
         if(TablaVenta.getRowCount()>0){
             if(!"".equals(txtNombreVenta.getText())){
                    RegistrarVenta();
                    RegristarDetalle();
                    ActualizarStock();
                    LimpiarTablaVenta();
                    txtRucVenta.setText("");
                    txtNombreVenta.setText("");
             }else{
                 JOptionPane.showMessageDialog(null, "Tiene que buscar un Cliente");
             }
         }else{
                 JOptionPane.showMessageDialog(null, "No hay productos en la venta");
             }
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void txtCodigoVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVentaKeyTyped
      event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCodigoVentaKeyTyped

    private void txtDescripcionVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionVentaKeyTyped
      event.textKeyPress(evt);
    }//GEN-LAST:event_txtDescripcionVentaKeyTyped

    private void txtCantidadVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCantidadVentaKeyTyped

    private void txtPrecioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProductoKeyTyped
      
    }//GEN-LAST:event_txtPrecioProductoKeyTyped

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
      
        if(!"".equals(txtRucDatos.getText()) || !"".equals(txtNombreDatos.getText())  || !"".equals(txtTelefonoDatos.getText()) ||  !"".equals(txtDireccionDatos.getText())){
            config.setRuc(Integer.parseInt(txtRucDatos.getText()));
            config.setNombre(txtNombreDatos.getText());
            config.setTelefono(Integer.parseInt(txtTelefonoDatos.getText()));
            config.setDireccion(txtDireccionDatos.getText());
            config.setRazon(txtRazonDatos.getText());
            config.setId(Integer.parseInt(txtIdDatos.getText()));
            pdDao.ModificarDatos(config);
               
               JOptionPane.showMessageDialog(null, "Datos de la Empresa Actualizados");
               
            }
        
        
        
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     jTabbedPane1.setSelectedIndex(4);
        LimpiarTabla();
     ListarVentas();
     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void TablasVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablasVentasMouseClicked
           
        int fila= TablasVentas.rowAtPoint(evt.getPoint());
        txtIdVentas.setText(TablasVentas.getValueAt(fila,0).toString());
       
    }//GEN-LAST:event_TablasVentasMouseClicked

    private void btnGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficaActionPerformed
     Grafica.Graficar(fechaActual);
        System.out.println(fechaActual);
    }//GEN-LAST:event_btnGraficaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel LabelVendedor;
    private com.toedter.calendar.JDateChooser Midate;
    private javax.swing.JTable TablaCliente;
    private javax.swing.JTable TablaProducto;
    private javax.swing.JTable TablaProveedor;
    private javax.swing.JTable TablaVenta;
    private javax.swing.JTable TablasVentas;
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnActualizarProducto;
    private javax.swing.JButton btnActualizarProveedor;
    private javax.swing.JButton btnElimarProveedor;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JLabel btnEliminarVenta;
    private javax.swing.JButton btnExcelPro;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnGrafica;
    private javax.swing.JButton btnGuadarProducto;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnNuevaProducto;
    private javax.swing.JButton btnNuevaProveedor;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnPdfVentas;
    private javax.swing.JButton btnproduc;
    private javax.swing.JButton btnprovee;
    private javax.swing.JComboBox<String> cbxProvedorProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtCodigoVenta;
    private javax.swing.JTextField txtDescripcionProducto;
    private javax.swing.JTextField txtDescripcionVenta;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDireccionDatos;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JButton txtGuardarProveedor;
    private javax.swing.JTextField txtIDCliente;
    private javax.swing.JTextField txtIDProducto;
    private javax.swing.JTextField txtIdDatos;
    private javax.swing.JTextField txtIdProveerdor;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtIdVentas;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreDatos;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtNombreVenta;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtRazonDatos;
    private javax.swing.JTextField txtRazonSociCliente;
    private javax.swing.JTextField txtRazonSocialProveedor;
    private javax.swing.JTextField txtRucCliente;
    private javax.swing.JTextField txtRucDatos;
    private javax.swing.JTextField txtRucProveedor;
    private javax.swing.JTextField txtRucVenta;
    private javax.swing.JTextField txtStockVenta;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoDatos;
    private javax.swing.JTextField txtTelefonoProveedor;
    // End of variables declaration//GEN-END:variables






  private void LimpiarCliente(){
      txtIDCliente.setText("");
      txtRucCliente.setText("");
      txtNombreCliente.setText("");
      txtTelefonoCliente.setText("");
      txtDireccionCliente.setText("");
      txtRazonSociCliente.setText("");
  }

  private void LimpiarProveedor(){
      txtIdProveerdor.setText("");
      txtRucProveedor.setText("");
      txtNombreProveedor.setText("");
      txtTelefonoProveedor.setText("");
      txtDireccionProveedor.setText("");
      txtRazonSocialProveedor.setText("");
  }


   private void LimpiarProducto(){
      txtIDProducto.setText("");
      txtCodigoProducto.setText("");
      txtDescripcionProducto.setText("");
      txtCantidadProducto.setText("");
      txtPrecioProducto.setText("");
      cbxProvedorProducto.setSelectedItem(null);
  }
   
   public void Totalapagar(){
       Totalpagar=0.00;
       int numeroPila= TablaVenta.getRowCount();
       
       for(int i=0;i<numeroPila;i++){
           double cal=Double.parseDouble(String.valueOf(TablaVenta.getModel().getValueAt(i, 4)));
           Totalpagar=Totalpagar+cal;
       }
       LabelTotal.setText( String.valueOf(Totalpagar));
   }
   
   
   private void LimpiarVenta(){
      txtCodigoVenta.setText("");
      txtDescripcionVenta.setText("");
      txtCantidadVenta.setText("");
      txtStockVenta.setText("");
      txtPrecioVenta.setText("");
      txtIdVenta.setText("");
    
  }
   
   public void RegistrarVenta(){
       String Cliente= txtNombreVenta.getText();
       String Vendedor= LabelVendedor.getText();
       double monto= Totalpagar;
       
       v.setCliente(Cliente);
       v.setVendedor(Vendedor);
       v.setTotal(monto);
       v.setFecha(fechaActual);
       vDao.RegistrarVenta(v);
   }
   
   private void RegristarDetalle(){
       
       int id=vDao.idVentas();
       for(int i=0; i< TablaVenta.getRowCount();i++){
           String cod=TablaVenta.getValueAt(i, 0).toString();
           int cant=Integer.parseInt(TablaVenta.getValueAt(i, 2).toString());
           double  precio=Double.parseDouble(TablaVenta.getValueAt(i, 3).toString());
           

           d.setCod_pro(cod);
           d.setCantida(cant);
           d.setPrecio(precio);
           d.setId_Venta(id);
           vDao.RegistrarDetalle(d);
       }
   }
   
   
   private void ActualizarStock(){
       for(int i=0; i< TablaVenta.getRowCount();i++){
           String cod=TablaVenta.getValueAt(i, 0).toString();
           int cant=Integer.parseInt(TablaVenta.getValueAt(i, 2).toString());
          
           pd=pdDao.BuscarProductos(cod);

           int StockActual= pd.getStock() - cant;
           vDao.ActualizarStock(StockActual, cod);
       }
   }
   
   private void LimpiarTablaVenta(){
       tmp= (DefaultTableModel) TablaVenta.getModel();
       int fila= TablaVenta.getRowCount();
       for(int i=0; i<fila;i++){
           tmp.removeRow(i);
            
        }
   }
}



