package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    private class Node {
        private final int val;
        private Node left, right;

        public Node(int value) {
            this.val = value;
            left = right = null;
        }
    }

    public BinarySearchTree() {}

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node x, int val) {
        if (x == null) {
            return new Node(val);
        }

        if (val < x.val) {
            x.left = insert(x.left, val);
        } else if (val > x.val) {
            x.right = insert(x.right, val);
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

    public int min() {
        return min(root).val;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    public int max() {
        return max(root).val;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }

    public void delMax() {
        root = delMax(root);
    }

    private Node delMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = delMax(x.right);
        return x;
    }

    public void delMin() {
        root = delMin(root);
    }

    private Node delMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = delMin(x.left);
        return x;
    }

    private Node delete(Node x, int val) {
        if (x == null) {
            return null;
        }

        if (val < x.val) {
            x.left = delete(x.left, val);
        } else if (val > x.val) {
            x.right = delete(x.right, val);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = min(t);
            x.right = delMin(t.right);
            x.left = t.left;
        }

        return x;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node x) {
        if (x != null) {
            inorder(x.left);
            System.out.println(x.val);
            inorder(x.right);
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node x) {
        if (x != null) {
            System.out.println(x.val);
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
            System.out.println(x.val);
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
            System.out.println(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
