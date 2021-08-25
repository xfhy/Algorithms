
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author : xfhy
 * Create time : 2021年08月14日08:58:46
 * Description :
 * source :
 */
public class Solution {

//    for 选择 in 选择列表:
//    # 做选择
//    将该选择从选择列表移除
//    路径.add(选择)
//    backtrack(路径, 选择列表)
//    # 撤销选择
//    路径.remove(选择)
//    将该选择再加入选择列表

    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        List<String> board = new LinkedList<>();

        initTrack(n, board);

        backtrack(board, 0);
        return res;
    }

    //全部放置.  初始化棋盘
    //'.' 表示空，'Q' 表示皇后，初始化空棋盘。
    private void initTrack(int n, List<String> track) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < n; j++) {
            stringBuilder.append(".");
        }
        for (int j = 0; j < n; j++) {
            track.add(stringBuilder.toString());
        }
    }

    //结束条件: row到达最后一行
    //row表示当前在哪一行,row上面的已经放好皇后了
    private void backtrack(List<String> board, int row) {
        //触发结束条件
        if (row == board.size()) {
            res.add(new LinkedList<>(board));
            return;
        }

        //在这一行里面选择某个点来放  [0-n)
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            //排除不合法选择
            if (!isValid(board, row, col)) {
                continue;
            }
            //做选择  在board的row行col列
            updateStrCharAt(board, row, col, "Q");
            //进入下一层决策树
            backtrack(board, row + 1);
            //撤销选择
            updateStrCharAt(board, row, col, ".");
        }
    }

    private void updateStrCharAt(List<String> board, int row, int col, String str) {
        StringBuilder stringBuilder = new StringBuilder(board.get(row));
        stringBuilder.replace(col, col + 1, str);
        board.set(row, stringBuilder.toString());
    }

    /**
     * 是否可以在 board[row][col] 放置皇后
     */
    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();

        //正上方
        for (String s : board) {
            if (s.charAt(col) == 'Q') {
                return false;
            }
        }

        //左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        //右上方
        for (int i = row - 1, j = col + 1; i >=0 && j <n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<String>> lists = solution.solveNQueens(8);
        for (List<String> list : lists) {
            System.out.println("------------");
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

}