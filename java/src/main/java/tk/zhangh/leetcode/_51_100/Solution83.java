package tk.zhangh.leetcode._51_100;

import tk.zhangh.leetcode.ListNode;

/**
 * Remove Duplicates from Sorted List
 * Created by ZhangHao on 2017/9/19.
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        // 依此遍历
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
