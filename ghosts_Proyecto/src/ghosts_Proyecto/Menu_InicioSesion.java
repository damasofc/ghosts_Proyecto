
/*
********Esta es la clase que contiene la ventanita de iniciar sesion***********88
*/
package ghosts_Proyecto;

import javax.swing.JOptionPane;


public class Menu_InicioSesion extends javax.swing.JFrame {
    public static Usuario  UsuarioActivo = new Usuario(" ", " ");
    public static Menu_principal mp ;//aca creo un objeto de la clase inicio_sesion

    public Menu_InicioSesion() {
        initComponents();
        setLocationRelativeTo(null);//esto hace que la ventana aparezca en medio.
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_usuario = new javax.swing.JTextField();
        bt_entrar = new javax.swing.JButton();
        psw_contra = new javax.swing.JPasswordField();
        but_regresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("WenQuanYi Micro Hei", 1, 24)); // NOI18N
        jLabel1.setText("LOGIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 11, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 92, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 142, -1, -1));

        jtf_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 89, 101, -1));

        bt_entrar.setText("Entrar");
        bt_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_entrarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 208, -1, -1));
        getContentPane().add(psw_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 142, 101, -1));

        but_regresar.setText("Regresar");
        but_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_regresarActionPerformed(evt);
            }
        });
        getContentPane().add(but_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 259, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ghosts_Proyecto/res/pueblo_fantasma.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_entrarActionPerformed
        if(jtf_usuario.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Usuario o contraseña invalidos\nPorfavor ingrese datos correctos","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
    //*********Aca se comprueba si el usuario y contrasena ingresadas son de algun usuario almacenado*******8888
            boolean comprobar = MainProyecto.comprobarUsuarioIni(jtf_usuario.getText(), psw_contra.getText());
    //********aca comprueba si es true y el usuario ingreso bien la contrasena y el usuario entncs muestra un mensaje que dice que inicio sesion      
            if(comprobar == true){
                int posicionUsuario = MainProyecto.comprobarPosicionUsuario(jtf_usuario.getText());
                UsuarioActivo = MainProyecto.usuarios[posicionUsuario];
                mp = new Menu_principal();//aca creo un nuevo objeto de la clase inicio_sesion
                JOptionPane.showMessageDialog(null,"Has iniciado sesion","Excelente",JOptionPane.INFORMATION_MESSAGE);
                mp.setVisible(true);
                this.dispose();
            }
            //******** y en caso de que ingreso mal algunos de los 2 datos, entonces dice invalido
            else if(comprobar == false){
                    JOptionPane.showMessageDialog(null,"Usuario o contraseña invalidos","Error",JOptionPane.ERROR_MESSAGE);

           }
        }    
        //******estos 2 de aca abajo hacen que luego de ingresar los datos y luego que haya ingresado el nuevo usuario entonces borre lo escrito en los textfiel
       jtf_usuario.setText("");
       psw_contra.setText("");
       
    }//GEN-LAST:event_bt_entrarActionPerformed

    private void jtf_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_usuarioActionPerformed

    private void but_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_regresarActionPerformed
        MainProyecto.m.setVisible(true);
        jtf_usuario.setText("");
        psw_contra.setText("");
        this.dispose();
    }//GEN-LAST:event_but_regresarActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_entrar;
    private javax.swing.JButton but_regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jtf_usuario;
    private javax.swing.JPasswordField psw_contra;
    // End of variables declaration//GEN-END:variables
}
