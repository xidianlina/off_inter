package sword_offer;

import java.util.LinkedList;

/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 示例1
 * 输入
 * {1,2,3,4,5,#,6,#,#,7}
 * 返回值
 * 4
 */
public class JZ38 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }

    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int curNode = 1;
        int depth = 0;
        while (!que.isEmpty()) {
            root = que.poll();
            --curNode;
            if (root.left != null) {
                que.offer(root.left);
            }
            if (root.right != null) {
                que.offer(root.right);
            }

            if (curNode == 0) {
                curNode = que.size();
                ++depth;
            }
        }

        return depth;
    }
}
