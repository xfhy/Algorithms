import java.util.*;

/**
 * @author : xfhy
 * Create time : 2020年12月30日08:17:09
 * Description : 572. 另一个树的子树
 * source : https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    //todo xfhy 看看这里是否还有其他思路

    /**
     * 思路1: 暴力求解,dfs遍历s中的所有节点,判断一下以这个节点为根节点的树是否和t一致,一致则返回true
     */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public static boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        //检查某个节点是否ok
        if (check(s, t)) {
            return true;
        }
        //去检查其他节点
        if (dfs(s.left, t)) {
            return true;
        }
        if (dfs(s.right, t)) {
            return true;
        }
        return false;
    }

    public static boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
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
        LinkedList<Integer> integers1 = new LinkedList<>(Arrays.asList(1, 1));
        TreeNode binaryTree1 = createBinaryTree(integers1);

        LinkedList<Integer> integers2 = new LinkedList<>(Arrays.asList(1));
        TreeNode binaryTree2 = createBinaryTree(integers2);

        boolean res = isSubtree(binaryTree1, binaryTree2);
        System.out.println(res);
    }

}
