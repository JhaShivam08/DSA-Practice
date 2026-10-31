public class ContainsBinaryTree {

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

    // Check whether target exists in tree
    static boolean contains(TreeNode root, int target) {

        // If tree is empty
        if (root == null) {
            return false;
        }

        // If current node matches target
        if (root.data == target) {
            return true;
        }

        // Search in left or right subtree
        return contains(root.left, target)
                || contains(root.right, target);
    }

    public static void main(String[] args) {

        // Create Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Check target
        System.out.println("Contains 5 = " + contains(root, 5));
    }
}