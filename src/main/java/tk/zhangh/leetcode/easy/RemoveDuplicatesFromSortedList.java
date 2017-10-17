package tk.zhangh.leetcode.easy;

import tk.zhangh.leetcode.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Created by ZhangHao on 2017/4/18.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
