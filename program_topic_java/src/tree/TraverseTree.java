package tree;

import java.util.Scanner;
import java.util.Stack;

public class TraverseTree {
    public static void main(String[] args) {
        TraverseTree traverseTree = new TraverseTree();
        //5 3 1 0 0 4 0 0 8 0 9 0 0
        TreeNode root = traverseTree.createTree();
        traverseTree.preTraverseTree(root);
        System.out.println();

        traverseTree.inTraverseTree(root);
        System.out.println();

        traverseTree.postTraverseTree(root);
        System.out.println();
    }

    //前序遍历二叉树
    public void preTraverseTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.data + " ");
            if (root.right != null) {
                stack.push(root.right);
            }

            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    //中序遍历二叉树
    public void inTraverseTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }

    //后序遍历二叉树
    public void postTraverseTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }

        while (!stack2.isEmpty()) {
            root = stack2.pop();
            System.out.print(root.data + " ");
        }
    }

    //创建二叉树
    public TreeNode createTree() {
        TreeNode tree;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == 0) {
            tree = null;
        } else {
            tree = new TreeNode();
            tree.data = data;
            tree.left = createTree();
            tree.right = createTree();
        }

        return tree;
    }
}
