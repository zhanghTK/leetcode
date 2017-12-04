package tk.zhangh.leetcode._1_50;

import org.junit.Test;
import tk.zhangh.leetcode.ListNode;

/**
 * Created by ZhangHao on 2017/9/4.
 */
public class _02_SolutionTest {
    @Test
    public void addTwoNumbers() throws Exception {
        _02_Solution solution = new _02_Solution();

        ListNode l1 = createList(2, 4, 3);
        ListNode l2 = createList(5, 6, 4);
        ListNode result = createList(7, 0, 8);

        assertListNodeEquals(solution.addTwoNumbers(l1,l2), result);
    }

    private ListNode createList(int x, int x2, int x3) {
        ListNode head = new ListNode(x);
        head.next = new ListNode(x2);
        head.next.next = new ListNode(x3);
        return head;
    }

    private void assertListNodeEquals(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return;
        }
        while (l1.next != null && l2.next != null) {
            assert l1.val == l2.val;
            l1 = l1.next;
            l2 = l2.next;
        }
        assert l1.next == l2.next;
    }
}