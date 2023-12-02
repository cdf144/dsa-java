package GraphTree.Tree;

public class BinarySearchTree {
    private Node root;

    private class Node {
        private final int key;
        private Node left, right;

        public Node(int value) {
            this.key = value;
            left = right = null;
        }
    }

    public BinarySearchTree() {}

    public void put(int key) {
        root = put(root, key);
    }

    private Node put(Node x, int key) {
        if (x == null) {
            return new Node(key);
        }

        if (key < x.key) {
            x.left = put(x.left, key);
        } else if (key > x.key) {
            x.right = put(x.right, key);
        }

        return x;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node x) {
        if (x != null) {
            inorder(x.left);
            System.out.println(x.key);
            inorder(x.right);
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node x) {
        if (x != null) {
            System.out.println(x.key);
            preorder(x.left);
            preorder(x.right);
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node x) {
        if (x != null) {
            postorder(x.left);
            postorder(x.right);
            System.out.println(x.key);
        }
    }
}
