package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class GetTreeNodeCounts {
    public static void main(String[] args) {
        GetTreeNodeCounts nodeCounts = new GetTreeNodeCounts();
        TreeNode root = nodeCounts.createTree();
        System.out.println(nodeCounts.getTreeNodeCountsRecursion(root));
        System.out.println(nodeCounts.getTreeNodeCounts(root));
    }

    public int getTreeNodeCountsRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getTreeNodeCounts(root.left) + getTreeNodeCounts(root.right) + 1;
    }

    public int getTreeNodeCounts(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
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
            if (curCount == 0) {
                curCount = queue.size();
                count += curCount;
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
