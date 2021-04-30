package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class GetTreeDepth {
    public static void main(String[] args) {
        GetTreeDepth getTreeDepth = new GetTreeDepth();
        TreeNode root = getTreeDepth.createTree();
        System.out.println(getTreeDepth.getTreeDepthRecursion(root));
        System.out.println(getTreeDepth.getTreeDepth(root));
    }

    public int getTreeDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getTreeDepthRecursion(root.left);
        int right = getTreeDepthRecursion(root.right);

        return left > right ? (left + 1) : (right + 1);
    }

    public int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        int count = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            --count;
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (count == 0) {
                ++depth;
                count = queue.size();
            }
        }

        return depth;
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
