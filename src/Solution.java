import java.util.*;

/**
 * @author : xfhy
 * Create time : 2021年09月25日07:20:46
 * Description : 131. 分割回文串
 * source : https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //递归解法
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

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(4);
        ListNode next = new ListNode(5);
        head.next = next;
        ListNode next1 = new ListNode(1);
        next.next = next1;
        ListNode next2 = new ListNode(9);
        next1.next = next2;
        ListNode result = solution.reverseList(head);

        System.out.println(result.val);
    }

}