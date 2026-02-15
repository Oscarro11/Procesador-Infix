package test.java;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.Converter.*;
import main.List.*;

public class ConvertInToPostListTest {
    String expresionInfix1 = "(10+20)*9";
    String expresionPostfix1 = "10 20 + 9 *";
    String expresionInfix2 = "(2+3)*(7-4)";
    String expresionPostfix2 = "2 3 + 7 4 - *";

    @Test
    public void listaSimple1(){
        ListaSimple<String> lista = new ListaSimple<String>();
        
        Assertions.assertEquals(expresionPostfix1, ConvertInToPostList.convertir(expresionInfix1, lista));
    }

    @Test
    public void listaSimple2(){
        ListaSimple<String> lista = new ListaSimple<String>();
        
        Assertions.assertEquals(expresionPostfix2, ConvertInToPostList.convertir(expresionInfix2, lista));
    }

    @Test
    public void listaDoble1(){
        ListaDoble<String> lista = new ListaDoble<String>();

        Assertions.assertEquals(expresionPostfix1, ConvertInToPostList.convertir(expresionInfix1, lista));
    }

    @Test
    public void listaDoble2(){
        ListaDoble<String> lista = new ListaDoble<String>();

        Assertions.assertEquals(expresionPostfix2, ConvertInToPostList.convertir(expresionInfix2, lista));
    }
}
