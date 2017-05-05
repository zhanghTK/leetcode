package tk.zhangh.leetcode.easy;

import tk.zhangh.leetcode.ListNode;

/**
 * Reverse a singly linked list.
 * Created by ZhangHao on 2017/5/4.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        ListNode newHead = reverseList(p);
        head.next = null;
        p.next = head;
        return newHead;
    }
}
