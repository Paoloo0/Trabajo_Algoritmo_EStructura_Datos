package Visual;

import Estructuras.Carrito;
import Estructuras.ColaImpresion;
import Modelo.ItemVentaCarrito;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * GUI 2 - RF2: Mantenimiento del Detalle del Comprobante (CRUD en Memoria).
 * Lado Izquierdo: Buscador interactivo y catálogo de productos (Read).
 * Lado Derecho: Detalle de venta en curso (Create, Update, Delete) y Confirmar Venta.
 */
public class VentanaEmisionComprobante extends javax.swing.JFrame {
    
    private Carrito carrito = new Carrito();
    private ColaImpresion colaImpresion = ColaImpresion.getInstancia();
    private static int correlativoBoleta = 1;
    
    private ArrayList<ItemVentaCarrito> listaProductosBase = ItemVentaCarrito.obtenerProductosDisponibles();

    public VentanaEmisionComprobante() {
        initComponents();
        setLocationRelativeTo(null);
        cargarListaProductos();
        actualizarTablaCarrito();
        actualizarTotales();
        configurarBuscador();
        configurarEdicionCantidad();
    }

    public void reiniciarVenta() {
        correlativoBoleta++;
        carrito.vaciar();
        actualizarTablaCarrito();
        actualizarTotales();
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

        btnConfirmarVenta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnConfirmarVenta.setText("Confirmar Venta");
        btnConfirmarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarVentaActionPerformed(evt);
            }
        });

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
                        .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(scrollCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSubtotal)
                            .addComponent(lblTotal))
                        .addGap(35, 35, 35)
                        .addComponent(btnConfirmarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );

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
                if (col == 1 && fila >= 0 && fila < carrito.getItems().size()) {
                    try {
                        Object val = tablaCarrito.getValueAt(fila, col);
                        int nuevaCant = Integer.parseInt(val.toString().trim());
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
                    String.format(Locale.US, "%.2f", item.getPrecioUnitario()),   
                    String.format(Locale.US, "%.2f", item.getSubtotal())          
                });
            }
        } finally {
            actualizandoTabla = false;
        }
    }
    
    private void actualizarTotales() {
        double total = carrito.calcularSubtotal();
        lblSubtotal.setText("Subtotal: S/ " + String.format(Locale.US, "%.2f", total));
        lblTotal.setText("TOTAL: S/ " + String.format(Locale.US, "%.2f", total));
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
        }
    }//GEN-LAST:event_btnCancelarCompraActionPerformed

    private void btnConfirmarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarVentaActionPerformed
        if (carrito.estaVacio()) {
            JOptionPane.showMessageDialog(this, 
                "Agregue productos antes de proceder al cobro.", 
                "Comprobante vacío", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // GUI 3 - RF3: Abrir ventana de Liquidación de Cobro (DlgCobro JFrame)
        Cobro cobro = new Cobro(carrito, colaImpresion, correlativoBoleta, this);
        cobro.setVisible(true);
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
    private javax.swing.JMenuItem itemVolverPrincipal;
    private javax.swing.JLabel lblBuscarProducto;
    private javax.swing.JLabel lblCarrito;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList<ItemVentaCarrito> listSugerencias;
    private javax.swing.JMenuBar menuBarCaja;
    private javax.swing.JMenu menuVolver;
    private javax.swing.JScrollPane scrollCarrito;
    private javax.swing.JScrollPane scrollSugerencias;
    private javax.swing.JTable tablaCarrito;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
