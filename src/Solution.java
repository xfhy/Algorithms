

/**
 * @author : xfhy
 * Create time : 2021年08月14日08:58:46
 * Description : 最长回文子序列
 * source :
 */
public class Solution {

    //思路:
    //定义dp数组,在子串s[i..j]中,最长回文子序列的长度为dp[i][j]
    //如果已经知道了,dp[i+1][j-1]的值,那么要求dp[i][j] :
    //  如果s[i]==s[j],那么dp[i][j]=dp[i+1][j-1]+2,因为多出来的2个是可以加入最长回文子序列里面的
    //  如果s[i]!=s[j],那么有可能在dp[i][j-1]或者dp[i+1][j]中可能存在更长的回文子序列,需要找它们的最大值

    public static void main(String[] args) {
        Solution solution = new Solution();

    }

}