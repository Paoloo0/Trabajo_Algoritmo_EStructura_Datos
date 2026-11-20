package Visual;

import Estructuras.ColaImpresion;
import Modelo.ComprobantePago;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * GUI 5 - RF5: Consulta de Historial y Reimpresión de Comprobantes.
 * Búsqueda indexada en O(1) con HashMap<String, ComprobantePago> por correlativo
 * y visualización del registro completo de boletas emitidas en el turno.
 */
public class HistorialBoletas extends javax.swing.JFrame {

    private ColaImpresion colaImpresion;

    public HistorialBoletas() {
        this.colaImpresion = ColaImpresion.getInstancia();
        initComponents();
        setTitle("");
        setLocationRelativeTo(null);
        cargarTabla(colaImpresion.obtenerTodos());
    }

    public HistorialBoletas(ColaImpresion cola) {
        this.colaImpresion = (cola != null) ? cola : ColaImpresion.getInstancia();
        initComponents();
        setTitle("");
        setLocationRelativeTo(null);
        cargarTabla(colaImpresion.obtenerTodos());
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent e) {
                cargarTabla(colaImpresion.obtenerTodos());
            }
        });
    }

    private void cargarTabla(ArrayList<ComprobantePago> lista) {
        DefaultTableModel model = (DefaultTableModel) tablaHistorial.getModel();
        model.setRowCount(0);
        for (ComprobantePago c : lista) {
            model.addRow(new Object[]{
                c.getNumeroComprobante(),
                c.getFechaHora(),
                c.getMetodoPago(),
                String.format(Locale.US, "%.2f", c.getTotal()),
                String.format(Locale.US, "%.2f", c.getVuelto())
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscarBoleta = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRestablecer = new javax.swing.JButton();
        scrollHistorial = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        btnReimprimir = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitulo.setText("Historial de Comprobantes Emitidos");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(70, 70, 70));
        lblSubtitulo.setText("Búsqueda indexada O(1) y reimpresión de boletas registradas en el turno");

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBuscar.setText("Buscar por Nro Comprobante:");

        txtBuscarBoleta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRestablecer.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnRestablecer.setText("Ver Todos");
        btnRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerActionPerformed(evt);
            }
        });

        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Nro Comprobante", "Fecha y Hora", "Forma de Pago", "Total (S/)", "Vuelto (S/)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollHistorial.setViewportView(tablaHistorial);

        btnReimprimir.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnReimprimir.setText("Reimprimir Comprobante");
        btnReimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReimprimirActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollHistorial)
                    .addComponent(lblSubtitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblSubtitulo)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscarBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String criterio = txtBuscarBoleta.getText().trim();
        if (criterio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un número de comprobante para buscar.");
            return;
        }

        // Búsqueda directa O(1) en la tabla hash de comprobantes
        ComprobantePago encontrado = colaImpresion.buscarPorNumero(criterio);
        ArrayList<ComprobantePago> resultado = new ArrayList<>();
        if (encontrado != null) {
            resultado.add(encontrado);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el comprobante " + criterio + " en el registro de caja.");
        }
        cargarTabla(resultado);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed
        txtBuscarBoleta.setText("");
        cargarTabla(colaImpresion.obtenerTodos());
    }//GEN-LAST:event_btnRestablecerActionPerformed

    private void btnReimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReimprimirActionPerformed
        int fila = tablaHistorial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un comprobante de la tabla para reimprimir.");
            return;
        }

        String nro = (String) tablaHistorial.getValueAt(fila, 0);
        ComprobantePago boleta = colaImpresion.buscarPorNumero(nro);
        if (boleta != null) {
            VisorBoleta visor = new VisorBoleta(boleta, null);
            visor.setVisible(true);
        }
    }//GEN-LAST:event_btnReimprimirActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnReimprimir;
    private javax.swing.JButton btnRestablecer;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollHistorial;
    private javax.swing.JTable tablaHistorial;
    private javax.swing.JTextField txtBuscarBoleta;
    // End of variables declaration//GEN-END:variables
}
