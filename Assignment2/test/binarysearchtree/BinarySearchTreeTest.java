package binarysearchtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(bst.findMax(regularTreeRoot),8);
    }

    @Test
    public void findMin() {
        Assertions.assertEquals(bst.findMin(regularTreeRoot), 1);
    }

}
