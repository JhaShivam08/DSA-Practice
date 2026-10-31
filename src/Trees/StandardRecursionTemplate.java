public class StandardRecursionTemplate {

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

    static int solve(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = solve(root.left);

        int right = solve(root.right);

        return 1 + left + right;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        System.out.println("Answer = " + solve(root));
    }
}