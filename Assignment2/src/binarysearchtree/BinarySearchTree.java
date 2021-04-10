package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree extends BinaryTree {

    BinaryTreeNode root;
    public BinarySearchTree(BinaryTreeNode root) {
        super(root);
        this.root=root;
    }

    public void insert(int element){
        BinaryTreeNode newNode = new BinaryTreeNode(element);

        BinaryTreeNode x = root;
        BinaryTreeNode y = null;

        while (x != null) {
            y = x;
            if (element < x.getElement())
                x = x.getLeftChild();
            else
                x = x.getRightChild();
        }

        if (element < y.getElement())
            y.addLeftChild(newNode);
        else
            y.addRightChild(newNode);
    }

    public int findMin(BinaryTreeNode node){
        if (node == null)
            return Integer.MAX_VALUE;

        int res = node.getElement();
        int lres = findMin(node.getLeftChild());
        int rres = findMin(node.getRightChild());

        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        return res;
    }

    public int findMax(BinaryTreeNode node){
        if (node == null)
            return Integer.MIN_VALUE;

        int res = node.getElement();
        int lres = findMax(node.getLeftChild());
        int rres = findMax(node.getRightChild());

        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

}
