```java
import java.util.LinkedList;

/**
 * @author : xfhy
 * Create time : 2020年7月21日17:54:41
 * Description : 剑指 Offer 09. 用两个栈实现队列
 * source : https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class Solution {

    static class CQueue {

        /**
         * 第一个栈维护插入
         */
        private LinkedList<Integer> stackIn = new LinkedList<>();
        /**
         * 第二个栈,用于删除.在需要删除的时候全部将第一个栈的元素,出栈到第二个栈里面.
         */
        private LinkedList<Integer> stackOut = new LinkedList<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stackIn.push(value);
        }

        public int deleteHead() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            if (stackOut.isEmpty()) {
                return -1;
            } else {
                return stackOut.pop();
            }
        }
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(5);
        obj.appendTail(2);
        System.out.println(obj.deleteHead());
        obj.appendTail(3);
        obj.appendTail(6);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }

}

```