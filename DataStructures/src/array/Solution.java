package array;

/**
 * @author : xfhy
 * Create time : 2020年07月05日10:20:18
 * Description : 剑指 Offer 04. 二维数组中的查找
 */
public class Solution {
    /**
     * 暴力 2层循环,找二维数组中的每一个元素
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (target == anInt) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     */
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (target < matrix[i][j]) {
                    break;
                }
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
       /* int heightChecker = heightChecker(new int[]{1, 2, 3, 4, 5});
        System.out.println(heightChecker);*/
        int[][] array = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray2(array, 5));

    }

}
