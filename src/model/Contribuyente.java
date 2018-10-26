/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Facundo
 */

@Entity
public class Contribuyente {
    
    //Atributos
    @Id
    @GeneratedValue
    private int id;
    
    private String codigoDocumento;

    private TipoDocumentoEnum tipoDocumento;
    
    private String nombre;
    
    private String apellido;
    
    private String domicilio;
    
    private Date fechaNacimiento;

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    } 

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //Constructores
    public Contribuyente() {}
    
    public Contribuyente(String codigoDocumento, TipoDocumentoEnum tipoDocumento, String nombre, String apellido, String domicilio) {
        this.codigoDocumento = codigoDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
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
    
}
