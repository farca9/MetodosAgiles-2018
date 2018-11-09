/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import hibernate.Hibernator;
import java.awt.Font;
import javax.swing.UIManager;
import util.ContribuyentePopulator;
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
     
        ContribuyentePopulator.populate(500);// -> Puebla la tabla de contribuyentes con datos aleatorios
        
        
        try{
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
        }catch (Exception e){
            
        }
        setUIFont(new javax.swing.plaf.FontUIResource("Segoe UI",Font.PLAIN,15));
        new MainMenu().setVisible(true);
    }
    
    private static void setUIFont (javax.swing.plaf.FontUIResource f){
    java.util.Enumeration keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get (key);
      if (value instanceof javax.swing.plaf.FontUIResource)
        UIManager.put (key, f);
      }
    } 
    
}
