二叉树
======
# 1.二叉树的遍历
> ![tree](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/tree/picture/tree.png)                              
## (1).递归遍历二叉树
```java
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
```
## (2).非递归遍历二叉树
```java
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
```
## (3).按层遍历二叉树
```java
package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class LevelTraverseTree {
    public static void main(String[] args) {
        LevelTraverseTree traverseTree = new LevelTraverseTree();
        TreeNode root = traverseTree.createTree();
        traverseTree.levelTraverseTree(root);
    }

    public void levelTraverseTree(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curNode = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            --curNode;
            System.out.print(root.data + " ");

            if (root.left != null) {
                queue.offer(root.left);
            }

            if (root.right != null) {
                queue.offer(root.right);
            }

            if (curNode == 0) {
                System.out.println();
                curNode = queue.size();
            }
        }
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
```
## 2.求二叉树的结点数
```java
package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class GetTreeNodeCounts {
    public static void main(String[] args) {
        GetTreeNodeCounts nodeCounts = new GetTreeNodeCounts();
        TreeNode root = nodeCounts.createTree();
        System.out.println(nodeCounts.getTreeNodeCountsRecursion(root));
        System.out.println(nodeCounts.getTreeNodeCounts(root));
    }

    public int getTreeNodeCountsRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getTreeNodeCounts(root.left) + getTreeNodeCounts(root.right) + 1;
    }

    public int getTreeNodeCounts(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        int curCount = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            --curCount;
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (curCount == 0) {
                curCount = queue.size();
                count += curCount;
            }
        }

        return count;
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
```
## 3.求二叉树的叶子结点数
```java
package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class GetLeafNodeCounts {
    public static void main(String[] args) {
        GetLeafNodeCounts leafNodeCounts = new GetLeafNodeCounts();
        TreeNode root = leafNodeCounts.createTree();
        System.out.println(leafNodeCounts.getLeafNodeCountsRecursion(root));
        System.out.println(leafNodeCounts.getLeafNodeCounts(root));
    }

    public int getLeafNodeCountsRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return getLeafNodeCountsRecursion(root.left) + getLeafNodeCountsRecursion(root.right);
    }

    public int getLeafNodeCounts(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        int curCount = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            --curCount;
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }

            if (root.left == null && root.right == null) {
                ++count;
            }

            if (curCount == 0) {
                curCount = queue.size();
            }
        }

        return count;
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
```
## 4.求树的深度
```java
package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class GetTreeDepth {
    public static void main(String[] args) {
        GetTreeDepth getTreeDepth = new GetTreeDepth();
        TreeNode root = getTreeDepth.createTree();
        System.out.println(getTreeDepth.getTreeDepthRecursion(root));
        System.out.println(getTreeDepth.getTreeDepth(root));
    }

    public int getTreeDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getTreeDepthRecursion(root.left);
        int right = getTreeDepthRecursion(root.right);

        return left > right ? (left + 1) : (right + 1);
    }

    public int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        int count = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            --count;
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (count == 0) {
                ++depth;
                count = queue.size();
            }
        }

        return depth;
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
```
## 5.求二叉树第 k 层的结点个数
```java
package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetKLevelNodeCounts {
    public static void main(String[] args) {
        GetKLevelNodeCounts kLevelNodeCounts = new GetKLevelNodeCounts();
        TreeNode root = kLevelNodeCounts.createTree();
        System.out.println(kLevelNodeCounts.getKLevelNodeCountsRecursion(root, 2));
        System.out.println(kLevelNodeCounts.getKLevelNodeCounts(root, 2));
    }

    public int getKLevelNodeCountsRecursion(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        return getKLevelNodeCountsRecursion(root.left, k - 1) + getKLevelNodeCountsRecursion(root.right, k - 1);
    }

    public int getKLevelNodeCounts(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curCount = 1;
        while (!queue.isEmpty() && k > 1) {
            root = queue.poll();
            --curCount;

            if (root.left != null) {
                queue.offer(root.left);
            }

            if (root.right != null) {
                queue.offer(root.right);
            }

            if (curCount == 0) {
                curCount = queue.size();
                --k;
            }
        }

        return curCount;
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
```
## 6.判断两棵二叉树是否结构相同
```java
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
```
## 7.求二叉树的镜像

```java
package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Mirror {
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
```
## 8.判断一颗二叉树是否是镜像二叉树
```java
package tree;

import java.util.Scanner;

public class IsMirror {
    public static void main(String[] args) {
        IsMirror isMirror = new IsMirror();
        TreeNode root = isMirror.createTree();
        System.out.println(isMirror.isMirror(root));
    }

    public boolean isMirror(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.data != right.data) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
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
```
## 9.求两个结点的最低公共祖先结点
```java
package tree;

import java.util.Scanner;

public class GetLowestCommonAncestor {
    public static void main(String[] args) {
        GetLowestCommonAncestor lowestCommonAncestor = new GetLowestCommonAncestor();
        TreeNode root = lowestCommonAncestor.createTree();
        TreeNode node1 = root.left.left;
        TreeNode node2 = root.left.right;
        TreeNode common = lowestCommonAncestor.lowestCommonAncestor(root, node1, node2);
        System.out.println(common.data);
    }

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        if (root == node1 || root == node2) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
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
```
## 10.求任意两结点距离
```java
package tree;

import java.util.Scanner;

/*
首先找到两个结点的 LCA，然后分别计算 LCA 与它们的距离，最后相加即可。
 */
public class DistanceTreeNodes {
    public static void main(String[] args) {
        DistanceTreeNodes distanceTreeNodes = new DistanceTreeNodes();
        TreeNode root = distanceTreeNodes.createTree();
        TreeNode node1 = root.left.left;
        TreeNode node2 = root.right.right;
        int distance = distanceTreeNodes.distanceTreeNodes(root, node1, node2);
        System.out.println(distance);
    }

    public int distanceTreeNodes(TreeNode root, TreeNode node1, TreeNode node2) {
        TreeNode lca = findLCA(root, node1, node2);
        int leftLevel = findLevel(lca, node1);
        int rightLevel = findLevel(lca, node2);

        return leftLevel + rightLevel;
    }

    public TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        if (root == node1 || root == node2) {
            return root;
        }

        TreeNode left = findLCA(root.left, node1, node2);
        TreeNode right = findLCA(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public int findLevel(TreeNode lca, TreeNode node) {
        if (lca == null) {
            return -1;
        }

        if (lca == node) {
            return 0;
        }

        //先在左子树查找
        int level = findLevel(lca.left, node);

        //如果左子树没找到，就在右子树查找
        if (level == -1) {
            level = findLevel(lca.right, node);
        }

        //查找到，回溯
        if (level != -1) {
            return level + 1;
        }

        return -1;
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
```
## 11.找出二叉树中某个结点的所有祖先结点
## 12.判断二叉树是不是完全二叉树
## 13.有序链表转化为平衡的二分查找树
## 14.判断是否是二叉查找树。假定二叉树没有重复元素，即对于每个结点，其左右孩子都是严格的小于和大于
## 15.求二叉树中节点的最大距离，即二叉树中相距最远的两个节点之间的距离
## 16.二叉排序树中插入新的节点
