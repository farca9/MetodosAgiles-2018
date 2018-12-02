/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LicenciaDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.ClaseLicenciaEnum;
import model.Licencia;
import model.Titular;

/**
 *
 * @author Santo
 */
public class LicenciaController {
    
    private static LicenciaController instance = null;
    
    public LicenciaController(){};
    
    public static LicenciaController getInstance(){
        if (instance == null) instance = new LicenciaController();
        return instance;
    }
    
    public Double calcularCosto (Date fechaVencimiento, ClaseLicenciaEnum target){
        
        int edad = (-1)*this.calcularEdad(fechaVencimiento);
        Double costo = 0.0;
        
        switch(target){
            case A:
            case F:
            case G:
            case B:
                if(edad==5){
                    costo = 40.0;
                }else if(edad==4){
                    costo = 30.0;
                }else if(edad==3){
                    costo = 25.0;
                }else if(edad==1){
                    costo = 20.0;
                }
                break;
            case C:
                if(edad==5){
                    costo = 47.0;
                }else if(edad==4){
                    costo = 35.0;
                }else if(edad==3){
                    costo = 30.0;
                }else if(edad==1){
                    costo = 23.0;
                }
                break;
            case D:
            case E:
                if(edad==5){
                    costo = 59.0;
                }else if(edad==4){
                    costo = 44.0;
                }else if(edad==3){
                    costo = 39.0;
                }else if(edad==1){
                    costo = 29.0;
                }
                break;   
        }
        return costo+8.0; //Gastos administrativos
    }
    
    public List<Licencia> licenciasVencidas (Date fechaInicio, Date fechaFin, ClaseLicenciaEnum claseLicenciaEnum, Titular titular){
        
        ArrayList<Licencia> resultado = new ArrayList();
        
        Licencia licencia = new Licencia();
        licencia.setClaseLicenciaEnum(claseLicenciaEnum);
        licencia.setTitular(titular);
        resultado = (ArrayList)LicenciaDAO.getInstance().find(licencia, fechaInicio, fechaFin);
        
        return resultado;
    }
    
    public Date calcularVigencia(Titular titular, ClaseLicenciaEnum claseLicenciaEnum){
        
        Date today = new Date();
        today.setHours(0);
        today.setMinutes(0);
        today.setSeconds(0);
        
        int duracionEnAnios=0;
        
        Date cumpleanios = new Date();
        cumpleanios.setDate(titular.getFechaNacimiento().getDate());
        cumpleanios.setMonth(titular.getFechaNacimiento().getMonth());
        cumpleanios.setYear(today.getYear());
        cumpleanios.setHours(0);
        cumpleanios.setMinutes(0);
        cumpleanios.setSeconds(0);
        
        if(cumpleanios.before(today)) duracionEnAnios++;
        
        int edad = this.calcularEdad(titular.getFechaNacimiento());
        
        if(edad>=21 && edad<46) duracionEnAnios+=5;
        else if(edad>=46 && edad<60) duracionEnAnios+=4;
        else if(edad>=60 && edad<70) duracionEnAnios+=3;
        else if(edad>=70) duracionEnAnios++;
        else if(edad>=17 && edad<21){
            
            if(this.yaEmitida(titular, claseLicenciaEnum)){
                duracionEnAnios+=3;
            }else duracionEnAnios++;
            
        }else return today;
        
        Date fechaVencimiento=new Date();
        fechaVencimiento.setDate(titular.getFechaNacimiento().getDate());
        fechaVencimiento.setMonth(titular.getFechaNacimiento().getMonth());
        fechaVencimiento.setYear(today.getYear()+duracionEnAnios);
        fechaVencimiento.setHours(0);
        fechaVencimiento.setMinutes(0);
        fechaVencimiento.setSeconds(0);        
        
        return fechaVencimiento;
    }

    public boolean crearLicencia(Titular titular, ClaseLicenciaEnum claseLicenciaEnum){
        
        Licencia licencia = new Licencia();
        licencia.setTitular(titular);
        licencia.setActiva(true);
        licencia.setClaseLicenciaEnum(claseLicenciaEnum);
        licencia.setFechaEmision(new Date());
        licencia.setFechaVencimiento(this.calcularVigencia(titular, claseLicenciaEnum));
        titular.getLicencias().add(licencia);
        
        return LicenciaDAO.getInstance().insert(licencia);
        
    }
    
    public int calcularEdad(Date fechaNacimiento){
        return Period.between(fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
    }
    
    public boolean tieneBValida(Titular titular){
        boolean tieneBValida=false;
        
        if(titular.getLicencias().isEmpty()) return false;
        for(Licencia licencia : titular.getLicencias()){
            
            if(licencia.getClaseLicenciaEnum()==ClaseLicenciaEnum.B && this.calcularEdad(licencia.getFechaEmision())>=1){
                tieneBValida=true;
                break;
            }
            
        }
        
        return tieneBValida;
    }
    
    public boolean yaEmitida(Titular titular, ClaseLicenciaEnum target){
        boolean yaEmitida = false;
        
        if(titular.getLicencias().isEmpty()) return false;
        for(Licencia licencia : titular.getLicencias()){
            if(licencia.getClaseLicenciaEnum()==target){
                yaEmitida = true;
                break;
            }
        }
        
        return yaEmitida;
    }
    
    public Date primerVencimiento(List<Licencia> licencias){
        
        if(licencias.isEmpty()) return new Date();
        Date primerVencimiento=null;
        for(Licencia lic : licencias){
            if(primerVencimiento==null) primerVencimiento=lic.getFechaVencimiento();
            else if (lic.getFechaVencimiento().before(primerVencimiento)) primerVencimiento=lic.getFechaVencimiento();
            
        }
        primerVencimiento.setHours(0);
        primerVencimiento.setMinutes(0);
        primerVencimiento.setSeconds(0);
        
        return primerVencimiento;
    }
    
    public void inhabilitarLicencia(Licencia licencia){
        LicenciaDAO.getInstance().update(licencia);
    }
    
}
