/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.Hibernator;
import java.util.ArrayList;
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
    
    public LicenciaDAO getInstance(){
        return instance;
    }
    
    public List<Licencia> find (Licencia licencia){
    
        ArrayList<Licencia> resultado;
        
        try{
            Session ses = Hibernator.getInstance().getSession();
            ses.beginTransaction();
            
            Criteria crit = null;
            
            Conjunction conj = Restrictions.conjunction();
            
            if(licencia.getId()!=null){
                conj.add(Restrictions.eq("id", licencia.getId()));
            }
            
            if(licencia.getTitular()!=null){
                conj.add(Restrictions.eq("titular", licencia.getTitular()));
            }
            
            if(licencia.getUsuario()!=null){
                conj.add(Restrictions.eq("usuario", licencia.getUsuario()));
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
