public class LowestCommonAncestorBST {

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

    // Find Lowest Common Ancestor in a Binary Search Tree
    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        // Traverse the tree
        while (root != null) {

            // Both nodes are smaller → go left
            if (p.data < root.data && q.data < root.data) {
                root = root.left;
            }

            // Both nodes are greater → go right
            else if (p.data > root.data && q.data > root.data) {
                root = root.right;
            }

            // Current root is the Lowest Common Ancestor
            else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Create BST
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;
        TreeNode q = root.right;

        LowestCommonAncestorBST obj = new LowestCommonAncestorBST();

        TreeNode result = obj.lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor = " + result.data);
    }
}