package Trees;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        // If root is null or root is one of the target nodes
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search for p and q in the left subtree
        TreeNode left = lowestCommonAncestor(
                root.left, p, q
        );

        // Search for p and q in the right subtree
        TreeNode right = lowestCommonAncestor(
                root.right, p, q
        );

        // If both sides found a target node,
        // current root is the Lowest Common Ancestor
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side contains a target node
        return left != null ? left : right;
    }
}