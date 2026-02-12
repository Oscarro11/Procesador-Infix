package java.Stack;

public interface IStack<T> {
    void push(T item); //agrega valor a la pila
    T pop();           //quita y devuelve ultimo valor agregado
    T peek();          //ve el ultimo valor agregado sin quitarlo
    boolean isEmpty(); //verifica si la pila esta vacia
    int size();   
}
