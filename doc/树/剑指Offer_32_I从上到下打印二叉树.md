```java
import java.util.*;


/**
 * @author : xfhy
 * Create time : 2020年7月28日09:44:20
 * Description : 剑指 Offer 32 - I. 从上到下打印二叉树
 * source : https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
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

    private static List<Integer> elements = new LinkedList<>();
    private static Queue<TreeNode> traverse = new LinkedList<>();

    /**
     * 方案1  通过队列的方式,将每一层的元素插入到队列
     * 广度优先遍历
     */
    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        traverse.offer(root);
        TreeNode temp = root;
        while (!traverse.isEmpty()) {
            temp = traverse.poll();
            elements.add(temp.val);
            if (temp.left != null) {
                traverse.offer(temp.left);
            }
            if (temp.right != null) {
                traverse.offer(temp.right);
            }
        }
        int[] result = new int[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            result[i] = elements.get(i);
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
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 9, 20, null, null, 15, 7));
        TreeNode binaryTree = createBinaryTree(integers);

        System.out.println(Arrays.toString(levelOrder(binaryTree)));
    }

}

```