```java
import java.util.*;


/**
 * @author : xfhy
 * Create time : 2020年08月02日13:45:56
 * Description : 剑指 Offer 07. 重建二叉树
 * source : https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //Arrays.copyOfRange 是[x1,x2)

    /**
     * 前序遍历: 根节点在最前面
     * 中序遍历: 根节点在中间
     * <p>
     * <p>
     * 假设
     * 前序：ABCDE
     * 中序：CDBAE
     * <p>
     * 方案1:
     * 思路: 在前序中找到第一个根节点A,这个A在中序里面: 左侧是A的左子树,右侧是A的右子树.
     * 然后在前序里面找到B,这个B在中序里面CD是它的左子树,它没有右子树
     * 然后在前序里面找到C,这个C在中序里面没有左子树,D是它的右子树
     * <p>
     * 用递归的思路,每次找到根节点之后,切分出该根节点的左子树的前序和中序,右子树的前序和中序,递归下去.
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        //根据前序构建根节点
        TreeNode root = new TreeNode(preorder[0]);

        //找到根节点在中序中的位置,才知道根节点的左子树和右子树
        int leftSize = find(inorder, root.val);

        //切分出根节点的左子树的前序和中序,然后递归去创建左子树
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
        root.left = buildTree(leftPreorder, leftInorder);

        //切分出根节点的右子树的前序和中序,然后递归去创建右子树
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftSize + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, leftSize + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

    private static int find(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 方案2: 和上面方案1是差不多的,只不过多了一个Map用来记住前序中的根节点在中序中的位置
     */
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd,
                                     Map<Integer, Integer> indexMap) {
        //说明是空子树了
        if (preorderStart > preorderEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderStart]);

        //当前为根节点,如果相等的话
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            //递归下去  创建左子树  右子树
            //根节点在中序 中的索引
            int rootIndex = indexMap.get(root.val);
            //根节点左右子树节点的个数
            int leftNodes = rootIndex - inorderStart;
            int rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
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

        int[] preorder = new int[]{1,2,3};
        int[] inorder = new int[]{3,2,1};

        System.out.println(buildTree2(preorder, inorder));
    }

}

```