package main;

import java.util.Scanner;

public class App {
    private static Scanner teclado = new Scanner(System.in);
    private static Controlador controlador;

    public static void main(String[] args) throws Exception {
        boolean continuarMenu = true;
        escribir("Bienvenido al programa de calculo de infix\n");
        
        while (continuarMenu) {
            escribir("""
                    Elija el numero de una de las siguientes opciones:
                    1. Elegir archivo de texto
                    2. Elegir estructura de datos para calculos
                    3. Procesar documento
                    4. Terminar programa

                    """);

            switch (teclado.nextLine().strip()) {
                case "1":
                    escribir("Ingrese la ruta absoluta del archivo a usar\n");
                    
                    try {
                        controlador = new Controlador(teclado.nextLine());
                        escribir("El archivo se ha creado exitosamente\n\n");
                    } catch (Exception e) {
                        escribir(e.getMessage() + "\n\n");
                    }
                    
                    break; 
            
                case "2":
                    if (controlador != null) {
                        escribir("""
                                Elija uno de los siguientes tipos de estructuras de datos: 
                                1. Listas
                                2. Stacks

                                """);

                        switch (teclado.nextLine().strip()) {
                            case "1":
                                try {
                                    controlador.elegirADT(1, elegirTipoLista());
                                    escribir("La estructura de datos se ha creado correctamente");
                                } catch (Exception e) {
                                    escribir(e.getMessage() + "\n\n");
                                }
                                break;
                        
                            case "2":
                                try {
                                    controlador.elegirADT(2, elegirTipoStack());
                                    escribir("La estructura de datos se ha creado correctamente");
                                } catch (Exception e) {
                                    escribir(e.getMessage() + "\n\n");
                                }
                                break;

                            default:
                                break;
                        }
                    }
                    else{
                        escribir("Debe completar la opcion 1 con exito para usar esta opcion\n");
                    }
                    break;

                case "3":
                    if (controlador != null) {
                        escribir(controlador.procesarDocumento());
                        escribir("El archivo no contiene más operaciones\n\n");
                    }
                    else {
                        escribir("Debe completar la opcion 1 con exito para usar esta opcion\n");
                    }
                    break;

                case "4":
                    escribir("Gracias por usar el programa, esperamos volver a verlo pronto\n");
                    continuarMenu = false;
                    break;

                default:
                    escribir("La opcion ingresada no corresponde con alguna del menu, intentelo de nuevo\n");
                    break;
            }
        }
    }

    public static int elegirTipoLista(){
        escribir("""
                Elija el tipo de Lista a usar:
                1. Lista simplemente encadenada
                2. Lista doblemente encadenada

                """);

        switch (teclado.nextLine().strip()) {
            case "1":
                return 1;

            case "2":
                return 2;
        
            default:
                return -1;
        }
    }

    public static int elegirTipoStack(){
        escribir("""
                Elija el tipo de Stack a usar:
                1. ArrayList
                2. Vector
                3. List

                """);

        switch (teclado.nextLine().strip()) {
            case "1":
                return 1;

            case "2":
                return 2;

            case "3":
                return 3;
        
            default:
                return -1;
        }
    }

    public static void escribir(String texto){
        System.out.print(texto);
    }
}
