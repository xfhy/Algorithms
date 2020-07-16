```java
package array;

import java.util.LinkedList;

/**
 * @author : xfhy
 * Create time : 2020年7月13日09:12:08
 * Description : 剑指 Offer 24. 反转链表
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
     * 解法1 用栈的方式
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                temp = head = stack.pop();
            } else {
                temp.next = stack.pop();
                temp = temp.next;
            }
        }
        if (temp != null) {
            temp.next = null;
        }
        return head;
    }

    /**
     * 解法2 从前往后遍历时,后面元素指向前面元素
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode last = head;
        ListNode next = last.next;
        last.next = null;
        while (next != null) {
            ListNode temp = next.next;
            next.next = last;
            last = next;
            next = temp;
        }

        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode next = new ListNode(5);
        head.next = next;
        ListNode next1 = new ListNode(1);
        next.next = next1;
        ListNode next2 = new ListNode(9);
        next1.next = next2;
        ListNode result = reverseList2(next1);
        System.out.println(result.val);
    }

}

```