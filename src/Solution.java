
/**
 * @author : xfhy
 * Create time : 2021年04月21日08:58:46
 * Description : 35. 搜索插入位置
 * source : https://leetcode-cn.com/problems/search-insert-position/
 */
public class Solution {

    /**
     * 二分查找 找得到就返回找到的位置,找不到就返回查找到最后时的left值,此时的left是最接近target值的位置
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.searchInsert(new int[]{0}, 8));
    }

}
