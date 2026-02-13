package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.lists.ListaSimple;
import java.util.ArrayList;
import java.util.List;

public class ListaSimpleTest {
    ListaSimple<Integer> lista;

    @Before
    public void setUp(){
        lista = new ListaSimple<Integer>();
        lista.agregarPrimero(1);
        lista.agregarPrimero(2);
        lista.agregarPrimero(3);
        lista.agregarPrimero(4);
    }
   
    @Test
    public void recorrerLista(){
        List<Integer> resultado = new ArrayList<Integer>();
        resultado.add(4);
        resultado.add(3);
        resultado.add(2);
        resultado.add(1);

        Assertions.assertEquals(resultado, lista.recorrer());
    }

    @Test
    public void eliminarElemento(){
        lista.retirarPrimero();

        Assertions.assertEquals(3, lista.verPrimero());
    }

    @Test
    public void tamano(){
        Assertions.assertEquals(4, lista.size());
    }
}
