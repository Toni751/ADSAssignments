package linkedstack;

import customexceptions.EmptyListException;

public interface List<T>
{
    boolean isEmpty();
    int size();
    void addToFront(T data);
    T removeFirst() throws EmptyListException;
}
