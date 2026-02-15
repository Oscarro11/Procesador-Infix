package test.java;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.List.ListaDoble;

import java.util.ArrayList;
import java.util.List;

public class ListaDobleTest {
    private ListaDoble<Integer> listaDoble;

    @Before
    public void setUp(){
        listaDoble = new ListaDoble<Integer>();
        listaDoble.agregarPrimero(1);
        listaDoble.agregarPrimero(2);
        listaDoble.agregarPrimero(3);
        listaDoble.agregarPrimero(4);
    }

    @Test
    public void recorrerLista(){
        List<Integer> resultado = new ArrayList<Integer>();
        resultado.add(4);
        resultado.add(3);
        resultado.add(2);
        resultado.add(1);

        Assertions.assertEquals(resultado, listaDoble.recorrer());
    }

    @Test
    public void recorrerInverso(){
        List<Integer> resultado = new ArrayList<Integer>();
        resultado.add(1);
        resultado.add(2);
        resultado.add(3);
        resultado.add(4);

        Assertions.assertEquals(resultado, listaDoble.recorrerInverso());
    }

    @Test
    public void eliminarElemento(){
        listaDoble.retirarPrimero();

        Assertions.assertEquals(3, listaDoble.verPrimero());
    }

    @Test
    public void tamano(){
        Assertions.assertEquals(4, listaDoble.size());
    }
}
