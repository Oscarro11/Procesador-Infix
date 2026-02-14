package main.lists;

import java.lang.Cloneable;

public class NodoDoble<T> implements Cloneable{
    private T dato;
    private NodoDoble<T> previo;
    private NodoDoble<T> siguiente;

    public NodoDoble(T dato, NodoDoble<T> previo, NodoDoble<T> siguiente){
        this.dato = dato;
        this.previo = previo;
        this.siguiente = siguiente;
    }

    public void setPrevio(NodoDoble<T> previo){
        this.previo = previo;
    }

    public void setSiguiente(NodoDoble<T> siguiente){
        this.siguiente = siguiente;
    }

    public T getDato(){
        return dato;
    }

    public NodoDoble<T> getPrevio(){
        return previo;
    }

    public NodoDoble<T> getSiguiente(){
        return siguiente;
    }

    @Override
    public NodoDoble<T> clone(){
        return new NodoDoble<T>(dato, previo, siguiente);
    }
}