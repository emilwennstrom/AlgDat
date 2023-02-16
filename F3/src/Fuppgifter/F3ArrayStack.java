package Fuppgifter;


import java.sql.Array;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Arrays;

public class F3ArrayStack<E> implements StackInt<E> {

    private E[] myArrStack;
    private int top;
    private int maxSize;
    @SuppressWarnings("unchecked")
    public F3ArrayStack(int maxSize) {
        myArrStack = (E[]) new Object[maxSize];
        top = -1;
        this.maxSize = maxSize;
    }
    public F3ArrayStack() {
        this(10);
    }

    private void reallocate(){
        maxSize *= 2;
        myArrStack = Arrays.copyOf(myArrStack, maxSize);
    }

    @Override
    public E push(E obj) {
        if (top == maxSize-1) {
            reallocate();
        }
        top++;
        myArrStack[top] = obj;
        return obj;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return myArrStack[top];
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return myArrStack[top--];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }
}
