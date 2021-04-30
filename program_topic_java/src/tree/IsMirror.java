package tree;

import java.util.Scanner;

public class IsMirror {
    public static void main(String[] args) {
        IsMirror isMirror = new IsMirror();
        TreeNode root = isMirror.createTree();
        System.out.println(isMirror.isMirror(root));
    }

    public boolean isMirror(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.data != right.data) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public TreeNode createTree() {
        TreeNode tree;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == 0) {
            tree = null;
        } else {
            tree = new TreeNode();
            tree.data = data;
            tree.left = createTree();
            tree.right = createTree();
        }

        return tree;
    }
}
