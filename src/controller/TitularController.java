/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TitularDAO;
import java.util.ArrayList;
import java.util.List;
import model.Titular;
import util.FiltroTitularesEnum;

/**
 *
 * @author Facundo
 */
public class TitularController {
    
    private static TitularController instance = null;
    
    private TitularController(){};
    
    public static TitularController getInstance(){
        if (instance == null) instance = new TitularController();
        return instance;
    }
    
    public List<Titular> buscarTitulares(String texto, FiltroTitularesEnum filtro){
        
        Titular titular = new Titular();
        
        if(filtro.equals(FiltroTitularesEnum.APELLIDO)) titular.setApellido(texto);
        else if (filtro.equals(FiltroTitularesEnum.DOCUMENTO)) titular.setCodigoDocumento(texto);
        else if (filtro.equals(FiltroTitularesEnum.NOMBRE)) titular.setNombre(texto);
        
        return (TitularDAO.getInstance().find(titular));
    }
    
}
