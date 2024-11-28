
package vista;


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class VentaEdit extends javax.swing.JFrame {

    private Connection connection;
    
    
    public VentaEdit() {
        initComponents();  
        connectToDatabase();  
        setupEventListeners();  
        loadComboBoxData();    
    }

    // Conectar con la base de datos
    private void connectToDatabase() {
        try {
            // Conexión a la base de datos
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

    // Buscar venta por ID
    private void buscarVenta() {
        try {
            String ventaID = txtVentaID.getText();
            if (ventaID.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese el ID de la venta", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "SELECT * FROM ventas WHERE venta_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ventaID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                comboAuto.setSelectedItem(rs.getString("auto_id"));
                comboCliente.setSelectedItem(rs.getString("cliente_id"));
                comboPagoTipo.setSelectedItem(rs.getString("pago_tipo"));
                txtPrecioFinal.setText(rs.getString("precio_final"));
                txtFechaVenta.setText(formatDate(rs.getDate("fecha_venta"))); // Usamos formatDate para convertir la fecha
            } else {
                JOptionPane.showMessageDialog(this, "Venta no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Guardar los cambios de la venta editada
    private void guardarVenta() {
        try {
            String ventaID = txtVentaID.getText();
            String autoID = comboAuto.getSelectedItem().toString();
            String clienteID = comboCliente.getSelectedItem().toString();
            String tipoPago = comboPagoTipo.getSelectedItem().toString();
            String precioFinal = txtPrecioFinal.getText();
            String fechaVenta = txtFechaVenta.getText();

            if (ventaID.isEmpty() || autoID.isEmpty() || clienteID.isEmpty() || tipoPago.isEmpty() || precioFinal.isEmpty() || fechaVenta.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convertir la fecha de texto a formato Date
            java.util.Date parsedDate = parseDate(fechaVenta);
            if (parsedDate == null) {
                JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Use dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Actualizar la venta en la base de datos
            String sql = "UPDATE ventas SET auto_id = ?, cliente_id = ?, pago_tipo = ?, precio_final = ?, fecha_venta = ? WHERE venta_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, autoID);
            stmt.setString(2, clienteID);
            stmt.setString(3, tipoPago);
            stmt.setString(4, precioFinal);
            stmt.setDate(5, new java.sql.Date(parsedDate.getTime()));  // Convertir a java.sql.Date
            stmt.setString(6, ventaID);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Venta actualizada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar la venta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para convertir el String de fecha a formato java.util.Date
    private java.util.Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    // Método para formatear java.util.Date a String con formato dd/MM/yyyy
    private String formatDate(java.sql.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    // Configurar los eventos de los botones
    private void setupEventListeners() {
        // Buscar venta por ID
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarVenta();
            }
        });

        // Guardar los cambios de la venta
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarVenta();
            }
        });

        // Cancelar la edición
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  // Cerrar la ventana
            }
        });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboAuto = new javax.swing.JComboBox<>();
        comboCliente = new javax.swing.JComboBox<>();
        comboPagoTipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrecioFinal = new javax.swing.JTextField();
        txtFechaVenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtVentaID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Editar Venta");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");

        jLabel3.setText("Auto ID:");

        jLabel4.setText("Cliente ID:");

        jLabel5.setText("Tipo de pago:");

        comboAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboPagoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Precio final:");

        jLabel7.setText("Fecha Venta (dd/MM/yyyy):");

        txtPrecioFinal.setText("jTextField2");

        txtFechaVenta.setText("jTextField3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboAuto, 0, 104, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPrecioFinal, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtFechaVenta, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(comboPagoTipo, 0, 104, Short.MAX_VALUE)
                                .addComponent(comboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(14, 14, 14)))
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboPagoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(32, 32, 32))
        );

        jLabel2.setText("Ingresar ID:");

        txtVentaID.setText("jTextField1");

        jButton1.setText("jButton1");

        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(70, 70, 70))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtVentaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(87, 87, 87)
                                    .addComponent(btnBuscar)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtVentaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VentaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentaEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboAuto;
    private javax.swing.JComboBox<String> comboCliente;
    private javax.swing.JComboBox<String> comboPagoTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtPrecioFinal;
    private javax.swing.JTextField txtVentaID;
    // End of variables declaration//GEN-END:variables
}
