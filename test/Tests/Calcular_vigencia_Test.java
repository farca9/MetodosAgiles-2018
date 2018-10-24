/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import controller.LicenciaController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import model.ClaseLicenciaEnum;
import model.GrupoSanguineoEnum;
import model.Licencia;
import model.TipoDocumentoEnum;
import model.Titular;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Santo
 * Consiste de un método que, dado un titular y una clase de licencia, calcule las fechas de inicio y vigencia de la misma y la retorne a la interfaz.


 */
public class Calcular_vigencia_Test {
    
    
    LicenciaController l1;
    Titular t1;
    Titular t2;
    Titular t3;
    Titular t4;
                    
    
    
    
    public Calcular_vigencia_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        //Init fechas nac
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
        
        String string1 = "01/12/1995";
        Date date1 = format.parse(string1);
        
        String string2 = "01/11/1995";
        Date date2 = format.parse(string2);
        
        String string3 = "01/12/1995";
        Date date3 = format.parse(string3);
        
        String string4 = "01/11/1995";
        Date date4 = format.parse(string4);
        
        //Init titulares
        t1 = new Titular("38898095", TipoDocumentoEnum.DU, "Santiago", "Roa", "San Luis 2820", GrupoSanguineoEnum.O, false, false, date1);
        t2 = new Titular("38898095", TipoDocumentoEnum.DU, "Lucas", "Roa", "San Luis 2820", GrupoSanguineoEnum.O, false, true, date2);
        t3 = new Titular("38898095", TipoDocumentoEnum.DU, "Martin", "Roa", "San Luis 2820", GrupoSanguineoEnum.O, true, false, date3);
        t4 = new Titular("38898095", TipoDocumentoEnum.DU, "Jorge", "Roa", "San Luis 2820", GrupoSanguineoEnum.O, true, true, date4);
        
        
        LicenciaController l1 = LicenciaController.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void TestVigencia1() throws ParseException {
        Date resultado = l1.calcularVigencia(t1, ClaseLicenciaEnum.C);
        
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
        String string1 = "01/12/2023";
        Date date1 = format.parse(string1);
       
        assertEquals(date1, resultado);
    }
    
    /*@Test
    public void TestVigencia2() {
        int resultado = calcularVigencia(t2, ClaseLicenciaEnum.A);
        int esperado = 3; //23 años y licencia de clase A da vigencia de 3 años
        assertEquals(esperado, resultado);
    }*/
    
    @Test
    public void TestVigencia3() {
        
        
    }
    
    @Test
    public void TestVigencia4() {
        
        
    }
    
}
