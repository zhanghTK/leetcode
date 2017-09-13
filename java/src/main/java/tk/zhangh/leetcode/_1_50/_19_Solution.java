package tk.zhangh.leetcode._1_50;

/**
 * Remove Nth Node From End of List
 * Created by ZhangHao on 2017/9/6.
 */
public class _19_Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }
        // 初始化preHead位于head前
        ListNode deleted = new ListNode(0);
        deleted.next = head;
        ListNode preDelete = deleted;
        // head先跑n步
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            } else {
                head = head.next;
            }
        }
        // head遍历到尾节点，preDelete在第n-1节点
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        // 删除
        preDelete.next = preDelete.next.next;
        return preDelete.next;
    }
}
