package tree;

import java.util.Scanner;

public class TwoTreeSame {
    public static void main(String[] args) {
        TwoTreeSame twoTreeSame = new TwoTreeSame();
        TreeNode node1 = twoTreeSame.createTree();
        System.out.println("----------------");
        TreeNode node2 = twoTreeSame.createTree();
        System.out.println("----------------");
        System.out.println(twoTreeSame.sameTree(node1, node2));
    }

    public boolean sameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.data != node2.data) {
            return false;
        }

        return sameTree(node1.left, node2.left) && sameTree(node1.right, node2.right);
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
}
