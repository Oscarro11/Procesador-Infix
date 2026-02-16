package test.java;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.Controlador;

public class ControladorTest {
    Controlador controlador;

    @Test
    public void ejemplo1List(){
        StringBuilder builder = new StringBuilder();
        controlador = new Controlador("src/test/resources/infix1.txt");
    
        controlador.elegirADT(1, 2);
        builder.append("El resultado de operar la expresion '((10+20)*10)/3' es: 100\n");
        builder.append("El resultado de operar la expresion '(17+11)/4' es: 7\n");
        builder.append("El resultado de operar la expresion '(7-5)%2' es: 0\n");

        Assertions.assertEquals(builder.toString(), controlador.procesarDocumento());
    }

    @Test
    public void ejemplo1Stack(){
        StringBuilder builder = new StringBuilder();
        controlador = new Controlador("src/test/resources/infix1.txt");

        controlador.elegirADT(2, 2);
        builder.append("El resultado de operar la expresion '((10+20)*10)/3' es: 100\n");
        builder.append("El resultado de operar la expresion '(17+11)/4' es: 7\n");
        builder.append("El resultado de operar la expresion '(7-5)%2' es: 0\n");

        Assertions.assertEquals(builder.toString(), controlador.procesarDocumento());
    }

    @Test
    public void ejemplo2Sin(){
        controlador = new Controlador("src/test/resources/infix2.txt");
        StringBuilder builder = new StringBuilder();

        builder.append("La linea '(1+2)+3' no puede ser procesada en el formato infix, debido a lo siguiente: \n");
        builder.append("No se ha designado una estructura de datos para la conversion de Infix a Postfix\n\n");
        builder.append("La linea '4-5-6' no puede ser procesada en el formato infix, debido a lo siguiente: \n");
        builder.append("No se ha designado una estructura de datos para la conversion de Infix a Postfix\n\n");

        Assertions.assertEquals(builder.toString(), controlador.procesarDocumento());
    }

    @Test
    public void ADTinvalido(){
        controlador = new Controlador("src/test/resources/infix2.txt");

        Assertions.assertThrows(IllegalArgumentException.class, () -> controlador.elegirADT(-1, 222));
    }
}
