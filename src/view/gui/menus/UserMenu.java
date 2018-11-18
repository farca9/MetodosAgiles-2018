/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.gui.menus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import view.gui.abm.*;
import view.gui.list.UserLicenciasVencidas;
import view.gui.login.MainMenu;
import view.gui.prints.UserPrintCarnet;
import view.gui.prints.UserPrintCarnetCopy;
import view.gui.renew.UserRenovarPopUp;

/**
 *
 * @author lau_9
 */
public class UserMenu extends javax.swing.JFrame {

    /** Creates new form userMenu */
    public UserMenu() {
        //Inicializacion de la ventana
        ImageIcon logo = new ImageIcon("src/res/drawable/sfc_logo.jpg");
        Image icon = logo.getImage();
        this.setIconImage(icon);
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth()/2;
        double height = screenSize.getHeight()/2;
        this.setLocation((int)width-this.getWidth()/2,(int)height-this.getHeight()/2);
        btnLogout.setBackground(Color.red);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSantaFe = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnLicenciasVencidas = new javax.swing.JButton();
        btnAgregarTitular = new javax.swing.JButton();
        btnRenovarLicencias = new javax.swing.JButton();
        btnCambiarLicencias = new javax.swing.JButton();
        btnLicenciasVigentes = new javax.swing.JButton();
        btnEmitirLicencia = new javax.swing.JButton();
        btnCambiarLicencias1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GLC | SFC - Menu");
        setResizable(false);

        lblSantaFe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/drawable/logo-santafe.png"))); // NOI18N

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/logout2.png"))); // NOI18N
        btnLogout.setToolTipText("Cerrar Sesión");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnLicenciasVencidas.setFont(btnLicenciasVencidas.getFont().deriveFont(btnLicenciasVencidas.getFont().getSize()+3f));
        btnLicenciasVencidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/list_vencidas.png"))); // NOI18N
        btnLicenciasVencidas.setText("Listado de Licencias Vencidas");
        btnLicenciasVencidas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLicenciasVencidas.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnLicenciasVencidas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLicenciasVencidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLicenciasVencidasActionPerformed(evt);
            }
        });

        btnAgregarTitular.setFont(btnAgregarTitular.getFont().deriveFont(btnAgregarTitular.getFont().getSize()+3f));
        btnAgregarTitular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/add_titular.png"))); // NOI18N
        btnAgregarTitular.setText("Agregar Titulares");
        btnAgregarTitular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarTitular.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnAgregarTitular.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTitularActionPerformed(evt);
            }
        });

        btnRenovarLicencias.setFont(btnRenovarLicencias.getFont().deriveFont(btnRenovarLicencias.getFont().getSize()+3f));
        btnRenovarLicencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/renew_licencia.png"))); // NOI18N
        btnRenovarLicencias.setText("Renovar Licencias");
        btnRenovarLicencias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRenovarLicencias.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnRenovarLicencias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRenovarLicencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenovarLicenciasActionPerformed(evt);
            }
        });

        btnCambiarLicencias.setFont(btnCambiarLicencias.getFont().deriveFont(btnCambiarLicencias.getFont().getSize()+3f));
        btnCambiarLicencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/duplicate_licencia.png"))); // NOI18N
        btnCambiarLicencias.setText("Imprimir Copia de Carnet");
        btnCambiarLicencias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCambiarLicencias.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnCambiarLicencias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCambiarLicencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarLicenciasActionPerformed(evt);
            }
        });

        btnLicenciasVigentes.setFont(btnLicenciasVigentes.getFont().deriveFont(btnLicenciasVigentes.getFont().getSize()+3f));
        btnLicenciasVigentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/list_ok.png"))); // NOI18N
        btnLicenciasVigentes.setText("Listado de Licencias Vigentes");
        btnLicenciasVigentes.setEnabled(false);
        btnLicenciasVigentes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLicenciasVigentes.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnLicenciasVigentes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLicenciasVigentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLicenciasVigentesActionPerformed(evt);
            }
        });

        btnEmitirLicencia.setFont(btnEmitirLicencia.getFont().deriveFont(btnEmitirLicencia.getFont().getSize()+3f));
        btnEmitirLicencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/new_licencia.png"))); // NOI18N
        btnEmitirLicencia.setText("Emitir Licencia");
        btnEmitirLicencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmitirLicencia.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEmitirLicencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEmitirLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirLicenciaActionPerformed(evt);
            }
        });

        btnCambiarLicencias1.setFont(btnCambiarLicencias1.getFont().deriveFont(btnCambiarLicencias1.getFont().getSize()+3f));
        btnCambiarLicencias1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/print.png"))); // NOI18N
        btnCambiarLicencias1.setText("Imprimir Carnet");
        btnCambiarLicencias1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCambiarLicencias1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnCambiarLicencias1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCambiarLicencias1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarLicencias1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSantaFe, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmitirLicencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRenovarLicencias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCambiarLicencias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarTitular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLicenciasVencidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLicenciasVigentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCambiarLicencias1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSantaFe, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarTitular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmitirLicencia)
                .addGap(5, 5, 5)
                .addComponent(btnRenovarLicencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiarLicencias1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiarLicencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLicenciasVigentes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLicenciasVencidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new MainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLicenciasVencidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLicenciasVencidasActionPerformed
       new UserLicenciasVencidas().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnLicenciasVencidasActionPerformed

    private void btnAgregarTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTitularActionPerformed
        new UserAddTitular().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarTitularActionPerformed

    private void btnRenovarLicenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenovarLicenciasActionPerformed
        new UserRenovarPopUp().setVisible(true);
    }//GEN-LAST:event_btnRenovarLicenciasActionPerformed

    private void btnCambiarLicenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarLicenciasActionPerformed
        new UserPrintCarnetCopy().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCambiarLicenciasActionPerformed

    private void btnLicenciasVigentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLicenciasVigentesActionPerformed
        JOptionPane.showMessageDialog(null, "Funcionalidad en desarrollo.", "Atencion", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnLicenciasVigentesActionPerformed

    private void btnEmitirLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirLicenciaActionPerformed
        new UserEmitirLicencia().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEmitirLicenciaActionPerformed

    private void btnCambiarLicencias1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarLicencias1ActionPerformed
        new UserPrintCarnet().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCambiarLicencias1ActionPerformed

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
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarTitular;
    private javax.swing.JButton btnCambiarLicencias;
    private javax.swing.JButton btnCambiarLicencias1;
    private javax.swing.JButton btnEmitirLicencia;
    private javax.swing.JButton btnLicenciasVencidas;
    private javax.swing.JButton btnLicenciasVigentes;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRenovarLicencias;
    private javax.swing.JLabel lblSantaFe;
    // End of variables declaration//GEN-END:variables

}
