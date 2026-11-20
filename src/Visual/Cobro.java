package Visual;

import Estructuras.Carrito;
import Estructuras.ColaImpresion;
import Modelo.ComprobantePago;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * GUI 3 - RF3: Liquidación de Cobro y Cálculo de Vuelto.
 * Permite seleccionar la modalidad de pago (Efectivo / Yape / Plin),
 * registrar el importe recibido, calcular el vuelto en tiempo real y emitir.
 */
public class Cobro extends javax.swing.JFrame {

    private Carrito carrito;
    private ColaImpresion colaImpresion;
    private int correlativoBoleta;
    private VentanaEmisionComprobante ventanaPadre;

    public Cobro() {
        initComponents();
        setTitle("");
        setLocationRelativeTo(null);
    }

    public Cobro(Carrito carrito, ColaImpresion colaImpresion, int correlativoBoleta, VentanaEmisionComprobante ventanaPadre) {
        this.carrito = carrito;
        this.colaImpresion = (colaImpresion != null) ? colaImpresion : ColaImpresion.getInstancia();
        this.correlativoBoleta = correlativoBoleta;
        this.ventanaPadre = ventanaPadre;
        initComponents();
        setTitle("");
        setLocationRelativeTo(null);
        inicializarDatos();
    }

    private void inicializarDatos() {
        if (carrito != null) {
            double total = carrito.calcularSubtotal();
            lblTotalPagar.setText("TOTAL A PAGAR: S/ " + String.format(Locale.US, "%.2f", total));
        }

        txtMontoRecibido.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calcularVueltoEnVivo();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnConfirmarActionPerformed(null);
                }
            }
        });
    }

    private void alternarModoPago() {
        boolean esEfectivo = (cboMetodoPago.getSelectedIndex() == 0);
        lblMonto.setVisible(esEfectivo);
        txtMontoRecibido.setVisible(esEfectivo);
        lblVueltoTitulo.setVisible(esEfectivo);
        lblVuelto.setVisible(esEfectivo);

        if (!esEfectivo) {
            double total = (carrito != null) ? carrito.calcularSubtotal() : 0.0;
            txtMontoRecibido.setText(String.format(Locale.US, "%.2f", total));
            lblVuelto.setText("S/ 0.00");
            lblVuelto.setForeground(new Color(22, 101, 52));
        } else {
            txtMontoRecibido.setText("");
            lblVuelto.setText("S/ 0.00");
            txtMontoRecibido.requestFocus();
        }
    }

    private void calcularVueltoEnVivo() {
        if (carrito == null) return;
        double total = carrito.calcularSubtotal();
        String texto = txtMontoRecibido.getText().trim();
        if (texto.isEmpty()) {
            lblVuelto.setText("S/ 0.00");
            lblVuelto.setForeground(new Color(100, 116, 139));
            return;
        }

        try {
            double recibido = Double.parseDouble(texto);
            double vuelto = carrito.calcularVuelto(recibido);
            if (vuelto >= 0) {
                lblVuelto.setText("S/ " + String.format(Locale.US, "%.2f", vuelto));
                lblVuelto.setForeground(new Color(22, 101, 52));
            } else {
                lblVuelto.setText("Falta: S/ " + String.format(Locale.US, "%.2f", Math.abs(vuelto)));
                lblVuelto.setForeground(new Color(220, 38, 38));
            }
        } catch (NumberFormatException e) {
            lblVuelto.setText("Importe no válido");
            lblVuelto.setForeground(new Color(220, 38, 38));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloCobro = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        lblTotalPagar = new javax.swing.JLabel();
        lblMetodo = new javax.swing.JLabel();
        cboMetodoPago = new javax.swing.JComboBox<>();
        lblMonto = new javax.swing.JLabel();
        txtMontoRecibido = new javax.swing.JTextField();
        lblVueltoTitulo = new javax.swing.JLabel();
        lblVuelto = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("");
        setResizable(false);

        lblTituloCobro.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTituloCobro.setText("Módulo de Cobro en Caja");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(70, 70, 70));
        lblSubtitulo.setText("Seleccione la modalidad de pago y registre el importe recibido");

        lblTotalPagar.setBackground(new java.awt.Color(245, 245, 245));
        lblTotalPagar.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTotalPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalPagar.setText("TOTAL A PAGAR: S/ 0.00");
        lblTotalPagar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(208, 208, 208)));
        lblTotalPagar.setOpaque(true);

        lblMetodo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMetodo.setText("Forma de Pago:");

        cboMetodoPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Billetera digital (Yape / Plin)" }));
        cboMetodoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMetodoPagoActionPerformed(evt);
            }
        });

        lblMonto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMonto.setText("Monto Recibido (S/):");

        txtMontoRecibido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblVueltoTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVueltoTitulo.setText("Vuelto a Entregar:");

        lblVuelto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVuelto.setForeground(new java.awt.Color(22, 101, 52));
        lblVuelto.setText("S/ 0.00");

        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnConfirmar.setText("Confirmar Pago y Emitir Boleta");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTituloCobro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotalPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVueltoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboMetodoPago, 0, 230, Short.MAX_VALUE)
                            .addComponent(txtMontoRecibido)
                            .addComponent(lblVuelto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTituloCobro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblSubtitulo)
                .addGap(20, 20, 20)
                .addComponent(lblTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMetodo)
                    .addComponent(cboMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonto)
                    .addComponent(txtMontoRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVueltoTitulo)
                    .addComponent(lblVuelto))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cboMetodoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMetodoPagoActionPerformed
        alternarModoPago();
    }//GEN-LAST:event_cboMetodoPagoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (carrito == null) return;
        double total = carrito.calcularSubtotal();
        String metodoPago = (String) cboMetodoPago.getSelectedItem();
        double recibido = total;
        double vuelto = 0.0;

        if (cboMetodoPago.getSelectedIndex() == 0) { // Efectivo
            String texto = txtMontoRecibido.getText().trim();
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor, ingrese el monto recibido en efectivo.", 
                    "Monto requerido", 
                    JOptionPane.WARNING_MESSAGE);
                txtMontoRecibido.requestFocus();
                return;
            }

            try {
                recibido = Double.parseDouble(texto);
                if (recibido < total) {
                    JOptionPane.showMessageDialog(this, 
                        "El monto recibido (S/ " + String.format(Locale.US, "%.2f", recibido) + ") es insuficiente para cubrir el total de S/ " + String.format(Locale.US, "%.2f", total), 
                        "Pago insuficiente", 
                        JOptionPane.ERROR_MESSAGE);
                    txtMontoRecibido.requestFocus();
                    return;
                }
                vuelto = carrito.calcularVuelto(recibido);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, 
                    "Ingrese un monto numérico válido.", 
                    "Formato inválido", 
                    JOptionPane.ERROR_MESSAGE);
                txtMontoRecibido.requestFocus();
                return;
            }
        }

        // RF3: Registrar modalidad de pago y liquidar cobro (Estructura: HashMap<String, Object>)
        HashMap<String, Object> datosPago = carrito.registrarPago(metodoPago, recibido);

        // RF4: Generar comprobante oficial con correlativo único (B001-XXXXXX)
        String numBoleta = String.format("B001-%06d", correlativoBoleta);
        ComprobantePago boleta = carrito.generarComprobante(numBoleta, metodoPago, recibido, vuelto);

        // Encolado secuencial en ColaImpresion (Queue / LinkedList FIFO)
        colaImpresion.encolar(boleta);

        // Procesar para emisión física en estricto orden FIFO
        ComprobantePago boletaEmitida = colaImpresion.procesarSiguiente();

        this.dispose();

        // GUI 4 - RF4: Abrir visor oficial de boleta emitida
        VisorBoleta visor = new VisorBoleta(boletaEmitida, ventanaPadre);
        visor.setVisible(true);
    }//GEN-LAST:event_btnConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> cboMetodoPago;
    private javax.swing.JLabel lblMetodo;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTituloCobro;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JLabel lblVuelto;
    private javax.swing.JLabel lblVueltoTitulo;
    private javax.swing.JTextField txtMontoRecibido;
    // End of variables declaration//GEN-END:variables
}
