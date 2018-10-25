/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.ContribuyenteDAO;
import hibernate.Hibernator;
import java.util.Random;
import model.Contribuyente;
import model.TipoDocumentoEnum;
import org.hibernate.Session;

/**
 *
 * @author Facundo
 */
public class ContribuyentePopulator {
    
    private static String[] apellidos={"Gonzalez", "Rodriguez", "Lopez", "Gomez", "Huertas", "Diaz", "Martinez", "Perez", "Garcia", "Sanchez", "Romero", "Sosa", "Alvarez", "Torres", "Ruiz", "Ramirez", "Flores", "Acosta", "Benitez", "Medina"};
    private static String[] nombres={"Juan","Matias","Carlos","Ezequiel","Dario","Pedro","Daniel","Marcos","Hector","Rodrigo","Ana","Susana","Erica","Daniela","Marta","Valeria","Patricia","Veronica","Alicia","Irma"};

    
    public static void populate(Integer cantidad){
            
        try{
            Session sesion = Hibernator.getInstance().getSession();
            sesion.beginTransaction();
            
            Random r1 = new Random();
            Random r2 = new Random();
            Random r3 = new Random();
             
        for(int i=0;i<cantidad;i++){
            
            Contribuyente contribuyente = new Contribuyente();

            int i1=r1.nextInt(apellidos.length);
            contribuyente.setApellido(apellidos[i1]);
            
            int i2=r2.nextInt(nombres.length);
            contribuyente.setNombre(nombres[i2]);
            
            long l1=r3.nextInt(35000000)+5000000;
            contribuyente.setCodigoDocumento(Long.toString(l1));
            
            contribuyente.setDomicilio("Calle Siempreviva "+r3.nextInt(10000));
            
            int i3=(r1.nextInt(TipoDocumentoEnum.values().length));
            contribuyente.setTipoDocumento(TipoDocumentoEnum.values()[i3]);     
            
            sesion.save(contribuyente);
        }
            
            sesion.getTransaction().commit();
            
        } catch(org.hibernate.exception.GenericJDBCException jdbc){
            jdbc.printStackTrace();
        }
            
        }
        
        
        
    }
        
    
    
