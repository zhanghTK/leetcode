package tk.zhangh.leetcode._51_100;


import tk.zhangh.leetcode.ListNode;

/**
 * Rotate List
 * Created by ZhangHao on 2017/9/14.
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);

        k = k % length;  // k可能大于整个list长度
        if (k == 0) {
            return head;
        }


        // 插入头结点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;

        // 找到倒数k
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = pre.next;
        pre.next = slow.next;
        slow.next = null;
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
