package main.Converter;

import main.List.IList;

public class ConvertInToPostList{
    
    public static String convertir(String linea, IList<String> stack){
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
                    stack.agregarPrimero(letra);
                }
                else if (letra.equals(")")) {
                    while (!stack.isEmpty() && !stack.verPrimero().equals("(")) {
                        builder.append(stack.retirarPrimero() + " ");
                    }
                    stack.retirarPrimero();
                }
                else{
                    while (!stack.isEmpty() && nivelOperador(letra) > nivelOperador(stack.verPrimero())) {
                        builder.append(stack.retirarPrimero() + " ");
                    }
                    stack.agregarPrimero(letra);
                }
            }
        }

        if (!numeroEnConstruccion.equals("")) {
            builder.append(numeroEnConstruccion + " ");    
        }
        
        while (!stack.isEmpty()) {
            builder.append(stack.retirarPrimero() + " ");
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
