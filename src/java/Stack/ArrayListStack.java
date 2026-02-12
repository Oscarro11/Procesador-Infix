package java.Stack;

import java.util.ArrayList;

public class ArrayListStack<T> implements IStack<T> {
    private ArrayList<T> data;

    public ArrayListStack(){
        data = new ArrayList<T>();
    }

    public void push (T item){
        data.add(item);
    }

    public T pop(){
        if (isEmpty()){
            throw new RuntimeException("Stack vacío");
        }
        return data.remove(data.size() - 1);
    }

    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("Stack vacío");
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
