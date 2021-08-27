
import java.util.Arrays;

/**
 * @author : xfhy
 * Create time : 2021年08月14日08:58:46
 * Description : 698. 划分为k个相等的子集
 * source : https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 */
public class Solution {

    //子集划分问题
    //给你输入一个数组nums和一个正整数k,请你判断nums是否能被评分为元素和相同的k个子集

    //思路1: 视角1:切换到这n个数字的视角,每个数字都要选择进入到k个桶中的某一个

    //递归遍历数组  模板
    void traverse(int[] nums, int index) {
        if (index == nums.length) {
            return;
        }
        System.out.println(nums[index]);
        traverse(nums, index + 1);
    }

    public boolean backtrack(int[] nums, int index, int[] bucket, int target) {
        //base case
        if (index == nums.length) {
            //检查所有桶的数字之和是否都是target
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            //nums成功平分成k个子集
            return true;
        }
        //穷举每个桶
        for (int i = 0; i < bucket.length; i++) {
            //剪枝  桶装满了
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            //选择装进第i个桶
            bucket[i] += nums[index];
            //递归穷举下一个数字的选择
            if (backtrack(nums, index + 1, bucket, target)) {
                return true;
            }
            //撤销选择
            bucket[i] -= nums[index];
        }
        //nums[index]装进哪个桶都不行
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;

        //可以做得优化: 将nums数组排序,从大到小,将有更大的几率命中剪枝那个if判断,减少递归
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        for (; i < j; i++, j--) {
            // 交换 nums[i] 和 nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        //k个桶  记录每个桶装的数字之和
        int[] bucket = new int[k];
        return backtrack(nums, 0, bucket, sum / k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] num = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(solution.canPartitionKSubsets(num, 3));
    }

}