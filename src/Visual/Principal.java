package Visual;

import Estructuras.ColaImpresion;

/**
 * GUI 1 - RF1: Menú Principal y Control de Operaciones en Caja.
 * Barra de menú superior con opciones al costado de Salir:
 * - Salir -> Cerrar Sesión
 * - Emitir Comprobante de Pago
 * - Historial de Comprobantes
 * - Cierre de Turno y Caja
 * Pantalla principal con el título oficial: Minimarket El Ahorro.
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        setTitle("Minimarket El Ahorro");
        setLocationRelativeTo(null);
    }

    private void abrirEmision() {
        VentanaEmisionComprobante ventana = new VentanaEmisionComprobante();
        ventana.setVisible(true);
        this.dispose();
    }

    private void abrirHistorial() {
        HistorialBoletas historial = new HistorialBoletas(ColaImpresion.getInstancia());
        historial.setVisible(true);
    }

    private void abrirCierre() {
        CierreCaja cierre = new CierreCaja(ColaImpresion.getInstancia());
        cierre.setVisible(true);
    }

    private void cerrarSesion() {
        new Login().setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloPrincipal = new javax.swing.JLabel();
        menuBarPrincipal = new javax.swing.JMenuBar();
        menuSalir = new javax.swing.JMenu();
        itemCerrarSesion = new javax.swing.JMenuItem();
        menuEmitir = new javax.swing.JMenu();
        itemEmitir = new javax.swing.JMenuItem();
        menuHistorial = new javax.swing.JMenu();
        itemHistorial = new javax.swing.JMenuItem();
        menuCierre = new javax.swing.JMenu();
        itemCierre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minimarket El Ahorro");
        setResizable(false);

        lblTituloPrincipal.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblTituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloPrincipal.setText("Minimarket El Ahorro");

        menuSalir.setText("Salir");
        menuSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemCerrarSesion.setText("Cerrar Sesión");
        itemCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        itemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarSesionActionPerformed(evt);
            }
        });
        menuSalir.add(itemCerrarSesion);

        menuBarPrincipal.add(menuSalir);

        menuEmitir.setText("Emitir Comprobante de Pago");
        menuEmitir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuEmitir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEmitirMouseClicked(evt);
            }
        });

        itemEmitir.setText("Emitir Comprobante de Pago");
        itemEmitir.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        itemEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEmitirActionPerformed(evt);
            }
        });
        menuEmitir.add(itemEmitir);

        menuBarPrincipal.add(menuEmitir);

        menuHistorial.setText("Historial de Comprobantes");
        menuHistorial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHistorialMouseClicked(evt);
            }
        });

        itemHistorial.setText("Historial de Comprobantes");
        itemHistorial.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        itemHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHistorialActionPerformed(evt);
            }
        });
        menuHistorial.add(itemHistorial);

        menuBarPrincipal.add(menuHistorial);

        menuCierre.setText("Cierre de Turno y Caja");
        menuCierre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuCierre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCierreMouseClicked(evt);
            }
        });

        itemCierre.setText("Cierre de Turno y Caja");
        itemCierre.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        itemCierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCierreActionPerformed(evt);
            }
        });
        menuCierre.add(itemCierre);

        menuBarPrincipal.add(menuCierre);

        setJMenuBar(menuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarSesionActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_itemCerrarSesionActionPerformed

    private void menuEmitirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEmitirMouseClicked
        abrirEmision();
    }//GEN-LAST:event_menuEmitirMouseClicked

    private void itemEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEmitirActionPerformed
        abrirEmision();
    }//GEN-LAST:event_itemEmitirActionPerformed

    private void menuHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHistorialMouseClicked
        abrirHistorial();
    }//GEN-LAST:event_menuHistorialMouseClicked

    private void itemHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHistorialActionPerformed
        abrirHistorial();
    }//GEN-LAST:event_itemHistorialActionPerformed

    private void menuCierreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCierreMouseClicked
        abrirCierre();
    }//GEN-LAST:event_menuCierreMouseClicked

    private void itemCierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCierreActionPerformed
        abrirCierre();
    }//GEN-LAST:event_itemCierreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCerrarSesion;
    private javax.swing.JMenuItem itemCierre;
    private javax.swing.JMenuItem itemEmitir;
    private javax.swing.JMenuItem itemHistorial;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JMenuBar menuBarPrincipal;
    private javax.swing.JMenu menuCierre;
    private javax.swing.JMenu menuEmitir;
    private javax.swing.JMenu menuHistorial;
    private javax.swing.JMenu menuSalir;
    // End of variables declaration//GEN-END:variables
}
