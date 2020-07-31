```java
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import tree.BinaryTree;

/**
 * @author : xfhy
 * Create time : 2020年07月26日23:17:17
 * Description : 剑指 Offer 55 - I. 二叉树的深度
 * source : https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
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

    /**
     * 思路: DFS   后序遍历
     * 左边深度+右边深度+1
     * 
     * 下面的解法2思路是一样的,只不过代码看着更短.
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 1;
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = maxDepth(root.left);
        }
        if (root.right != null) {
            right = maxDepth(root.right);
        }
        sum = sum + Math.max(left, right);
        return sum;
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
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

        System.out.println(maxDepth2(binaryTree));
    }

}

```