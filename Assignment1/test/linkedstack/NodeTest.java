package linkedstack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeTest
{
    private Node<Integer> node;
    private int item1;
    private int item2;
    private int item3;

    @BeforeEach
    void setUp()
    {
        item1 = 1;
        item2 = 2;
        item3 = 3;
        this.node = new Node<>(item1);
    }

    @Test
    void setDataSameType()
    {
        Assertions.assertEquals(node.getData(), 1);
        node.setData(item2);
        Assertions.assertEquals(node.getData(), 2);
    }

    @Test
    void getData()
    {
        Assertions.assertEquals(node.getData(), 1);
    }

    @Test
    void setNext()
    {
        Node<Integer> node1 = new Node<>(item2);
        node.setNext(node1);
        Assertions.assertEquals(node.getNext().getData(), 2);
    }

    @Test
    void getNext()
    {
        Node<Integer> node1 = new Node<>(item2);
        node.setNext(node1);
        Assertions.assertEquals(node.getNext().getData(), 2);
    }
}