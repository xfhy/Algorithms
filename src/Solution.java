

/**
 * @author : xfhy
 * Create time : 2021年05月21日08:58:46
 * Description : 左右指针常用算法
 * source : https://leetcode-cn.com/problems/open-the-lock/
 */
public class Solution {

    /**
     * 二分查找基本框架
     */
    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    //两数之和
    //输入一个已按照升序排列的有序数组nums和一个目标target,在nums中找到2个数使得它们相加之和等于target,请返回这2个数的索引(索引从1开始算).
    //思路: 只要数组有序,首先应该想到双指针技巧.  这道题的解法有点像二分搜索,通过比较2个指针的sum与target的大小,然后移动left和right的指针.
    // sum比target大,说明需要查找的2个数的索引在right的左边,现在只需要把right指针左移. sum比target小,则只需要把left右移.
    int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                //因为索引从1开始算,这里需要+1
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    //反转数组
    //思路: 双指针,left在最前面,right在最后面,交换2个数,然后left往右移,right往左移
    void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        int temp;
        while (left < right) {
            //交换2个指针处的元素
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.binarySearch(new int[]{1, 2, 3, 4, 5}, 0));

        /*int[] twoSum = solution.twoSum(new int[]{3, 5, 6, 10, 15}, 8);
        System.out.println(twoSum[0] + "," + twoSum[1]);*/

        int[] nums = new int[]{3, 5, 6, 10, 15};
        solution.reverse(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }

}