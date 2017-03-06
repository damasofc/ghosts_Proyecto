
package ghosts_Proyecto;

import javax.swing.JOptionPane;


public class Menu_principal extends javax.swing.JFrame {

    
    public Menu_principal() {
        initComponents();
        jLabel3.setText(Menu_InicioSesion.nombreUsuarioActiv);
        jLabel3.setVisible(true);
        setLocationRelativeTo(null);//esto hace que la panatalla aparezca en medio
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Menu Principal");
        jLabel1.setMaximumSize(new java.awt.Dimension(70, 30));

        jb_JugarGhost.setText("Jugar Ghost");
        jb_JugarGhost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_JugarGhostActionPerformed(evt);
            }
        });

        jb_Configuracion.setText("Configuracion");
        jb_Configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ConfiguracionActionPerformed(evt);
            }
        });

        jb_Reportes.setText("Reportes");
        jb_Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ReportesActionPerformed(evt);
            }
        });

        jb_Miperfil.setText("Mi Perfil");
        jb_Miperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_MiperfilActionPerformed(evt);
            }
        });

        jb_Salir.setText("Cerrar Sesion");
        jb_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_SalirActionPerformed(evt);
            }
        });

        jb_juega.setText("Como se juega");
        jb_juega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_juegaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jb_Salir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 340, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jb_JugarGhost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_Configuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_Reportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_Miperfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jb_juega))))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jb_JugarGhost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_Configuracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_Reportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_Miperfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_juega)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_Salir)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_MiperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_MiperfilActionPerformed
       this.dispose();//aca se cierra esta ventana actual
       Mi_perfil mip=new Mi_perfil();
       mip.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jb_MiperfilActionPerformed

    private void jb_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_SalirActionPerformed
this.dispose();//esto hace que al apretar el boton salir, se cierre el programa 
JOptionPane.showMessageDialog(null,"A cerrado sesion","Nos vemos luego",JOptionPane.INFORMATION_MESSAGE);
MainProyecto.m.setVisible(true);//etso hace que se abra la ventana de Menu_inicio
this.dispose();//aca se cierra esta ventana actual
    }//GEN-LAST:event_jb_SalirActionPerformed

    private void jb_ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ConfiguracionActionPerformed
        Menu_configuracion mc=new Menu_configuracion();
        mc.setVisible(true);
        this.dispose();//aca se cierra esta ventana actual
    }//GEN-LAST:event_jb_ConfiguracionActionPerformed

    private void jb_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ReportesActionPerformed
        Menu_reportes mr=new Menu_reportes();
        mr.setVisible(true);
        this.dispose();//aca se cierra esta ventana actual
    }//GEN-LAST:event_jb_ReportesActionPerformed

    private void jb_juegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_juegaActionPerformed
        Como_jugar cmj= new Como_jugar();
        cmj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jb_juegaActionPerformed

    private void jb_JugarGhostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_JugarGhostActionPerformed
        Player_2 p2=new Player_2();
        p2.setVisible(true);
        this.setVisible(false);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jb_Configuracion;
    private javax.swing.JButton jb_JugarGhost;
    private javax.swing.JButton jb_Miperfil;
    private javax.swing.JButton jb_Reportes;
    private javax.swing.JButton jb_Salir;
    private javax.swing.JButton jb_juega;
    // End of variables declaration//GEN-END:variables
}
