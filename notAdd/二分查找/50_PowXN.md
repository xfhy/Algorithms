```java

/**
 * @author : xfhy
 * Create time : 2021年04月22日08:58:46
 * Description : 50. Pow(x, n)
 * source : https://leetcode-cn.com/problems/powx-n/
 */
public class Solution {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        //是否需要倒置
        boolean needInvert = n < 0;
        double innerPow = innerPow(x, needInvert ? -n : n);
        return needInvert ? 1.0 / innerPow : innerPow;
    }

    /**
     * 思路:
     * 当n为偶数时 x^1 -> x^2 -> x^4 -> x^8 -> x^16 -> x^32 -> x^64 -> x^128
     * 当n为奇数时 x^1 -> x^2 -> x^4 -> x^9 -> x^19 -> x^38 -> x^77=x^76 * x ,只需要在之前的基础上乘以x
     */
    private double innerPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = innerPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //System.out.println(solution.myPow(2, -2));
        //System.out.println(solution.myPow(2, 3));
        //System.out.println(solution.myPow(3, 3));
        System.out.println(solution.myPow(0.2, 10000000));
        System.out.println(solution.myPow(0.00001, 2147483647));
    }

}

```