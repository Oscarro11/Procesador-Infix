package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import main.Converter.*;
import main.List.*;

public class ConvertInToPostTest {
    String expresionInfix = "(10+20)*9";
    String expresionPostfix = "10 20 + 9 *";

    @Test
    public void listaSimple(){
        ListaSimple<String> lista = new ListaSimple<String>();
        
        Assertions.assertEquals(expresionPostfix, ConvertInToPostList.convertir(expresionInfix, lista));
    }

    @Test
    public void listaDoble(){
        ListaDoble<String> lista = new ListaDoble<String>();

        Assertions.assertEquals(expresionPostfix, ConvertInToPostList.convertir(expresionInfix, lista));
    }
}
