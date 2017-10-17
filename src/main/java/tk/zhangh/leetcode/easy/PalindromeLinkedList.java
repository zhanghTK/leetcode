package tk.zhangh.leetcode.easy;

import tk.zhangh.leetcode.ListNode;

/**
 * Created by ZhangHao on 2017/5/10.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (validate(head)) return true;
        ListNode mid = getListMid(head);
        ListNode secondHead = reverseSecondList(mid);
        return compareList(head, secondHead);
    }

    private boolean validate(ListNode head) {
        return head == null || head.next == null;
    }

    private boolean compareList(ListNode head, ListNode secondHead) {
        while (secondHead != null) {
            if (head.val != secondHead.val) {
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        return true;
    }

    private ListNode reverseSecondList(ListNode mid) {
        ListNode p1 = mid;
        ListNode p2 = p1.next;

        while (p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        mid.next = null;
        return p1;
    }

    private ListNode getListMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
}
