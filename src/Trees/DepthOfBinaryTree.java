public class DepthOfBinaryTree {

    // Tree Node
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Find maximum depth of Binary Tree
    static int depth(TreeNode root) {

        // If tree is empty
        if (root == null) {
            return 0;
        }

        // Find depth of left subtree
        int left = depth(root.left);

        // Find depth of right subtree
        int right = depth(root.right);

        // Current node + maximum of left and right
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

        // Create Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Find depth
        System.out.println("Depth of tree = " + depth(root));
    }
}