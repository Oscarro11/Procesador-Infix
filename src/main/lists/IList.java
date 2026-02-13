package main.lists;

import java.util.List;

public interface IList<T> {
    List<T> recorrer();
    void agregarPrimero(T elemento);
    T retirarPrimero();
    T verPrimero();
    int size();
    boolean isEmpty();
}
