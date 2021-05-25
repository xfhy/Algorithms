import java.util.*;

import jdk.nashorn.internal.ir.WhileNode;


/**
 * @author : xfhy
 * Create time : 2021年05月21日08:58:46
 * Description : 752. 打开转盘锁
 * source : https://leetcode-cn.com/problems/open-the-lock/
 */
public class Solution {

    static class ListNode {
        ListNode next;
        int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    //1. 判定链表中是否含有环
    boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        //初始化快慢指针指向头节点
        fast = slow = head;
        while (fast != null && fast.next != null) {
            //快指针每次前进两步
            fast = fast.next.next;
            //慢指针每次前进一步
            slow = slow.next;
            //如果存在环,快慢指针必然相遇  因为此时快指针已经"超圈"了
            if (fast == slow) return true;
        }
        return false;
    }

    //2. 已知链表中含有环,返回这个环的起始位置
    //思路: 假设快指针与慢指针相遇时,慢指针走了k步,那么快指针肯定走了2k步.假设k这里离环的起始位置是m步,那么起点到环的起始位置就是k-m,快指针再走k-m步也是环的起始位置.
    //在相遇时,将慢指针回到起始点,重新出发,再次与快指针相遇时,那么就是环的起始位置
    ListNode detectNode(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        //慢指针重新指向head
        slow = head;
        while (fast != slow) {
            //两个指针以相同的速度前进
            fast = fast.next;
            slow = slow.next;
        }
        //两个指针相遇的那个单链表节点就是环的起点
        return fast;
    }

    //3. 寻找无环单链表的中点(重要作用:其中之一是对链表进行归并排序)
    //思路: 快慢指针,快指针一次走2步,快指针到终点时,慢指针就刚好在中间
    ListNode findMiddleNode(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow就在中间位置
        return slow;
    }

    //4. 寻找单链表的倒数第k个元素
    //思路: 还是快慢指针,让快指针先走k步,然后再让快慢指针同速前进,当快指针到终点时,慢指针就是倒数第k个元素(这里为了简化,假设k不会超过链表长度)
    ListNode findLastK(ListNode head, int k) {
        ListNode fast, slow;
        fast = slow = head;
        while (k-- > 0) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node2;

        System.out.println(solution.hasCycle(node1));
        //System.out.println(solution.detectNode(node1).data);
        System.out.println(solution.findMiddleNode(node1).data);
        System.out.println(solution.findLastK(node1,3).data);
    }

}