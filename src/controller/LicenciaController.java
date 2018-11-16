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
    
    public Date calcularVigencia(Titular t1, ClaseLicenciaEnum c1){
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");  
              
        Date vencimiento = new Date();
        Date actual = new Date();
        actual.setHours(0);
        actual.setMinutes(0);
        actual.setSeconds(0);
        
        Date nacimiento = t1.getFechaNacimiento();
        
        
        Calendar c = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c.setTime(actual);
        
        Calendar c3 = Calendar.getInstance();
        c3.setTime(nacimiento);
        c3.set(c.get(Calendar.YEAR), c3.get(Calendar.MONTH), c3.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        
        c2.setTime(nacimiento); 
        
        int string_nacimiento = Integer.parseInt(formatter.format(t1.getFechaNacimiento()));                            
        int string_actual = Integer.parseInt(formatter.format(actual));  
        
        int edad = (string_actual - string_nacimiento) / 10000;

        
        
        if(edad<17){
            
            return actual;
            //menores de 17 no pueden solicitar ninguna licencia
        }else{
            if( (c1==ClaseLicenciaEnum.C || c1==ClaseLicenciaEnum.D || c1==ClaseLicenciaEnum.E) && edad<21){
                
                return actual;
                //menores de 21 no pueden solicitar tipo c,d o e
            }
            else{
                
                if(edad==17){
                    
                    if(actual.before(c3.getTime())){
                        //Cumpleaños todavia no paso
                        //Vigencia 1 año
                        
                        c.add(Calendar.YEAR, 1);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime();  
                        
                        
                        return vencimiento;
                    }else{
                        //cumpleaños ya paso
                        //vencimiento = actual - diferencia + vigencia
                        c.add(Calendar.YEAR, 2);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime();  
                        
                        return vencimiento;
                    }
                }
                if (edad>17 && edad<21){
                    if(actual.before(c3.getTime())){
                        if(!t1.haveLicencia(c1)){
                        //Cumpleaños todavia no paso, es la primer licencia que saca
                        //Vigencia 1 años
                        c.add(Calendar.YEAR, 1);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                        
                        return vencimiento;
                        }
                        else{
                        c.add(Calendar.YEAR, 3);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                        }
                        
                        
                    }else{
                        if(!t1.haveLicencia(c1)){
                        //Cumpleaños ya paso, es la primer licencia que saca
                        //Vigencia 1 años y lo que falte
                        c.add(Calendar.YEAR, 2);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                        
                        return vencimiento;
                        }else{
                        c.add(Calendar.YEAR, 4);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                        }
                    }
                }
                if (edad>=21 && edad<=46){
                    if(actual.before(c3.getTime())){
                        //Cumpleaños todavia no paso
                        //Vigencia 5 años
                        c.add(Calendar.YEAR, 5);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                        
                        return vencimiento;
                        
                    }else{
                        //cumpleaños ya paso
                        //vencimiento = actual - diferencia + vigencia
                        c.add(Calendar.YEAR, 6);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                      
                        return vencimiento;
                    }
                }
                if(edad>46 && edad<=60){
                    if(actual.before(c3.getTime())){
                        //Cumpleaños todavia no paso
                        //Vigencia 4 años
                        c.add(Calendar.YEAR, 4);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                        
                        return vencimiento;
                        //vencimiento = actual + vigencia + diferencia
                    }else{
                        //cumpleaños ya paso
                        //vencimiento = actual - diferencia + vigencia
                        c.add(Calendar.YEAR, 5);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                        
                        return vencimiento;
                    }
                }
                if(edad>60 && edad<=70){
                    if(actual.before(c3.getTime())){
                        //Cumpleaños todavia no paso
                        //Vigencia 3 años
                        c.add(Calendar.YEAR, 3);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime();
                        
                        return vencimiento;
                        //vencimiento = actual + vigencia + diferencia
                    }else{
                        //cumpleaños ya paso
                        //vencimiento = actual - diferencia + vigencia
                        c.add(Calendar.YEAR, 4);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                        
                        return vencimiento;
                    }
                }
                if(edad>70){
                    if(actual.before(c3.getTime())){
                        //Cumpleaños todavia no paso
                        
                        //Vigencia 1 año
                        c.add(Calendar.YEAR, 1);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                        
                        return vencimiento;
                        //vencimiento = actual + vigencia + diferencia
                    }else{
                        //cumpleaños ya paso
                        //vencimiento = actual - diferencia + vigencia
                        c.add(Calendar.YEAR, 2);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                        
                        return vencimiento;
                    }
                }
            }
        }        
        
                
                
           return vencimiento;
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
