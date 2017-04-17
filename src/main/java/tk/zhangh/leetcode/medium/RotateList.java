package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.ListNode;

/**
 * Created by ZhangHao on 2017/4/14.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        k = k % length;
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;
        ListNode tail = pre;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        while (head.next != null) {
            tail = tail.next;
            head = head.next;
        }
        head.next = pre.next;
        pre.next = tail.next;
        tail.next = null;
        return pre.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
