package tk.zhangh.leetcode.easy;

import tk.zhangh.leetcode.ListNode;

/**
 * Created by ZhangHao on 2017/5/3.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;

        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return pre.next;
    }
}
