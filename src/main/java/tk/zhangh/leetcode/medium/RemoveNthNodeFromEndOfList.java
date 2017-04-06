package tk.zhangh.leetcode.medium;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * Created by ZhangHao on 2017/4/6.
 */
public class RemoveNthNodeFromEndOfList {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }
        ListNode deleted = new ListNode(0);
        deleted.next = head;
        ListNode preDelete = deleted;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return deleted.next;
    }
}
