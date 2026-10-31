package Trees;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        // If root is null, there is no path
        if (root == null) {
            return false;
        }

        // If current node is a leaf node
        if (root.left == null && root.right == null) {

            // Check whether target matches leaf value
            return targetSum == root.val;
        }

        // Subtract current node value from target
        int remaining = targetSum - root.val;

        // Check both left and right subtrees
        return hasPathSum(root.left, remaining)
                || hasPathSum(root.right, remaining);
    }
}