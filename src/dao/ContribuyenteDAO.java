/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.Hibernator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import model.Contribuyente;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lau_9
 */
public class ContribuyenteDAO {
    
    private static ContribuyenteDAO instance = null;
    
    private ContribuyenteDAO(){};
    
    public static ContribuyenteDAO getInstance(){
        if (instance == null) instance = new ContribuyenteDAO();
        return instance;
    }
    
    public List<Contribuyente> find(Contribuyente contribuyente){
        
        ArrayList<Contribuyente> results;
        
        try{
            Session sesion = Hibernator.getInstance().getSession();
            sesion.beginTransaction();
            
            Criteria crit = sesion.createCriteria(Contribuyente.class);
            
            Conjunction conj = Restrictions.conjunction();
            
            if(contribuyente.getNombre() != null){
                conj.add(Restrictions.ilike("nombre", contribuyente.getNombre(), MatchMode.ANYWHERE));
            }
            
            if(contribuyente.getApellido() != null){
                conj.add(Restrictions.ilike("apellido", contribuyente.getApellido(), MatchMode.ANYWHERE));
            }
            
            if(contribuyente.getCodigoDocumento() != null){
                conj.add(Restrictions.eq("codigodocumento", contribuyente.getCodigoDocumento()));
            }
            
            if(contribuyente.getDomicilio() != null){
                conj.add(Restrictions.ilike("domicilio", contribuyente.getDomicilio(), MatchMode.ANYWHERE));
            }
            
            if(contribuyente.getTipoDocumento() != null){
                conj.add(Restrictions.eq("tipodocumento", contribuyente.getTipoDocumento()));
            }
            
            crit.add(conj);
            
            results = (ArrayList<Contribuyente>)crit.list(); // TODO Ver por qué se rompe aca con los DNI
            
            sesion.getTransaction().commit();          
            
        } catch(org.hibernate.exception.GenericJDBCException jdbc){
            results = new ArrayList();
        }
        
        return results;
        
    }
    
    public boolean insert(Contribuyente contribuyente){
        // TODO Ver si es necesario implementar 'insert'
        return true;
    }
    
    public boolean update(Contribuyente contribuyente){
        // TODO Ver si es necesario implementar 'update'
        return true;
    }
    
    public boolean delete(Contribuyente contribuyente){
        // TODO Ver si es necesario implementar 'delete'
        return true;
    }
    
}
