/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghosts_Proyecto;

import static ghosts_Proyecto.MainProyecto.usuarios;
import static ghosts_Proyecto.Menu_InicioSesion.UsuarioActivo;
import static ghosts_Proyecto.Menu_InicioSesion.mp;
import javax.swing.JOptionPane;



/**
 *
 * @author Jhair
 */
public class Eliminar_Usuario extends javax.swing.JFrame {
    private static int contador=0;// es un contador que se usa mas abajo.
    private static int hola=0;// es un contador que se usa mas abajo.

    /**
     * Creates new form Eliminar_Usuario
     */
    public Eliminar_Usuario() {
        initComponents();
        setLocationRelativeTo(null);//esto hace que la panatalla aparezca en medio
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jb_si = new javax.swing.JButton();
        jb_No = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Desea Realmente Eliminar Su Cuenta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 400, -1));

        jb_si.setText("SI");
        jb_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_siActionPerformed(evt);
            }
        });
        getContentPane().add(jb_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 73, -1));

        jb_No.setText("NO");
        jb_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_NoActionPerformed(evt);
            }
        });
        getContentPane().add(jb_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 70, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ghosts_Proyecto/res/Fantasmas.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_siActionPerformed
    Menu_InicioSesion mi =new Menu_InicioSesion();
    
   
            
             
        Menu_InicioSesion.UsuarioActivo.setContra("");
        Menu_InicioSesion.UsuarioActivo.setNombUsuario("");
        JOptionPane.showMessageDialog(null,"Cuenta eliminada",":-(",JOptionPane.INFORMATION_MESSAGE);
        
        
       
     
        Menu_inicio mn=new Menu_inicio();
        mn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jb_siActionPerformed

    private void jb_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_NoActionPerformed
      Mi_perfil mp=new Mi_perfil();
      mp.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jb_NoActionPerformed

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
            java.util.logging.Logger.getLogger(Eliminar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jb_No;
    private javax.swing.JButton jb_si;
    // End of variables declaration//GEN-END:variables
}
