/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.gui.abm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.GrupoSanguineoEnum;
import model.TipoDocumentoEnum;
import model.Titular;
import util.LengthRestrictedDocument;

/**
 *
 * @author Facundo
 */
public class UserEmitirLicencia extends javax.swing.JFrame {

    private List<Titular> titulares;
    
    /**
     * Creates new form UserEmitirLicencia
     */
    public UserEmitirLicencia() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        txtFiltro.setDocument(new LengthRestrictedDocument(60));
        txtFiltro.setEnabled(false);
        
        radioGroup.add(radioA);
        radioGroup.add(radioB);
        radioGroup.add(radioC);
        radioGroup.add(radioD);
        radioGroup.add(radioE);
        radioGroup.add(radioF);
        radioGroup.add(radioG);
        
        radioA.setEnabled(false);
        radioB.setEnabled(false);
        radioC.setEnabled(false);
        radioD.setEnabled(false);
        radioE.setEnabled(false);
        radioF.setEnabled(false);
        radioG.setEnabled(false);
        
        btnEmitirLicencia.setEnabled(false);
        
        tableTitulares.setRowSelectionAllowed(true);
        tableTitulares.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableTitulares.getTableHeader().setReorderingAllowed(false);
        
        tableTitulares.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            
            if(tableTitulares.getSelectedRow() == -1) return;
            
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            radioA.setEnabled(true);
            radioB.setEnabled(true);
            radioC.setEnabled(true);
            radioD.setEnabled(true);
            radioE.setEnabled(true);
            radioF.setEnabled(true);
            radioG.setEnabled(true);
            
            Titular t = titulares.get(tableTitulares.getSelectedRow());
            labelNombre.setText("Nombre: "+t.getNombre());
            labelApellido.setText("Apellido: "+t.getApellido());
            labelTipoNroDocumento.setText("Documento: "+t.getTipoDocumento().toString()+" "+t.getCodigoDocumento());
            labelDomicilio.setText("Domicilio: "+t.getDomicilio());
            labelFechaNacimiento.setText("Fecha de nacimiento: "+simpleDateFormat.format(t.getFechaNacimiento()));
            String factor;
            if(t.isFactor()) factor="+";
            else factor="-";
            labelGrupoFactorSanguineo.setText("Grupo Sanguineo: "+t.getGrupoSanguineo().toString()+" "+factor);
            String donante;
            if(t.isDonanteOrganos()) donante="SI DONA ORGANOS";
            else donante="NO DONA ORGANOS";
            labelDonanteOrganos.setText(donante);
            
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

        radioGroup = new javax.swing.ButtonGroup();
        lblSantaFe = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblEmitirLicencia = new javax.swing.JLabel();
        pnlTitulares = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTitulares = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();
        btnFiltroNombre = new javax.swing.JButton();
        btnFiltroApellido = new javax.swing.JButton();
        btnFiltroDocumento = new javax.swing.JButton();
        btnAplicarFiltro = new javax.swing.JButton();
        btnLimpiarFiltro = new javax.swing.JButton();
        pnlClaseLicencia = new javax.swing.JPanel();
        radioA = new javax.swing.JRadioButton();
        radioB = new javax.swing.JRadioButton();
        radioC = new javax.swing.JRadioButton();
        radioD = new javax.swing.JRadioButton();
        radioE = new javax.swing.JRadioButton();
        radioF = new javax.swing.JRadioButton();
        radioG = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaClaseLicencia = new javax.swing.JTextArea();
        btnEmitirLicencia = new javax.swing.JButton();
        pnlDatosTitular = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelTipoNroDocumento = new javax.swing.JLabel();
        labelDomicilio = new javax.swing.JLabel();
        labelFechaNacimiento = new javax.swing.JLabel();
        labelGrupoFactorSanguineo = new javax.swing.JLabel();
        labelDonanteOrganos = new javax.swing.JLabel();
        pnlObservaciones = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaObservaciones = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblSantaFe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSantaFe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/drawable/logo-santafe.png"))); // NOI18N
        lblSantaFe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Seleccione el titular y el tipo de licencia a emitir");

