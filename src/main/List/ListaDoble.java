package main.List;

import java.util.List;
import java.util.ArrayList;

public class ListaDoble<T> implements IList<T> {
    private NodoDoble<T> cabeza;

    public List<T> recorrer(){
        List<T> coleccion = new ArrayList<T>();
        NodoDoble<T> actual = cabeza;

        while (actual != null) {
            coleccion.add(actual.getDato());
            actual = actual.getSiguiente();
        }

        return coleccion;
    }

    //El recorrido inverso es una funcion propia de las listas doblemente encadenadas, aunque
    // no es necesario tenerlo para que la lista funcione como Stack
    public List<T> recorrerInverso(){
        List<T> coleccion = new ArrayList<T>();
        NodoDoble<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        while (actual != null) {
            coleccion.add(actual.getDato());
            actual = actual.getPrevio();
        }

        return coleccion;
    }

    public void agregarPrimero(T elemento){
        NodoDoble<T> nuevo = new NodoDoble<T>(elemento, null, cabeza);
        NodoDoble<T> temp = cabeza;
        
        cabeza = nuevo;

        if (temp != null) {
            temp.setPrevio(cabeza);   
        }
    };

    public T retirarPrimero() throws NullPointerException{
        T dato = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        cabeza.setPrevio(null);

        return dato;
    };

    public T verPrimero() throws NullPointerException{
        return cabeza.getDato();
    };

    public int size(){
        int cont = 0;
        NodoDoble<T> actual = cabeza;

        while (actual != null) {
            cont++;
            actual = actual.getSiguiente();
        }

        return cont;
    };

    public boolean isEmpty(){
        return cabeza == null;
    };
}
