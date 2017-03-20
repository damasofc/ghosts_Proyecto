
package ghosts_Proyecto;

import javax.swing.JOptionPane;

public class MenuCrearUsuario  extends javax.swing.JFrame{


    public MenuCrearUsuario(){
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtf_usuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bt_crearJugador = new javax.swing.JButton();
        bt_atras = new javax.swing.JButton();
        psw_contra = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Jugador");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 11, -1, -1));
        getContentPane().add(jtf_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 95, 119, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 98, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 136, -1, -1));

        bt_crearJugador.setText("Crear Jugador");
        bt_crearJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_crearJugadorActionPerformed(evt);
            }
        });
        getContentPane().add(bt_crearJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 171, -1, -1));

        bt_atras.setText("Atras");
        bt_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_atrasActionPerformed(evt);
            }
        });
        getContentPane().add(bt_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 259, -1, -1));
        getContentPane().add(psw_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 133, 119, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ghosts_Proyecto/res/pueblo_fantasma.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void bt_crearJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_crearJugadorActionPerformed
        if(jtf_usuario.getText().equals("") || psw_contra.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Porfavor Complete los campos vacios","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            boolean comprobar = MainProyecto.comprobarUsuario(jtf_usuario.getText());//aca se llama al metodo comprobarUsuario y se almacena en la variable comprobar
            if(comprobar == true){//aca ya se evalua si el usuario esta o no esta.
                JOptionPane.showMessageDialog(null,"Jugador ya existente","Error",JOptionPane.ERROR_MESSAGE);
            }
            else if(comprobar == false){//aca se evalua si el usuario no esta entonces se hacen las siguientes instrucciones.
                    MainProyecto.crearUsuario(jtf_usuario.getText(), psw_contra.getText());//se llama al metodo y se crea el usuario.
                    JOptionPane.showMessageDialog(null,"Usuario creado","Excelente",JOptionPane.INFORMATION_MESSAGE);//hace que se vea la ventanita diciendo que se creo el nuevo usuario
           }
        }    
        //******estos 2 de aca abajo hacen que luego de ingresar los datos y luego que haya ingresado el nuevo usuario entonces borre lo escrito en los textfiel
       jtf_usuario.setText("");
       psw_contra.setText("");
       

    }//GEN-LAST:event_bt_crearJugadorActionPerformed

    private void bt_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_atrasActionPerformed

        MainProyecto.m.setVisible(true);//etso hace que se abra la ventana de Menu_inicio
        this.dispose();//aca se cierra esta ventana actual de crearPlayer
    }//GEN-LAST:event_bt_atrasActionPerformed

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
            java.util.logging.Logger.getLogger(MenuCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCrearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_atras;
    private javax.swing.JButton bt_crearJugador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jtf_usuario;
    private javax.swing.JPasswordField psw_contra;
    // End of variables declaration//GEN-END:variables
}
