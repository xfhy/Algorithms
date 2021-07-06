```java


/**
 * @author : xfhy
 * Create time : 2021年07月1日08:58:46
 * Description : 剑指 Offer 42. 连续子数组的最大和
 * source : https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class Solution {

    /**
     * 最大子数组问题
     * 求数组nums中和最大的子数组,返回这个子数组的和
     * 思路1: 假设已经算出了dp[i-1],那么dp[i]有两种选择,要么与前面的相邻子数组连接,形成一个更大的子数组;要么不与前面的子数组连接,自成一派,自己作为一个子数组.
     * dp[i]=max(nums[i],nums[i]+dp[i-1])     ,要么和前面的子数组合并,要么自成一派.
     */
    int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;


        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            //状态转移方程
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        //求dp数组中的最大值
        int res = Integer.MIN_VALUE;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }

    // 思路2: 状态压缩,dp[i]仅仅与dp[i-1]有关,所以可以把dp数组去掉,只定义2个变量,从而压缩了空间
    int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int dp_0 = nums[0];
        int dp_1, res = dp_0;
        for (int i = 1; i < nums.length; i++) {
            //dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            //向后推进时,顺便计算最大值   
            res = Math.max(dp_1, res);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxSubArray(new int[]{1, 2, 4, 234, 23, 5}));
        System.out.println(solution.maxSubArray2(new int[]{1, 2, 4, 234, 23, 5}));

    }

}
```