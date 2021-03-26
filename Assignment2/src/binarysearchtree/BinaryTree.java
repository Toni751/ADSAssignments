package binarysearchtree;

public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return recursiveSize(root);
    }

    private int recursiveSize(BinaryTreeNode node) {
        if(node == null)
            return 0;

        return 1 + recursiveSize(node.getLeftChild()) + recursiveSize(node.getRightChild());
    }

    public boolean contains(int element) {
        return recursiveContains(root, element);
    }

    private boolean recursiveContains(BinaryTreeNode node, int element) {
        if(node == null)
            return false;
        if(node.getElement() == element)
            return true;

        return recursiveContains(node.getLeftChild(), element) || recursiveContains(node.getRightChild(), element);
    }
}
