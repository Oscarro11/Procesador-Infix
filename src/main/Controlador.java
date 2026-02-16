package main;

import java.io.IOException;
import java.util.InputMismatchException;

public class Controlador {

    //Lector de donde se obtendra el texto de un .txt
    private LectorDeTexto lector;

    //Controlador de operaciones infix
    private ControladorInfix controladorInfix = new ControladorInfix();

    public Controlador(String rutaArchivo) throws InputMismatchException{
        try {
            crearLector(rutaArchivo);
        } catch (IOException e) {
            throw new InputMismatchException("La ruta del archivo a leer es invalida");
        }
    }

    /**
     * Genera un nuevo lector de texto, el cual extrae el texto de un archivo.txt para las operaciones de infix
     * @param rutaArchivo ruta absoluta del .txt
     * @throws IOException
     */
    public void crearLector(String rutaArchivo) throws IOException{
        rutaArchivo = formatearRuta(rutaArchivo);
        
        try {
           lector = new LectorDeTexto(rutaArchivo); 
        } catch (IOException e) {
            throw e;
        }
    }

    private String formatearRuta(String rutaArchivo){
        return rutaArchivo.replace("\"", "");
    }

    /**
     * Genera una estructura de datos de tipo {@code IList} o {@code IStack} para operaciones infix
     * @param categoria codigo del tipo de ADT que se quiere crear:<br>
     *                  1 = List<br>
     *                  2 = Stack
     * @param codigo codigo especifico del ADT a crearse, segun la categoria:<br>
     *                  Para List:
     *                  <ul>
     *                      <li>1 = Lista de encadenado simple</li>
     *                      <li>2 = Lista de encadenado doble</li>
     *                  </ul><br>
     * 
     *                  Para Stack:
     *                  <ul>
     *                      <li>1 = ArrayList</li>
     *                      <li>2 = Vector</li>
     *                      <li>3 = List</li>
     *                  </ul>
     * @throws IllegalArgumentException
     */
    public void elegirADT(int categoria, int codigo) throws IllegalArgumentException{
        switch (categoria) {
            case 1:
                controladorInfix.generarList(codigo);
                break;
        
            case 2:
                controladorInfix.generarStack(codigo);
                break;

            default:
                throw new IllegalArgumentException("No existe una categoria de ADT con numero: " + categoria);
        }
    }

    /**
     * A partir de un {@code LectorDeTexto} propio, se generan los resultados de las expresiones infix encontradas
     * @return {@code String} que contiene los resultados de cada linea infix
     */
    public String procesarDocumento() throws IllegalStateException{
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < lector.cantidadLineas(); i++){
            String linea = lector.textoLinea(i);

            try{
                int resultadoLinea = controladorInfix.calcularInfix(linea);
                builder.append(mostrarResultado(linea, resultadoLinea));
                builder.append("\n");    
            } catch (Exception e) {
                builder.append(mensajeLineaInvalida(linea));
                builder.append(e.getMessage());
                builder.append("\n\n");
            }
        }

        return builder.toString();
    }

    private String mensajeLineaInvalida(String linea) {
        return "La linea '" + linea + "' no puede ser procesada en el formato infix, debido a lo siguiente: \n";
    }

    public String mostrarResultado(String linea, int resultado){
        return "El resultado de operar la expresion '" + linea + "' es: " + resultado;
    }
}
