package main.Stack;
import java.util.NoSuchElementException;
import java.util.Vector;

public class VectorStack<T> implements IStack<T> {

    private Vector<T> data;

    //constructor
    public VectorStack(){
        data = new Vector<T>();
    }

    //métodos

    public void push (T item){
        data.add(item);
    }

    public T pop(){
        if (isEmpty()){
            throw new NoSuchElementException("Stack vacío");
        }
        return data.remove(data.size() - 1);
    }

    public T peek(){
        if (isEmpty()){
            throw new NoSuchElementException("Stack vacío");
        }
        return data.get(data.size() - 1);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public int size(){
        return data.size();
    }
    
}
