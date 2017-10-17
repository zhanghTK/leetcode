package tk.zhangh.leetcode.easy;

import tk.zhangh.leetcode.ListNode;

/**
 * Created by ZhangHao on 2017/5/10.
 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
