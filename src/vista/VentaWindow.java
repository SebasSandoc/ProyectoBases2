
package vista;


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class VentaWindow extends javax.swing.JFrame {

    /**
     * Creates new form a
     */
    public VentaWindow() {
        initComponents();
        connectToDatabase();
        loadComboBoxData();
        
        // Aquí se agregan los manejadores de eventos para los botones
        setupEventListeners();
    }

    private Connection connection;

    private void connectToDatabase() {
        try {
            // Asume que tienes una base de datos llamada 'concesionario'
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", ""); // Ajusta según tu configuración
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de conexión con la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Cargar los ComboBox con datos de la base de datos
    private void loadComboBoxData() {
        try {
            Statement stmt = connection.createStatement();

            // Llenar ComboBox de Auto
            ResultSet rsAutos = stmt.executeQuery("SELECT auto_id FROM autos");
            while (rsAutos.next()) {
                comboAuto.addItem(rsAutos.getString("auto_id"));
            }

            // Llenar ComboBox de Cliente
            ResultSet rsClientes = stmt.executeQuery("SELECT cliente_id FROM clientes");
            while (rsClientes.next()) {
                comboCliente.addItem(rsClientes.getString("cliente_id"));
            }

            // Llenar ComboBox de Tipo de Pago
            comboPagoTipo.addItem("Efectivo");
            comboPagoTipo.addItem("Tarjeta");
            comboPagoTipo.addItem("Transferencia");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Guardar la venta
    private void guardarVenta() {
        try {
            String autoID = comboAuto.getSelectedItem().toString();
            String clienteID = comboCliente.getSelectedItem().toString();
            String tipoPago = comboPagoTipo.getSelectedItem().toString();
            String precioFinal = txtPrecioFinal.getText();
            String fechaVenta = txtFechaVenta.getText();

            // Validar que todos los campos tengan datos
            if (autoID.isEmpty() || clienteID.isEmpty() || tipoPago.isEmpty() || precioFinal.isEmpty() || fechaVenta.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convertir la fecha de venta (asumiendo formato dd/MM/yyyy)
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fecha = sdf.parse(fechaVenta);
            java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());

            // Insertar la venta en la base de datos
            String sql = "INSERT INTO ventas (auto_id, cliente_id, pago_tipo, precio_final, fecha_venta) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, autoID);
            stmt.setString(2, clienteID);
            stmt.setString(3, tipoPago);
            stmt.setString(4, precioFinal);
            stmt.setDate(5, sqlFecha);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Venta registrada exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar la venta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | java.text.ParseException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Limpiar los campos de la ventana
    private void cancelarVenta() {
        comboAuto.setSelectedIndex(0);
        comboCliente.setSelectedIndex(0);
        comboPagoTipo.setSelectedIndex(0);
        txtPrecioFinal.setText("");
        txtFechaVenta.setText("");
    }

    // Configuración de eventos para los botones
    private void setupEventListeners() {
        // Manejador de evento para el botón "Guardar"
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarVenta();
            }
        });

        // Manejador de evento para el botón "Cancelar"
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarVenta();
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboAuto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox<>();
        comboPagoTipo = new javax.swing.JComboBox<>();
        txtPrecioFinal = new javax.swing.JTextField();
        txtFechaVenta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 36)); // NOI18N
        jLabel1.setText("Venta");

        jLabel3.setText("Auto ID:");

        jLabel4.setText("Cliente ID:");

        jLabel5.setText("Tipo de pago:");

        comboAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Precio final:");

        jLabel7.setText("Fecha Venta (dd/MM/yyyy):");

        comboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboPagoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtPrecioFinal.setText("jTextField1");

        txtFechaVenta.setText("jTextField2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(btnGuardar))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboAuto, 0, 92, Short.MAX_VALUE)
                                .addComponent(comboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboPagoTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtFechaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(txtPrecioFinal)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboPagoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentaWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboAuto;
    private javax.swing.JComboBox<String> comboCliente;
    private javax.swing.JComboBox<String> comboPagoTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtPrecioFinal;
    // End of variables declaration//GEN-END:variables
}
