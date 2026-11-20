package Visual;

import Modelo.ComprobantePago;
import javax.swing.JOptionPane;

/**
 * GUI 4 - RF4: Emisión, Foliado e Impresión del Comprobante Fiscal.
 * Muestra el comprobante emitido formalmente con su número correlativo único oficial.
 */
public class VisorBoleta extends javax.swing.JFrame {

    private ComprobantePago boleta;
    private VentanaEmisionComprobante ventanaPadre;

    public VisorBoleta() {
        initComponents();
        setTitle("");
        setLocationRelativeTo(null);
    }

    public VisorBoleta(ComprobantePago boleta, VentanaEmisionComprobante ventanaPadre) {
        this.boleta = boleta;
        this.ventanaPadre = ventanaPadre;
        initComponents();
        setTitle("");
        setLocationRelativeTo(null);
        mostrarBoleta();
    }

    private void mostrarBoleta() {
        if (boleta != null) {
            lblSubtituloBoleta.setText("Serie y Correlativo: " + boleta.getNumeroComprobante());
            txtTicket.setText(boleta.generarBoleta());
            txtTicket.setCaretPosition(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloBoleta = new javax.swing.JLabel();
        lblSubtituloBoleta = new javax.swing.JLabel();
        scrollTicket = new javax.swing.JScrollPane();
        txtTicket = new javax.swing.JTextArea();
        btnImprimir = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("");
        setResizable(false);

        lblTituloBoleta.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTituloBoleta.setText("Comprobante de Pago Oficial");

        lblSubtituloBoleta.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubtituloBoleta.setForeground(new java.awt.Color(22, 101, 52));
        lblSubtituloBoleta.setText("Serie y Correlativo: B001-000001");

        txtTicket.setEditable(false);
        txtTicket.setColumns(20);
        txtTicket.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        txtTicket.setRows(5);
        scrollTicket.setViewportView(txtTicket);

        btnImprimir.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnImprimir.setText("Imprimir Boleta");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnFinalizar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnFinalizar.setText("Finalizar y Nueva Venta");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSubtituloBoleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTituloBoleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTituloBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblSubtituloBoleta)
                .addGap(18, 18, 18)
                .addComponent(scrollTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        String num = (boleta != null) ? boleta.getNumeroComprobante() : "";
        JOptionPane.showMessageDialog(this,
            "Comprobante " + num + " enviado exitosamente a la impresora térmica.",
            "Impresión Exitosa",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        this.dispose();
        if (ventanaPadre != null) {
            ventanaPadre.reiniciarVenta();
            ventanaPadre.setVisible(true);
            ventanaPadre.toFront();
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel lblSubtituloBoleta;
    private javax.swing.JLabel lblTituloBoleta;
    private javax.swing.JScrollPane scrollTicket;
    private javax.swing.JTextArea txtTicket;
    // End of variables declaration//GEN-END:variables
}
