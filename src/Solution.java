import java.util.Arrays;

/**
 * @author : xfhy
 * Create time : 2021年06月29日08:58:46
 * Description : 最长递增子序列
 * source :
 */
public class Solution {

    /**
     * 最长递增子序列
     * 思路: dp[i]表示nums[i]处的最长递增子序列,假设d[0..i-1]是已知的,如果求dp[i]? 只需要在nums[0..i]中找到比nums[i]小的,并且此处是dp最大的,然后加上1即可.
     * 这样就能保证在dp[i]处依然是最长的递增子序列
     */
    int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //只需要在nums[0..i]中找到比nums[i]小的,并且此处是dp最大的,然后加上1即可.
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        String minWindow = solution.minWindow("AABBCCDGEDDS", "BCA");
//        System.out.println("\n");
//        System.out.println(minWindow);

//        List<Integer> anagrams = solution.findAnagrams("wocaoaadda", "ad");
//        System.out.println(anagrams);

        System.out.println(solution.lengthOfLIS(new int[]{1, 2, 4, 234, 23, 5}));

    }

}