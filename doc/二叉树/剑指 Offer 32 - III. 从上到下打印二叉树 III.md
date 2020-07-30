```java
import java.util.*;


/**
 * @author : xfhy
 * Create time : 2020年7月30日09:33:50
 * Description : 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * source : https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
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
     * 思路 : 用队列存储每一层的元素,然后循环这一层,添加到temp集合中.再把temp集合添加到结果中
     * 遇到偶数层,则添加元素时,每次都添加到头部
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp = root;
        boolean needReverse = false;
        while (!queue.isEmpty()) {
            LinkedList<Integer> tempList = new LinkedList<>();
            int size = result.size();
            needReverse = (size + 1) % 2 == 0;
            for (int i = queue.size() - 1; i >= 0; i--) {
                temp = queue.poll();
                if (needReverse) {
                    tempList.addFirst(temp.val);
                } else {
                    tempList.add(temp.val);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(tempList);
        }
        return result;
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
        /*LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(5, 4, 11, 7, null, null, 2, null, null, null, 8, 13, null, null, 4,
                5, null, null, 1));*/
        /*LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null,
                null, 8, null, 4));*/
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 9, null, null, 20, 15, null, null, 7));
        TreeNode binaryTree = createBinaryTree(integers);

        System.out.println(levelOrder(binaryTree));
        //[[3], [9, 20], [15, 7]]
        //[[3], [20, 9], [15, 7]]
    }

}

```