package sword_offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * 示例1
 * 输入
 * {8,6,10,5,7,9,11}
 * 返回值
 * [[8],[10,6],[5,7,9,11]]
 */
public class JZ59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int curNode = 1;
        boolean leftToRight = true;
        while (!que.isEmpty()) {
            root = que.poll();
            --curNode;
            if (root.left != null) {
                que.offer(root.left);
            }
            if (root.right != null) {
                que.offer(root.right);
            }
            list.add(root.val);

            if (curNode == 0) {
                curNode = que.size();
                if (leftToRight) {
                    res.add(list);
                } else {
                    res.add(reverseList(list));
                }
                leftToRight = !leftToRight;
                list = new ArrayList<>();
            }
        }

        return res;
    }

    private ArrayList<Integer> reverseList(ArrayList<Integer> list) {
        int size = list.size();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = size - 1; i >= 0; i--) {
            res.add(list.get(i));
        }
        return res;
    }
}
