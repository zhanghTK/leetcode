package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Created by ZhangHao on 2017/4/7.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;
        while (head.next != null && head.next.next != null) {
            ListNode node1 = head.next;
            ListNode node2 = head.next.next;
            head.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            head = node1;
        }
        return pre.next;
    }
}
