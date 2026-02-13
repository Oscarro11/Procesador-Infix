package main.Stack;

public class ListStack<T> implements IStack<T> {
    //propia interfaz
    private List<T> list; //almacenamiento interno 

    //constructor
    public ListStack(List<T> listImplementation){
        list = listImplementation;
    }

    //métodos
    //consideramos el inicio de la lista como la parte superior de la pila
    public void push (T item){
        list.addFirst(item);
    }

    public T pop(){
        if (isEmpty()){
            throw new RuntimeException("Stack vacío");
        }
        return list.removeFirst();
    }

    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("Stack vacío");
        }
        return list.getFirst();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

}
