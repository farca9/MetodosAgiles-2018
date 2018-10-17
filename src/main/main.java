/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import hibernate.Hibernator;
import view.gui.login.MainMenu;

/**
 *
 * @author Facundo
 */
public class main {
    
    public static void main (String args[]){
        
        try{
            Hibernator.getInstance();
        }
        catch(org.hibernate.exception.JDBCConnectionException ex){
            ex.printStackTrace();
        }
     
        new MainMenu().setVisible(true);
        
    }
    
}
