```java
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : xfhy
 * Create time : 2020年7月23日09:58:27
 * Description : 剑指 Offer 59 - II. 队列的最大值
 * source : https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 */
public class Solution {

    /**
     * 思路: 一个队列queue专门存储数据,给外面调用的,入队,出队.
     * 另一个辅助双端队列deque,用于存储queue中当前的最大值.deque队头永远是queue中的最大值,第二个是就是第二大的元素\
     * 入队: 首先是入队到queue中, 其次是入队到deque中时先判断队尾的元素是否小于需要插入的值,如果是,则先把deque队尾元素出队.  出队的那些元素因为比queue最后入队的小,所以没有啥用.
     * 出队: 首先是出队queue. 然后判断queue出队的这个值,是否等于deque的队头,如果是则需要deque出队,因为最大值已经发生了变化.
     */
    static class MaxQueue {

        private Queue<Integer> queue = new LinkedList<>();
        private LinkedList<Integer> deque = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.element();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!deque.isEmpty() && value > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }

            int pop = queue.poll();
            if (deque.getFirst() == pop) {
                deque.poll();
            }
            return pop;
        }
    }

    public static void main(String[] args) {
        /*
        ["MaxQueue","max_value","pop_front","pop_front","push_back","push_back","push_back","pop_front","push_back","pop_front"]
        [[],[],[],[],[94],[16],[89],[],[22],[]]
         */
        MaxQueue minStack = new MaxQueue();
        System.out.println(minStack.max_value());
        System.out.println(minStack.pop_front());
        System.out.println(minStack.pop_front());
        minStack.push_back(94);
        minStack.push_back(16);
        minStack.push_back(89);
        System.out.println(minStack.pop_front());
        minStack.push_back(22);
        System.out.println(minStack.pop_front());

        //[null,-1,-1,-1,null,null,null,94,null,16]
    }

}

```