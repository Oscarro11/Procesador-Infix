package main.Converter;

import main.Stack.IStack;

public class ConvertInToPostStack{
    
    public static String convertir(String linea, IStack<String> stack){
        StringBuilder builder = new StringBuilder();
        String numeroEnConstruccion = "";

        for (String letra : linea.split("")) {
            
            if (letra.matches("^\\p{Alnum}+$")) {
                if (letra.matches("\\d+")) {
                    numeroEnConstruccion += letra;
                }
                else{
                    builder.append(letra + " ");
                }
            }
            else {
                if (!numeroEnConstruccion.equals("")) {
                    builder.append(numeroEnConstruccion + " ");
                    numeroEnConstruccion = "";    
                }
                
                if (letra.equals("(")){
                    stack.push(letra);
                }
                else if (letra.equals(")")) {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        builder.append(stack.pop() + " ");
                    }
                    stack.pop();
                }
                else{
                    while (!stack.isEmpty() && nivelOperador(letra) > nivelOperador(stack.peek())) {
                        builder.append(stack.pop() + " ");
                    }
                    stack.push(letra);
                }
            }
        }

        if (!numeroEnConstruccion.equals("")) {
            builder.append(numeroEnConstruccion + " ");
        }
    
        while (!stack.isEmpty()) {
            builder.append(stack.pop() + " ");
        }

        return builder.toString().strip();
    }

    private static int nivelOperador(String operador){
        switch (operador) {
            case "+":
            case "-":
                return 0;

            case "*":
            case "/":
            case "%":
                return 1;
            
            case "^":
                return 2;

            case "(":
                return 3;

            default:
                throw new IllegalArgumentException("Operador desconocido: " + operador);
        }
    }
}