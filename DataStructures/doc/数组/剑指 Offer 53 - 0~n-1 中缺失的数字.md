```java
package array;

/**
 * @author : xfhy
 * Create time : 2020年07月05日10:20:18
 * Description : 剑指 Offer 53 - 0~n-1 中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 */
public class Solution {

    /**
     * 容易想到的方法,从前往后找,找到就返回
     * O(n)
     */
    public static int missingNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = -1;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums[i]) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            result = nums[length - 1] + 1;
        }
        return result;
    }

    /**
     * 二分查找法
     * 如果中间那个值等于该处的索引,那么说明那么说明左边肯定是排好序了的,缺失的那个数肯定在右边.
     * 如果中间那个值不等于该处的索引,那么说明左边没有排好序,缺一个,那么缺失的那个数肯定在左边.
     * O(logN)
     */
    public static int missingNumber3(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] array0 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        int[] array5 = new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array1 = new int[]{0};  //1
        int[] array2 = new int[]{1};  //0
        int[] array3 = new int[]{0, 1};  //2
        int[] array4 = new int[]{1, 2};  //0
        System.out.println(missingNumber3(array5));

        System.out.println(missingNumber2(array5));
        System.out.println(missingNumber2(array1));
        System.out.println(missingNumber2(array2));
        System.out.println(missingNumber2(array3));
        System.out.println(missingNumber2(array4));

    }

}

```