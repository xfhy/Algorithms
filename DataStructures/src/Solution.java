import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author : xfhy
 * Create time : 2020年07月12日19:24:32
 * Description : 剑指 Offer 06. 从尾到头打印链表
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 用栈的方式实现,先压栈,再出栈
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        int size = stack.size();
        int[] result = new int[size];
        int index = 0;
        while (index < size) {
            result[index] = stack.pop();
            index++;
        }
        return result;
    }

    /**
     * 题目说了最大长度是10000,则先放入一个大数组再取出来.
     */
    public static int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int[] maxArray = new int[10000];
        int index = 0;
        ListNode temp = head;
        while (temp != null) {
            maxArray[index] = temp.val;
            temp = temp.next;
            index++;
        }
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = maxArray[index - i - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode listNode = new ListNode(1);
        ListNode next1 = new ListNode(3);
        listNode.next = next1;
        ListNode next2 = new ListNode(2);
        next1.next = next2;

        head.next = listNode;
        System.out.println(Arrays.toString(reversePrint2(head)));
    }

}
