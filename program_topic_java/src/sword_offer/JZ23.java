package sword_offer;

import jdk.nashorn.tools.Shell;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜素树）
 * 示例1
 * 输入
 * [4,8,6,12,16,14,10]
 * 返回值
 * true
 */

/*
后序遍历定义:[左子树|右子树|根节点],即遍历顺序为“左、右、根” 。
二叉搜索树定义:左子树中所有节点的值小于根节点的值；右子树中所有节点的值大于根节点的值；其左、右子树也分别为二叉搜索树。
 */
public class JZ23 {
    public boolean VerifySquenceOfBST(int[] arr) {
        int size = arr.length;
        if (size == 0) {
            return false;
        }

        if (size == 1) {
            return true;
        }

        return helper(arr, 0, size - 1);
    }

    private boolean helper(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }

        int i = end;
        while (i > start && arr[i - 1] > arr[end]) {
            --i;
        }

        for (int j = start; j < i; ++j) {
            if (arr[j] > arr[end]) {
                return false;
            }
        }

        return helper(arr, start, i - 1) && helper(arr, i, end - 1);
    }
}
