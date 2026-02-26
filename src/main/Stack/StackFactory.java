package main.Stack;

import java.util.ArrayList;

// selecciona la implementacion a utilizar para un stack
// se utiliza el patron Factory
public class StackFactory<T> {

   public IStack<T> getStack(String tipoStack) {

      // seleccion de la implementacion a utilizar:
      if (tipoStack.equals("arrayList"))
         return new ArrayListStack<T>(); // regresa ArrayListStack

      else if (tipoStack.equals("list"))
         return new ListStack<T>(new ArrayList<T>()); // regresa ListStack

      else if (tipoStack.equals("vector"))
         return new VectorStack<T>(); // regresa VectorStack

      else
         return null; // tipo no valido
   }
}