
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : xfhy
 * Create time : 2021年09月11日07:20:46
 * Description : 剑指 Offer II 085. 生成匹配的括号
 * source : https://leetcode-cn.com/problems/IDBivT/
 */
public class Solution {

    //先拿出回溯算法模板
    /*result = []
    void backtrack(路径,选择列表){
        if(满足结束条件) {
            result.add(路径);
            return;
        }
        for(选择 in 选择列表) {
            做选择;
            backtrack(路径,选择列表);
            撤销选择
        }
    }*/

    //思路:
    //n对括号,那么就是有2n个位置,每个位置可能会放置"("或者")"
    //一个合法的字符串组合p,肯定是左右括号数量相等
    //一个合法的字符串组合p,对于已经放置的i(0<=i<=len(p))个字符来说,左括号的数量肯定是大于等于右括号的数量的
    //回溯法问题,先考虑穷举完所有答案,再考虑剪枝

    char[] choice = new char[]{'(', ')'};

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder track = new StringBuilder();
        //start=1,代表当前的位置,一共有2n个位置
        backtrack(1, 2 * n, res, track);
        return res;
    }

    private void backtrack(int start, int n, List<String> res, StringBuilder track) {
        //start表示当前的位置,当start==n+1时,说明全面已穷举完成 track长度为2n了
        if (start == n + 1) {
            if (stringIsLegal(track)) {
                res.add(track.toString());
            }
            return;
        }
        for (char c : choice) {
            track.append(c);
            backtrack(start + 1, n, res, track);
            track.deleteCharAt(track.length() - 1);
        }
    }

    private boolean stringIsLegal(StringBuilder stringBuilder) {
        int length = stringBuilder.length();
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < length; i++) {
            if (stringBuilder.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (rightCount > leftCount) {
                return false;
            }
        }
        return leftCount == rightCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.stringIsLegal(new StringBuilder("))((")));
//        System.out.println(solution.stringIsLegal(new StringBuilder("()()")));
//        System.out.println(solution.stringIsLegal(new StringBuilder("(())")));

        List<String> res = solution.generateParenthesis(3);
        System.out.println(res);
    }

}