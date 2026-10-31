import java.util.*;

public class InorderIterative {

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

    static List<Integer> inorderIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            // Go as far left as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit node
            current = stack.pop();
            result.add(current.val);

            // Move to right subtree
            current = current.right;
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> result = inorderIterative(root);

        System.out.println("Inorder Traversal: " + result);
    }
}