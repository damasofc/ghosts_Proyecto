//************Esta clase es la de menu inicio que se abre de primero************************
package ghosts_Proyecto;



public class Menu_inicio extends javax.swing.JFrame {
    
    /**
     * Creates new form Menu_inicio
     */
    public Menu_inicio() {
        initComponents();
        setLocationRelativeTo(null);//esto hace que la panatalla aparezca en medio 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        bt_iniciarSesion = new javax.swing.JButton();
        bt_crearPlayer = new javax.swing.JButton();
        bt_salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(61, 90, 32));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 47, 103));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_iniciarSesion.setText("Iniciar sesion");
        bt_iniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_iniciarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(bt_iniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        bt_crearPlayer.setText("Crear Player");
        bt_crearPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_crearPlayerActionPerformed(evt);
            }
        });
        jPanel1.add(bt_crearPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, -1));

        bt_salir.setText("Salir");
        bt_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salirActionPerformed(evt);
            }
        });
        jPanel1.add(bt_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 86, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Menu de Inicio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("Ghosts");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("/home/damasofc/Descargas/imagenes descargadas/ghosts2.jpg")); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.black, java.awt.Color.lightGray, null, java.awt.Color.orange));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 430, 350));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salirActionPerformed
        System.exit(EXIT_ON_CLOSE);//esto hace que al apretar el boton salir, se cierre el programa
    }//GEN-LAST:event_bt_salirActionPerformed

    private void bt_iniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_iniciarSesionActionPerformed
        Menu_InicioSesion nw = new Menu_InicioSesion();//aca creo un objeto de la clase inicio_sesion
        nw.setVisible(true);//esto hace que al dar click en el boton iniciar sesion, se abra la ventana inicio_sesion
    }//GEN-LAST:event_bt_iniciarSesionActionPerformed

    private void bt_crearPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_crearPlayerActionPerformed
        MainProyecto.crear.setVisible(true);//esto hace que al dar click en el boton crear player aparezca la ventana de crearPlayer
        this.setVisible(false);//esto hace que al dar click en crear player, se cierre esta ventana de Menu_Inicio
    }//GEN-LAST:event_bt_crearPlayerActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_crearPlayer;
    private javax.swing.JButton bt_iniciarSesion;
    private javax.swing.JButton bt_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}
