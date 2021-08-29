package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
199. 二叉树的右视图
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例 1:
输入:[1,2,3,null,5,null,4]
输出:[1,3,4]
示例 2:

输入:[1,null,3]
输出:[1,3]
示例 3:

输入:[]
输出:[]

提示:
二叉树的节点个数的范围是 [0,100]
-100<= Node.val <= 100
 */
public class lc199 {
    /*
        时间复杂度 : O(n)。 每个节点最多进队列一次，出队列一次，因此广度优先搜索的复杂度为线性。
        空间复杂度 : O(n)。
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int node = 1;
        while (!que.isEmpty()) {
            root = que.poll();
            --node;
            if (root.left != null) {
                que.offer(root.left);
            }
            if (root.right != null) {
                que.offer(root.right);
            }
            if (node == 0) {
                res.add(root.val);
                node = que.size();
            }
        }
        return res;
    }
}
