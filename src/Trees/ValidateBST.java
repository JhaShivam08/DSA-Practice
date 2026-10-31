package Trees;

public class ValidateBST {

    // Validate whether the tree is a valid Binary Search Tree
    static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Check every node within its allowed range
    static boolean validate(TreeNode root, long min, long max) {

        // Empty tree is a valid BST
        if (root == null) {
            return true;
        }

        // Current node must be within the valid range
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // Check left and right subtrees
        return validate(root.left, min, root.val)
                && validate(root.right, root.val, max);
    }

    public static void main(String[] args) {

        // Create BST
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        // Check BST
        if (isValidBST(root)) {
            System.out.println("Valid Binary Search Tree");
        } else {
            System.out.println("Invalid Binary Search Tree");
        }
    }
}