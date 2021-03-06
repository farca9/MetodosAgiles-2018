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
import view.gui.abm.AdminModificarTitular;
import view.gui.login.MainMenu;

/**
 *
 * @author lau_9
 */
public class AdminMenu extends javax.swing.JFrame {

    /**
     * Creates new form adminMenu
     */
    public AdminMenu() {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddUser = new javax.swing.JButton();
        btnEditUser = new javax.swing.JButton();
        btnEditTitular = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblSantaFe = new javax.swing.JLabel();
        lblAdministrador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GLC | SFC - Menu");
        setResizable(false);

        btnAddUser.setFont(btnAddUser.getFont().deriveFont(btnAddUser.getFont().getSize()+3f));
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/add_user.png"))); // NOI18N
        btnAddUser.setText("Agregar Usuarios");
        btnAddUser.setEnabled(false);
        btnAddUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddUser.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnAddUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnEditUser.setFont(btnEditUser.getFont().deriveFont(btnEditUser.getFont().getSize()+3f));
        btnEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/edit_user.png"))); // NOI18N
        btnEditUser.setText("Editar Datos de Usuarios");
        btnEditUser.setEnabled(false);
        btnEditUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditUser.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEditUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnEditTitular.setFont(btnEditTitular.getFont().deriveFont(btnEditTitular.getFont().getSize()+3f));
        btnEditTitular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/edit_titular.png"))); // NOI18N
        btnEditTitular.setText("Editar Datos de Titulares");
        btnEditTitular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditTitular.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEditTitular.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTitularActionPerformed(evt);
            }
        });

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/logout2.png"))); // NOI18N
        btnLogout.setToolTipText("Cerrar Sesión");
        btnLogout.setBorderPainted(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblSantaFe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/drawable/logo-santafe.png"))); // NOI18N
        lblSantaFe.setText("jLabel1");

        lblAdministrador.setFont(lblAdministrador.getFont().deriveFont(lblAdministrador.getFont().getSize()+6f));
        lblAdministrador.setText("ADMINISTRADOR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditTitular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAdministrador))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSantaFe, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSantaFe, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAdministrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditTitular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new MainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnEditTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTitularActionPerformed
        new AdminModificarTitular().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditTitularActionPerformed

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
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnEditTitular;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel lblAdministrador;
    private javax.swing.JLabel lblSantaFe;
    // End of variables declaration//GEN-END:variables
}
