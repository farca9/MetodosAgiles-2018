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
import model.Carnet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Facundo
 */
public class CarnetDAO {
    
    private static CarnetDAO instance = null;
    
    private CarnetDAO(){};
    
    public static CarnetDAO getInstance(){
        if (instance == null) instance = new CarnetDAO();
        return instance;
    }
    
    public List<Carnet> find (Carnet carnet){
        
        List<Carnet> resultado;
        
        try{
            Session ses = Hibernator.getInstance().getSession();
            ses.beginTransaction();
            
            Criteria crit = ses.createCriteria(Carnet.class);
            
            Conjunction conj = Restrictions.conjunction();
            
            if(carnet.getId()!=null){
                conj.add(Restrictions.eq("id", carnet.getId()));
            }
            
            if(carnet.getTitular()!=null){
                conj.add(Restrictions.eq("titular", carnet.getTitular()));
            }
            
            if(carnet.getFechaImpresion()!=null){
                conj.add(Restrictions.eq("fechaImpresion",carnet.getFechaImpresion()));
            }
            
            if(carnet.getFechaVencimiento()!=null){
                conj.add(Restrictions.eq("fechaVencimiento", carnet.getFechaVencimiento()));
            }
            
            if(carnet.getClases()!=null){
                conj.add(Restrictions.eq("clases",carnet.getClases()));
            }
            
            Date today = new Date();
            today.setHours(0);
            today.setMinutes(0);
            today.setSeconds(0);
            
            conj.add(Restrictions.gt("fechaVencimiento",today));
            
            crit.add(conj);
            
            resultado = (ArrayList<Carnet>)crit.list();
            
            ses.getTransaction().commit();
            
        }
        catch(Exception ex){
            resultado = new ArrayList();
        }
        
        return resultado;
    }
    
    public boolean insert (Carnet carnet){
        
        try{
            Session sesion = Hibernator.getInstance().getSession();
            sesion.beginTransaction();
            sesion.save(carnet);
            sesion.getTransaction().commit();
            return true;
        } catch(Exception e){
            return false;
        }
        
    }
    
}
