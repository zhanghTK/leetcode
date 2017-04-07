package tk.zhangh.leetcode.hard;

import tk.zhangh.leetcode.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * Created by ZhangHao on 2017/4/7.
 */
public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;
        while (head.next != null) {
            head = reverseNextK(head, k);
        }
        return pre.next;
    }

    private ListNode reverseNextK(ListNode head, int k) {
        // check there is enought nodes to reverse
        ListNode next = head; // next is not null
        for (int i = 0; i < k; i++) {
            if (next.next == null) {
                return next;
            }
            next = next.next;
        }

        // reverse
        ListNode node = head.next;
        ListNode prev = head, curt = node;
        for (int i = 0; i < k; i++) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }

        node.next = curt;
        head.next = prev;
        return node;
    }
}
