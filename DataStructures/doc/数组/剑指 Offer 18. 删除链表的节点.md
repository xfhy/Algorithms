```java
package array;

/**
 * @author : xfhy
 * Create time : 2020年7月13日09:12:08
 * Description : 剑指 Offer 18. 删除链表的节点
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head.next;
        if (first.val == val) {
            head = head.next;
        } else {
            while (second != null) {
                if (second.val == val) {
                    first.next = second.next;
                    break;
                }
                first = first.next;
                second = second.next;
            }
        }
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
        ListNode result = deleteNode(head, 5);
        System.out.println(result);
    }

}

```