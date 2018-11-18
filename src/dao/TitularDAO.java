/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.Hibernator;
import java.util.ArrayList;
import java.util.List;
import model.Titular;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lau_9
 */
public class TitularDAO {
    
    private static TitularDAO instance = null;
    
    private TitularDAO(){};
    
    public static TitularDAO getInstance(){
        if (instance == null) instance = new TitularDAO();
        return instance;
    }
    
    public boolean insert(Titular titular){
    
        try{
            Session sesion = Hibernator.getInstance().getSession();
            sesion.beginTransaction();
            sesion.save(titular);
            sesion.getTransaction().commit();
            return true;
        } catch(org.hibernate.exception.GenericJDBCException jdbc){
            return false;
        }
    }
    
    public List<Titular> find(Titular titular){
       
        ArrayList<Titular> resultado;
        
        try{
            
            Session ses = Hibernator.getInstance().getSession();
            ses.beginTransaction();
            
            Criteria crit = ses.createCriteria(Titular.class);
            Conjunction conj = Restrictions.conjunction();
            
            if(titular.getApellido() != null ) conj.add(Restrictions.ilike("apellido", titular.getApellido(), MatchMode.ANYWHERE));
            if (titular.getNombre() != null) conj.add(Restrictions.ilike("nombre",titular.getNombre(), MatchMode.ANYWHERE));
            if (titular.getCodigoDocumento() != null) conj.add(Restrictions.eq("codigoDocumento", titular.getCodigoDocumento()));
            if (titular.getTipoDocumento() != null) conj.add(Restrictions.eq("tipoDocumento",titular.getTipoDocumento()));
            
            crit.add(conj);
            
            resultado = (ArrayList)(crit.list());
            
            ses.getTransaction().commit();
            
        } catch (Exception ex){
            return new ArrayList();
        }
        
        return resultado;
        
    }
    
    public boolean update(Titular titular){
          try{
            Session s=Hibernator.getInstance().getSession();
            s.beginTransaction();
            s.update(titular);
            s.getTransaction().commit();
            return true;
        }
        catch (org.hibernate.exception.GenericJDBCException jbdc){
            return false;
        }
    }
    
    public boolean delete(Titular titular){
        // TODO Ver si es necesario implementar 'delete'
        return true;
    }
}
