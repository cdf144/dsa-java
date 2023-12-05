package Tree;

public class BinaryTreeDiameter {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        int diameter(Node root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            int leftSubtreeDiameter = diameter(root.left);
            int rightSubtreeDiameter = diameter(root.right);

            return Math.max(
                    leftHeight + 1 + rightHeight,
                    Math.max(leftSubtreeDiameter, rightSubtreeDiameter)
            );
        }

        /*
         * "height" here is defined as the number of nodes between the tree's
         * root and its furthest leaf.
         * Not to be confused with the traditional definition of the height of
         * a tree which is the number of edges between the tree's root and its
         * furthest leaf.
         */
        int height (Node node) {
            if (node == null) {
                return 0;
            }

            return (1 + Math.max(height(node.right), height(node.left)));
        }
    }
}
