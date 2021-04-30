package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class GetLeafNodeCounts {
    public static void main(String[] args) {
        GetLeafNodeCounts leafNodeCounts = new GetLeafNodeCounts();
        TreeNode root = leafNodeCounts.createTree();
        System.out.println(leafNodeCounts.getLeafNodeCountsRecursion(root));
        System.out.println(leafNodeCounts.getLeafNodeCounts(root));
    }

    public int getLeafNodeCountsRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return getLeafNodeCountsRecursion(root.left) + getLeafNodeCountsRecursion(root.right);
    }

    public int getLeafNodeCounts(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        int curCount = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            --curCount;
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }

            if (root.left == null && root.right == null) {
                ++count;
            }

            if (curCount == 0) {
                curCount = queue.size();
            }
        }

        return count;
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
