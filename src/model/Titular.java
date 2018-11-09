/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author lau_9
 */

@Entity
public class Titular {

    //Atributos
    @Id
    @GeneratedValue
    private int id;
    
    private String codigoDocumento;

    private TipoDocumentoEnum tipoDocumento;
    
    private String nombre;
    
    private String apellido;
    
    private String domicilio;
    
    private GrupoSanguineoEnum grupoSanguineo;
   
    private boolean factor; //1 si es '+' -- 0 si es '-'
    
    private boolean donanteOrganos;
    
    private String observaciones;
    
    @OneToMany(targetEntity = Licencia.class, mappedBy="titular", cascade = CascadeType.PERSIST)
    private Collection<Licencia> licencias;  
    
    private Date fechaNacimiento;
   
    //Constructores
    public Titular() {}
    
    public Titular(String codigoDocumento, TipoDocumentoEnum tipoDocumento, String nombre, String apellido, String domicilio, GrupoSanguineoEnum grupoSanguineo, boolean factor, boolean donanteOrganos, Date fechaNacimient, String observaciones) {
        this.codigoDocumento = codigoDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.grupoSanguineo = grupoSanguineo;
        this.factor = factor;
        this.donanteOrganos = donanteOrganos;
        this.licencias = new ArrayList();
        this.fechaNacimiento = fechaNacimiento;
        this.observaciones = observaciones;
    }

    //Metodos    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setCodigoDocumento(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public TipoDocumentoEnum getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoEnum tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public GrupoSanguineoEnum getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(GrupoSanguineoEnum grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
   
    public boolean isFactor() {
        return factor;
    }

    public void setFactor(boolean factor) {
        this.factor = factor;
    }

    public boolean isDonanteOrganos() {
        return donanteOrganos;
    }

    public void setDonanteOrganos(boolean donanteOrganos) {
        this.donanteOrganos = donanteOrganos;
    }

    public Collection<Licencia> getLicencias() {
        return licencias;
    }

    public void setLicencias(List<Licencia> licencias) {
        this.licencias=licencias;
    }
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public boolean haveLicencia(ClaseLicenciaEnum clase){
        
        Boolean result = false;
        
        
        for(Licencia l : licencias){
            if (l.getClaseLicenciaEnum() == clase){
                result = true;
            }
        }        
        
        return result;
    }
    
    public List<ClaseLicenciaEnum> getClases(){
        List<ClaseLicenciaEnum> clases = new ArrayList<ClaseLicenciaEnum>();
        for(Licencia lic : licencias){
            clases.add(lic.getClaseLicenciaEnum());
        }
        return clases;
    }
    
    /*public List<Date> getFechasMasProximas(){
        List<Date> fechas = new ArrayList();
        List<Date> fechasE = new ArrayList();
        List<Date> fechasV = new ArrayList();
        
        for(Licencia lic : licencias) fechasE.add(lic.getFechaEmision());
        for(Licencia lic : licencias) fechasV.add(lic.getFechaVencimiento());
        
        Collections.sort(fechasE);
        Collections.sort(fechasV);
        
        fechas.add(fechasE.get(0));
        fechas.add(fechasV.get(0));
        
        return fechas;
    }*/
    
    /*public Date getVencimientoMasProximo(){
        List<Date> fechasV = new ArrayList();
        Date fechaF = new Date();
        Date fechaA = new Date();
            
        for(Licencia lic : licencias) fechasV.add(lic.getFechaVencimiento());
            
        Collections.sort(fechasV);
            
        for(Date f : fechasV){
            if(f.after(fechaA)){
                fechaF = f;
                break;
            }
        }
        
        return fechaF;
    }*/


}
