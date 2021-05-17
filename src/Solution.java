import java.util.Arrays;
import java.util.LinkedList;


/**
 * @author : xfhy
 * Create time : 2021年05月14日08:58:46
 * Description : 111. 二叉树的最小深度
 * source : https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
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

    //BFS 框架
    /*

    //计算从起点start到终点target的最短距离
        int BFS(Node start, Node target) {
            //核心数据结构
            Queue<Node> q;
            //避免走回头路
            Set<Node> visited;

            //将起点加入
            q.offer(start);
            visited.add(start);
            //记录扩散的步数
            int step = 0;

            while (q not empty){
                int sz = q.size();
                //将当前队列中的所有节点向四周扩散
                for (int i = 0; i < sz; i++) {
                    Node cur = q.poll();
                    //判断是否已经到达终点
                    if (cur is target)return step;
                    //将cur相邻节点加入队列
                    for (Node x : cur.adj()) {
                        if(x not in visited) {
                            q.offer(x);
                            visited.add(x);
                        }
                    }
                }
                //!!!更新步数
                step++;
            }
        }

    * */

    //二叉树的最小深度
    //使用BFS 广度优先搜索 ,空间复杂度稍微高一些
    //使用DFS 深度优先搜索, 空间复杂度稍微低一些

    //这里使用BFS框架
    int minDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //root本身占一层,所以初始化为1
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //将当前队列中的所有节点向四周扩散
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                //判断是否到达终点
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                //将cur相邻节点加入队列
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            //将这一层的全部添加完成  增加步数
            depth++;
        }
        return depth;
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
        Solution solution = new Solution();
        LinkedList<Integer> integers = new LinkedList<>(Arrays.asList(3, 9, null, null, 20, 15, null, null, 7));
        TreeNode binaryTree = createBinaryTree(integers);

        System.out.println(solution.minDepth(binaryTree));
    }

}