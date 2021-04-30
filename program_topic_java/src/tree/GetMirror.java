package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GetMirror {
    public static void main(String[] args) {
        GetMirror mirror = new GetMirror();
        TreeNode root = mirror.createTree();
        mirror.levelTraverseTree(root);
        System.out.println("------------------");
        mirror.mirror(root);
        mirror.levelTraverseTree(root);
        System.out.println("------------------");
        mirror.mirror2(root);
        mirror.levelTraverseTree(root);
        System.out.println("------------------");
        TreeNode node = mirror.mirror3(root);
        mirror.levelTraverseTree(node);
    }

    //递归求二叉树的镜像
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirror(root.left);
        mirror(root.right);
    }

    //非递归求二叉树的镜像
    public void mirror2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    //递归求二叉树的镜像
    public TreeNode mirror3(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = mirror3(root.left);
        TreeNode right = mirror3(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

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

    public void levelTraverseTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curCount = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            --curCount;
            System.out.print(root.data + " ");
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (curCount == 0) {
                curCount = queue.size();
                System.out.println();
            }
        }
    }
}
