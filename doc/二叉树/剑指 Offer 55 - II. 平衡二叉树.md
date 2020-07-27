```java
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import tree.BinaryTree;

/**
 * @author : xfhy
 * Create time : 2020年07月27日09:17:17
 * Description : 剑指 Offer 55 - II. 平衡二叉树
 * source : https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */
public class Solution {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public static int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        //相减小于 2 是 ok的
        //否则就 不ok,则剪枝
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        TreeNode node = null;
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(5, 4, 11, 7, null, null, 2, null, null, null, 8, 13, null, null, 4,
                5, null, null, 1));
        /*LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null,
                null, 8, null, 4));*/
        TreeNode binaryTree = createBinaryTree(integers);

        System.out.println(isBalanced(binaryTree));
    }

}

```