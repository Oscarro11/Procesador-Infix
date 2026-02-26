package main.List;

// selecciona la implementacion a utilizar para una lista
// se utiliza el patron Factory
public class ListFactory<T> {

   public IList<T> getList(String tipoList) {

      // seleccion de la implementacion a utilizar:
      if (tipoList.equals("simple"))
         return new ListaSimple<T>(); // regresa ListaSimple

      else if (tipoList.equals("doble"))
         return new ListaDoble<T>(); // regresa ListaDoble

      else
         return null; // tipo no valido
   }
}