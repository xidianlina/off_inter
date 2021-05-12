package tree;

import java.util.Scanner;

/*
首先找到两个结点的 LCA，然后分别计算 LCA 与它们的距离，最后相加即可。
 */
public class DistanceTreeNodes {
    public static void main(String[] args) {
        DistanceTreeNodes distanceTreeNodes = new DistanceTreeNodes();
        TreeNode root = distanceTreeNodes.createTree();
        TreeNode node1 = root.left.left;
        TreeNode node2 = root.right.right;
        int distance = distanceTreeNodes.distanceTreeNodes(root, node1, node2);
        System.out.println(distance);
    }

    public int distanceTreeNodes(TreeNode root, TreeNode node1, TreeNode node2) {
        TreeNode lca = findLCA(root, node1, node2);
        int leftLevel = findLevel(lca, node1);
        int rightLevel = findLevel(lca, node2);

        return leftLevel + rightLevel;
    }

    public TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        if (root == node1 || root == node2) {
            return root;
        }

        TreeNode left = findLCA(root.left, node1, node2);
        TreeNode right = findLCA(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public int findLevel(TreeNode lca, TreeNode node) {
        if (lca == null) {
            return -1;
        }

        if (lca == node) {
            return 0;
        }

        //先在左子树查找
        int level = findLevel(lca.left, node);

        //如果左子树没找到，就在右子树查找
        if (level == -1) {
            level = findLevel(lca.right, node);
        }

        //查找到，回溯
        if (level != -1) {
            return level + 1;
        }

        return -1;
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
