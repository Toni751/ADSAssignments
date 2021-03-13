package linkedstack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedStackTest
{
    private LinkedStack<Integer> linkedStack;
    private int item1;
    private int item2;
    private int item3;

    @BeforeEach
    void setUp()
    {
        this.linkedStack = new LinkedStack<>();
        this.item1 = 1;
        this.item2 = 2;
        this.item3 = 3;

    }

    @Test
    void isEmptyTrue()
    {
        Assertions.assertTrue(linkedStack.isEmpty());
    }

    @Test
    void isEmptyFalse()
    {
        linkedStack.push(item1);
        Assertions.assertFalse(linkedStack.isEmpty());
    }

    @Test
    void pushOne()
    {
        Assertions.assertTrue(linkedStack.isEmpty());
        linkedStack.push(item1);
        Assertions.assertFalse(linkedStack.isEmpty());
    }

    @Test
    void pushMany()
    {
        Assertions.assertTrue(linkedStack.isEmpty());
        linkedStack.push(item1);
        linkedStack.push(item2);
        linkedStack.push(item3);
        Assertions.assertFalse(linkedStack.isEmpty());
    }


    @Test
    void popOne() throws Exception
    {
        linkedStack.push(item1);
        Assertions.assertFalse(linkedStack.isEmpty());
        Object object = linkedStack.pop();
        Assertions.assertEquals(object, 1);
    }

    @Test
    void popEmpty()
    {
        Assertions.assertThrows(Exception.class, () ->
                linkedStack.pop());
    }

    @Test
    void popMany() throws Exception
    {   //not sure but shouldn't pop remove from the end?
        linkedStack.push(item1);
        linkedStack.push(item2);
        linkedStack.push(item3);
        Assertions.assertFalse(linkedStack.isEmpty());
        Object object3 = linkedStack.pop();
        Object object2 = linkedStack.pop();
        Object object1 = linkedStack.pop();
        Assertions.assertEquals(object1, 1);
        Assertions.assertEquals(object2, 2);
        Assertions.assertEquals(object3, 3);
        Assertions.assertTrue(linkedStack.isEmpty());
    }
}