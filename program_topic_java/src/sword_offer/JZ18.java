package sword_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class JZ18 {
    /*
    方法一 递归
    先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子节点，当交换完所有的非叶子结点的左右子结点之后，就得到了树的镜像。
     */
    public TreeNode Mirror(TreeNode root) {
        //当前节点为空，直接返回
        if (root == null)
            return root;
        //当前节点没有叶子节点，直接返回
        if (root.left == null && root.right == null)
            return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归交换叶子节点
        if (root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);
        return root;
    }

    /*
    方法二 非递归
    思路类似于之前的求二叉树高度，以广度优先的方式进行查找。首先查找出每一层的节点，接着对每一层节点的子节点进行镜像，也就是交换操作。全部完成后即镜像完毕。
     */
    public TreeNode Mirror2(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int count = 1;
        while (que.size() != 0) {
            count--;
            TreeNode top = que.poll();
            if (top.left != null || top.right != null) {
                TreeNode temp = top.left;
                top.left = top.right;
                top.right = temp;
                if (top.left != null) {
                    que.offer(top.left);
                }
                if (top.right != null) {
                    que.offer(top.right);
                }
            }
            if (count == 0) {
                count = que.size();
            }
        }

        return root;
    }
}
