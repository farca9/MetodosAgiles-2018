/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.gui.prints;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import model.Licencia;
import model.Titular;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author lau_9
 */
public class UserPreviewCarnetPopUp extends javax.swing.JFrame {

    private int posicion;
    private List<Licencia> recorrido;
    private Titular titular;
    /** Creates new form UserPreviewCarnetPopUp */
    public UserPreviewCarnetPopUp() {
        initComponents();
    }

    public UserPreviewCarnetPopUp(Titular titular, List<Licencia> licencias) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Vista previa: "+ titular.getApellido() +", " + titular.getNombre());
        this.titular = titular;
        this.recorrido = licencias;
        this.posicion = 0;
        btnAnterior.setEnabled(false);
        if(licencias.size() == 1){
            btnSiguiente.setEnabled(false);
        }
        pnlCarnet.setOpaque(true);
        pnlCarnet.setBackground(new java.awt.Color(255, 206, 123));
        pnlDatosLicencia.setOpaque(true);
        pnlDatosLicencia.setBackground(new java.awt.Color(255, 206, 123));
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(new java.awt.Color(255, 162, 5));
        lblGobierno.setOpaque(true);
        lblGobierno.setBackground(new java.awt.Color(255, 162, 5));
    
        this.completarCarnet(titular,recorrido,posicion);
    }    
    
    public void completarCarnet(Titular titular, List<Licencia> recorridoLicencias, int pos){    
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        lblLicencia.setText(titular.getCodigoDocumento());
        lblApellido.setText(titular.getApellido());
        lblNombre.setText(titular.getNombre());
        lblFechaNac.setText(simpleDateFormat.format(titular.getFechaNacimiento()));
        lblDomicilio.setText(titular.getDomicilio());
        lblOtorgamiento.setText(simpleDateFormat.format(recorridoLicencias.get(pos).getFechaEmision()));
        lblVencimiento.setText(simpleDateFormat.format(recorridoLicencias.get(pos).getFechaVencimiento()));
        lblClase.setText(recorridoLicencias.get(pos).getClaseLicenciaEnum().name());
        lblGrupo.setText(titular.getGrupoSanguineo().name());
        String factor;
        if(titular.isFactor()){
            factor = "+";
        }else{
            factor = "-";
        }
        lblFactor.setText(factor);
        lblObservaciones.setText(recorridoLicencias.get(pos).getObservacion());       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbarOperaciones = new javax.swing.JToolBar();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        pnlCarnet = new javax.swing.JPanel();
        lblFotoTitular = new javax.swing.JLabel();
        lblGobierno = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        pnlDatosLicencia = new javax.swing.JPanel();
        lblTLicencia = new javax.swing.JLabel();
        lblTApellido = new javax.swing.JLabel();
        lblTNombre = new javax.swing.JLabel();
        lblTFechaNac = new javax.swing.JLabel();
        lblTDomicilio = new javax.swing.JLabel();
        lblTOtorgamiento = new javax.swing.JLabel();
        lblTClase = new javax.swing.JLabel();
        lblLicencia = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblFechaNac = new javax.swing.JLabel();
        lblDomicilio = new javax.swing.JLabel();
        lblOtorgamiento = new javax.swing.JLabel();
        lblClase = new javax.swing.JLabel();
        lblTGrupo = new javax.swing.JLabel();
        lblGrupo = new javax.swing.JLabel();
        lblTObservaciones = new javax.swing.JLabel();
        lblTVencimiento = new javax.swing.JLabel();
        lblVencimiento = new javax.swing.JLabel();
        lblTFactor = new javax.swing.JLabel();
        lblFactor = new javax.swing.JLabel();
        lblObservaciones = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnImprimirActual = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(243, 207, 165));
        setType(java.awt.Window.Type.UTILITY);

        toolbarOperaciones.setRollover(true);

        btnAnterior.setFont(btnAnterior.getFont().deriveFont(btnAnterior.getFont().getStyle() & ~java.awt.Font.BOLD));
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/previous_mini.png"))); // NOI18N
        btnAnterior.setText("Anterior");
        btnAnterior.setFocusable(false);
        btnAnterior.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        toolbarOperaciones.add(btnAnterior);

        btnSiguiente.setFont(btnSiguiente.getFont().deriveFont(btnSiguiente.getFont().getStyle() & ~java.awt.Font.BOLD));
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/next_mini.png"))); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setFocusable(false);
        btnSiguiente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnSiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        toolbarOperaciones.add(btnSiguiente);

        lblFotoTitular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFotoTitular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/drawable/user.png"))); // NOI18N
        lblFotoTitular.setToolTipText("");
        lblFotoTitular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGobierno.setBackground(new java.awt.Color(255, 162, 5));
        lblGobierno.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblGobierno.setForeground(new java.awt.Color(255, 255, 255));
        lblGobierno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGobierno.setText("GOBIERNO DE LA CIUDAD DE SANTA FE");

        lblTitulo.setFont(new java.awt.Font("Gill Sans MT", 1, 30)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Licencia Municipal de Conducir - SFC");

        lblTLicencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTLicencia.setForeground(new java.awt.Color(0, 0, 0));
        lblTLicencia.setText("LICENCIA N°:");

        lblTApellido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTApellido.setForeground(new java.awt.Color(0, 0, 0));
        lblTApellido.setText("APELLIDO:");

        lblTNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblTNombre.setText("NOMBRE:");

        lblTFechaNac.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTFechaNac.setForeground(new java.awt.Color(0, 0, 0));
        lblTFechaNac.setText("FECHA DE NAC.:");

        lblTDomicilio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTDomicilio.setForeground(new java.awt.Color(0, 0, 0));
        lblTDomicilio.setText("DOMICILIO:");

        lblTOtorgamiento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTOtorgamiento.setForeground(new java.awt.Color(0, 0, 0));
        lblTOtorgamiento.setText("OTORGAMIENTO:");

        lblTClase.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTClase.setForeground(new java.awt.Color(0, 0, 0));
        lblTClase.setText("CLASE:");

        lblLicencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        lblApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblFechaNac.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblDomicilio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblOtorgamiento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblClase.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        lblTGrupo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTGrupo.setForeground(new java.awt.Color(0, 0, 0));
        lblTGrupo.setText("GRUPO SANGUINEO:");

        lblGrupo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblTObservaciones.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTObservaciones.setForeground(new java.awt.Color(0, 0, 0));
        lblTObservaciones.setText("OBSERVACIONES:");

        lblTVencimiento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTVencimiento.setForeground(new java.awt.Color(0, 0, 0));
        lblTVencimiento.setText("VENCIMIENTO:");

        lblVencimiento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        lblTFactor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTFactor.setForeground(new java.awt.Color(0, 0, 0));
        lblTFactor.setText("FACTOR:");

        lblFactor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblObservaciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblObservaciones.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlDatosLicenciaLayout = new javax.swing.GroupLayout(pnlDatosLicencia);
        pnlDatosLicencia.setLayout(pnlDatosLicenciaLayout);
        pnlDatosLicenciaLayout.setHorizontalGroup(
            pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLicenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTObservaciones, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTFechaNac, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTDomicilio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTLicencia, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlDatosLicenciaLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblTOtorgamiento)
                                .addComponent(lblTVencimiento)
                                .addComponent(lblTClase)))
                        .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTGrupo)
                            .addComponent(lblTFactor))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLicenciaLayout.createSequentialGroup()
                        .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLicencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addComponent(lblOtorgamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLicenciaLayout.createSequentialGroup()
                        .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblVencimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGrupo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFactor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(pnlDatosLicenciaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDatosLicenciaLayout.setVerticalGroup(
            pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLicenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTLicencia)
                    .addComponent(lblLicencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTNombre)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTFechaNac)
                    .addComponent(lblFechaNac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTDomicilio)
                    .addComponent(lblDomicilio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLicenciaLayout.createSequentialGroup()
                        .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLicenciaLayout.createSequentialGroup()
                                .addComponent(lblTOtorgamiento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTVencimiento)
                                    .addComponent(lblVencimiento)))
                            .addGroup(pnlDatosLicenciaLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTClase)
                                    .addComponent(lblClase))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTGrupo)
                            .addComponent(lblGrupo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTFactor)
                            .addComponent(lblFactor)))
                    .addComponent(lblOtorgamiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTObservaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlCarnetLayout = new javax.swing.GroupLayout(pnlCarnet);
        pnlCarnet.setLayout(pnlCarnetLayout);
        pnlCarnetLayout.setHorizontalGroup(
            pnlCarnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarnetLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblFotoTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatosLicencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
            .addComponent(lblGobierno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCarnetLayout.setVerticalGroup(
            pnlCarnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarnetLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCarnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlDatosLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFotoTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGobierno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jToolBar1.setRollover(true);

        btnImprimirActual.setFont(btnImprimirActual.getFont().deriveFont(btnImprimirActual.getFont().getStyle() & ~java.awt.Font.BOLD));
        btnImprimirActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons/printer_mini.png"))); // NOI18N
        btnImprimirActual.setText("Imprimir");
        btnImprimirActual.setToolTipText("");
        btnImprimirActual.setFocusable(false);
        btnImprimirActual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnImprimirActual.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnImprimirActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActualActionPerformed(evt);
            }
        });
        jToolBar1.add(btnImprimirActual);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCarnet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbarOperaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toolbarOperaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        if(posicion == 1){
            this.btnAnterior.setEnabled(false);
        }
        if(posicion == recorrido.size()-1){
            this.btnSiguiente.setEnabled(true);
        }
            this.completarCarnet(titular,recorrido,--posicion);

    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
 
        if(posicion+1 == recorrido.size()-1){
            this.btnSiguiente.setEnabled(false);
        }
        if(posicion == 0){
            this.btnAnterior.setEnabled(true);
        }
        this.completarCarnet(titular,recorrido,++posicion);

    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnImprimirActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActualActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            
           JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile("src/view/reports/Carnet.jasper");
           
           //Pasaje del parametros del reporte
           HashMap<String,Object> parameters = new HashMap();
           parameters.put("codigoDocumento", titular.getCodigoDocumento());
           parameters.put("apellido", titular.getApellido());
           parameters.put("nombre", titular.getNombre());
           parameters.put("fechaNac", sdf.format(titular.getFechaNacimiento()));
           parameters.put("domicilio", titular.getDomicilio());
           parameters.put("grupoSanguineo", titular.getGrupoSanguineo().name());
           if(titular.isFactor()){
               parameters.put("factor", "+");
           } else {
               parameters.put("factor", "-");
           }
               
           parameters.put("emision", sdf.format(recorrido.get(posicion).getFechaEmision()));
           parameters.put("vencimiento", sdf.format(recorrido.get(posicion).getFechaVencimiento()));
           parameters.put("clase", recorrido.get(posicion).getClaseLicenciaEnum().name());
           parameters.put("observaciones", recorrido.get(posicion).getObservacion());
               
           JasperPrint jp = JasperFillManager.fillReport(jr, parameters, new JREmptyDataSource());
           JasperViewer jv = new JasperViewer(jp,false);
           jv.show();

            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnImprimirActualActionPerformed

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
            java.util.logging.Logger.getLogger(UserPreviewCarnetPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPreviewCarnetPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPreviewCarnetPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPreviewCarnetPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPreviewCarnetPopUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnImprimirActual;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblClase;
    private javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblFactor;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblFotoTitular;
    private javax.swing.JLabel lblGobierno;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JLabel lblLicencia;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblOtorgamiento;
    private javax.swing.JLabel lblTApellido;
    private javax.swing.JLabel lblTClase;
    private javax.swing.JLabel lblTDomicilio;
    private javax.swing.JLabel lblTFactor;
    private javax.swing.JLabel lblTFechaNac;
    private javax.swing.JLabel lblTGrupo;
    private javax.swing.JLabel lblTLicencia;
    private javax.swing.JLabel lblTNombre;
    private javax.swing.JLabel lblTObservaciones;
    private javax.swing.JLabel lblTOtorgamiento;
    private javax.swing.JLabel lblTVencimiento;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVencimiento;
    private javax.swing.JPanel pnlCarnet;
    private javax.swing.JPanel pnlDatosLicencia;
    private javax.swing.JToolBar toolbarOperaciones;
    // End of variables declaration//GEN-END:variables

}
