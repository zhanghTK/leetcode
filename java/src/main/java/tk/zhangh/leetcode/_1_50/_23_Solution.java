package tk.zhangh.leetcode._1_50;

import java.util.Arrays;
import java.util.List;

/**
 * Merge k Sorted Lists
 * Created by ZhangHao on 2017/9/6.
 */
public class _23_Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return helper(Arrays.asList(lists), 0, lists.length - 1);
    }

    private ListNode helper(List<ListNode> lists, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            return merge(helper(lists, l, m), helper(lists, m + 1, r));
        }
        return lists.get(l);
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
}
