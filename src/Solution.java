
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

    //思路2: 视角2:以桶的视角,从数组中选数字然后装进桶内,看能否装得下,桶装满了接着装下一个桶,所有桶装满了就ok
    //base case 当全部装完了的时候(k==0),就是OK的
    //bucket装满了,就继续装下一个

    /**
     * @param k      开始装第几个桶
     * @param bucket 当前桶已经装了的和
     * @param nums   所有的数字
     * @param used   已经被装进桶了的数字
     * @param start  从这个下标开始,后面的数字才能装
     * @param target 每个桶需要装的和
     * @return
     */
    public boolean backtrack2(int k, int bucket,
                       int[] nums, int start, boolean[] used, int target) {
        // base case
        if (k == 0) {
            // 所有桶都被装满了，而且 nums 一定全部用完了
            // 因为 target == sum / k
            return true;
        }
        if (bucket == target) {
            // 装满了当前桶，递归穷举下一个桶的选择
            // 让下一个桶从 nums[0] 开始选数字
            return backtrack2(k - 1, 0, nums, 0, used, target);
        }

        // 从 start 开始向后探查有效的 nums[i] 装入当前桶
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (used[i]) {
                // nums[i] 已经被装入别的桶中
                continue;
            }
            if (nums[i] + bucket > target) {
                // 当前桶装不下 nums[i]
                continue;
            }
            // 做选择，将 nums[i] 装入当前桶中
            used[i] = true;
            bucket += nums[i];
            // 递归穷举下一个数字是否装入当前桶
            if (backtrack2(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            // 撤销选择
            used[i] = false;
            bucket -= nums[i];
        }
        // 穷举了所有数字，都无法装满当前桶
        return false;
    }

    public boolean canPartitionKSubsets2(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;

        boolean[] used = new boolean[nums.length];
        int target = sum / k;
        return backtrack2(k, 0, nums, 0, used, target);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] num = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(solution.canPartitionKSubsets2(num, 3));
    }

}