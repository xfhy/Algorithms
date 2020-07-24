```java
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : xfhy
 * Create time : 2020年7月24日09:31:38
 * Description : 剑指 Offer 59 - I. 滑动窗口的最大值
 * source : https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class Solution {

    //deque 内 仅包含窗口内的元素 ⇒ 每轮窗口滑动移除了元素 nums[i−1] ，需将 deque 内的对应元素一起删除。
    //deque 内的元素 非严格递减 ⇒ 每轮窗口滑动添加了元素 nums[j+1] ，需将 deque 内所有 < nums[j+1] 的元素删除。
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0 || k > nums.length) {
            return new int[0];
        }
        //队列用来装窗口内的数据,队头的数值最大
        Deque<Integer> deque = new LinkedList<>();
        int times = nums.length - k + 1;
        int[] result = new int[times];

        //-----未创建窗口时
        for (int i = 0; i < k; i++) {
            //如果队列最后一个元素,即当前队列最小值<需要新插入的值,则先移除. 小的值,没有存下来的意义
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offer(nums[i]);
        }
        result[0] = deque.peekFirst();

        //已创建窗口时
        for (int i = 1; i < times; i++) {
            //判断滑动出窗口的元素是否为窗口内最大值,  如果刚好是,则需要移除队头
            if (!deque.isEmpty() && nums[i - 1] == deque.peekFirst()) {
                deque.pollFirst();
            }
            //判断划入的元素是否大于队列尾部(最小值)
            int nextNum = nums[i + k - 1];
            while (!deque.isEmpty() && deque.peekLast() < nextNum) {
                deque.pollLast();
            }
            //添加这一次滑动之后的新元素
            deque.offer(nextNum);
            //队列头部 即是窗口最大值,这里不需要移除
            result[i] = deque.peekFirst();
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = {4, 3,11};
        System.out.println(Arrays.toString(maxSlidingWindow(ints, 3)));
    }

}

```