package linkedstack;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {
    private LinkedList<T> list;

    public LinkedStack() {
        list = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T elem) {
        list.addToFront(elem);
    }

    @Override
    public T pop() throws Exception {
        try {
            return list.removeFirst();
        } catch (Exception e) {
            throw new Exception("Cannot pop from empty stack");
        }
    }
}
