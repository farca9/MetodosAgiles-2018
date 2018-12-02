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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.ClaseLicenciaEnum;
import model.GrupoSanguineoEnum;
import model.Licencia;
import model.TipoDocumentoEnum;
import model.Titular;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author JOSE
 */
public class Calcular_costo_Test {
    
    public LicenciaController l1;
    
    ClaseLicenciaEnum claseA = ClaseLicenciaEnum.A;
    ClaseLicenciaEnum claseB = ClaseLicenciaEnum.B;
    ClaseLicenciaEnum claseC = ClaseLicenciaEnum.C;
    ClaseLicenciaEnum claseD = ClaseLicenciaEnum.D;
    ClaseLicenciaEnum claseE = ClaseLicenciaEnum.E;
    ClaseLicenciaEnum claseF = ClaseLicenciaEnum.F;
    ClaseLicenciaEnum claseG = ClaseLicenciaEnum.G;
    
    Date Fecha1 = new Date();
    Date Fecha2 = new Date();
    Date Fecha3 = new Date();
    Date Fecha4 = new Date();
    Date Fecha5 = new Date();
    Date Fecha6 = new Date();
    
    private static Date today;
    
     public Calcular_costo_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        today=new Date();
        try{
            String command = "cmd.exe /c start "+"date 08/11/2018";
            Runtime rt = Runtime.getRuntime();
            rt.exec(command);
            Thread.sleep(500);
            rt.exec("taskkill /IM cmd.exe");
        }catch (Exception e){
            e.printStackTrace();
        }        
    }
    
    @AfterClass
    public static void tearDownClass() {
                try{
                    String command = "cmd.exe /c start "+"date "+new SimpleDateFormat("dd/MM/yyyy").format(today);
            Runtime rt = Runtime.getRuntime();
            rt.exec(command);
            Thread.sleep(500);
            rt.exec("taskkill /IM cmd.exe");
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
    
    @Before
    public void setUp() throws ParseException {
        //Init fechas nac
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        String string1 = "16/08/2020"; //case 2 ( 19 años), 1 licencia tipo B
        Date date1 = format.parse(string1);
        
        String string2 = "09/11/2021";// case 3 (20 años), 2 licencia clase A
        Date date2 = format.parse(string2);
        
        String string3 = "30/06/2020";//case 4 (76 años), clase G
        Date date3 = format.parse(string3);
        
        String string4 = "23/11/2019";// case 5 (73 años), clase B
        Date date4 = format.parse(string4);
        
        String string5 = "19/11/2023";// case 6 (27 años), clase C
        Date date5 = format.parse(string5);
        
        String string6 = "14/09/2024";// case 7 (30 años), clase D
        Date date6 = format.parse(string6);
        
        Fecha1 = date1;
        Fecha2 = date2;
        Fecha3 = date3;
        Fecha4 = date4;
        Fecha5 = date5;
        Fecha6 = date6;
        
              
                     
        
        l1 = LicenciaController.getInstance();
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void TestCosto1() throws ParseException {
        Double resultado = l1.calcularCosto(Fecha1, claseB);
        
        Double costoEsperado = 28.0;        
        
        assertEquals(costoEsperado, resultado);
    }
    
    @Test
    public void TestCosto2() throws ParseException {
        Double resultado = l1.calcularCosto(Fecha2, claseA);
        
        Double costoEsperado = 33.0;        
        
        assertEquals(costoEsperado, resultado);
    }
    
    @Test
    public void TestCosto3() throws ParseException {
        Double resultado = l1.calcularCosto(Fecha3, claseG);
        
        Double costoEsperado = 28.0;        
        
        assertEquals(costoEsperado, resultado);
    }
    
    @Test
    public void TestCosto4() throws ParseException {
        Double resultado = l1.calcularCosto(Fecha4, claseF);
        
        Double costoEsperado = 28.0;        
        
        assertEquals(costoEsperado, resultado);
    }
    
    
     @Test
    public void TestCosto5() throws ParseException {
        Double resultado = l1.calcularCosto(Fecha5, claseC);
        
        Double costoEsperado = 55.0;        
        
        assertEquals(costoEsperado, resultado);
    }
    
     @Test
    public void TestCosto6() throws ParseException {
        Double resultado = l1.calcularCosto(Fecha6, claseD);
        
        Double costoEsperado = 67.0;        
        
        assertEquals(costoEsperado, resultado);
    }

    
    
    
}
