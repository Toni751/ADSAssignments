package linkedstack;

import customexceptions.EmptyListException;
import linkedstack.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest
{
    private LinkedList<Integer> linkedList;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;


    @BeforeEach
    void setUp()
    {
        this.linkedList = new LinkedList<>();
        item1 = 1;
        item2 = 2;
        item3 = 3;
        item4 = 4;
        item5 = 5;
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void isEmptyFalse()
    {
        linkedList.addToFront(item1);
        Assertions.assertFalse(linkedList.isEmpty());

    }

    @Test
    void isEmptyTrue()
    {
        Assertions.assertTrue(linkedList.isEmpty());
    }

    @Test
    void sizeZero()
    {

        Assertions.assertEquals(linkedList.size(), 0);
    }

    @Test
    void sizeOne()
    {
        linkedList.addToFront(item1);
        Assertions.assertEquals(linkedList.size(), 1);
    }

    @Test
    void sizeMany()
    {
        linkedList.addToFront(item3);
        linkedList.addToFront(item4);
        Assertions.assertEquals(linkedList.size(), 2);
    }

    @Test
    void addToFrontToEmpty()
    {
        Assertions.assertEquals(linkedList.size(), 0);
        linkedList.addToFront(item3);
        Assertions.assertFalse(linkedList.isEmpty());
        Assertions.assertEquals(linkedList.size(), 1);
    }


    @Test
    void addToFrontToMany()
    {
        linkedList.addToFront(item4);
        linkedList.addToFront(item5);
        linkedList.addToFront(item3);
        Assertions.assertFalse(linkedList.isEmpty());
        Assertions.assertEquals(linkedList.size(), 3);
    }

    @Test
    void removeFirstEmpty()
    {
        Assertions.assertThrows(EmptyListException.class, () ->
                linkedList.removeFirst());
    }

    @Test
    void removeFirstOne() throws Exception
    {
        Assertions.assertEquals(linkedList.size(), 0);
        linkedList.addToFront(item1);
        Assertions.assertEquals(linkedList.size(), 1);
        int firstElement = linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 0);
        Assertions.assertEquals(item1, firstElement);
    }

    @Test
    void removeFirstMany() throws Exception
    {
        int firstItem;
        linkedList.addToFront(item4);
        linkedList.addToFront(item5);
        linkedList.addToFront(item2);
        Assertions.assertEquals(linkedList.size(), 3);

        firstItem = linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 2);
        Assertions.assertEquals(firstItem, item2);

        firstItem = linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 1);
        Assertions.assertEquals(firstItem, item5);

        firstItem = linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 0);
        Assertions.assertEquals(firstItem, item4);
    }
}