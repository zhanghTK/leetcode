package tk.zhangh.leetcode._51_100;

import tk.zhangh.leetcode.ListNode;

/**
 * Partition List
 * Created by ZhangHao on 2017/9/21.
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode preLeft = new ListNode(0);
        ListNode preRight = new ListNode(0);
        ListNode left = preLeft, right = preRight;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }

        right.next = null;
        left.next = preRight.next;
        return preLeft.next;
    }
}
