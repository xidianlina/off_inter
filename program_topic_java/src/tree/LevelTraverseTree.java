package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class LevelTraverseTree {
    public static void main(String[] args) {
        LevelTraverseTree traverseTree = new LevelTraverseTree();
        TreeNode root = traverseTree.createTree();
        traverseTree.levelTraverseTree(root);
    }

    public void levelTraverseTree(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curNode = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            --curNode;
            System.out.print(root.data + " ");

            if (root.left != null) {
                queue.offer(root.left);
            }

            if (root.right != null) {
                queue.offer(root.right);
            }

            if (curNode == 0) {
                System.out.println();
                curNode = queue.size();
            }
        }
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
