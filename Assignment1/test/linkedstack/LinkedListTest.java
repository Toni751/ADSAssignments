package linkedstack;

import linkedstack.LinkedList;
import org.junit.jupiter.api.Assertions;

class LinkedListTest
{
    private LinkedList<Integer> linkedList;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;


    @org.junit.jupiter.api.BeforeEach
    void setUp()
    {
        this.linkedList = new LinkedList<>();
        item1 = 1;
        item2 = 2;
        item3 = 3;
        item4 = 4;
        item5 = 5;
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown()
    {
    }

    @org.junit.jupiter.api.Test
    void isEmptyFalse()
    {
        linkedList.addToFront(item1);
        Assertions.assertFalse(linkedList.isEmpty());

    }

    @org.junit.jupiter.api.Test
    void isEmptyTrue()
    {
        Assertions.assertTrue(linkedList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void sizeZero()
    {

        Assertions.assertEquals(linkedList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void sizeOne()
    {
        linkedList.addToFront(item1);
        Assertions.assertEquals(linkedList.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void sizeMany()
    {
        linkedList.addToFront(item3);
        linkedList.addToFront(item4);
        Assertions.assertEquals(linkedList.size(), 2);
    }

    @org.junit.jupiter.api.Test
    void addToFrontToEmpty()

    {

        Assertions.assertEquals(linkedList.size(), 0);
        linkedList.addToFront(item3);
        Assertions.assertFalse(linkedList.isEmpty());
        Assertions.assertEquals(linkedList.size(), 1);

    }


    @org.junit.jupiter.api.Test
    void addToFrontToMany()
    {

        linkedList.addToFront(item4);
        linkedList.addToFront(item5);
        linkedList.addToFront(item3);
        Assertions.assertFalse(linkedList.isEmpty());
        Assertions.assertEquals(linkedList.size(), 3);
    }

    @org.junit.jupiter.api.Test
    void removeFirstEmpty()
    {

        Assertions.assertThrows(Exception.class, () ->
                linkedList.removeFirst());
    }

    @org.junit.jupiter.api.Test
    void removeFirstOne() throws Exception
    {
        Assertions.assertEquals(linkedList.size(), 0);
        linkedList.addToFront(item1);
        Assertions.assertEquals(linkedList.size(), 1);
        linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void removeFirstMany() throws Exception
    {

        linkedList.addToFront(item4);
        linkedList.addToFront(item5);
        linkedList.addToFront(item2);
        Assertions.assertEquals(linkedList.size(), 3);
        linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 2);
        linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 1);
        linkedList.removeFirst();
        Assertions.assertEquals(linkedList.size(), 0);
    }
}