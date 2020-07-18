package tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author : xfhy
 * Create time : 2020/7/12 10:01 上午
 * Description :
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null,
                null, 8, null, 4));

        BinaryTree.TreeNode treeNode = binaryTree.createBinaryTree(integers);
        System.out.println("前序遍历");
//        binaryTree.preOrderTraveral(treeNode);
        binaryTree.preOrderTraveralWithStack(treeNode);
        System.out.println("中序遍历");
        binaryTree.inOrderTraveral(treeNode);
        System.out.println("后序遍历");
        binaryTree.postOrderTraveral(treeNode);
        System.out.println("层序遍历");
        binaryTree.levelOrderTraversal(treeNode);
    }

}
