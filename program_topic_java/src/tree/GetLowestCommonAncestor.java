package tree;

import java.util.Scanner;

public class GetLowestCommonAncestor {
    public static void main(String[] args) {
        GetLowestCommonAncestor lowestCommonAncestor = new GetLowestCommonAncestor();
        TreeNode root = lowestCommonAncestor.createTree();
        TreeNode node1 = root.left.left;
        TreeNode node2 = root.left.right;
        TreeNode common = lowestCommonAncestor.lowestCommonAncestor(root, node1, node2);
        System.out.println(common.data);
    }

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        if (root == node1 || root == node2) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
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
