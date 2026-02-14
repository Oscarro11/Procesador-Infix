package main.lists;

import java.lang.Cloneable;

public class NodoSimple<T> implements Cloneable{
    private T dato;
    private NodoSimple<T> siguiente;

    public NodoSimple(T dato, NodoSimple<T> siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
    } 

    public void setSiguiente(NodoSimple<T> siguiente){
        this.siguiente = siguiente;
    }

    public T getDato(){
        return dato;
    }

    public NodoSimple<T> getSiguiente(){
        return siguiente;
    }

    @Override
    public NodoSimple<T> clone(){
        return new NodoSimple<T>(dato, siguiente);
    }
}
