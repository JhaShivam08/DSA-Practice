public class InorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // Left
        inorder(root.left);

        // Root
        System.out.print(root.val + " ");

        // Right
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}