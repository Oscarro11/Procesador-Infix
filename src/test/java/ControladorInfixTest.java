package test.java;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.ControladorInfix;

public class ControladorInfixTest {
    private ControladorInfix controlador = new ControladorInfix();
    
    @Test
    public void controladorConStack(){
        String expresionInfix = "(10+20)*9";
        int resultado = (10+20)*9;

        controlador.generarStack(2);
        Assertions.assertEquals(resultado, controlador.calcularInfix(expresionInfix));
    }

    @Test
    public void controladorConList(){
        String expresionInfix = "(7-9)/2";
        int resultado = (7-9)/2;

        controlador.generarList(1);
        Assertions.assertEquals(resultado, controlador.calcularInfix(expresionInfix));
    }

    @Test
    public void controladorSinEstructura(){
        String expresionInfix = "4+2";

        Assertions.assertThrows(IllegalStateException.class, () -> controlador.calcularInfix(expresionInfix));
    }
}
