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
    
    private static Integer primerDocumento=10000000;
    private static String[] apellidos={"Gonzalez", "Rodriguez", "Lopez", "Gomez", "Huertas", "Diaz", "Martinez", "Perez", "Garcia", "Sanchez", "Romero", "Sosa", "Alvarez", "Torres", "Ruiz", "Ramirez", "Flores", "Acosta", "Benitez", "Medina"};
    private static String[] nombres={"Juan","Matias","Carlos","Ezequiel","Dario","Pedro","Daniel","Marcos","Hector","Rodrigo","Ana","Susana","Erica","Daniela","Marta","Valeria","Patricia","Veronica","Alicia","Irma"};
    private static Integer nombreCounter=0;
    private static Integer apellidoCounter=0;
    
    public static void populate(Integer cantidad){
       
            
        try{
            Session sesion = Hibernator.getInstance().getSession();
            sesion.beginTransaction();
            
             
        for(int i=0;i<cantidad;i++){
            
            Contribuyente contribuyente = new Contribuyente();

            apellidoCounter++;
            contribuyente.setApellido(apellidos[apellidoCounter%apellidos.length]);
            
            nombreCounter+=3;
            contribuyente.setNombre(nombres[nombreCounter%nombres.length]);
            
            primerDocumento++;
            contribuyente.setCodigoDocumento(primerDocumento.toString());
            
            contribuyente.setDomicilio("Calle Siempreviva "+ 1000+(apellidoCounter%9000));
            
            contribuyente.setTipoDocumento(TipoDocumentoEnum.values()[apellidoCounter%TipoDocumentoEnum.values().length]);     
            
            sesion.save(contribuyente);
        }
            
            sesion.getTransaction().commit();
            
        } catch(org.hibernate.exception.GenericJDBCException jdbc){
            jdbc.printStackTrace();
        }
            
        }
        
        
        
    }
        
    
    
