package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class IsCompleteBinaryTree {
    public static void main(String[] args) {
        IsCompleteBinaryTree isCompleteBinaryTree = new IsCompleteBinaryTree();
        TreeNode root = isCompleteBinaryTree.createTree();
        boolean flag = isCompleteBinaryTree.isCompleteBinaryTree(root);
        System.out.println(flag);
    }

    public boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean flag = false;
        while (!que.isEmpty()) {
            TreeNode node = que.poll();

            //右孩子不等于空，左孩子等于空  -> false
            if ((node.left == null && node.right != null) ||
                    //开启叶节点判断标志位时，如果层次遍历中的后继结点不是叶节点 -> false
                    (flag && (node.left != null || node.right != null))) {
                return false;
            }

            if (node.left != null) {
                que.offer(node.left);
            }
            if (node.right != null) {
                que.offer(node.right);
            } else {
                flag = true;
            }
        }

        return true;
    }

    public TreeNode createTree() {
        TreeNode tree;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        if (data == 0) {
            return null;
        } else {
            tree = new TreeNode();
            tree.data = data;
            tree.left = createTree();
            tree.right = createTree();
        }

        return tree;
    }
}
