/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.reports;

import java.text.SimpleDateFormat;
import model.Licencia;

/**
 *
 * @author Facundo
 */
public class LicenciaReportModel {
    
    private String documento;
    private String titular;
    private String clase;
    private String emision;
    private String vencimiento;

    public LicenciaReportModel() {
    }

    public LicenciaReportModel(Licencia licencia){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        this.documento=licencia.getTitular().getTipoDocumento().toString()+" "+licencia.getTitular().getCodigoDocumento();
        this.titular=licencia.getTitular().getApellido()+", "+licencia.getTitular().getNombre();
        this.clase=licencia.getClaseLicenciaEnum().toString();
        this.emision=sdf.format(licencia.getFechaEmision());
        this.vencimiento=sdf.format(licencia.getFechaVencimiento());
    }
    
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getEmision() {
        return emision;
    }

    public void setEmision(String emision) {
        this.emision = emision;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }
    
    
    
}
