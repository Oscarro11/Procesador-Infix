package main;

import java.security.InvalidParameterException;

import main.Converter.*;
import main.List.*;
import main.Stack.*;

public class ControladorInfix {

    //Estructuras de datos a usar para la conversion de expresiones, deben cambiarse a lo largo del programa
    private IList<String> listaActiva = null;
    private IStack<String> stackActivo = null;

    //Indicador del tipo de la ultima estructura de datos creada
    private String estructuraActiva = "";

    /**
     * Crea y guarda una estructura de datos de tipo Lista, con el proposito de usarse para el calculo de expresiones infix
     * @param tipoList nombre del tipo de {@code IList} a crearse
     * @throws InvalidParameterException
     */
    public void generarList(String tipoList) throws InvalidParameterException{
        ListFactory<String> factory = new ListFactory<>();
        
        listaActiva = factory.createList(tipoList);
        
        if (listaActiva == null) {
            estructuraActiva = "";
            throw new InvalidParameterException("No existe un tipo de lista con el nombre: " + tipoList);
        }

        estructuraActiva = "lista";
    }

    /**
     * Crea y guarda una estructura de datos de tipo Stack, con el proposito de usarse para el calculo de expresiones infix
     * @param tipoList nombre del tipo de {@code IStack} a crearse
     * @throws InvalidParameterException
     */
    public void generarStack(String tipoStack) throws InvalidParameterException{
        StackFactory<String> factory = new StackFactory<>();
        
        stackActivo = factory.createStack(tipoStack);
        
        if (stackActivo == null) {
            estructuraActiva = "";
            throw new InvalidParameterException("No existe un tipo de stack con el nombre: " + tipoStack);
        }

        estructuraActiva = "stack";
    }

    /**
     * Calcula el resultado de una expresion matematica en formato infix
     * @param linea {@code String} que contiene la expresion matematica
     * @return resultado de calcular expresion infix
     */
    public int calcularInfix(String linea){
        String expresionPostfix = convertirInfixToPost(linea);
        return Calculadora.procesarLineaPostfix(expresionPostfix);
    }

    private String convertirInfixToPost(String expresion) throws IllegalStateException{
        String expresionPostfix = "";
        
        switch (estructuraActiva) {
            case "lista":
                expresionPostfix = ConvertInToPostList.convertir(expresion, listaActiva);
                break;
        
            case "stack":
                expresionPostfix = ConvertInToPostStack.convertir(expresion, stackActivo);
                break;

            default:
                throw new IllegalStateException("No se ha designado una estructura de datos para la conversion de Infix a Postfix");
        }

        return expresionPostfix;
    }
}
