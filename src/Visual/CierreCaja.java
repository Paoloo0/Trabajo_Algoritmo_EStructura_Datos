package Visual;

import Estructuras.ColaImpresion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * GUI 6 - RF6: Cierre de Turno y Cuadre de Caja (Arqueo de Comprobantes).
 * Consolida el número de boletas emitidas, subtotales por forma de pago
 * y gran total de ingresos del turno en caja.
 */
public class CierreCaja extends javax.swing.JFrame {

    private ColaImpresion colaImpresion;

    public CierreCaja() {
        this.colaImpresion = ColaImpresion.getInstancia();
        initComponents();
        setTitle("");
        setLocationRelativeTo(null);
        calcularCuadre();
    }

    public CierreCaja(ColaImpresion cola) {
        this.colaImpresion = (cola != null) ? cola : ColaImpresion.getInstancia();
        initComponents();
        setTitle("");
        setLocationRelativeTo(null);
        calcularCuadre();
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(java.awt.event.WindowEvent e) {
                calcularCuadre();
            }
        });
    }

    private void calcularCuadre() {
        int boletas = colaImpresion.totalComprobantesEmitidos();

        // RF6: Consolidación mediante HashMap<String, Double> (Tabla Hash de Acumulación)
        java.util.HashMap<String, Double> balanceArqueo = colaImpresion.consolidarArqueoPorMetodo();
        double efectivo = balanceArqueo.get("Efectivo");
        double digital = balanceArqueo.get("Digital");
        double total = balanceArqueo.get("Total");

        lblTotalBoletas.setText(boletas + " comprobante(s)");
        lblTotalEfectivo.setText("S/ " + String.format(Locale.US, "%.2f", efectivo));
        lblTotalDigital.setText("S/ " + String.format(Locale.US, "%.2f", digital));
        lblGranTotal.setText("TOTAL EN CAJA: S/ " + String.format(Locale.US, "%.2f", total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        lblTotalBoletasTitulo = new javax.swing.JLabel();
        lblTotalBoletas = new javax.swing.JLabel();
        lblEfectivoTitulo = new javax.swing.JLabel();
        lblTotalEfectivo = new javax.swing.JLabel();
        lblDigitalTitulo = new javax.swing.JLabel();
        lblTotalDigital = new javax.swing.JLabel();
        lblGranTotal = new javax.swing.JLabel();
        btnReporte = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitulo.setText("Cierre de Turno y Cuadre de Caja");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(70, 70, 70));
        lblSubtitulo.setText("Consolidación y arqueo de comprobantes de pago emitidos");

        lblTotalBoletasTitulo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTotalBoletasTitulo.setText("Total Boletas Emitidas:");

        lblTotalBoletas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTotalBoletas.setText("0 comprobantes");

        lblEfectivoTitulo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblEfectivoTitulo.setText("Total Recaudado en Efectivo:");

        lblTotalEfectivo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTotalEfectivo.setText("S/ 0.00");

        lblDigitalTitulo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblDigitalTitulo.setText("Total Billeteras (Yape / Plin):");

        lblTotalDigital.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTotalDigital.setText("S/ 0.00");

        lblGranTotal.setBackground(new java.awt.Color(245, 245, 245));
        lblGranTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGranTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGranTotal.setText("TOTAL RECAUDADO EN CAJA: S/ 0.00");
        lblGranTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(208, 208, 208)));
        lblGranTotal.setOpaque(true);

        btnReporte.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnReporte.setText("Generar Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
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
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGranTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalBoletasTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEfectivoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDigitalTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalBoletas, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(lblTotalEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalDigital, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblSubtitulo)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalBoletasTitulo)
                    .addComponent(lblTotalBoletas))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEfectivoTitulo)
                    .addComponent(lblTotalEfectivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDigitalTitulo)
                    .addComponent(lblTotalDigital))
                .addGap(25, 25, 25)
                .addComponent(lblGranTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append("=========================================\n");
        sb.append("     MINIMARKET EL AHORRO - ARQUEO CAJA  \n");
        sb.append("=========================================\n");
        sb.append("Fecha y Hora  : ").append(fecha).append("\n");
        sb.append("Total Boletas : ").append(colaImpresion.totalComprobantesEmitidos()).append("\n");
        sb.append("Total Efectivo: S/ ").append(String.format(Locale.US, "%.2f", colaImpresion.calcularTotalEfectivo())).append("\n");
        sb.append("Total Digital : S/ ").append(String.format(Locale.US, "%.2f", colaImpresion.calcularTotalDigital())).append("\n");
        sb.append("-----------------------------------------\n");
        sb.append("BALANCE TOTAL : S/ ").append(String.format(Locale.US, "%.2f", colaImpresion.calcularGranTotal())).append("\n");
        sb.append("=========================================\n");
        sb.append("      Cuadre de caja conforme!\n");
        sb.append("=========================================");

        javax.swing.JTextArea ta = new javax.swing.JTextArea(sb.toString());
        ta.setFont(new java.awt.Font("Courier New", java.awt.Font.PLAIN, 12));
        ta.setEditable(false);
        JOptionPane.showMessageDialog(this, new javax.swing.JScrollPane(ta), "Reporte de Cuadre de Caja", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblDigitalTitulo;
    private javax.swing.JLabel lblEfectivoTitulo;
    private javax.swing.JLabel lblGranTotal;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotalBoletas;
    private javax.swing.JLabel lblTotalBoletasTitulo;
    private javax.swing.JLabel lblTotalDigital;
    private javax.swing.JLabel lblTotalEfectivo;
    // End of variables declaration//GEN-END:variables
}
