package GraphTree.Tree;

public class AVLTree {
    private class Node {
        int val;
        int height;
        Node left, right;

        public Node() {
            val = height = 0;
            left = right = null;
        }

        public Node(int val) {
            this.val = val;
            height = 0;
            left = right = null;
        }
    }

    Node root;

    public AVLTree() {
        root = new Node();
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node x, int val) {
        // Same insertion as normal BST
        if (x == null) {
            return new Node(val);
        }

        if (val < x.val) {
            x.left = insert(x.left, val);
        } else if (val > x.val) {
            x.right = insert(x.right, val);
        } else {
            // No duplicates allowed in BST
            return x;
        }

        // Update height of each father/ancestor node
        updateHeight(x);

        // Tree balancing
        int balanceFactor = getBalanceFactor(x);
        if (balanceFactor > 1) {
            // Left-heavy
            // Examine left subtree
            if (getBalanceFactor(x.left) >= 0) {
                // Is balanced or has more left weight -> Left Left
                return rightRotate(x);
            } else {
                // Has more right weight -> Left Right
                x.left = leftRotate(x.left);
                return rightRotate(x);
            }
        } else if (balanceFactor < -1) {
            // Right-heavy
            // Examine right subtree
            if (getBalanceFactor(x.right) <= 0) {
                // Is balanced or has more right weight -> Right Right
                return leftRotate(x);
            } else {
                // Has more left weight -> Right Left
                x.right = rightRotate(x.right);
                return leftRotate(x);
            }
        }

        // Tree is balanced
        return x;
    }

    private int getBalanceFactor(Node x) {
        if (x == null) {
            return 0;
        }
        return height(x.left) - height(x.right);
    }

    private int height(Node x) {
        if (x == null) {
            return -1;
        }
        return x.height;
    }

    private void updateHeight(Node x) {
        x.height = 1 + Math.max(height(x.left), height(x.right));
    }

    private Node rightRotate(Node x) {
        Node xl = x.left;

        // Execute rotation
        x.left = xl.right;
        xl.right = x;

        // Update heights
        updateHeight(x);
        updateHeight(xl);

        // Return new root
        return xl;
    }

    private Node leftRotate(Node x) {
        Node xr = x.right;

        // Execute rotation
        x.right = xr.left;
        xr.left = x;

        // Update heights
        updateHeight(x);
        updateHeight(xr);

        // Return new root
        return xr;
    }
}
