/**
 * @author : xfhy
 * Create time : 2020年07月19日21:53:58
 * Description : 剑指 Offer 52. 两个链表的第一个公共节点
 * source :
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //   3 2 4 6 7
    // 9 0 2 4 6 7
    //tampA = 3 2 4 6 7 n 9 0 2
    //tempB = 9 0 2 4 6 7 n 3 2

    /**
     * 用2个指针(node1和node2),分别指向2条链表的头结点(headA和headB).然后依次往后遍历,当node1到达链表headA末尾时,赋值为headB的头结点.当node2到达链表headB的末尾时,赋值为headA的头结点.然后继续往后遍历,
     * 当node1和node2相遇时,就找到了公共节点
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(29);
        ListNode node2 = new ListNode(30);
        node1.next = node2;
        ListNode listNode31 = new ListNode(31);
        ListNode listNode32 = new ListNode(32);
        node2.next = listNode31;
        listNode31.next = listNode32;

        System.out.println(getIntersectionNode(node1, node2));
    }

}
