package binarysearchtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BinarySearchTreeTest {

    private BinaryTreeNode regularTreeRoot;
    private BinarySearchTree bst;

    @BeforeEach
    public void setUpBST(){

        regularTreeRoot = new BinaryTreeNode(5);
        regularTreeRoot.addLeftChild(new BinaryTreeNode(3));
        regularTreeRoot.addRightChild(new BinaryTreeNode(7));

        regularTreeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(2));
        regularTreeRoot.getLeftChild().addRightChild(new BinaryTreeNode(4));

        regularTreeRoot.getLeftChild().getLeftChild().addLeftChild(new BinaryTreeNode(1));
        regularTreeRoot.getLeftChild().getLeftChild().addRightChild(new BinaryTreeNode(2));

        regularTreeRoot.getRightChild().addLeftChild(new BinaryTreeNode(6));
        regularTreeRoot.getRightChild().addRightChild(new BinaryTreeNode(8));

        bst = new BinarySearchTree(regularTreeRoot);
    }

    @Test
    public void insertNode(){
        int temp = bst.size();
        bst.insert(11);
        Assertions.assertEquals(bst.size(),temp+1);
        Assertions.assertTrue(bst.contains(11));
    }

    @Test
    public void insertMany(){
        int temp = bst.size();

        bst.insert(23);
        bst.insert(21);
        bst.insert(24);

        Assertions.assertEquals(bst.size(),temp+3);
        Assertions.assertTrue(bst.contains(23)&&bst.contains(21)&&bst.contains(24));
    }

    @Test
    public void findMax(){
        Assertions.assertEquals(bst.findMax(),8);
    }

    @Test
    public void findMin() {
        Assertions.assertEquals(bst.findMin(), 1);
    }

    @Test
    public void removeLeafNode()
    {
        bst.removeElement(1);
        Assertions.assertFalse(bst.contains(1));
        Assertions.assertNull(regularTreeRoot.getLeftChild().getLeftChild().getLeftChild());
    }
    @Test
    public void removeNodeWithOneChild()
    {
        bst.insert(9);
        bst.removeElement(8);
        Assertions.assertFalse(bst.contains(8));
        Assertions.assertEquals(9, regularTreeRoot.getRightChild().getRightChild().getElement());
        Assertions.assertNull(regularTreeRoot.getRightChild().getRightChild().getRightChild());
    }
    @Test
    public void removeNodeWithTwoChildren()
    {
        Assertions.assertEquals(6, regularTreeRoot.getRightChild().getLeftChild().getElement());
        bst.removeElement(5);
        Assertions.assertFalse(bst.contains(5));
        Assertions.assertEquals(6, regularTreeRoot.getElement());
        Assertions.assertEquals(7, regularTreeRoot.getRightChild().getElement());
        Assertions.assertNull(regularTreeRoot.getRightChild().getLeftChild());
        Assertions.assertEquals(8, regularTreeRoot.getRightChild().getRightChild().getElement());
    }
    @Test
    public void rebalance()
    {
        bst.removeElement(5);
        bst.rebalance();
        ArrayList<Integer> preOrder  = new ArrayList<>();
        preOrder.add(3);
        preOrder.add(2);
        preOrder.add(1);
        preOrder.add(2);
        preOrder.add(6);
        preOrder.add(4);
        preOrder.add(7);
        preOrder.add(8);
        Assertions.assertEquals(preOrder, bst.preOrder());
    }
}
