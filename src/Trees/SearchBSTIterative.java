package Trees;

public class SearchBSTIterative {

    static TreeNode searchBSTIterative(TreeNode root, int target) {

        TreeNode current = root;

        while (current != null) {

            if (current.val == target) {
                return current;
            }

            if (target < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        int target = 14;

        TreeNode result = searchBSTIterative(root, target);

        if (result != null) {
            System.out.println("Element found: " + result.val);
        } else {
            System.out.println("Element not found");
        }
    }
}