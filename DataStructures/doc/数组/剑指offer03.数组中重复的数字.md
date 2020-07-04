
```java
package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : xfhy
 * Create time : 2020年07月04日14:28:52
 * Description : 剑指 Offer 03. 数组中重复的数字
 */
public class Solution {
    /**
     * 解法1:将nums数组的值挨个存入集合,存入时判断集合中是否存在该元素,存在则找到了.
     */
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return 0;
    }

    /**
     * 解法2: 定义1个长度为100000的数组,因为nums的所有元素都在2-100000的范围内.
     * 将nums[i]的值与数组下标对应,循环nums数组,将数组相应位置+1.循环时遇到数组不为0的则找到了
     */
    public static int findRepeatNumber2(int[] nums) {
        int[] array = new int[100000];
        for (int num : nums) {
            if (array[num] != 0) {
                return num;
            }
            array[num]++;
        }
        return 0;
    }

    public static void main(String[] args) {
       /* int heightChecker = heightChecker(new int[]{1, 2, 3, 4, 5});
        System.out.println(heightChecker);*/
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));

    }

}

```