package Visual;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloPrincipal = new javax.swing.JLabel();
        btnVentaProductos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        menuBarPrincipal = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemCerrarSesion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minimarket El Ahorro - Sistema de Caja");

        lblTituloPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloPrincipal.setText("Minimarket El Ahorro");

        btnVentaProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVentaProductos.setText("Emitir Comprobante de Pago");
        btnVentaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaProductosActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        menuArchivo.setText("Archivo");

        itemCerrarSesion.setText("Cerrar Sesión");
        itemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarSesionActionPerformed(evt);
            }
        });
        menuArchivo.add(itemCerrarSesion);
        menuArchivo.add(jSeparator1);

        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(itemSalir);

        menuBarPrincipal.add(menuArchivo);

        setJMenuBar(menuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVentaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnVentaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btnVentaProductosActionPerformed(java.awt.event.ActionEvent evt) {
        new VentanaEmisionComprobante().setVisible(true);
    }

    private void itemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {
        new Login().setVisible(true);
        this.dispose();
    }

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnVentaProductos;
    private javax.swing.JMenuItem itemCerrarSesion;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar menuBarPrincipal;
    // End of variables declaration//GEN-END:variables
}
