package Trees;

public class DeleteBST {

    // Delete a node from BST
    static TreeNode deleteBST(TreeNode root, int key) {

        // If tree is empty
        if (root == null) {
            return null;
        }

        // Search in left subtree
        if (key < root.val) {
            root.left = deleteBST(root.left, key);

            // Search in right subtree
        } else if (key > root.val) {
            root.right = deleteBST(root.right, key);

        } else {

            // Case 1 and 2: node has 0 or 1 child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Case 3: node has two children
            TreeNode successor = root.right;

            // Find smallest node in right subtree
            while (successor.left != null) {
                successor = successor.left;
            }

            // Copy successor value
            root.val = successor.val;

            // Delete successor
            root.right = deleteBST(root.right, successor.val);
        }

        return root;
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

        // Delete node
        root = deleteBST(root, 5);

        System.out.println("Node deleted successfully");
    }
}