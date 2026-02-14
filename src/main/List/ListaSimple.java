package main.List;

import java.util.ArrayList;
import java.util.List;

public class ListaSimple<T> implements IList<T>{
    private NodoSimple<T> cabeza;

    public List<T> recorrer(){
        List<T> coleccion = new ArrayList<T>();
        NodoSimple<T> actual = cabeza;

        while (actual != null) {
            coleccion.add(actual.getDato());
            actual = actual.getSiguiente();
        }

        return coleccion;
    }

    public void agregarPrimero(T elemento){
        NodoSimple<T> nuevo = new NodoSimple<T>(elemento, cabeza);
        cabeza = nuevo;
    }

    public T retirarPrimero() throws NullPointerException{
        T dato = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        return dato;
    }

    public T verPrimero() throws NullPointerException{
        return cabeza.getDato();
    }

    public int size(){
        int cont = 0;
        NodoSimple<T> actual = cabeza;

        while (actual != null) {
            cont++;
            actual = actual.getSiguiente();
        }

        return cont;
    }

    public boolean isEmpty(){
        return cabeza == null;
    }
}
