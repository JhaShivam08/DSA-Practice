package Trees;

public class IterativeInsertion {

    // Iterative method to insert a value into BST
    static TreeNode insertBSTIterative(TreeNode root, int val) {

        // If tree is empty, create a new node
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;

        // Keep searching until the correct position is found
        while (true) {

            // Insert into left subtree
            if (val < current.val) {

                // If left is empty, insert new node
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                }

                // Move to left child
                current = current.left;

            }

            // Insert into right subtree
            else if (val > current.val) {

                // If right is empty, insert new node
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                }

                // Move to right child
                current = current.right;

            }

            // Ignore duplicate values
            else {
                break;
            }
        }

        return root;
    }

    public static void main(String[] args) {

        // Create an empty BST
        TreeNode root = null;

        // Insert values
        root = insertBSTIterative(root, 10);
        root = insertBSTIterative(root, 5);
        root = insertBSTIterative(root, 15);
        root = insertBSTIterative(root, 3);
        root = insertBSTIterative(root, 7);

        System.out.println("BST created successfully");
    }
}