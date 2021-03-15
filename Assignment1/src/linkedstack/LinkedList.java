package linkedstack;

import customexceptions.EmptyListException;

public class LinkedList<T> implements List<T>{
    private Node<T> head;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addToFront(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public T removeFirst() throws EmptyListException {
        if(isEmpty())
            throw new EmptyListException("Cannot remove from an empty list");

        T firstNodeData = head.getData();
        head = head.getNext();
        size--;
        return firstNodeData;
    }
}
