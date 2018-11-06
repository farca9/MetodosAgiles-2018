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
public class Licencia {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Enumerated(EnumType.ORDINAL)
    private ClaseLicenciaEnum claseLicenciaEnum;
    
    @ManyToOne
    @JoinColumn(name="idTitularFK")
    private Titular titular;
    
    private Date fechaEmision;
    
    private Date fechaVencimiento;
      
    private boolean activa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClaseLicenciaEnum getClaseLicenciaEnum() {
        return claseLicenciaEnum;
    }

    public void setClaseLicenciaEnum(ClaseLicenciaEnum claseLicenciaEnum) {
        this.claseLicenciaEnum = claseLicenciaEnum;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    
}
