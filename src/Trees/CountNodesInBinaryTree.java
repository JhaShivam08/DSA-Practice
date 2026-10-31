public class CountNodesInBinaryTree {

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

    // Count total nodes in Binary Tree
    static int count(TreeNode root) {

        // If tree is empty
        if (root == null) {
            return 0;
        }

        // Count nodes in left subtree
        int left = count(root.left);

        // Count nodes in right subtree
        int right = count(root.right);

        // Current node + left + right
        return 1 + left + right;
    }

    public static void main(String[] args) {

        // Create Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Count nodes
        System.out.println("Number of nodes = " + count(root));
    }
}