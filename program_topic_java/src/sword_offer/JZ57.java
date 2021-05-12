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
    /*
    如果结点中有指向父亲结点的指针（假如根结点的父结点为null），则：
    (1).如果当前结点有右孩子，则后继结点为这个右孩子的最左孩子；
    (2).如果当前结点没有右孩子；
    (2.1).当前结点为根结点，返回null；
    (2.2).当前结点只是个普通结点，也就是存在父结点；
    (2.2.1).当前结点是父亲结点的左孩子，则父亲结点就是后继结点；
    (2.2.2).当前结点是父亲结点的右孩子，沿着父亲结点往上走，直到n-1代祖先是n代祖先的左孩子，
            则后继为n代祖先或遍历到根结点也没找到符合的，则当前结点就是中序遍历的最后一个结点，返回null。
     */
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
