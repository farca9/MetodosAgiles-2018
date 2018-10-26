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
import java.util.Calendar;
import java.util.Date;
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
    
    public Date calcularVigencia(Titular t1, ClaseLicenciaEnum c1){
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");  
        
        System.out.println("HOLANDAAAAAAAAAAAAAAAAAAAAAAAAAA");
        
        
        Date vencimiento = new Date();
        Date actual = new Date();
        actual.setHours(0);
        actual.setMinutes(0);
        actual.setSeconds(0);
        
        System.out.println("Actual: " +actual);
        
        
        
        Date nacimiento = t1.getFechaNacimiento();
        System.out.println("nacimiento: " + nacimiento);
        
        //Date cumpleanios = new Date();
        //cumpleanios = nacimiento;
        //cumpleanios.setYear(actual.getYear());
        
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
        System.out.println(edad);
        //c3.add(Calendar.YEAR, edad);
        System.out.println("c3: "+ c3.getTime());
        
        
        if(edad<17){
            
            return actual;
            //menores de 17 no pueden solicitar ninguna licencia
        }else{
            if( (c1==ClaseLicenciaEnum.C || c1==ClaseLicenciaEnum.D || c1==ClaseLicenciaEnum.E) && edad<21){
                
                System.out.println("2");
                return actual;
                //menores de 21 no pueden solicitar tipo c,d o e
            }
            else{
                
                if(edad==18){
                    
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
                if (edad>18 && edad<21){
                    System.out.println("4");
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
                if (edad>=21 && edad<=46){
                    System.out.println("5");
                    if(actual.before(c3.getTime())){
                        System.out.println("a");
                        //Cumpleaños todavia no paso
                        //Vigencia 5 años
                        c.add(Calendar.YEAR, 5);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                        
                        System.out.println(vencimiento);
                        return vencimiento;
                        
                    }else{
                        System.out.println("b");
                        //cumpleaños ya paso
                        //vencimiento = actual - diferencia + vigencia
                        c.add(Calendar.YEAR, 6);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime(); 
                      
                        System.out.println(vencimiento);
                        return vencimiento;
                    }
                }
                if(edad>46 && edad<=60){
                    System.out.println("6");
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
                        System.out.println("7");
                        //Cumpleaños todavia no paso
                        //Vigencia 3 años
                        c.add(Calendar.YEAR, 3);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
                        vencimiento = c.getTime();
                        ;
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
                    System.out.println("8");
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

    public boolean crearLicencia(Titular titular, ClaseLicenciaEnum claseLicenciaEnum, String observaciones){
        
        Licencia licencia = new Licencia();
        licencia.setTitular(titular);
        licencia.setActiva(true);
        licencia.setClaseLicenciaEnum(claseLicenciaEnum);
        licencia.setFechaEmision(new Date());
        Date fakeVencimiento = new Date();
        fakeVencimiento.setYear(125);
        licencia.setFechaVencimiento(fakeVencimiento); //TBD - this.calcularVigencia;
        licencia.setObservacion(observaciones);
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
    
}
