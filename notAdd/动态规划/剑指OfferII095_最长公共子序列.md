```java


/**
 * @author : xfhy
 * Create time : 2021年08月8日08:58:46
 * Description : 剑指 Offer II 095. 最长公共子序列
 * source : https://leetcode-cn.com/problems/qJnOS7/
 */
public class Solution {

    //给定2个字符串s1和s2,求最长公共子序列的长度(lcs)

    //1. 确定dp数组含义,dp[i][j]是s1[0..i]和s2[0..j]的最长公共子序列的长度
    //2. 确定base case,让索引为0的行和列表示空串,dp[0][j]和dp[i][0]都应该初始化为0
    //3. 找状态转移方程,对于dp[i][j]来说,
    //      如果s1[i]==s2[j],那么这个字符肯定在lcs里面,只要知道s1[0..i-1]和s2[0..j-1]的lcs然后加1就行了.
    //      如果s1[i]!=s2[j],那么有可能某个字符在lcs里面,但是我们不晓得哪个字符在lcs里面,将dp[i-1][j]和dp[i][j-1]取最大值即可

    //1. 递归解法
    int longestCommonSubsequence(String str1, String str2) {
        return dp(str1, str2, str1.length() - 1, str2.length() - 1);
    }

    int dp(String str1, String str2, int i, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return dp(str1, str2, i - 1, j - 1) + 1;
        } else {
            return Math.max(dp(str1, str2, i - 1, j), dp(str1, str2, i, j - 1));
        }
    }

    //2. dp table 备忘录解法
    int longestCommonSubsequence2(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.longestCommonSubsequence("abcde", "aceb"));
        System.out.println(solution.longestCommonSubsequence2("abcde", "eceb"));
    }

}
```