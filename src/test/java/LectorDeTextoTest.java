package test.java;

import org.junit.*;
import main.LectorDeTexto;

public class LectorDeTextoTest {
    LectorDeTexto lector;

    @Before
    public void setUp(){
        try{
            lector = new LectorDeTexto("src/test/resources/ejemplo.txt");
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    @Test
    public void linea1(){
        Assert.assertEquals("Saludos!", lector.textoLinea(0));    
    }

    @Test
    public void linea2(){
        Assert.assertEquals("12443", lector.textoLinea(3));
    }

    @Test
    public void cuenta(){
        Assert.assertEquals(4, lector.cantidadLineas());
    }
}
