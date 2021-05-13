package leetcode;

/*
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。

示例:
给定的有序链表： [-10, -3, 0, 5, 9],
一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class lc109 {
    /*
        时间复杂度：O(nlogn)，其中n是链表的长度。
        设长度为n的链表构造二叉搜索树的时间为T(n)，递推式为T(n)=2⋅T(n/2)+O(n)，根据主定理，T(n)=O(nlogn)。
        空间复杂度：O(logn)，这里只计算除了返回答案之外的空间。平衡二叉树的高度为O(logn)，即为递归过程中栈的最大深度，也就是需要的空间。
     */
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }

        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
