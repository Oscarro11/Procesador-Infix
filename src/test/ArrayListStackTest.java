package test;

import main.Stack.ArrayListStack;
import main.Stack.IStack;

import org.junit.Assert;
import org.junit.Test;

public class ArrayListStackTest {
    @Test
    public void pushPop(){
        IStack<Integer> stack = new ArrayListStack<Integer>();
        stack.push(8);
        stack.push(3);
        Assert.assertEquals(Integer.valueOf(3), stack.pop());
        Assert.assertEquals(Integer.valueOf(8), stack.pop());
    }

    @Test
    public void peek(){
        IStack<Integer> stack = new ArrayListStack<Integer>();
        stack.push(3);
        Assert.assertEquals(Integer.valueOf(3), stack.peek());
        Assert.assertEquals(1, stack.size());
    }

    @Test
    public void isEmpty(){
        IStack<Integer> stack = new ArrayListStack<Integer>();
        Assert.assertTrue(stack.isEmpty());
        stack.push(5);
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void size(){
        IStack<Integer> stack = new ArrayListStack<Integer>();
        Assert.assertEquals(0, stack.size());
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(2, stack.size());
    }
}
