/**
 * @author : xfhy
 * Create time : 2020年07月18日15:16:37
 * Description : 1512. 好数对的数目
 */
public class Solution {

    /**
     * 用一个数组记录一下哪些数字超过了1,超过1的话,则计算一下x-1到1的等差队列之和
     */
    public static int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] myNums = new int[101];
        for (int num : nums) {
            myNums[num]++;
        }
        int result = 0;
        for (int myNum : myNums) {
            result += getNum(myNum);
        }
        return result;
    }

    public static int getNum(int num) {
        if (num <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = num - 1; i > 0; i--) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 1, 1, 3};
        int[] array2 = new int[]{1,1,1,1};
        int[] array3 = new int[]{1,2,3};
        System.out.println(numIdenticalPairs(array3));
    }

}
