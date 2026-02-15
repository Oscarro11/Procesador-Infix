package test;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.Converter.*;
import main.Stack.*;

public class ConvertInToPostStackTest {
    String expresionInfix1 = "(10+20)*9";
    String expresionPostfix1 = "10 20 + 9 *";
    String expresionInfix2 = "(2+3)*(7-4)";
    String expresionPostfix2 = "2 3 + 7 4 - *";

    @Test
    public void arrayList1(){
        ArrayListStack<String> lista = new ArrayListStack<String>();
        
        Assertions.assertEquals(expresionPostfix1, ConvertInToPostStack.convertir(expresionInfix1, lista));
    }

    @Test
    public void arrayList2(){
        ArrayListStack<String> lista = new ArrayListStack<String>();
        
        Assertions.assertEquals(expresionPostfix2, ConvertInToPostStack.convertir(expresionInfix2, lista));
    }

    @Test
    public void listStack1(){
        ListStack<String> lista = new ListStack<String>(new ArrayList<String>());
        
        Assertions.assertEquals(expresionPostfix1, ConvertInToPostStack.convertir(expresionInfix1, lista));
    }

    @Test
    public void listStack2(){
        ListStack<String> lista = new ListStack<String>(new ArrayList<String>());
        
        Assertions.assertEquals(expresionPostfix2, ConvertInToPostStack.convertir(expresionInfix2, lista));
    }

    @Test
    public void VectorStack1(){
        VectorStack<String> lista = new VectorStack<String>();
        
        Assertions.assertEquals(expresionPostfix1, ConvertInToPostStack.convertir(expresionInfix1, lista));
    }

    @Test
    public void VectorStack2(){
        VectorStack<String> lista = new VectorStack<String>();
        
        Assertions.assertEquals(expresionPostfix2, ConvertInToPostStack.convertir(expresionInfix2, lista));
    }
}