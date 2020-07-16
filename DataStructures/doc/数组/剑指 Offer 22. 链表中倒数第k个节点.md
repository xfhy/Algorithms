```java
package array;

/**
 * @author : xfhy
 * Create time : 2020年7月13日09:12:08
 * Description : 剑指 Offer 22. 链表中倒数第k个节点
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //先计算链表长度,再计算需要获取的元素的位置,第二次遍历就能找到
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int resultIndex = size - k;
        int index = 0;
        temp = head;
        while (index != resultIndex && temp != null) {
            index++;
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode next = new ListNode(5);
        head.next = next;
        ListNode next1 = new ListNode(1);
        next.next = next1;
        ListNode next2 = new ListNode(9);
        next1.next = next2;
        ListNode result = getKthFromEnd(head, 4);
        System.out.println(result.val);
    }

}

```