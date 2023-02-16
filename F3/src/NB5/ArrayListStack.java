package NB5;

import Fuppgifter.StackInt;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInt<E> {

    private ArrayList<E> data;

    public ArrayListStack(){
        data = new ArrayList<>();
    }


    @Override
    public E push(E obj) {
        data.add(obj);
        return obj;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data.get(data.size() - 1);
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data.remove(data.size() - 1);
    }

    @Override
    public boolean empty() {
        return data.size() == 0;
    }
}
