package linkedstack;

import java.util.EmptyStackException;

public interface Stack<T>
{
    boolean isEmpty();
    void push(T elem);
    T pop() throws Exception;
}
