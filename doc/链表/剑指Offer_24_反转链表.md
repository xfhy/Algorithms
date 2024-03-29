```java
package array;

import java.util.LinkedList;

/**
 * @author : xfhy
 * Create time : 2020年7月13日09:12:08
 * Description : 剑指 Offer 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
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

     //解法3: 递归
    public ListNode reverseList(ListNode head) {
        //base case
        if (head == null || head.next == null) return head;

        ListNode last = reverseList(head.next);
        //System.out.println("head=" + head.val + "  last=" + last.val);

        //第2个指向第一个(头节点)
        head.next.next = head;
        head.next = null;

        //返回尾节点(最后的时候已经是头节点了)
        return last;
    }

    //反转链表前n个
    ListNode afterNode=null;
    public ListNode reverseN(ListNode head, int n) {
        //base case 当n减到1时,说明已经到达前n的最后一个,把n的后面那个节点记录下来
        if (n == 1) {
            afterNode = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);

        head.next.next = head;
        //将n的后面个节点连起来
        head.next = afterNode;

        return last;
    }

    //反转某个链表区间
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //base case 如果m=1,那么相当于反转前N个
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
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