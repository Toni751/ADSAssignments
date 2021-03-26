package binarysearchtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {

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
    void setUpBinaryTrees() {
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
    void getRootOfEmptyTree() {
        Assertions.assertNull(emptyTree.getRoot());
    }

    @Test
    void getRootOfTreeWithOnlyRoot() {
        Assertions.assertEquals(4, treeWithOnlyTheRoot.getRoot().getElement());
    }

    @Test
    void getRootOfRegularTree() {
        Assertions.assertEquals(regularTreeRoot, regularTree.getRoot());
    }

    @Test
    void setRootOfEmptyTree() {
        emptyTree.setRoot(new BinaryTreeNode(3));
        Assertions.assertEquals(3, emptyTree.getRoot().getElement());
    }

    @Test
    void setRootOfTreeWithOnlyRoot() {
        treeWithOnlyTheRoot.setRoot(new BinaryTreeNode(3));
        Assertions.assertEquals(3, treeWithOnlyTheRoot.getRoot().getElement());
    }

    @Test
    void emptyTreeIsEmpty() {
        Assertions.assertTrue(emptyTree.isEmpty());
    }

    @Test
    void treeWithOnlyRootIsNotEmpty() {
        Assertions.assertFalse(treeWithOnlyTheRoot.isEmpty());
    }

    @Test
    void regularTreeIsNotEmpty() {
        Assertions.assertFalse(regularTree.isEmpty());
    }

    @Test
    void emptyTreeHasSize0() {
        Assertions.assertEquals(0, emptyTree.size());
    }

    @Test
    void treeWithOnlyRootHasSize1() {
        Assertions.assertEquals(1, treeWithOnlyTheRoot.size());
    }

    @Test
    void regularTreeHasSize9() {
        Assertions.assertEquals(9, regularTree.size());
    }

    @Test
    void fullTreeHasSize7() {
        Assertions.assertEquals(7, fullTree.size());
    }

    @Test
    void heavyLeftTreeHasSize5() {
        Assertions.assertEquals(5, heavyLeftTree.size());
    }

    @Test
    void heavyRightTreeHasSize5() {
        Assertions.assertEquals(5, heavyRightTree.size());
    }

    @Test
    void emptyTreeDoesntContainElement() {
        Assertions.assertFalse(emptyTree.contains(2));
    }

    @Test
    void treeWithOnlyRootContainsElement() {
        Assertions.assertTrue(treeWithOnlyTheRoot.contains(4));
    }

    @Test
    void regularTreeContains2() {
        Assertions.assertTrue(regularTree.contains(2));
    }

    @Test
    void regularTreeDoesntContain9() {
        Assertions.assertFalse(regularTree.contains(9));
    }

    @Test
    void heavyLeftTreeContains4() {
        Assertions.assertTrue(heavyLeftTree.contains(4));
    }

    @Test
    void heavyRightTreeDoesntContain7() {
        Assertions.assertFalse(heavyRightTree.contains(7));
    }
}
