package sword_offer;

import java.util.Stack;
import java.util.ArrayList;

/**
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 * 示例1
 * 输入
 * {5,3,7,2,4,6,8},3
 * 返回值
 * {4}
 * 说明
 * 按结点数值大小顺序第三小结点的值为4
 */
public class JZ62 {
    TreeNode KthNode(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }

        Stack<TreeNode> stk = new Stack<>();
        while (!stk.isEmpty() || root != null) {
            if (root != null) {
                stk.push(root);
                root = root.left;
            } else {
                root = stk.pop();
                if (k == 1) {
                    return root;
                }
                --k;
                root = root.right;
            }
        }

        return null;
    }

    TreeNode KthNode2(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }

        ArrayList<TreeNode> arr = new ArrayList<>();
        while (!arr.isEmpty() || root != null) {
            if (root != null) {
                arr.add(root);
                root = root.left;
            } else {
                root = arr.get(arr.size() - 1);
                arr.remove(arr.size() - 1);
                if (k == 1) {
                    return root;
                }
                --k;
                root = root.right;
            }
        }

        return null;
    }
}
