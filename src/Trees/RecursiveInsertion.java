package Trees;

public class RecursiveInsertion {

    // Recursive method to insert a value in BST
    static TreeNode insertBST(TreeNode root, int val) {

        // If tree/subtree is empty, create a new node
        if (root == null) {
            return new TreeNode(val);
        }

        // If value is smaller, insert into left subtree
        if (val < root.val) {
            root.left = insertBST(root.left, val);

            // If value is greater, insert into right subtree
        } else if (val > root.val) {
            root.right = insertBST(root.right, val);
        }

        // Return the root of the tree
        return root;
    }

    public static void main(String[] args) {

        // Create an empty tree
        TreeNode root = null;

        // Insert values into BST
        root = insertBST(root, 10);
        root = insertBST(root, 5);
        root = insertBST(root, 15);
        root = insertBST(root, 3);
        root = insertBST(root, 7);

        System.out.println("BST created successfully");
    }
}