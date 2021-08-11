

/**
 * @author : xfhy
 * Create time : 2021年08月12日08:58:46
 * Description : 经典动态规划:编辑距离
 * source :
 */
public class Solution {

    //可以对一个字符串进行三种操作:插入一个字符,删除一个字符,替换一个字符
    //现在给你两个字符串s1和s2,请计算s1转换成s2最少需要多少次操作

    //思路: 搞2个索引i和j,分别从s1和s2的末尾出发,然后向前.
    // 如果s1[i]==s2[j] 那么不需要做任何操作,i和j都向前移动
    //如果s1[i]!=s2[j] 时,有3种情况,分别是增加字符、删除字符、替换字符  找出最小操作值即可
    //base case : 当i或j完成时,返回对方字符串剩余的个数,这部分要么是需要删除的要么是需要增加的字符,但我们只需要知道操作个数就行

    private String s1;
    private String s2;

    public int minDistance(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        //i,j 初始化,指向最后一个索引
        return dp(s1.length() - 1, s2.length() - 1);
    }

    //dp函数定义: s1[0..i]和s2[0..j]的最小编辑距离是dp(i,j)
    private int dp(int i, int j) {
        //i走完了  返回对方字符串剩余的字符个数
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        //做选择
        if (s1.charAt(i) == s2.charAt(j)) {
            //什么都不用操作
            return dp(i - 1, j - 1);
        } else {
            int add = dp(i, j - 1) + 1;
            int replace = dp(i - 1, j - 1) + 1;
            int delete = dp(i - 1, j) + 1;
            return Math.min(Math.min(add, replace), delete);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.longestCommonSubsequence("abcde", "aceb"));
        System.out.println(solution.minDistance("rad", "apple"));
    }

}