package tree;

import java.util.*;

/**
 * @author : xfhy
 * Create time : 2020/7/12 9:51 上午
 * Description : 二叉树操作
 */
public class BinaryTree {

    /**
     * 二叉树节点
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode createBinaryTree(LinkedList<Integer> inputList) {
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

    //深度优先搜索(DFS) : 采用深度作为优先级,以便从根开始一直到达某个确定的叶子,然后再返回根到达另一个分支.深度优先搜索策略又可以根据根节点,左孩子和右孩子的相对顺序被细分为前序遍历,中序遍历,后续遍历
    //宽度优先搜索(BFS) : 按照高度顺序一层一层的访问整棵树,高层次的节点将会比低层次的节点先被访问到

    public void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
    }

    public void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.left);
        System.out.println(node.val);
        inOrderTraveral(node.right);
    }

    public void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.left);
        postOrderTraveral(node.right);
        System.out.println(node.val);
    }

    /**
     * 前序遍历 二叉树 非递归实现思路1
     * 使用栈来实现
     *
     * @param root 二叉树根节点
     */
    public void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //不断往栈中压入左节点,直到左边没有左节点
            while (treeNode != null) {
                System.out.println(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //弹栈 访问右边节点
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    /**
     * 前序遍历 二叉树 非递归实现思路2
     * 从根节点开始压栈,每次迭代弹出栈顶节点,然后压入子节点,先压右节点,再压左节点,每次弹出栈顶的时候将栈顶节点的数据存入结果List中.
     * 最后的输出顺序是由上往下,由左往右,符合前序遍历的顺序
     * 相关题: 144
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> preList = new LinkedList<>();
        if (root == null) {
            return preList;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            preList.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return preList;
    }

    /**
     * 中序遍历,非递归
     * 在前序遍历的基础上,只需要稍等改动一下sout的位置即可.
     * 从根节点开始找二叉树的最左节点,找到最左节点后访问,对于每个节点来说,它都是以自己为根的子树的根节点,访问完之后就可以转到右儿子上了.
     */
    public void middleOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //不断往栈中压入左节点,直到左边没有左节点
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //弹栈 访问右边节点
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }

    /**
     * 后序遍历(前后中)
     * 其实只需要在先序遍历的基础上稍微改改就行了,先序是:中前后,改一下while中的左右压栈顺序就是: 中后前,得到数据之后再反转,即:前后中.就得到了最后的结果
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 二叉树层序遍历
     *
     * @param root 二叉树根节点
     */
    public void levelOrderTraversal(TreeNode root) {
        //1. 声明一个队列,将根节点入队
        //2. 然后将根节点出队,在根节点出队时将根节点的左节点和右节点都入队
        //3. 循环遍历队列,依次出队,在第2步中的左节点出队时,将自己视为根节点,然后将左右节点入队. 同理,右节点也一样
        //4. 遍历完队列时,所有节点的左右节点都遍历完了.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 二叉树层序遍历 且记录每一层的所有元素
     *
     * @param root 二叉树根节点
     */
    public List<List<TreeNode>> levelOrderTraversals(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<TreeNode>> tree = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<TreeNode> levels = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                levels.add(poll);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            tree.add(levels);
        }
        return tree;
    }

    /**
     * 二叉树的最大深度
     * 思路: 比较左子树的最大深度和右子树的最大深度,
     * 左子树的最大深度同样也适用于这种思路,右子树的最大深度同样也适用于这种思路
     * 这就很适合递归,在访问到空节点时退出.
     * 最后深度需要+1,因为需要计算上根节点.
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
