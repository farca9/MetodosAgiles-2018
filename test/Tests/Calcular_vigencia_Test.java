/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

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
    
    
    Licencia l1;
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
        //Init Licencias
        Set set1 = new HashSet();
        String element = "A";
        set1.add(element);
        
        Set set2 = new HashSet();
        String element2 = "B";
        set2.add(element2);
        
        Set set3 = new HashSet();
        String element3 = "A";
        set3.add(element3);
        
        Set set4 = new HashSet();
        String element4 = "A";
        set4.add(element4);
        
        //Init fechas nac
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
        
        String string1 = "01/11/1998";
        Date date1 = format.parse(string1);
        
        String string2 = "01/11/1995";
        Date date2 = format.parse(string2);
        
        String string3 = "01/12/1995";
        Date date3 = format.parse(string3);
        
        String string4 = "01/11/1995";
        Date date4 = format.parse(string4);
        
        //Init titulares
        t1 = new Titular(1, "38898095", TipoDocumentoEnum.DU, "Santiago", date1, "Roa", "San Luis 2820", GrupoSanguineoEnum.O, false, false, set1);
        t2 = new Titular(1, "38898095", TipoDocumentoEnum.DU, "Santiago", date2, "Roa", "San Luis 2820", GrupoSanguineoEnum.O, false, false, set2);
        t3 = new Titular(1, "38898095", TipoDocumentoEnum.DU, "Santiago", date3, "Roa", "San Luis 2820", GrupoSanguineoEnum.O, false, false, set3);
        t4 = new Titular(1, "38898095", TipoDocumentoEnum.DU, "Santiago", date4, "Roa", "San Luis 2820", GrupoSanguineoEnum.O, false, false, set4);
        
        
        l1 = new Licencia();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void TestVigencia1() {
        int resultado = calcularVigencia(t1, ClaseLicenciaEnum.C);
        int esperado = 0; //Menor de 21 años no puede solicitar licencia clase C
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void TestVigencia2() {
        int resultado = calcularVigencia(t2, ClaseLicenciaEnum.A);
        int esperado = 3; //23 años y licencia de clase A da vigencia de 3 años
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void TestVigencia3() {
        
        
    }
    
    @Test
    public void TestVigencia4() {
        
        
    }
    
}
