package binarysearchtree;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree
{

    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root)
    {
        this.root = root;
    }

    public void setRoot(BinaryTreeNode root)
    {
        this.root = root;
    }

    public BinaryTreeNode getRoot()
    {
        return root;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public int size()
    {
        return recursiveSize(root);
    }

    private int recursiveSize(BinaryTreeNode node)
    {
        if (node == null)
            return 0;

        return 1 + recursiveSize(node.getLeftChild()) + recursiveSize(node.getRightChild());
    }

    public boolean contains(int element)
    {
        return recursiveContains(root, element);
    }

    private boolean recursiveContains(BinaryTreeNode node, int element)
    {
        if (node == null)
            return false;
        if (node.getElement() == element)
            return true;

        return recursiveContains(node.getLeftChild(), element) || recursiveContains(node.getRightChild(), element);
    }

    private void inOrder(BinaryTreeNode root, ArrayList<Integer> inOrder)
    {
        if (root == null)
            return;

        inOrder(root.getLeftChild(), inOrder);
        inOrder.add(root.getElement());
        inOrder(root.getRightChild(), inOrder);
    }

    public ArrayList<Integer> inOrder()
    {
        if (root == null)
            return null;

        ArrayList<Integer> inOrder = new ArrayList<Integer>();
        inOrder(root, inOrder);
        return inOrder;
    }

    private void preOrder(BinaryTreeNode root, ArrayList<Integer> preorder)
    {
        if (root == null)
            return;

        preorder.add(root.getElement());
        preOrder(root.getLeftChild(), preorder);
        preOrder(root.getRightChild(), preorder);
    }

    public ArrayList<Integer> preOrder()
    {
        if (root == null)
            return null;
        ArrayList<Integer> preorder = new ArrayList<Integer>();
        preOrder(root, preorder);
        return preorder;
    }

    private void postOrder(BinaryTreeNode root, ArrayList<Integer> postorder)
    {
        if (root == null)
            return;

        postOrder(root.getLeftChild(), postorder);
        postOrder(root.getRightChild(), postorder);
        postorder.add(root.getElement());
    }

    public ArrayList<Integer> postOrder()
    {
        if (root == null)
            return null;
        ArrayList<Integer> postorder = new ArrayList<Integer>();
        postOrder(root, postorder);
        return postorder;
    }

    public ArrayList<Integer> levelOrder()
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return null;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            root = q.peek();
            res.add(root.getElement());
            q.poll();
            if (root.getLeftChild() != null)
                q.add(root.getLeftChild());
            if (root.getRightChild() != null)
                q.add(root.getRightChild());
        }
        return res;
    }


    private int recursiveHeight(BinaryTreeNode node)
    {
        if (node == null || (node.getLeftChild() == null && node.getRightChild() == null))
        {
            return 0;
        }
        return 1 + Math.max(recursiveHeight(node.getLeftChild()), recursiveHeight(node.getRightChild()));
    }

    public int height()
    {
        return recursiveHeight(getRoot());
    }
}


