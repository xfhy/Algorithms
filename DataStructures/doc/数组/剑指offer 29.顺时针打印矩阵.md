```java
package array;

import java.util.Arrays;

/**
 * @author : xfhy
 * Create time : 2020年07月05日10:20:18
 * Description : 剑指 Offer 29. 顺时针打印矩阵
 */
public class Solution {
    public static int[] spiralOrder(int[][] matrix) {
        //思路: 顺时针,其实就是先从左往右,再从上往下,再从右往左,然后从下往上.依次这样遍历二维数组,然后将遍历的数组放到结果数组中即可.
        //当到达边界的时候,需要换方向.当遍历一次之后需要缩小边界(left,right,top,bottom),如果边界越界则退出循环
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int index = 0;
        while (true) {
            //从左往右
            for (int i = left; i <= right; i++) {
                res[index] = matrix[top][i];
                index++;
            }
            if (++top > bottom) {
                break;
            }
            //从上往下
            for (int i = top; i <= bottom; i++) {
                res[index] = matrix[i][right];
                index++;
            }
            if (--right < left) {
                break;
            }
            //从右往左
            for (int i = right; i >= left; i--) {
                res[index] = matrix[bottom][i];
                index++;
            }
            if (--bottom < top) {
                break;
            }
            //从下往上
            for (int i = bottom; i >= top; i--) {
                res[index] = matrix[i][left];
                index++;
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[][] array2 = new int[][]{
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        System.out.println(Arrays.toString(spiralOrder(array)));

    }

}

```