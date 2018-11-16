/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TitularDAO;
import java.util.ArrayList;
import java.util.List;
import model.Contribuyente;
import model.GrupoSanguineoEnum;
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
    
    public boolean crearTitular(Contribuyente contribuyente, GrupoSanguineoEnum grupoSanguineo, boolean factor, boolean donante){
        
        Titular titular = new Titular();
        titular.setNombre(contribuyente.getNombre());
        titular.setApellido(contribuyente.getApellido());
        titular.setTipoDocumento(contribuyente.getTipoDocumento());
        titular.setCodigoDocumento(contribuyente.getCodigoDocumento());
        titular.setDomicilio(contribuyente.getDomicilio());
        titular.setFechaNacimiento(contribuyente.getFechaNacimiento());
        titular.setGrupoSanguineo(grupoSanguineo);
        titular.setFactor(factor);
        titular.setDonanteOrganos(donante);
        titular.setLicencias(new ArrayList());
        
        return TitularDAO.getInstance().insert(titular);
    }

    public boolean titularRegistrado(Contribuyente contribuyente) {
        
        Titular titular = new Titular();
        titular.setApellido(contribuyente.getApellido());
        titular.setNombre(contribuyente.getNombre());
        titular.setCodigoDocumento(contribuyente.getCodigoDocumento());
        titular.setTipoDocumento(contribuyente.getTipoDocumento());
        
        Integer tam = TitularDAO.getInstance().find(titular).size();

        if(tam > 0){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean modificarTitular(Titular t1,GrupoSanguineoEnum grupoSanguineo, boolean factor, boolean donante ){
        t1.setGrupoSanguineo(grupoSanguineo);
        t1.setFactor(factor);
        t1.setDonanteOrganos(donante);
        
        return TitularDAO.getInstance().update(t1);
        
        
    }
    
}
