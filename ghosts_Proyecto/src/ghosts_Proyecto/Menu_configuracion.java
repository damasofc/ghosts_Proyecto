
package ghosts_Proyecto;


public class Menu_configuracion extends javax.swing.JFrame {

    
    public Menu_configuracion() {
        initComponents();
        setLocationRelativeTo(null);//esto hace que la panatalla aparezca en medio
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jb_regresar = new javax.swing.JButton();
        jcb_dificultad = new javax.swing.JComboBox<>();
        jcb_modo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Configuracion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 11, -1, -1));

        jb_regresar.setText("Regresar");
        jb_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_regresarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 137, 118, -1));

        jcb_dificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Expert", "Genius" }));
        jcb_dificultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_dificultadActionPerformed(evt);
            }
        });
        getContentPane().add(jcb_dificultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 73, 99, -1));

        jcb_modo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aleatorio", "Normal" }));
        getContentPane().add(jcb_modo, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 99, 99, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dificultad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 73, 94, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modo de Juego");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 102, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ghosts_Proyecto/res/wallpaper-792477_960_720.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_regresarActionPerformed
        
        String Dificultad = jcb_dificultad.getSelectedItem().toString();
        //condiciones dificultad
        if("Normal".equals(Dificultad)){
            JuegoTablero.dificulty = 8;
        }
        else if("Expert".equals(Dificultad)){
            JuegoTablero.dificulty = 4;
        }
        else if("Genius".equals(Dificultad)){
            JuegoTablero.dificulty = 2;
        }
       
        Menu_principal mp=new Menu_principal();
        mp.setVisible(true);
        this.dispose();//aca se cierra esta ventana actual
    }//GEN-LAST:event_jb_regresarActionPerformed

    private void jcb_dificultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_dificultadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_dificultadActionPerformed

    
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jb_regresar;
    private javax.swing.JComboBox<String> jcb_dificultad;
    private javax.swing.JComboBox<String> jcb_modo;
    // End of variables declaration//GEN-END:variables
}
