package main;

import java.security.InvalidParameterException;
import java.util.ArrayList;

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
     * @param tipoList codigo del tipo de {@code IList} a crearse:<br>
     *                  1 = Lista de encadenado simple<br>
     *                  2 = Lista de encadenado doble
     * @throws InvalidParameterException
     */
    public void generarList(int tipoList) throws InvalidParameterException{
        switch (tipoList) {
            case 1:
                listaActiva = new ListaSimple<String>();
                break;
            
            case 2:
                listaActiva = new ListaDoble<String>();
                break;

            default:
                listaActiva = null;
                estructuraActiva = "";
                throw new InvalidParameterException("No existe un tipo de lista con el numero: " + tipoList);
        }

        estructuraActiva = "lista";
    }

    /**
     * Crea y guarda una estructura de datos de tipo Stack, con el proposito de usarse para el calculo de expresiones infix
     * @param tipoList codigo del tipo de {@code IStack} a crearse:<br>
     *                  1 = ArrayList<br>
     *                  2 = Vector<br>
     *                  3 = Lista
     * @throws InvalidParameterException
     */
    public void generarStack(int tipoStack) throws InvalidParameterException{
        switch (tipoStack) {
            case 1:
                stackActivo = new ArrayListStack<String>();
                break;

            case 2:
                stackActivo = new VectorStack<String>();
                break;

            case 3:
                stackActivo = new ListStack<String>(new ArrayList<String>());
                break;

            default:
                stackActivo = null;
                estructuraActiva = "";
                throw new InvalidParameterException("No existe un tipo de stack con el numero: " + tipoStack);
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
