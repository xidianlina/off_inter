package sword_offer;

import java.io.File;
import java.util.ArrayList;

/**
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 示例1
 * 输入
 * {10,5,12,4,7},22
 * 返回值
 * [[10,5,7],[10,12]]
 * 示例2
 * 输入
 * {10,5,12,4,7},15
 * 返回值
 * []
 */

/*
思路分析：首先思考节点值的和为输入的整数，每条路径都一定是从根节点到叶子节点，
在数据结构中从根节点到叶子节点的遍历称之为深度优先遍历DFS。因此整个过程可以采用先序遍历方式的DFS，
即根节点》左子树》右子树。随后考虑一次遍历完成后的处理，当一次遍历完成后，如果输入整数值恰好等于节点值之和，
则输出这条路径并且回退一个节点；如果不等于则直接回退一个节点，即回退到当前节点的父节点，如果该父节点有右孩子，
则继续遍历，否则继续回退。考虑回退到根节点，此时如果它有右孩子，则继续遍历，否则整个DFS结束。
 */
public class JZ24 {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }

        path.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }

        FindPath(root.left, target - root.val);
        FindPath(root.right, target - root.val);
        path.remove(path.size() - 1);

        return res;
    }
}
