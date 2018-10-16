/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

/**
 *
 * @author Facundo
 */

@Entity
public class Contribuyente {
    
    @Id
    private long dni;
    
    private TipoDocumentoEnum tipoDocumento;
    
    private String nombre;
    
    private String apellido;
    
    private String domicilio;

    public Contribuyente(long dni, TipoDocumentoEnum tipoDocumento, String nombre, String apellido, String domicilio) {
        this.dni = dni;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
    }

    public Contribuyente() {
    }
    
    
}
