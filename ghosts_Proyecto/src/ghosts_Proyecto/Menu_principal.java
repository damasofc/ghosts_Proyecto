
package ghosts_Proyecto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Menu_principal extends javax.swing.JFrame {
/*esto que viene aca sera crear las variables para cada uno de los Jframes
    que se podran abrir al iniciar sesion y asi poder accederlos desde una sola clase*/
        public static Player_2 p2;
        Mi_perfil mip=new Mi_perfil();
        Menu_configuracion mc=new Menu_configuracion();
        Como_jugar cmj= new Como_jugar();
    
    
    public Menu_principal() {
        initComponents();
        setLocationRelativeTo(null);//esto hace que la panatalla aparezca en medio
        jLabel3.setText(Menu_InicioSesion.UsuarioActivo.getNombUsuario());
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jb_JugarGhost = new javax.swing.JButton();
        jb_Configuracion = new javax.swing.JButton();
        jb_Reportes = new javax.swing.JButton();
        jb_Miperfil = new javax.swing.JButton();
        jb_Salir = new javax.swing.JButton();
        jb_juega = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu Principal");
        jLabel1.setMaximumSize(new java.awt.Dimension(70, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 11, 290, 55));

        jb_JugarGhost.setText("Jugar Ghost");
        jb_JugarGhost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_JugarGhostActionPerformed(evt);
            }
        });
        getContentPane().add(jb_JugarGhost, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 120, -1));

        jb_Configuracion.setText("Configuracion");
        jb_Configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ConfiguracionActionPerformed(evt);
            }
        });
        getContentPane().add(jb_Configuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 120, -1));

        jb_Reportes.setText("Reportes");
        jb_Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ReportesActionPerformed(evt);
            }
        });
        getContentPane().add(jb_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 120, -1));

        jb_Miperfil.setText("Mi Perfil");
        jb_Miperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_MiperfilActionPerformed(evt);
            }
        });
        getContentPane().add(jb_Miperfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 120, -1));

        jb_Salir.setText("Cerrar Sesion");
        jb_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_SalirActionPerformed(evt);
            }
        });
        getContentPane().add(jb_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        jb_juega.setText("Como se juega");
        jb_juega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_juegaActionPerformed(evt);
            }
        });
        getContentPane().add(jb_juega, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 120, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 91, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ghosts_Proyecto/res/3299645895_19639a3730.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_MiperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_MiperfilActionPerformed
        mip.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jb_MiperfilActionPerformed

    private void jb_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_SalirActionPerformed
        JOptionPane.showMessageDialog(null,"A cerrado sesion","Nos vemos luego",JOptionPane.INFORMATION_MESSAGE);
        MainProyecto.m.setVisible(true);//etso hace que se abra la ventana de Menu_inicio
        this.dispose();//aca se cierra esta ventana actual
    }//GEN-LAST:event_jb_SalirActionPerformed

    private void jb_ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ConfiguracionActionPerformed
        mc.setVisible(true);
        this.dispose();//aca se cierra esta ventana actual
    }//GEN-LAST:event_jb_ConfiguracionActionPerformed

    private void jb_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ReportesActionPerformed
        Menu_reportes mr =new Menu_reportes();
        mr.setVisible(true);
        this.dispose();//aca se cierra esta ventana actual
    }//GEN-LAST:event_jb_ReportesActionPerformed

    private void jb_juegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_juegaActionPerformed
        cmj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jb_juegaActionPerformed

    private void jb_JugarGhostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_JugarGhostActionPerformed
        p2 =new Player_2();
        p2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jb_JugarGhostActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jb_Configuracion;
    private javax.swing.JButton jb_JugarGhost;
    private javax.swing.JButton jb_Miperfil;
    private javax.swing.JButton jb_Reportes;
    private javax.swing.JButton jb_Salir;
    private javax.swing.JButton jb_juega;
    // End of variables declaration//GEN-END:variables
}
