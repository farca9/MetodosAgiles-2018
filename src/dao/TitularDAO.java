/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.Hibernator;
import model.Titular;
import org.hibernate.Session;

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
    
    public boolean find(Titular titular){
        // TODO Implementar 'find' (Historia 10)
        return true;
    }
    
    public boolean update(Titular titular){
        // TODO Implementar 'update' (Historia 10)
        return true;
    }
    
    public boolean delete(Titular titular){
        // TODO Ver si es necesario implementar 'delete'
        return true;
    }
}
