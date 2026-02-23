package main.Stack;

import java.util.ArrayList;

public class StackFactory<T> {
    
    /**
     * Metodo principal para instanciar {@code IStack}
     * @param tipoStack tipo de {@code IStack} a instanciar. Puede ser: "arrayList", "list", "vector".
     * @return {@code IStack}
     */
    public IStack<T> createStack(String tipoStack){
        switch (tipoStack) {
            case "arrayList":
                return new ArrayListStack<T>();
        
            case "list":
                return new ListStack<T>(new ArrayList<T>());

            case "vector":
                return new VectorStack<T>();

            default:
                return null;
        }
    }
}
