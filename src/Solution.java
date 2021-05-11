import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : xfhy
 * Create time : 2021年05月11日08:58:46
 * Description : 46. 全排列
 * source : https://leetcode-cn.com/problems/permutations/
 */
public class Solution {

    //n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    //
    //给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
    //
    //每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

    //思路:首先这题肯定是求所有答案,也就是全部穷举完,回朔法
    //核心就是:
    /*

    for 选择 in 选择列表:
        # 做选择
        将该选择从选择列表中移除
        路径.add(选择)
        backtrack(路径,选择列表)
        # 撤销选择
        路径.remove(选择)
        将该选择恢复到选择列表

    * */

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //board: 一个棋盘
        List<String> board = new ArrayList<>();
        //一行
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        for (int i = 0; i < n; i++) {
            board.add(new String(chars));
        }
        backtrack(board, 0);
        return res;
    }

    /**
     * 路径: 记录在board中
     * 选择列表: board中的第row行的任意一列
     * 结束条件: 最后一行都已经做出选择了
     *
     * @param board 棋盘
     * @param row   第几行
     */
    private void backtrack(List<String> board, int row) {
        //触发结束条件
        if (board.size() == row) {
            res.add(new ArrayList<>(board));
            return;
        }
        String rowText = board.get(row);
        for (int col = 0; col < rowText.length(); col++) {
            //不合法,排除
            if (!isValid(board, row, col)) continue;
            //做出选择  在这一行的第i个节点放置皇后
            placeChess(board, row, col, 'Q');

            //回溯   进入下一层决策树
            backtrack(board, row + 1);

            //撤销选择
            placeChess(board, row, col, '.');
        }
    }

    private void placeChess(List<String> board, int row, int index, char data) {
        char[] chars = new char[board.size()];
        Arrays.fill(chars, '.');
        chars[index] = data;
        board.set(row, new String(chars));
    }

    /**
     * 判断皇后放置在row行col列是否合法
     *
     * @param board 棋盘
     * @param row   行
     * @param col   列
     */
    private boolean isValid(List<String> board, int row, int col) {
        //todo xfhy 未完
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solveNQueens(3));
    }

}