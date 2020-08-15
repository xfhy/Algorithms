```java
import java.util.Stack;

/**
 * @author : xfhy
 * Create time : 2020年7月22日09:12:05
 * Description : 剑指 Offer 30. 包含min函数的栈
 * source : https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class Solution {

    static class MinStack {

        private Stack<Integer> stack = new Stack<>();
        private int min = Integer.MAX_VALUE;

        public MinStack() {

        }

        public void push(int x) {
            if (x < min) {
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            int pop = stack.pop();
            if (min == pop && !stack.isEmpty()) {
                min = stack.get(0);
                for (Integer integer : stack) {
                    if (integer < min) {
                        min = integer;
                    }
                }
            }
            if(stack.isEmpty()) {
                min = Integer.MAX_VALUE;
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.get(stack.size() - 1);
        }

        public int min() {
            return min;
        }
    }


    public static void main(String[] args) {
        /*
        ["MinStack","push","push","push","top","pop","min","pop", "min","pop", "push","top",    "min","push",   "top","min","pop","min"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
         */
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());

        //[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
    }

}

```