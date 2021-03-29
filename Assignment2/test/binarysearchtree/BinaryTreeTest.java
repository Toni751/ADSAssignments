package binarysearchtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BinaryTreeTest
{

    private BinaryTreeNode regularTreeRoot; // value 5
    private BinaryTree regularTree; // size 9

    private BinaryTree emptyTree; // size 0

    private BinaryTreeNode rootTreeWithOnlyTheRoot; // value 4
    private BinaryTree treeWithOnlyTheRoot; // size 1

    private BinaryTreeNode fullTreeRoot; // value 4
    private BinaryTree fullTree; // size 7

    private BinaryTreeNode heavyLeftTreeRoot; // value 5
    private BinaryTree heavyLeftTree; // size 5

    private BinaryTreeNode heavyRightTreeRoot; // value 1
    private BinaryTree heavyRightTree; // size 5

    @BeforeEach
    public void setUp()
    {
        regularTreeRoot = new BinaryTreeNode(5);

        regularTreeRoot.addLeftChild(new BinaryTreeNode(3));
        regularTreeRoot.addRightChild(new BinaryTreeNode(7));

        regularTreeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(2));
        regularTreeRoot.getLeftChild().addRightChild(new BinaryTreeNode(4));

        regularTreeRoot.getLeftChild().getLeftChild().addLeftChild(new BinaryTreeNode(1));
        regularTreeRoot.getLeftChild().getLeftChild().addRightChild(new BinaryTreeNode(2));

        regularTreeRoot.getRightChild().addLeftChild(new BinaryTreeNode(6));
        regularTreeRoot.getRightChild().addRightChild(new BinaryTreeNode(8));

        regularTree = new BinaryTree(regularTreeRoot);

        emptyTree = new BinaryTree(null);

        rootTreeWithOnlyTheRoot = new BinaryTreeNode(4);
        treeWithOnlyTheRoot = new BinaryTree(rootTreeWithOnlyTheRoot);

        fullTreeRoot = new BinaryTreeNode(4);
        fullTree = new BinaryTree(fullTreeRoot);
        fullTreeRoot.addLeftChild(new BinaryTreeNode(2));
        fullTreeRoot.addRightChild(new BinaryTreeNode(6));

        fullTreeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(1));
        fullTreeRoot.getLeftChild().addRightChild(new BinaryTreeNode(3));

        fullTreeRoot.getRightChild().addLeftChild(new BinaryTreeNode(5));
        fullTreeRoot.getRightChild().addRightChild(new BinaryTreeNode(7));

        fullTree = new BinaryTree(fullTreeRoot);

        heavyLeftTreeRoot = new BinaryTreeNode(5);

        heavyLeftTreeRoot.addLeftChild(new BinaryTreeNode(3));

        heavyLeftTreeRoot.getLeftChild().addLeftChild(new BinaryTreeNode(2));
        heavyLeftTreeRoot.getLeftChild().addRightChild(new BinaryTreeNode(4));

        heavyLeftTreeRoot.getLeftChild().getLeftChild().addLeftChild(new BinaryTreeNode(1));

        heavyLeftTree = new BinaryTree(heavyLeftTreeRoot);

        heavyRightTreeRoot = new BinaryTreeNode(1);

        heavyRightTreeRoot.addRightChild(new BinaryTreeNode(3));

        heavyRightTreeRoot.getRightChild().addLeftChild(new BinaryTreeNode(2));
        heavyRightTreeRoot.getRightChild().addRightChild(new BinaryTreeNode(4));

        heavyRightTreeRoot.getRightChild().getRightChild().addRightChild(new BinaryTreeNode(5));

        heavyRightTree = new BinaryTree(heavyLeftTreeRoot);
    }

    @Test
    public void getRootOfEmptyTree()
    {
        Assertions.assertNull(emptyTree.getRoot());
    }

    @Test
    public void getRootOfTreeWithOnlyRoot()
    {
        Assertions.assertEquals(4, treeWithOnlyTheRoot.getRoot().getElement());
    }

    @Test
    public void getRootOfRegularTree()
    {
        Assertions.assertEquals(regularTreeRoot, regularTree.getRoot());
    }

    @Test
    public void setRootOfEmptyTree()
    {
        emptyTree.setRoot(new BinaryTreeNode(3));
        Assertions.assertEquals(3, emptyTree.getRoot().getElement());
    }

    @Test
    public void setRootOfTreeWithOnlyRoot()
    {
        treeWithOnlyTheRoot.setRoot(new BinaryTreeNode(3));
        Assertions.assertEquals(3, treeWithOnlyTheRoot.getRoot().getElement());
    }

    @Test
    public void emptyTreeIsEmpty()
    {
        Assertions.assertTrue(emptyTree.isEmpty());
    }

    @Test
    public void treeWithOnlyRootIsNotEmpty()
    {
        Assertions.assertFalse(treeWithOnlyTheRoot.isEmpty());
    }

    @Test
    public void regularTreeIsNotEmpty()
    {
        Assertions.assertFalse(regularTree.isEmpty());
    }

    @Test
    public void emptyTreeHasSize0()
    {
        Assertions.assertEquals(0, emptyTree.size());
    }

    @Test
    public void treeWithOnlyRootHasSize1()
    {
        Assertions.assertEquals(1, treeWithOnlyTheRoot.size());
    }

    @Test
    public void regularTreeHasSize9()
    {
        Assertions.assertEquals(9, regularTree.size());
    }

    @Test
    public void fullTreeHasSize7()
    {
        Assertions.assertEquals(7, fullTree.size());
    }

    @Test
    public void heavyLeftTreeHasSize5()
    {
        Assertions.assertEquals(5, heavyLeftTree.size());
    }

    @Test
    public void heavyRightTreeHasSize5()
    {
        Assertions.assertEquals(5, heavyRightTree.size());
    }

    @Test
    public void emptyTreeDoesntContainElement()
    {
        Assertions.assertFalse(emptyTree.contains(2));
    }

    @Test
    public void treeWithOnlyRootContainsElement()
    {
        Assertions.assertTrue(treeWithOnlyTheRoot.contains(4));
    }

    @Test
    public void regularTreeContains2()
    {
        Assertions.assertTrue(regularTree.contains(2));
    }

    @Test
    public void regularTreeDoesntContain9()
    {
        Assertions.assertFalse(regularTree.contains(9));
    }

    @Test
    public void heavyLeftTreeContains4()
    {
        Assertions.assertTrue(heavyLeftTree.contains(4));
    }

    @Test
    public void heavyRightTreeDoesntContain7()
    {
        Assertions.assertFalse(heavyRightTree.contains(7));
    }

    @Test
    public void heightZero()
    {
        Assertions.assertEquals(0, emptyTree.height());
    }

    @Test
    public void heightOne()
    {
        Assertions.assertEquals(0, treeWithOnlyTheRoot.height());
    }

    @Test
    public void heightMany()
    {
        Assertions.assertEquals(3, regularTree.height());
        Assertions.assertEquals(2, fullTree.height());
        Assertions.assertEquals(3, heavyLeftTree.height());
        Assertions.assertEquals(3, heavyRightTree.height());
    }

    @Test
    public void preOrderZero()
    {
        Assertions.assertEquals(null, emptyTree.preOrder());
    }

    @Test
    public void preOrderOne()
    {
        ArrayList<Integer> one = new ArrayList<>();
        one.add(4);
        Assertions.assertEquals(one, treeWithOnlyTheRoot.preOrder());
    }

    @Test
    public void preOrderMany()
    {
        ArrayList<Integer> many = new ArrayList<>();
        many.add(5);
        many.add(3);
        many.add(2);
        many.add(1);
        many.add(2);
        many.add(4);
        many.add(7);
        many.add(6);
        many.add(8);
        Assertions.assertEquals(many, regularTree.preOrder());
    }

    @Test
    public void inOrderZero()
    {
        Assertions.assertEquals(null, emptyTree.inOrder());
    }

    @Test
    public void inOrderOne()
    {
        ArrayList<Integer> one = new ArrayList<>();
        one.add(4);
        Assertions.assertEquals(one, treeWithOnlyTheRoot.inOrder());
    }

    @Test
    public void inOrderMany()
    {
        ArrayList<Integer> many = new ArrayList<>();
        many.add(1);
        many.add(2);
        many.add(2);
        many.add(3);
        many.add(4);
        many.add(5);
        many.add(6);
        many.add(7);
        many.add(8);
        Assertions.assertEquals(many, regularTree.inOrder());
    }

    @Test
    public void postOrderZero()
    {
        Assertions.assertEquals(null, emptyTree.postOrder());
    }

    @Test
    public void postOrderOne()
    {
        ArrayList<Integer> one = new ArrayList<>();
        one.add(4);
        Assertions.assertEquals(one, treeWithOnlyTheRoot.postOrder());
    }

    @Test
    public void postOrderMany()
    {
        ArrayList<Integer> many = new ArrayList<>();
        many.add(1);
        many.add(2);
        many.add(2);
        many.add(4);
        many.add(3);
        many.add(6);
        many.add(8);
        many.add(7);
        many.add(5);
        Assertions.assertEquals(many, regularTree.postOrder());
    }

    @Test
    public void levelOrderZero()
    {
        Assertions.assertEquals(null, emptyTree.levelOrder());
    }

    @Test
    public void levelOrderOne()
    {
        ArrayList<Integer> one = new ArrayList<>();
        one.add(4);
        Assertions.assertEquals(one, treeWithOnlyTheRoot.levelOrder());
    }

    @Test
    public void levelOrderMany()
    {
        ArrayList<Integer> many = new ArrayList<>();
        many.add(5);
        many.add(3);
        many.add(7);
        many.add(2);
        many.add(4);
        many.add(6);
        many.add(8);
        many.add(1);
        many.add(2);
        Assertions.assertEquals(many, regularTree.levelOrder());
    }

}
