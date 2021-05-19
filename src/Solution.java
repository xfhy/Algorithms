import java.util.*;


/**
 * @author : xfhy
 * Create time : 2021年05月14日08:58:46
 * Description : 111. 二叉树的最小深度
 * source : https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class Solution {

    //打开转盘锁
    //从"0000"开始,转第一次,有8种可能,分别是"1000","9000","0100","0900"...
    //可以把"0000"看成是根节点,然后可以把题目看成图,从根节点出发,每个节点都有8个相邻的节点.
    //首先穷举完所有可能的结果,然后根据题目意思 跳过 已经访问过的+不允许访问的

    int openLock(String[] deadends, String target) {
        return -1;
    }

    /**
     * 将s[j]向上拨动一次
     */
    String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j]++;
        }
        return new String(chars);
    }

    /**
     * 将s[j]向下拨动一次
     */
    String minusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j]--;
        }
        return new String(chars);
    }

    //这是代码框架
    //缺陷1: 会走回头路. 比如0000拨到1000,但是等从队列中拿出1000时,还会拨出一个0000,如此往复,产生死循环
    //缺陷2: 没有终止条件,按照题目要求,找到target就应该结束并返回拨动的次数
    //缺陷3: 没有对deadends的处理,按道理这些死亡密码是不能出现的,也就是说遇到这些密码需要跳过,不进行操作
    void BFS(String target) {
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            //将当前队列的所有节点向周围扩散
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                //判断是否到达终点
                System.out.println(poll);

                //将一个节点的相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    //将s[j]向上拨动一次  一个新密码形成
                    String plusOneNewPwd = plusOne(poll, j);
                    String minusOneNewPwd = minusOne(poll, j);
                    queue.offer(plusOneNewPwd);
                    queue.offer(minusOneNewPwd);
                }
            }
            //在这里增加步数
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.BFS("0100");
    }

}