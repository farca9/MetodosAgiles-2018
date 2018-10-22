/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    
    private List<Licencia> licencias;  
    
    private Date fechaNacimiento;

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //Constructores
    public Titular() {}
    
    public Titular(String codigoDocumento, TipoDocumentoEnum tipoDocumento, String nombre, String apellido, String domicilio, GrupoSanguineoEnum grupoSanguineo, boolean factor, boolean donanteOrganos, Date fechaNacimiento) {
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

    public List<Licencia> getLicencias() {
        return licencias;
    }

    public void setLicencias(List<Licencia> licencias) {
        this.licencias=licencias;
    }
    
    
}
