package main.List;

public class ListFactory<T> {
    
    /**
     * Metodo principal para instanciar {@code IList}
     * @param tipoList tipo de {@code IList} a instanciar. Puede ser: "simple", "doble".
     * @return {@code IList}
     */
    public IList<T> createList(String tipoList){
        switch (tipoList) {
            case "simple":
                return new ListaSimple<T>();
        
            case "doble":
                return new ListaDoble<T>();

            default:
                return null;
        }
    }
}
