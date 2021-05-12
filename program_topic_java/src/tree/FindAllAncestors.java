package tree;

import java.util.Scanner;

public class FindAllAncestors {
    public static void main(String[] args) {
        FindAllAncestors findAllAncestors = new FindAllAncestors();
        TreeNode root = findAllAncestors.createTree();
        TreeNode target = root.left.right;
        TreeNode node = root.right.right;
        findAllAncestors.findAllAncestors(root, target);
        findAllAncestors.findAllAncestors(root, node);
    }

    public boolean findAllAncestors(TreeNode node, TreeNode target) {
        if (node == null) {
            return false;
        }

        if (node == target) {
            return true;
        }

        if (findAllAncestors(node.left, target) || findAllAncestors(node.right, target)) {
            System.out.print(node.data + "\t");
            return true;
        }

        return false;
    }

    public TreeNode createTree() {
        TreeNode tree;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        if (data == 0) {
            return null;
        } else {
            tree = new TreeNode();
            tree.data = data;
            tree.left = createTree();
            tree.right = createTree();
        }

        return tree;
    }
}
