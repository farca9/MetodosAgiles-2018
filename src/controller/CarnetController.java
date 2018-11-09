/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CarnetDAO;
import java.util.Date;
import java.util.List;
import model.Carnet;
import model.Titular;

/**
 *
 * @author Facundo
 */
public class CarnetController {
    private static CarnetController instance = null;
    
    private CarnetController(){};
    
    public static CarnetController getInstance(){
        if (instance == null) instance = new CarnetController();
        return instance;
    }
    
    public List<Carnet> buscarCarnet(Titular titular){
        return CarnetDAO.getInstance().find(new Carnet(null,null,null,titular,null));
    }
    
    public List<Carnet> buscarCarnet(Titular titular, Date fechaVencimiento, String clases){
        return CarnetDAO.getInstance().find(new Carnet(null,null,fechaVencimiento,titular,clases));
    }
    
    public boolean agregarCarnet(Titular titular, Date fechaImpresion, Date fechaVencimiento, String clases){
        return CarnetDAO.getInstance().insert(new Carnet(null,fechaImpresion,fechaVencimiento,titular,clases));
    }
    
}
