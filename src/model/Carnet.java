/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Facundo
 */
@Entity
public class Carnet {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private Date fechaImpresion;
    
    private Date fechaVencimiento;
    
    @ManyToOne
    @JoinColumn(name="idTitularFK")
    private Titular titular;
    
    private String clases;

    public Carnet() {
    }

    public Carnet(Integer id, Date fechaImpresion, Date fechaVencimiento, Titular titular, String clases) {
        this.id = id;
        this.fechaImpresion = fechaImpresion;
        this.fechaVencimiento = fechaVencimiento;
        this.titular = titular;
        this.clases = clases;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaImpresion() {
        return fechaImpresion;
    }

    public void setFechaImpresion(Date fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public String getClases() {
        return clases;
    }

    public void setClases(String clases) {
        this.clases = clases;
    }
    
    
}
