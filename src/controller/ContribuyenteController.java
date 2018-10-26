/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ContribuyenteDAO;
import java.util.List;
import model.Contribuyente;
import util.FiltroTitularesEnum;

/**
 *
 * @author lau_9
 */
public class ContribuyenteController {
    
    private static ContribuyenteController instance = null;
    
    private ContribuyenteController(){};
    
    public static ContribuyenteController getInstance(){
        if (instance == null) instance = new ContribuyenteController();
        return instance;
    }
    
    public List<Contribuyente> buscarContribuyentes(String texto, FiltroTitularesEnum filtro){
        
        Contribuyente contribuyente = new Contribuyente();
        
        if(filtro.equals(FiltroTitularesEnum.APELLIDO)) contribuyente.setApellido(texto);
        else if (filtro.equals(FiltroTitularesEnum.DOCUMENTO)) contribuyente.setCodigoDocumento(texto);
        else if (filtro.equals(FiltroTitularesEnum.NOMBRE)) contribuyente.setNombre(texto);
        
        return (ContribuyenteDAO.getInstance().find(contribuyente));
    }
    
    
}
