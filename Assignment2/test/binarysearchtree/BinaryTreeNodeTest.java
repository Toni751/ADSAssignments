package binarysearchtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryTreeNodeTest {

    private BinaryTreeNode node;
    private int element1;
    private int element2;
    private int element3;

    @BeforeEach
    void setUpNode()
    {
        element1 = 1;
        element2 = 2;
        element3 = 3;
        node = new BinaryTreeNode(element1);
    }

    @Test
    void setElementReplacesDefaultElement()
    {
        Assertions.assertEquals(element1, node.getElement());
        node.setElement(element2);
        Assertions.assertEquals(element2, node.getElement());
    }

    @Test
    void getElementRetrievesProperElement()
    {
        Assertions.assertEquals(element1, node.getElement());
    }

    @Test
    void addNullLeftChild()
    {
        node.addLeftChild(null);
        Assertions.assertNull(node.getLeftChild());
    }

    @Test
    void addNonNullLeftChild()
    {
        node.addLeftChild(new BinaryTreeNode(element2));
        Assertions.assertEquals(element2, node.getLeftChild().getElement());
    }

    @Test
    void addNullRightChild()
    {
        node.addRightChild(null);
        Assertions.assertNull(node.getRightChild());
    }

    @Test
    void addNonNullRightChild()
    {
        node.addRightChild(new BinaryTreeNode(element3));
        Assertions.assertEquals(element3, node.getRightChild().getElement());
    }

    @Test
    void getLeftChildForNull()
    {
        Assertions.assertNull(node.getLeftChild());
    }

    @Test
    void getLeftChildReturnsReferenceToNonNullChild()
    {
        BinaryTreeNode leftChild = new BinaryTreeNode(element2);
        node.addLeftChild(leftChild);
        Assertions.assertEquals(leftChild, node.getLeftChild());
    }

    @Test
    void getRightChildForNull()
    {
        Assertions.assertNull(node.getRightChild());
    }

    @Test
    void getRightChildReturnsReferenceToNonNullChild()
    {
        BinaryTreeNode rightChild = new BinaryTreeNode(element3);
        node.addRightChild(rightChild);
        Assertions.assertEquals(rightChild, node.getRightChild());
    }

    @Test
    void getBothChildrenOfNode()
    {
        node.addLeftChild(new BinaryTreeNode(element2));
        node.addRightChild(new BinaryTreeNode(element3));
        Assertions.assertEquals(element2, node.getLeftChild().getElement());
        Assertions.assertEquals(element3, node.getRightChild().getElement());
    }
}
