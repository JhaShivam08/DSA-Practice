package Trees;

public class BalancedBinaryTree {

    // Check whether the binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Returns height if balanced, otherwise returns -1
    private int checkHeight(TreeNode root) {

        // Empty tree has height 0
        if (root == null) {
            return 0;
        }

        // Find height of left subtree
        int left = checkHeight(root.left);

        // If left subtree is unbalanced
        if (left == -1) {
            return -1;
        }

        // Find height of right subtree
        int right = checkHeight(root.right);

        // If right subtree is unbalanced
        if (right == -1) {
            return -1;
        }

        // Check difference between left and right heights
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        // Return height of current node
        return 1 + Math.max(left, right);
    }
}