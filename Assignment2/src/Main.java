import binarysearchtree.BinaryTreeNode;

public class Main {

    public static void main(String[] args) {
        BinaryTreePrint binaryTreePrint = new BinaryTreePrint();
        BinaryTreeNode root = new BinaryTreeNode(5);

        root.addLeftChild(new BinaryTreeNode(3));
        root.addRightChild(new BinaryTreeNode(7));

        root.getLeftChild().addLeftChild(new BinaryTreeNode(2));
        root.getLeftChild().addRightChild(new BinaryTreeNode(4));

        root.getLeftChild().getLeftChild().addLeftChild(new BinaryTreeNode(1));

        root.getRightChild().addLeftChild(new BinaryTreeNode(6));
        root.getRightChild().addRightChild(new BinaryTreeNode(8));
        binaryTreePrint.printTree(root);
    }
}
