 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.Hibernator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Licencia;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;

/**
 *
 * @author Facundo
 */
public class LicenciaDAO{
    
    private static final LicenciaDAO instance = new LicenciaDAO();
    
    private LicenciaDAO(){
        
    };
    
    public static LicenciaDAO getInstance(){
        return instance;
    }
    
    public List<Licencia> find (Licencia licencia){
    
        ArrayList<Licencia> resultado;
        
        try{
            Session ses = Hibernator.getInstance().getSession();
            ses.beginTransaction();
            
            Criteria crit = ses.createCriteria(Licencia.class);
            
            Conjunction conj = Restrictions.conjunction();
            
            if(licencia.getId()!=null){
                conj.add(Restrictions.eq("id", licencia.getId()));
            }
            
            if(licencia.getTitular()!=null){
                conj.add(Restrictions.eq("titular", licencia.getTitular()));
            } 
            
            crit.add(conj);
            
            resultado = (ArrayList<Licencia>)crit.list();
            
            ses.getTransaction().commit();
            
        }
        catch(Exception ex){
            resultado = new ArrayList();
        }
        
        return resultado;
    }
    
    public List<Licencia> find (Licencia licencia, Date fechaInicio, Date fechaFin){
        
        ArrayList<Licencia> resultado;
        
        try{
            Session ses = Hibernator.getInstance().getSession();
            ses.beginTransaction();
            
            Criteria crit = ses.createCriteria(Licencia.class);
            
            Conjunction conj = Restrictions.conjunction();
            
            if(licencia.getTitular() != null){
                conj.add(Restrictions.eq("titular", licencia.getTitular()));
            }
            
            if(licencia.getClaseLicenciaEnum()!=null){
                conj.add(Restrictions.eq("claseLicenciaEnum", licencia.getClaseLicenciaEnum()));
            }
            
            if(fechaInicio != null){
                conj.add(Restrictions.gt("fechaVencimiento", fechaInicio));
            }
            
            if(fechaFin != null){
                conj.add(Restrictions.lt("fechaVencimiento", fechaFin));
            }
            
            Date today = new Date();
            today.setHours(0);
            today.setMinutes(0);
            today.setSeconds(0);
            
            conj.add(Restrictions.lt("fechaVencimiento", today)); //Validar que en efecto este vencida
            
            crit.add(conj);
            
            resultado = (ArrayList<Licencia>)crit.list();
            
            ses.getTransaction().commit();
            
        }
        catch(Exception ex){
            resultado = new ArrayList();
            ex.printStackTrace();
        }
        
        return resultado;
        
    }
    
    public boolean insert (Licencia licencia){
        
        try{
            Session s = Hibernator.getInstance().getSession();
            s.beginTransaction();
            s.save(licencia);
            s.getTransaction().commit();
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    
}
