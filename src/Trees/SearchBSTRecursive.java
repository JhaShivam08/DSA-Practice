package Trees;

public class SearchBSTRecursive {

    static TreeNode searchBST(TreeNode root, int target) {

        if (root == null || root.val == target) {
            return root;
        }

        if (target < root.val) {
            return searchBST(root.left, target);
        }

        return searchBST(root.right, target);
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

        TreeNode result = searchBST(root, target);

        if (result != null) {
            System.out.println("Element found: " + result.val);
        } else {
            System.out.println("Element not found");
        }
    }
}