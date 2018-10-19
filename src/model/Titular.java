/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collections;
import java.util.Date;
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
    
    private Date fechaNac;
    
    private Set<String> clasesSolicitadas;    
    
    //Constructores
    public Titular() {}
    
    public Titular(int id, String codigoDocumento, TipoDocumentoEnum tipoDocumento, String nombre, Date fechaNac, String apellido, String domicilio, GrupoSanguineoEnum grupoSanguineo, boolean factor, boolean donanteOrganos, Set clasesSolicitadas) {
        this.id = id;
        this.codigoDocumento = codigoDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.grupoSanguineo = grupoSanguineo;
        this.factor = factor;
        this.donanteOrganos = donanteOrganos;
        this.clasesSolicitadas = Collections.<String>emptySet();    //Crea un set vacio donde se agregaran las clases al emitir licencias
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

    public Date getFechaNac() {
        return fechaNac;
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

    public Set<String> getClasesSolicitadas() {
        return clasesSolicitadas;
    }

    public void setClasesSolicitadas(Set<String> clasesSolicitadas) {
        this.clasesSolicitadas = clasesSolicitadas;
    }
    
    
}
