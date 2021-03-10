package sword_offer;

/**
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 示例1
 * 输入
 * {8,8,#,9,#,2,#,5},{8,9,#,2}
 * 返回值
 * true
 */
public class JZ17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        return isSubtree(root1, root2) || isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }
}
