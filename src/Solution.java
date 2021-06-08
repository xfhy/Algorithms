
/**
 * @author : xfhy
 * Create time : 2021年06月08日08:58:46
 * Description : 二分查找
 * source :
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

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;   //left+right太大了，防止溢出
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        //出循环时 left = right+1
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                //收缩左侧边界
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        //出循环时  right=left-1
        if (right < 0 || nums[right] != target) return -1;
        return right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //System.out.println(solution.left_bound(new int[]{1, 3, 5/*, 5, 5, 5*/, 6}, 5));
        System.out.println(solution.right_bound(new int[]{1, 3, 5/*, 5, 5, 5*/, 6}, 1));

    }

}