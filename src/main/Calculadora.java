package main;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

import main.Stack.VectorStack;

public class Calculadora{
    
    public static int procesarLineaPostfix(String linea) throws NoSuchElementException, InvalidParameterException{
        String[] contenidoLinea = linea.split("\\s+");
        VectorStack<Integer> vector =  new VectorStack<Integer>();

        for (String elemento : contenidoLinea) {
            try {
                int numero = Integer.parseInt(elemento);
                vector.push(numero);
            } catch (NumberFormatException e) {
                try {
                    int operandoB = vector.pop();
                    int operandoA = vector.pop();
                    int resultado = calcular(elemento, operandoA, operandoB);
                    vector.push(resultado);
                } catch (NoSuchElementException e2) {
                    throw new NoSuchElementException("La linea no tiene suficientes numeros para poder ser operada en formato postfix");
                } catch (InvalidParameterException e3) {
                    throw e3;
                }
            }
        }

        return vector.pop();
    }

    public static int calcular(String operador, int operandoA, int operandoB) throws InvalidParameterException{
        switch (operador) {
            case "+":
                return operandoA + operandoB;
                
            case "-":
                return operandoA - operandoB;

            case "*":
                return operandoA * operandoB;

            case "/":
                return operandoA / operandoB;

            case "%":
                return operandoA % operandoB;

            default:
                throw new InvalidParameterException("El simbolo '" + operador + "' no se reconoce, por lo que no se puede realizar la operacion");
        }
    }

}
