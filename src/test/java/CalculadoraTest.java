package test.java;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

import org.junit.*;
import main.Calculadora;

public class CalculadoraTest {
    @Test
    public void calculo1(){
        String operacion = "1 2 + 10 * 4 %";
        int resultado = ((1 + 2) * 10) % 4;
        
        Assert.assertEquals(resultado, Calculadora.procesarLineaPostfix(operacion));
    }

    @Test
    public void calculo2(){
        String operacion = "4 7 + 2 - 3 %";
        int resultado = ((4 + 7) - 2) % 3;
        
        Assert.assertEquals(resultado, Calculadora.procesarLineaPostfix(operacion));
    }

    @Test
    public void error1(){
        String operacion = "- 1 2";
        Assert.assertThrows(NoSuchElementException.class, () -> Calculadora.procesarLineaPostfix(operacion));
    }

    @Test
    public void error2(){
        String operacion = "1 3 @";
        Assert.assertThrows(InvalidParameterException.class, () -> Calculadora.procesarLineaPostfix(operacion));
    }
}
