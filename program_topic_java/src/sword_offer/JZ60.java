package sword_offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 示例1
 * 输入
 * {8,6,10,5,7,9,11}
 * 返回值
 * [[8],[6,10],[5,7,9,11]]
 */
public class JZ60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int curNode = 1;
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
                res.add(list);
                list = new ArrayList<>();
            }
        }

        return res;
    }

    ArrayList<ArrayList<Integer>> Print2(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> arr = new ArrayList<>();
        arr.add(root);
        int curNode = 1;
        while (!arr.isEmpty()) {
            root = arr.get(0);
            arr.remove(0);
            --curNode;
            if (root.left != null) {
                arr.add(root.left);
            }
            if (root.right != null) {
                arr.add(root.right);
            }
            list.add(root.val);
            if (curNode == 0) {
                curNode = arr.size();
                res.add(list);
                list = new ArrayList<>();
            }
        }

        return res;
    }
}
