```java
import java.util.HashMap;

/**
 * @author : xfhy
 * Create time : 2021年04月30日08:58:46
 * Description : 剑指 Offer 10- I. 斐波那契数列
 * source :
 */
public class Solution {

    //严格来说,斐波拉契序列不算是动态规划  因其不涉及 最优子结构
    //F(0) = 0,   F(1) = 1
    //F(N) = F(N - 1) + F(N - 2), 其中 N > 1

    //思路1: 直接递归
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    //思路2: 因思路1中涉及到大量重复计算子问题的缺陷,因而可能将子问题记录下来,,形成备忘录,需要时直接取出即可
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        hashMap.put(0, 0);
        hashMap.put(1, 1);
        return helper1(n);
    }

    private int helper1(int n) {
        if (hashMap.get(n) != null) {
            return hashMap.get(n);
        }
        int result = helper1(n - 1) + helper1(n - 2);
        hashMap.put(n, result);
        return result;
    }

    //思路3: DP table,可以直接通过迭代的方式,将前2个的值相加得到下一个的值,不断迭代,直到得出最后f(n)的结果
    public int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        HashMap<Integer, Integer> dpTable = new HashMap<>();
        dpTable.put(0, 0);
        dpTable.put(1, 1);
        dpTable.put(2, 1);
        int result = 1;
        for (int i = 3; i <= n; i++) {
            dpTable.put(i, dpTable.get(i - 1) + dpTable.get(i - 2));
        }
        return dpTable.get(n);
    }

    //思路4: 将思路3中的DP table压缩,只需要存储前2个位置的值,即f(n-1)和f(n-2)就能得出下一个
    public int fib4(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        //前2个
        int prevX = 1, prevY = 1, result = 0;
        for (int i = 3; i <= n; i++) {
            result = prevX + prevY;
            prevX = prevY;
            prevY = result;
        }
        return result;
    }

    //思路1: 直接递归
    //思路2: 因思路1中涉及到大量重复计算子问题的缺陷,因而可能将子问题记录下来,,形成备忘录,需要时直接取出即可
    //思路3: DP table,可以直接通过迭代的方式,将前2个的值相加得到下一个的值,不断迭代,直到得出最后f(n)的结果
    //思路4: 将思路3中的DP table压缩,只需要存储前2个位置的值,即f(n-1)和f(n-2)就能得出下一个

    /**
     * 上面4个都是思路  这个是答题用的,为了符合题目要求,需要考虑越界问题
     */
    public int fib5(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        //前2个
        long prevX = 1, prevY = 1, result = 0;
        for (int i = 3; i <= n; i++) {
            result = (prevX + prevY) % 1000000007;
            prevX = prevY;
            prevY = result;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

       /* System.out.println(solution.fib1(2));
        System.out.println(solution.fib2(20));
        System.out.println(solution.fib3(20));
        System.out.println(solution.fib4(20));*/
        System.out.println(solution.fib5(100));
    }

}
```