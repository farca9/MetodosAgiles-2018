/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import model.ClaseLicenciaEnum;
import model.Titular;

/**
 *
 * @author Santo
 */
public class LicenciaController {
    
    public Date calcularVigencia(Titular t1, ClaseLicenciaEnum c1){
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");  
        
        
        Date vencimiento = new Date();
        Date actual = new Date();
        Date nacimiento = t1.getFechaNacimiento();
        
        Calendar c = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c.setTime(actual);
        c2.setTime(nacimiento); 
        
        int string_nacimiento = Integer.parseInt(formatter.format(t1.getFechaNacimiento()));                            
        int string_actual = Integer.parseInt(formatter.format(actual));  
        
        int edad = (string_actual - string_nacimiento) / 10000;      
        
        
        if(edad<17){
            return actual;
            //menores de 17 no pueden solicitar ninguna licencia
        }else{
            if( c1==ClaseLicenciaEnum.C || c1==ClaseLicenciaEnum.D || c1==ClaseLicenciaEnum.E && edad<21){
                return actual;
                //menores de 21 no pueden solicitar tipo c,d o e
            }
            else{
                if(edad==18){
                    if(nacimiento.before(actual)){
                        //Cumpleaños todavia no paso
                        //Vigencia 1 año
                        
                        c.add(Calendar.YEAR, 1);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                        vencimiento = c.getTime();  
                        
                        return vencimiento;
                    }else{
                        //cumpleaños ya paso
                        //vencimiento = actual - diferencia + vigencia
                        c.add(Calendar.YEAR, 2);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                        vencimiento = c.getTime();  
                        return vencimiento;
                    }
                }
                if (edad>18 && edad<21){
                    if(nacimiento.before(actual)){
                        //Cumpleaños todavia no paso
                        //Vigencia 3 años
                        c.add(Calendar.YEAR, 3);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                        vencimiento = c.getTime(); 
                        return vencimiento;
                        //vencimiento = actual + vigencia + diferencia
                    }else{
                        //cumpleaños ya paso
                        //vencimiento = actual - diferencia + vigencia
                        c.add(Calendar.YEAR, 4);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                        vencimiento = c.getTime(); 
                        return vencimiento;
                    }
                }
                if (edad>21 && edad<46){
                    if(nacimiento.before(actual)){
                        //Cumpleaños todavia no paso
                        //Vigencia 5 años
                        c.add(Calendar.YEAR, 5);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                        vencimiento = c.getTime(); 
                        return vencimiento;
                    }else{
                        //cumpleaños ya paso
                        //vencimiento = actual - diferencia + vigencia
                        c.add(Calendar.YEAR, 6);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                        vencimiento = c.getTime(); 
                        return vencimiento;
                    }
                }
                if(edad>45 && edad<60){
                    if(nacimiento.before(actual)){
                        //Cumpleaños todavia no paso
                        //Vigencia 4 años
                        c.add(Calendar.YEAR, 4);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                        vencimiento = c.getTime(); 
                        return vencimiento;
                        //vencimiento = actual + vigencia + diferencia
                    }else{
                        //cumpleaños ya paso
                        //vencimiento = actual - diferencia + vigencia
                        c.add(Calendar.YEAR, 5);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                        vencimiento = c.getTime(); 
                        return vencimiento;
                    }
                }
                if(edad>59 && edad<=70){
                    if(nacimiento.before(actual)){
                        //Cumpleaños todavia no paso
                        //Vigencia 3 años
                        c.add(Calendar.YEAR, 3);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                        vencimiento = c.getTime(); 
                        return vencimiento;
                        //vencimiento = actual + vigencia + diferencia
                    }else{
                        //cumpleaños ya paso
                        //vencimiento = actual - diferencia + vigencia
                        c.add(Calendar.YEAR, 4);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                        vencimiento = c.getTime(); 
                        return vencimiento;
                    }
                }
                if(edad>70){
                    if(nacimiento.before(actual)){
                        //Cumpleaños todavia no paso
                        //Vigencia 1 año
                        c.add(Calendar.YEAR, 1);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                        vencimiento = c.getTime(); 
                        return vencimiento;
                        //vencimiento = actual + vigencia + diferencia
                    }else{
                        //cumpleaños ya paso
                        //vencimiento = actual - diferencia + vigencia
                        c.add(Calendar.YEAR, 2);
                        c.set(c.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH));
                        vencimiento = c.getTime(); 
                        return vencimiento;
                    }
                }
            }
        }        
        
                
                
           return vencimiento;
    }

    public LicenciaController() {
    }
    
    
}
