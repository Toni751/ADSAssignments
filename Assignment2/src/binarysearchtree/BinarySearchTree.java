package binarysearchtree;

import java.util.ArrayList;
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

    public int findMin(){
        return findMin(root);
    }

    private int findMin(BinaryTreeNode node){
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

    public int findMax(){
        return findMax(root);
    }

    private int findMax(BinaryTreeNode node){
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
    public void removeElement(int element)
    {
        removeElement(root, element);
    }

    private BinaryTreeNode removeElement(BinaryTreeNode root, int element) {
       if(root == null)
        return null;
       if(element<root.getElement()) {
                   root.addLeftChild(removeElement(root.getLeftChild(), element));
       }else if(element>root.getElement())
       {
           root.addRightChild(removeElement(root.getRightChild(), element));
       }
       else
       {
           if(root.getLeftChild() == null && root.getRightChild() == null) {
               root = null;
           }
           else if(root.getLeftChild() != null && root.getRightChild() != null)
           {
               int successor = findMin(root.getRightChild());
               root.setElement(successor);

               root.addRightChild(removeElement(root.getRightChild(), successor));
           }
           else if(root.getLeftChild() != null && root.getRightChild() == null)
                root = root.getLeftChild();
           else if(root.getRightChild() != null && root.getLeftChild() == null)
               root = root.getRightChild();
       }
        return root;
    }

    public void rebalance()
    {
        int end = inOrder().size() - 1;
        setRoot(rebalance(inOrder(), 0, end));
    }
    private BinaryTreeNode rebalance(ArrayList<Integer> inOrder, int start, int end)
    {
        if(start > end) {
            return null;
        }
        int mid = (start + end)/2;
        System.out.println("Middle element is " + inOrder.get(mid));
        BinaryTreeNode node = new BinaryTreeNode(inOrder.get(mid));

        node.addLeftChild(rebalance(inOrder, start, mid-1));

        node.addRightChild(rebalance(inOrder, mid+1, end));
        return node;
    }

}
