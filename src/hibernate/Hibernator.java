/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import dao.LicenciaDAO;
import dao.TitularDAO;
import java.util.Date;
import model.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Facundo
 */
public class Hibernator {
    
    private static AnnotationConfiguration config;
    private static SessionFactory sesFactory;
    private static Session sesion;
    private static Hibernator instance=null;
    
    private Hibernator(){
        config=new AnnotationConfiguration();
        
        config.addAnnotatedClass(Contribuyente.class);
        config.addAnnotatedClass(Titular.class);
        config.addAnnotatedClass(Licencia.class);
                
        config.configure("hibernate/hibernate.cfg.xml");        
        
        sesFactory=config.buildSessionFactory();
        sesion=sesFactory.openSession(); 

        //new SchemaExport(config).create(true, true);// -> Exporta en el schema nuevas tablas en base a las anotaciones en las clases
        
    };
    
    public static Hibernator getInstance() throws org.hibernate.exception.GenericJDBCException{
        if(instance==null) {
            
            try{
                instance=new Hibernator();
            }
            catch (org.hibernate.exception.GenericJDBCException gjdbce){
                throw new GenericJDBCException(gjdbce.getMessage(),gjdbce.getSQLException());
            }
            
        }
        return instance;
    }
    
    
    public Session getSession(){
        return sesion;
    }
    
}

