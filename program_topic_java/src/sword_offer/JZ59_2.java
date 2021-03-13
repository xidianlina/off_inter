package sword_offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 示例1
 * 输入
 * {8,6,10,5,7,9,11}
 * 返回值
 * [[8],[10,6],[5,7,9,11]]
 */
public class JZ59_2 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> arr = new ArrayList<>();
        arr.add(root);
        int curNode = 1;
        boolean leftToRight = true;
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
