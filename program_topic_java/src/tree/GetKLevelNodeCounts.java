package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetKLevelNodeCounts {
    public static void main(String[] args) {
        GetKLevelNodeCounts kLevelNodeCounts = new GetKLevelNodeCounts();
        TreeNode root = kLevelNodeCounts.createTree();
        System.out.println(kLevelNodeCounts.getKLevelNodeCountsRecursion(root, 2));
        System.out.println(kLevelNodeCounts.getKLevelNodeCounts(root, 2));
    }

    public int getKLevelNodeCountsRecursion(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        return getKLevelNodeCountsRecursion(root.left, k - 1) + getKLevelNodeCountsRecursion(root.right, k - 1);
    }

    public int getKLevelNodeCounts(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curCount = 1;
        while (!queue.isEmpty() && k > 1) {
            root = queue.poll();
            --curCount;

            if (root.left != null) {
                queue.offer(root.left);
            }

            if (root.right != null) {
                queue.offer(root.right);
            }

            if (curCount == 0) {
                curCount = queue.size();
                --k;
            }
        }

        return curCount;
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
