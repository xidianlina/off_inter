package sword_offer;

/**
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class JZ57 {
    public TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }

            return node;
        }

        while (node.next != null) {
            TreeLinkNode root = node.next;
            if (root.left == node) {
                return root;
            }
            node = node.next;
        }

        return null;
    }
}
