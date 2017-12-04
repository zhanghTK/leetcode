package tk.zhangh.leetcode._1_50;

import tk.zhangh.leetcode.ListNode;

/**
 * Add Two Numbers
 * Created by ZhangHao on 2017/9/4.
 */
public class _02_Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;  // 进位

        // 遍历链表节点相加
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }

        // l1不为空
        while (l1 != null) {
            int sum = carry + l1.val;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            current = current.next;
        }

        // l2不为空
        while (l2 != null) {
            int sum = carry + l2.val;
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            current = current.next;
        }

        // 处理进位
        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return head.next;
    }
}
