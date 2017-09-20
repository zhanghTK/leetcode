package tk.zhangh.leetcode._51_100;

import tk.zhangh.leetcode.ListNode;

/**
 * Created by ZhangHao on 2017/9/19.
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 插入头结点
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                // 找到重复
                int val = head.next.val;
                // 跳过所有重复
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }

        return pre.next;
    }
}
