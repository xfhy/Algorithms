```java
package array;

/**
 * @author : xfhy
 * Create time : 2020年07月05日10:20:18
 * Description : 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 */
public class Solution {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        for (int num : nums) {
            if (num == target) {
                result++;
            } else if (num > target) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(search(array, 12));

    }

}

```