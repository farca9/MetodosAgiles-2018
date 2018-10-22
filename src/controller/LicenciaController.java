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
    
    public int calcularVigencia(Titular t1, ClaseLicenciaEnum c1){
        int vigencia = 0;
        Date actual = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");        
        
        int d1 = Integer.parseInt(formatter.format(t1.getFechaNacimiento()));                            
        int d2 = Integer.parseInt(formatter.format(actual));  
        
        int edad = (d2 - d1) / 10000;      
        
        
        if(edad<17){
            vigencia = 0;
            //menores de 17 no pueden solicitar ninguna licencia
        }else{
            if( c1==ClaseLicenciaEnum.C || c1==ClaseLicenciaEnum.D || c1==ClaseLicenciaEnum.E && edad<21){
                vigencia = 0;
                //menores de 21 no pueden solicitar tipo c,d o e
            }
            else{
                if(edad == 21){
                    vigencia = 1;
                }
                if (edad>21 && edad<46){
                    vigencia = 3;
                }
                if(edad>45 && edad<60){
                    vigencia = 5;
                }
                if(edad>59 && edad<=70){
                    vigencia = 3;
                }
                if(edad>70){
                    vigencia = 1;
                }
            }
        }        
        
                
                
           return vigencia;
    }
    
    
}
