package tk.zhangh.leetcode;

/**
 * Swap Nodes in Pairs
 * Created by ZhangHao on 2017/9/6.
 */
public class _24_Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;

        while (head.next != null && head.next.next != null) {
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            head = n1;
        }
        return pre.next;
    }
}