        lblEmitirLicencia.setFont(lblEmitirLicencia.getFont().deriveFont(lblEmitirLicencia.getFont().getSize()+6f));
        lblEmitirLicencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmitirLicencia.setText("EMITIR UNA LICENCIA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(lblEmitirLicencia))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jLabel1)))
                .addGap(344, 344, 344))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEmitirLicencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTitulares.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione el titular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), java.awt.SystemColor.textHighlight)); // NOI18N

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
        jScrollPane1.setViewportView(tableTitulares);

        txtFiltro.setFont(txtFiltro.getFont().deriveFont(txtFiltro.getFont().getSize()+4f));

        btnFiltroNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/filter_mini.png"))); // NOI18N
        btnFiltroNombre.setText("Nombre");
        btnFiltroNombre.setToolTipText("Filtre a los contribuyentes por su nombre.");
        btnFiltroNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroNombreActionPerformed(evt);
            }
        });

        btnFiltroApellido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/filter_mini.png"))); // NOI18N
        btnFiltroApellido.setText("Apellido");
        btnFiltroApellido.setToolTipText("Filtre a los contribuyentes por su apellido.");
        btnFiltroApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroApellidoActionPerformed(evt);
            }
        });

        btnFiltroDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/filter_mini.png"))); // NOI18N
        btnFiltroDocumento.setText("N° Documento");
        btnFiltroDocumento.setToolTipText("Filtre a los contribuyentes por su N° de documento.");
        btnFiltroDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroDocumentoActionPerformed(evt);
            }
        });

        btnAplicarFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/search_mini.png"))); // NOI18N
        btnAplicarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarFiltroActionPerformed(evt);
            }
        });

        btnLimpiarFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/cancel_mini.png"))); // NOI18N
        btnLimpiarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTitularesLayout = new javax.swing.GroupLayout(pnlTitulares);
        pnlTitulares.setLayout(pnlTitularesLayout);
        pnlTitularesLayout.setHorizontalGroup(
            pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitularesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlTitularesLayout.createSequentialGroup()
                        .addComponent(btnFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltroApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltroDocumento)
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(pnlTitularesLayout.createSequentialGroup()
                        .addComponent(txtFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAplicarFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiarFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlTitularesLayout.setVerticalGroup(
            pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitularesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltroNombre)
                    .addComponent(btnFiltroApellido)
                    .addComponent(btnFiltroDocumento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTitularesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAplicarFiltro)
                    .addComponent(btnLimpiarFiltro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlClaseLicencia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione la clase de licencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), java.awt.SystemColor.textHighlight)); // NOI18N

        radioA.setText("A");
        radioA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAActionPerformed(evt);
            }
        });

        radioB.setText("B");

        radioC.setText("C");

        radioD.setText("D");
        radioD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDActionPerformed(evt);
            }
        });

        radioE.setText("E");

        radioF.setText("F");

        radioG.setText("G");

        txtAreaClaseLicencia.setEditable(false);
        txtAreaClaseLicencia.setColumns(20);
        txtAreaClaseLicencia.setRows(5);
        jScrollPane3.setViewportView(txtAreaClaseLicencia);

        javax.swing.GroupLayout pnlClaseLicenciaLayout = new javax.swing.GroupLayout(pnlClaseLicencia);
        pnlClaseLicencia.setLayout(pnlClaseLicenciaLayout);
        pnlClaseLicenciaLayout.setHorizontalGroup(
            pnlClaseLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClaseLicenciaLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(pnlClaseLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioB)
                    .addComponent(radioA)
                    .addComponent(radioC))
                .addGap(74, 74, 74)
                .addGroup(pnlClaseLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClaseLicenciaLayout.createSequentialGroup()
                        .addGroup(pnlClaseLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioF)
                            .addComponent(radioE))
                        .addContainerGap(193, Short.MAX_VALUE))
                    .addGroup(pnlClaseLicenciaLayout.createSequentialGroup()
                        .addComponent(radioD)
                        .addGap(74, 74, 74)
                        .addComponent(radioG)
                        .addGap(69, 69, 69))))
            .addGroup(pnlClaseLicenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        pnlClaseLicenciaLayout.setVerticalGroup(
            pnlClaseLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClaseLicenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClaseLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioA)
                    .addComponent(radioD)
                    .addComponent(radioG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlClaseLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioB)
                    .addComponent(radioE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlClaseLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioC)
                    .addComponent(radioF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnEmitirLicencia.setText("Emitir Licencia");
        btnEmitirLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirLicenciaActionPerformed(evt);
            }
        });

        pnlDatosTitular.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del titular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), java.awt.SystemColor.textHighlight)); // NOI18N

        labelNombre.setText(" ");

        labelApellido.setText(" ");

        labelTipoNroDocumento.setText(" ");

        labelDomicilio.setText(" ");

        labelFechaNacimiento.setText(" ");

        labelGrupoFactorSanguineo.setText(" ");

        labelDonanteOrganos.setText(" ");

        javax.swing.GroupLayout pnlDatosTitularLayout = new javax.swing.GroupLayout(pnlDatosTitular);
        pnlDatosTitular.setLayout(pnlDatosTitularLayout);
        pnlDatosTitularLayout.setHorizontalGroup(
            pnlDatosTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosTitularLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTipoNroDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGrupoFactorSanguineo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDonanteOrganos, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDatosTitularLayout.setVerticalGroup(
            pnlDatosTitularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosTitularLayout.createSequentialGroup()
                .addComponent(labelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTipoNroDocumento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDomicilio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFechaNacimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelGrupoFactorSanguineo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelDonanteOrganos)
                .addContainerGap())
        );

        pnlObservaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), java.awt.SystemColor.textHighlight)); // NOI18N

        txtAreaObservaciones.setColumns(20);
        txtAreaObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtAreaObservaciones);

        javax.swing.GroupLayout pnlObservacionesLayout = new javax.swing.GroupLayout(pnlObservaciones);
        pnlObservaciones.setLayout(pnlObservacionesLayout);
        pnlObservacionesLayout.setHorizontalGroup(
            pnlObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlObservacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        pnlObservacionesLayout.setVerticalGroup(
            pnlObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlObservacionesLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEmitirLicencia)
                .addGap(383, 383, 383))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSantaFe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pnlTitulares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pnlClaseLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlDatosTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSantaFe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlClaseLicencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTitulares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatosTitular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmitirLicencia)
                .addGap(10, 10, 10))
        );

        pnlTitulares.getAccessibleContext().setAccessibleName("Seleccione el titular");

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

    private void btnLimpiarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltroActionPerformed
        btnFiltroNombre.setEnabled(true);
        btnFiltroApellido.setEnabled(true);
        btnFiltroDocumento.setEnabled(true);
        txtFiltro.setText("");
        txtFiltro.setEnabled(false);
        btnAplicarFiltro.setEnabled(false);
        btnLimpiarFiltro.setEnabled(false);

    }//GEN-LAST:event_btnLimpiarFiltroActionPerformed

    
    
    private void btnEmitirLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirLicenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmitirLicenciaActionPerformed

    private void radioAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioAActionPerformed

    private void radioDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDActionPerformed

    private void btnAplicarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarFiltroActionPerformed
        
        String filtro = txtFiltro.getText();
        
        if(!txtFiltro.isEnabled()){
            titulares=new ArrayList();
            //Busca todos los titulares
        } else if (btnFiltroNombre.isEnabled()){
            titulares=new ArrayList();
            //Busca filtrando por nombre
        } else if (btnFiltroApellido.isEnabled()){
            titulares=new ArrayList();
            //Busca filtrando por apellido
        } else if (btnFiltroDocumento.isEnabled()){
            titulares=new ArrayList();
            //Busca filtrando por documento
        } else titulares=new ArrayList();
        
        DefaultTableModel model = (DefaultTableModel)tableTitulares.getModel();
        model.setRowCount(0);
        
        for(int i=0;i<titulares.size();i++){
            Titular titular = titulares.get(i);
            Object[] fila = {titular.getNombre(),titular.getApellido(),titular.getTipoDocumento().toString(),titular.getCodigoDocumento()};
            model.addRow(fila);
        }
        
    }//GEN-LAST:event_btnAplicarFiltroActionPerformed

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
            java.util.logging.Logger.getLogger(UserEmitirLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserEmitirLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserEmitirLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserEmitirLicencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserEmitirLicencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarFiltro;
    private javax.swing.JButton btnEmitirLicencia;
    private javax.swing.JButton btnFiltroApellido;
    private javax.swing.JButton btnFiltroDocumento;
    private javax.swing.JButton btnFiltroNombre;
    private javax.swing.JButton btnLimpiarFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelDomicilio;
    private javax.swing.JLabel labelDonanteOrganos;
    private javax.swing.JLabel labelFechaNacimiento;
    private javax.swing.JLabel labelGrupoFactorSanguineo;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTipoNroDocumento;
    private javax.swing.JLabel lblEmitirLicencia;
    private javax.swing.JLabel lblSantaFe;
    private javax.swing.JPanel pnlClaseLicencia;
    private javax.swing.JPanel pnlDatosTitular;
    private javax.swing.JPanel pnlObservaciones;
    private javax.swing.JPanel pnlTitulares;
    private javax.swing.JRadioButton radioA;
    private javax.swing.JRadioButton radioB;
    private javax.swing.JRadioButton radioC;
    private javax.swing.JRadioButton radioD;
    private javax.swing.JRadioButton radioE;
    private javax.swing.JRadioButton radioF;
    private javax.swing.JRadioButton radioG;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JTable tableTitulares;
    private javax.swing.JTextArea txtAreaClaseLicencia;
    private javax.swing.JTextArea txtAreaObservaciones;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}