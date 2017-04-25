package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.ListNode;

/**
 * Created by ZhangHao on 2017/4/25.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode sortedHead = new ListNode(0);
        while (head != null) {
            ListNode node = sortedHead;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return sortedHead.next;
    }
}
