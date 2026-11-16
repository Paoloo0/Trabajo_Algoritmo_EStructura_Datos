package Visual;

import Estructuras.Carrito;
import Estructuras.ColaImpresion;
import Modelo.ComprobantePago;
import Modelo.ItemVentaCarrito;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 * Formulario visual (JFrame) para la atencion y emision de comprobantes de pago.
 * La logica de negocio y datos residen en Carrito y ColaImpresion.
 */
public class VentanaEmisionComprobante extends javax.swing.JFrame {
    
    // Conexiones con la logica del sistema
    private Carrito carrito = new Carrito();
    private ColaImpresion colaImpresion = new ColaImpresion();
    private static int correlativoBoleta = 1;
    
    // Catalogo de productos provisto por el Modelo
    private ArrayList<ItemVentaCarrito> listaProductosBase = ItemVentaCarrito.obtenerProductosDisponibles();

    public VentanaEmisionComprobante() {
        initComponents();
        setLocationRelativeTo(null);
        cargarListaProductos();
        actualizarTablaCarrito();
        actualizarTotales();
        configurarBuscador();
        configurarMetodoPago();
        configurarEdicionCantidad();
    }

    private void configurarBuscador() {
        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String criterio = txtBuscador.getText().trim().toLowerCase();
                filtrarProductos(criterio);
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    if (listSugerencias.getModel().getSize() > 0) {
                        listSugerencias.setSelectedIndex(0);
                        agregarProductoSeleccionado();
                    }
                }
            }
        });
    }

    private void configurarMetodoPago() {
        cboMetodoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boolean esEfectivo = cboMetodoPago.getSelectedIndex() == 0;
                lblMontoRecibido.setVisible(esEfectivo);
                txtMontoRecibido.setVisible(esEfectivo);
                lblVuelto.setVisible(esEfectivo);
                if (!esEfectivo) {
                    txtMontoRecibido.setText("");
                    lblVuelto.setText("Vuelto: S/ 0.00");
                }
            }
        });

        txtMontoRecibido.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calcularVueltoEnVivo();
            }
        });
    }

    private void calcularVueltoEnVivo() {
        try {
            String texto = txtMontoRecibido.getText().trim();
            if (!texto.isEmpty()) {
                double recibido = Double.parseDouble(texto);
                double vuelto = carrito.calcularVuelto(recibido);
                if (vuelto >= 0) {
                    lblVuelto.setText("Vuelto: S/ " + String.format("%.2f", vuelto));
                    lblVuelto.setForeground(new Color(30, 120, 30));
                } else {
                    lblVuelto.setText("Falta: S/ " + String.format("%.2f", Math.abs(vuelto)));
                    lblVuelto.setForeground(new Color(180, 40, 40));
                }
            } else {
                lblVuelto.setText("Vuelto: S/ 0.00");
                lblVuelto.setForeground(new Color(50, 50, 50));
            }
        } catch (NumberFormatException e) {
            lblVuelto.setText("Vuelto: S/ 0.00");
        }
    }

    private void filtrarProductos(String criterio) {
        DefaultListModel<ItemVentaCarrito> modeloFiltrado = new DefaultListModel<>();
        for (ItemVentaCarrito p : listaProductosBase) {
            if (p.getNombreProducto().toLowerCase().contains(criterio)) {
                modeloFiltrado.addElement(p);
            }
        }
        listSugerencias.setModel(modeloFiltrado);
    }

    private void cargarListaProductos() {
        DefaultListModel<ItemVentaCarrito> modelo = new DefaultListModel<>();
        for (ItemVentaCarrito p : listaProductosBase) {
            modelo.addElement(p);
        }
        listSugerencias.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        menuBarCaja = new javax.swing.JMenuBar();
        menuVolver = new javax.swing.JMenu();
        itemVolverPrincipal = new javax.swing.JMenuItem();


        lblTitulo = new javax.swing.JLabel();
        lblBuscarProducto = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        scrollSugerencias = new javax.swing.JScrollPane();
        listSugerencias = new javax.swing.JList<>();
        lblCarrito = new javax.swing.JLabel();
        scrollCarrito = new javax.swing.JScrollPane();
        tablaCarrito = new javax.swing.JTable();
        btnEliminarSeleccionado = new javax.swing.JButton();
        btnCancelarCompra = new javax.swing.JButton();
        lblSubtotal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblMetodoPago = new javax.swing.JLabel();
        cboMetodoPago = new javax.swing.JComboBox<>();
        lblMontoRecibido = new javax.swing.JLabel();
        txtMontoRecibido = new javax.swing.JTextField();
        lblVuelto = new javax.swing.JLabel();
        btnConfirmarVenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Minimarket El Ahorro - Caja de Ventas");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setText("Emisión de Comprobante de Pago");

        lblBuscarProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBuscarProducto.setText("Buscar producto:");

        listSugerencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSugerenciasMouseClicked(evt);
            }
        });
        scrollSugerencias.setViewportView(listSugerencias);

        lblCarrito.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCarrito.setText("Detalle del Comprobante:");

        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Producto", "Cant.", "Precio Unit.", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollCarrito.setViewportView(tablaCarrito);

        btnEliminarSeleccionado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnEliminarSeleccionado.setText("Eliminar Ítem");
        btnEliminarSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSeleccionadoActionPerformed(evt);
            }
        });

        btnCancelarCompra.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCancelarCompra.setForeground(new java.awt.Color(180, 40, 40));
        btnCancelarCompra.setText("Cancelar Venta");
        btnCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCompraActionPerformed(evt);
            }
        });

        lblSubtotal.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblSubtotal.setText("Subtotal: S/ 0.00");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setText("TOTAL: S/ 0.00");

        lblMetodoPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMetodoPago.setText("Forma de pago:");

        cboMetodoPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Billetera digital Yape/Plin" }));

        lblMontoRecibido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMontoRecibido.setText("Monto recibido (S/):");

        txtMontoRecibido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblVuelto.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblVuelto.setText("Vuelto: S/ 0.00");

        btnConfirmarVenta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnConfirmarVenta.setText("Confirmar Venta");
        btnConfirmarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollSugerencias, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(lblBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscador))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollCarrito, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminarSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMontoRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMontoRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblVuelto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(btnConfirmarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarProducto)
                    .addComponent(lblCarrito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollSugerencias, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubtotal)
                            .addComponent(lblMetodoPago)
                            .addComponent(cboMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal)
                            .addComponent(lblMontoRecibido)
                            .addComponent(txtMontoRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVuelto))
                        .addGap(28, 28, 28)
                        .addComponent(btnConfirmarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );

        
        menuVolver.setText("Volver");

        itemVolverPrincipal.setText("Volver al Menú Principal");
        itemVolverPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVolverPrincipalActionPerformed(evt);
            }
        });
        menuVolver.add(itemVolverPrincipal);

        menuBarCaja.add(menuVolver);

        setJMenuBar(menuBarCaja);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean actualizandoTabla = false;

    private void configurarEdicionCantidad() {
        tablaCarrito.getModel().addTableModelListener(e -> {
            if (actualizandoTabla) {
                return;
            }
            if (e.getType() == javax.swing.event.TableModelEvent.UPDATE) {
                int fila = e.getFirstRow();
                int col = e.getColumn();
                // Columna 1 corresponde a Cant.
                if (col == 1 && fila >= 0 && fila < carrito.getItems().size()) {
                    try {
                        Object val = tablaCarrito.getValueAt(fila, col);
                        int nuevaCant = Integer.parseInt(val.toString().trim());
                        // RF3 (Update): Modificar cantidad en el comprobante actualizando de inmediato
                        carrito.modificarCantidad(fila, nuevaCant);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, 
                            "Por favor ingrese un número entero válido.", 
                            "Aviso", 
                            JOptionPane.WARNING_MESSAGE);
                    }
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        actualizarTablaCarrito();
                        actualizarTotales();
                    });
                }
            }
        });
    }

    private void actualizarTablaCarrito() {
        actualizandoTabla = true;
        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaCarrito.getModel();
            modelo.setRowCount(0);

            for (ItemVentaCarrito item : carrito.getItems()) {
                modelo.addRow(new Object[]{
                    item.getNombreProducto(),   
                    item.getCantidad(),         
                    String.format(java.util.Locale.US, "%.2f", item.getPrecioUnitario()),   
                    String.format(java.util.Locale.US, "%.2f", item.getSubtotal())          
                });
            }
        } finally {
            actualizandoTabla = false;
        }
    }
    
    private void actualizarTotales() {
        double total = carrito.calcularSubtotal();
        lblSubtotal.setText("Subtotal: S/ " + String.format(java.util.Locale.US, "%.2f", total));
        lblTotal.setText("TOTAL: S/ " + String.format(java.util.Locale.US, "%.2f", total));
        calcularVueltoEnVivo();
    }

    private void btnCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCompraActionPerformed
        if (carrito.estaVacio()) {
            JOptionPane.showMessageDialog(this, "El carrito ya está vacío.");
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this, 
            "¿Desea cancelar la compra actual?", 
            "Confirmar cancelación", 
            JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            carrito.vaciar();
            actualizarTablaCarrito();
            actualizarTotales();
            txtMontoRecibido.setText("");
            lblVuelto.setText("Vuelto: S/ 0.00");
        }
    }//GEN-LAST:event_btnCancelarCompraActionPerformed

    private void btnConfirmarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarVentaActionPerformed
        if (carrito.estaVacio()) {
            JOptionPane.showMessageDialog(this, 
                "Agregue productos antes de confirmar la venta.", 
                "Carrito vacío", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        double total = carrito.calcularSubtotal();
        String metodoPago = (String) cboMetodoPago.getSelectedItem();
        double recibido = total;
        double vuelto = 0.00;

        if (cboMetodoPago.getSelectedIndex() == 0) { // Pago en efectivo
            String texto = txtMontoRecibido.getText().trim();
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Ingrese el monto recibido en efectivo.", 
                    "Aviso", 
                    JOptionPane.WARNING_MESSAGE);
                txtMontoRecibido.requestFocus();
                return;
            }
            try {
                recibido = Double.parseDouble(texto);
                if (recibido < total) {
                    JOptionPane.showMessageDialog(this, 
                        "El monto recibido es insuficiente.", 
                        "Pago insuficiente", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                vuelto = carrito.calcularVuelto(recibido);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, 
                    "Ingrese un número válido.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // RF5 (Create / Update): Registrar modalidad de pago y liquidar cobro (Estructura: HashMap<String, Object>)
        HashMap<String, Object> datosPago = carrito.registrarPago(metodoPago, recibido);

        // RF6 (Create): Generar comprobante de pago oficial con correlativo único
        String numBoleta = String.format("B001-%06d", correlativoBoleta++);
        ComprobantePago boleta = carrito.generarComprobante(numBoleta, metodoPago, recibido, vuelto);

        // Encolar secuencialmente (offer) en buffer FIFO (ColaImpresion / LinkedList)
        colaImpresion.encolar(boleta);

        // Desencolar para emisión física e impresión (poll) en estricto orden FIFO
        ComprobantePago boletaEmitida = colaImpresion.procesarSiguiente();

        // Mostrar la boleta formal emitida
        JTextArea textArea = new JTextArea(boletaEmitida.generarBoleta());
        textArea.setFont(new Font("Courier New", Font.PLAIN, 12));
        textArea.setEditable(false);
        JScrollPane sp = new JScrollPane(textArea);
        sp.setPreferredSize(new Dimension(380, 420));

        JOptionPane.showMessageDialog(this, sp, "Boleta Emitida - Nro: " + numBoleta, JOptionPane.INFORMATION_MESSAGE);

        // Limpiar para atender al siguiente cliente
        carrito.vaciar();
        actualizarTablaCarrito();
        actualizarTotales();
        txtMontoRecibido.setText("");
        lblVuelto.setText("Vuelto: S/ 0.00");
    }//GEN-LAST:event_btnConfirmarVentaActionPerformed

    private void agregarProductoSeleccionado() {
        ItemVentaCarrito seleccionado = listSugerencias.getSelectedValue();
        if (seleccionado == null) {
            return;
        }

        ItemVentaCarrito item = new ItemVentaCarrito(
            seleccionado.getNombreProducto(),
            1,
            seleccionado.getPrecioUnitario()
        );

        carrito.agregar(item);
        actualizarTablaCarrito();
        actualizarTotales();
    }

    private void listSugerenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSugerenciasMouseClicked
        agregarProductoSeleccionado();
    }//GEN-LAST:event_listSugerenciasMouseClicked

    private void btnEliminarSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSeleccionadoActionPerformed
        int fila = tablaCarrito.getSelectedRow();
        if (fila == -1) {
            return;
        }

        carrito.eliminar(fila);
        actualizarTablaCarrito();
        actualizarTotales();
    }//GEN-LAST:event_btnEliminarSeleccionadoActionPerformed

    
    private void itemVolverPrincipalActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.Window[] windows = java.awt.Window.getWindows();
        boolean principalEncontrado = false;
        for (java.awt.Window w : windows) {
            if (w instanceof Principal && w.isDisplayable()) {
                w.setVisible(true);
                w.toFront();
                principalEncontrado = true;
                break;
            }
        }
        if (!principalEncontrado) {
            new Principal().setVisible(true);
        }
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCompra;
    private javax.swing.JButton btnConfirmarVenta;
    private javax.swing.JButton btnEliminarSeleccionado;
    private javax.swing.JComboBox<String> cboMetodoPago;
    private javax.swing.JLabel lblBuscarProducto;
    private javax.swing.JLabel lblCarrito;
    private javax.swing.JLabel lblMetodoPago;
    private javax.swing.JLabel lblMontoRecibido;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVuelto;
    private javax.swing.JList<ItemVentaCarrito> listSugerencias;
    private javax.swing.JScrollPane scrollCarrito;
    private javax.swing.JScrollPane scrollSugerencias;
    private javax.swing.JTable tablaCarrito;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextField txtMontoRecibido;
        private javax.swing.JMenuItem itemVolverPrincipal;
    private javax.swing.JMenuBar menuBarCaja;
    private javax.swing.JMenu menuVolver;
    // End of variables declaration//GEN-END:variables
}
