package tree;

public class InsertTreeNode {
    public static void main(String[] args) {
        int[] arr = {0, 5, 8, 4, 2, 3, 8, 10};

        TreeNode root = null;
        for (int i = 0; i < arr.length; ++i) {
            root = insertTreeNode(root, arr[i]);
        }

        inTraverseTree(root);
    }

    //往二叉排序树中插入一个新节点(递归实现)
    public static TreeNode insertTreeNode(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur = null;
            if (data <= node.data) {
                cur = insertTreeNodeRecursion(node.left, data);
                node.left = cur;
            } else {
                cur = insertTreeNodeRecursion(node.right, data);
                node.right = cur;
            }
        }

        return node;
    }

    //往二叉排序树中插入一个新节点(非递归实现)
    public static TreeNode insertTreeNodeRecursion(TreeNode root, int data) {
        TreeNode node = new TreeNode(data);
        if (root == null) {
            return node;
        } else {
            TreeNode curNode = root;
            while (true) {
                if (data < curNode.data) {
                    if (curNode.left == null) {
                        curNode.left = node;
                        return root;
                    } else {
                        curNode = curNode.left;
                    }
                } else if (data > curNode.data) {
                    if (curNode.right == null) {
                        curNode.right = node;
                        return root;
                    } else {
                        curNode = curNode.right;
                    }
                } else {
                    System.out.println(data + " 结点已存在");
                    return root;
                }
            }
        }
    }

    //中序遍历二叉树
    public static void inTraverseTree(TreeNode root) {
        if (root == null) {
            return;
        }

        inTraverseTree(root.left);
        System.out.print(root.data + "\t");
        inTraverseTree(root.right);
    }
}
