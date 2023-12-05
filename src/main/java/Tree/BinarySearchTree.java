package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

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

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node x, int key) {
        if (x == null) {
            return new Node(key);
        }

        if (key < x.key) {
            x.left = insert(x.left, key);
        } else if (key > x.key) {
            x.right = insert(x.right, key);
        }

        return x;
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) {
            return -1;
        }

        return 1 + Math.max(height(x.left), height(x.right));
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

    public void levelorder() {
        levelorder(root);
    }

    private void levelorder(Node x) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(x);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.key);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
