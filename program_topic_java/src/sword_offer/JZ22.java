package sword_offer;

import apple.laf.JRSUIConstants;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 示例1
 * 输入
 * {5,4,#,3,#,2,#,1}
 * 返回值
 * [5,4,3,2,1]
 */
public class JZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        que.offer(root);
        while (!que.isEmpty()) {
            root = que.poll();
            res.add(root.val);
            if (root.left != null) {
                que.offer(root.left);
            }
            if (root.right != null) {
                que.offer(root.right);
            }
        }

        return res;
    }
}
