package tk.zhangh.leetcode.hard;

import java.util.Arrays;
import java.util.List;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * Created by ZhangHao on 2017/4/6.
 */
public class MergeKSortedLists {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return helper(Arrays.asList(lists), 0, lists.length - 1);
    }

    private ListNode helper(List<ListNode> lists, int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;
            return merge(helper(lists, left, m), helper(lists, m + 1, right));
        }
        return lists.get(left);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l1 = l1.next;
            } else {
                ListNode next = l2.next;
                cur.next = l2;
                l2.next = l1;
                l2 = next;
            }
            cur = cur.next;
        }
        if (l2 != null)
            cur.next = l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        new MergeKSortedLists().mergeKLists(new ListNode[]{});
    }
}
