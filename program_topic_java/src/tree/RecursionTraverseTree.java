package tree;

import java.util.Scanner;

public class RecursionTraverseTree {
    public static void main(String[] args) {
        RecursionTraverseTree traverseTree = new RecursionTraverseTree();
        //5 3 1 0 0 4 0 0 8 0 9 0 0
        TreeNode root = traverseTree.createTree();
        traverseTree.preTraverseTree(root);
        System.out.println();

        traverseTree.inTraverseTree(root);
        System.out.println();

        traverseTree.postTraverseTree(root);
        System.out.println();
    }

    //前序递归遍历二叉树
    public void preTraverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preTraverseTree(root.left);
        preTraverseTree(root.right);
    }

    //中序递归遍历二叉树
    public void inTraverseTree(TreeNode root) {
        if (root == null) {
            return;
        }

        inTraverseTree(root.left);
        System.out.print(root.data + " ");
        inTraverseTree(root.right);
    }

    //后序递归遍历二叉树
    public void postTraverseTree(TreeNode root) {
        if (root == null) {
            return;
        }

        postTraverseTree(root.left);
        postTraverseTree(root.right);
        System.out.print(root.data + " ");
    }

    //创建二叉树
    public TreeNode createTree() {
        TreeNode tree;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == 0) {
            tree = null;
        } else {
            tree = new TreeNode(data);
            tree.left = createTree();
            tree.right = createTree();
        }

        return tree;
    }
}

class TreeNode {
    public int data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}