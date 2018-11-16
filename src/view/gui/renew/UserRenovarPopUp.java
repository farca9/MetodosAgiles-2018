/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.gui.renew;

import view.gui.list.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Titular;
import util.FiltroTitularesEnum;
import controller.*;
import java.awt.Color;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.ClaseLicenciaEnum;
import model.Licencia;
import util.TitularReceiver;

/**
 *
 * @author Laureano
 */
public class UserRenovarPopUp extends javax.swing.JFrame {

    private List<Titular> titulares;
    private JFrame self;
    private ClaseLicenciaEnum claseSeleccionada;
    
    /**
     * Creates new form UserRenovarPopUp
     */

    public UserRenovarPopUp() {
        ImageIcon logo = new ImageIcon("src/res/drawable/sfc_logo.jpg");
        Image icon = logo.getImage();
        this.setIconImage(icon);
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        tableTitulares.getTableHeader().setReorderingAllowed(false);
        tableTitulares.setRowSelectionAllowed(true);
        tableTitulares.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        self = this;
        
        btnGuardar.setEnabled(false);
        
        tableTitulares.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            
            if(tableTitulares.getSelectedRow() == -1){
                btnGuardar.setEnabled(false);
                return;
            }
            
            txtFiltro.setText("");
            txtFiltro.setEnabled(false);
            btnAplicarFiltro.setEnabled(false);
            btnLimpiarFiltro.setEnabled(true);            
            
            Titular t = titulares.get(tableTitulares.getSelectedRow());
            Collection<Licencia> l = t.getLicencias();
            List<String> clases = new ArrayList();
            clases.add("");
            
            for(Licencia lic : l){
                if(lic.isActiva()) clases.add(lic.getClaseLicenciaEnum().name());
            }
            
            Collections.sort(clases);
            cmbClases.setModel(new DefaultComboBoxModel(clases.toArray()));
            
            cmbClases.setEnabled(true);
            
            lblAviso.setText("");
        }
        });
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                self.dispose();
            }    
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitulares = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTitulares = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();
        btnFiltroNombre = new javax.swing.JButton();
        btnFiltroApellido = new javax.swing.JButton();
        btnAplicarFiltro = new javax.swing.JButton();
        btnLimpiarFiltro = new javax.swing.JButton();
        lblBuscarPor = new javax.swing.JLabel();
        btnFiltroDocumento = new javax.swing.JButton();
        cmbClases = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Renovar una licencia");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        tableTitulares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Tipo Documento", "N° Documento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTitulares.setRowHeight(20);
        jScrollPane1.setViewportView(tableTitulares);

        txtFiltro.setFont(txtFiltro.getFont().deriveFont(txtFiltro.getFont().getSize()+4f));
        txtFiltro.setEnabled(false);

        btnFiltroNombre.setFont(btnFiltroNombre.getFont().deriveFont(btnFiltroNombre.getFont().getSize()+2f));
        btnFiltroNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/filter_mini.png"))); // NOI18N
        btnFiltroNombre.setText("Nombre");
        btnFiltroNombre.setToolTipText("Filtre a los contribuyentes por su nombre.");
        btnFiltroNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroNombreActionPerformed(evt);
            }
        });

        btnFiltroApellido.setFont(btnFiltroApellido.getFont().deriveFont(btnFiltroApellido.getFont().getSize()+2f));
        btnFiltroApellido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/filter_mini.png"))); // NOI18N
        btnFiltroApellido.setText("Apellido");
        btnFiltroApellido.setToolTipText("Filtre a los contribuyentes por su apellido.");
        btnFiltroApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroApellidoActionPerformed(evt);
            }
        });

        btnAplicarFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/search_mini.png"))); // NOI18N
        btnAplicarFiltro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAplicarFiltro.setEnabled(false);
        btnAplicarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarFiltroActionPerformed(evt);
            }
        });

        btnLimpiarFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/cancel_mini.png"))); // NOI18N
        btnLimpiarFiltro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiarFiltro.setEnabled(false);
        btnLimpiarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFiltroActionPerformed(evt);
            }
        });

        lblBuscarPor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblBuscarPor.setForeground(java.awt.Color.black);
        lblBuscarPor.setText("Buscar titulares por...");

        btnFiltroDocumento.setFont(btnFiltroDocumento.getFont().deriveFont(btnFiltroDocumento.getFont().getSize()+2f));
        btnFiltroDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/filter_mini.png"))); // NOI18N
        btnFiltroDocumento.setText("Documento");
        btnFiltroDocumento.setToolTipText("Filtre a los contribuyentes por su N° de documento.");
        btnFiltroDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroDocumentoActionPerformed(evt);
            }
        });

        cmbClases.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cmbClases.setEnabled(false);
        cmbClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClasesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Clases");

        lblAviso.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N

        btnGuardar.setFont(btnGuardar.getFont().deriveFont(btnGuardar.getFont().getSize()+2f));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/save.png"))); // NOI18N
        btnGuardar.setText("Renovar");
        btnGuardar.setToolTipText("Guarde los datos del titular actual");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTitularesLayout = new javax.swing.GroupLayout(pnlTitulares);
        pnlTitulares.setLayout(pnlTitularesLayout);
        pnlTitularesLayout.setHorizontalGroup(
            pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitularesLayout.createSequentialGroup()
                .addGroup(pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTitularesLayout.createSequentialGroup()
                        .addGroup(pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTitularesLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblBuscarPor))
                            .addGroup(pnlTitularesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlTitularesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTitularesLayout.createSequentialGroup()
                                .addComponent(btnFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btnFiltroApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFiltroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlTitularesLayout.createSequentialGroup()
                                .addComponent(txtFiltro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAplicarFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiarFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlTitularesLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbClases, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(pnlTitularesLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTitularesLayout.setVerticalGroup(
            pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitularesLayout.createSequentialGroup()
                .addComponent(lblBuscarPor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlTitularesLayout.createSequentialGroup()
                        .addGroup(pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFiltroNombre)
                            .addComponent(btnFiltroApellido)
                            .addComponent(btnFiltroDocumento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFiltro)
                            .addComponent(btnAplicarFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiarFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbClases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitulares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTitulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltroNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroNombreActionPerformed
        btnFiltroApellido.setEnabled(false);
        btnFiltroDocumento.setEnabled(false);
        txtFiltro.setEnabled(true);
        btnAplicarFiltro.setEnabled(true);
        btnLimpiarFiltro.setEnabled(true);
    }//GEN-LAST:event_btnFiltroNombreActionPerformed

    private void btnFiltroApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroApellidoActionPerformed
        btnFiltroNombre.setEnabled(false);
        btnFiltroDocumento.setEnabled(false);
        txtFiltro.setEnabled(true);
        btnAplicarFiltro.setEnabled(true);
        btnLimpiarFiltro.setEnabled(true);
    }//GEN-LAST:event_btnFiltroApellidoActionPerformed

    private void btnFiltroDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroDocumentoActionPerformed
        btnFiltroNombre.setEnabled(false);
        btnFiltroApellido.setEnabled(false);
        txtFiltro.setEnabled(true);
        btnAplicarFiltro.setEnabled(true);
        btnLimpiarFiltro.setEnabled(true);
    }//GEN-LAST:event_btnFiltroDocumentoActionPerformed

    private void btnAplicarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarFiltroActionPerformed

        String filtro = txtFiltro.getText();

        if (btnFiltroNombre.isEnabled()){
            titulares = TitularController.getInstance().buscarTitulares(filtro, FiltroTitularesEnum.NOMBRE);
        } else if (btnFiltroApellido.isEnabled()){
            titulares = TitularController.getInstance().buscarTitulares(filtro, FiltroTitularesEnum.APELLIDO);
        } else if (btnFiltroDocumento.isEnabled()){
            titulares = TitularController.getInstance().buscarTitulares(filtro, FiltroTitularesEnum.DOCUMENTO);
        } else titulares = TitularController.getInstance().buscarTitulares(filtro, FiltroTitularesEnum.TODOS);

        DefaultTableModel model = (DefaultTableModel)tableTitulares.getModel();
        model.setRowCount(0);

        for(int i=0;i<titulares.size();i++){
            Titular titular = titulares.get(i);
            Object[] fila = {titular.getNombre(),titular.getApellido(),titular.getTipoDocumento().toString(),titular.getCodigoDocumento()};
            model.addRow(fila);
        }

    }//GEN-LAST:event_btnAplicarFiltroActionPerformed

    private void btnLimpiarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltroActionPerformed
        btnFiltroNombre.setEnabled(true);
        btnFiltroApellido.setEnabled(true);
        btnFiltroDocumento.setEnabled(true);

        txtFiltro.setText("");
        txtFiltro.setEnabled(false);
        btnAplicarFiltro.setEnabled(false);
        btnLimpiarFiltro.setEnabled(false);

        DefaultTableModel model = (DefaultTableModel)tableTitulares.getModel();
        model.setRowCount(0);
        
        cmbClases.setEnabled(false);
        lblAviso.setText("");
    }//GEN-LAST:event_btnLimpiarFiltroActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Titular t = titulares.get(tableTitulares.getSelectedRow());
        Collection<Licencia> licencias = t.getLicencias();
        
        for(Licencia lic : licencias){
            if(lic.getClaseLicenciaEnum().equals(claseSeleccionada)){
                lic.setActiva(false);
                LicenciaController.getInstance().inhabilitarLicencia(lic);
            }
        }
        
        if(LicenciaController.getInstance().crearLicencia(titulares.get(tableTitulares.getSelectedRow()), claseSeleccionada)){
            JOptionPane.showMessageDialog(null, "La licencia ha sido renovada con éxito. Se han inhabilitado todas las licencias anteriores clase " + claseSeleccionada.name() + ".", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido renovar la licencia.", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClasesActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Titular t = titulares.get(tableTitulares.getSelectedRow());
        Collection<Licencia> licencias = t.getLicencias();
        boolean ok = false;
        ClaseLicenciaEnum clase = null;
        String vencimiento = "";
       
        
        for(Licencia lic : licencias){
            if(lic.getClaseLicenciaEnum().name().equals(cmbClases.getSelectedItem())){
                if(lic.puedeRenovar() && lic.isActiva()){
                    ok = true;
                    clase = lic.getClaseLicenciaEnum();
                }
                vencimiento = sdf.format(lic.getFechaVencimiento());
            }
        }
        
        if(ok){
            lblAviso.setForeground(new Color(0,153,0));
            lblAviso.setText("La licencia puede ser renovada.");
            btnGuardar.setEnabled(true);
            claseSeleccionada = clase;
            
        } else {
            lblAviso.setForeground(new Color(153,0,0));
            lblAviso.setText("La licencia no puede ser renovada. Próximo vencimiento: " + vencimiento + ".");
            btnGuardar.setEnabled(false);
        }
        
        if(cmbClases.getSelectedItem().equals("")) lblAviso.setText("");
        
    }//GEN-LAST:event_cmbClasesActionPerformed

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
            java.util.logging.Logger.getLogger(UserRenovarPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRenovarPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRenovarPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRenovarPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRenovarPopUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarFiltro;
    private javax.swing.JButton btnFiltroApellido;
    private javax.swing.JButton btnFiltroDocumento;
    private javax.swing.JButton btnFiltroNombre;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiarFiltro;
    private javax.swing.JComboBox<String> cmbClases;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblBuscarPor;
    private javax.swing.JPanel pnlTitulares;
    private javax.swing.JTable tableTitulares;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
