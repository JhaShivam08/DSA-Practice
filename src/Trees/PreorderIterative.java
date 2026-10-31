import java.util.*;

public class PreorderIterative {

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

    static List<Integer> preorderIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            result.add(node.val);

            // Push right first
            if (node.right != null) {
                stack.push(node.right);
            }

            // Push left second
            if (node.left != null) {
                stack.push(node.left);
            }
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

        List<Integer> result = preorderIterative(root);

        System.out.println("Preorder Traversal: " + result);
    }
}