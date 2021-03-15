package linkedstack;

import customexceptions.EmptyStackException;

public interface Stack<T>
{
    boolean isEmpty();
    void push(T elem);
    T pop() throws EmptyStackException;
}
