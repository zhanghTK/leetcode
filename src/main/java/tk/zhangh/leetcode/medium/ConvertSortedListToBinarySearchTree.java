package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.ListNode;
import tk.zhangh.leetcode.TreeNode;

import java.util.ArrayList;

/**
 * Created by ZhangHao on 2017/4/20.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(head);
        return helper(list, 0, count - 1);
    }

    private TreeNode helper(ArrayList<ListNode> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode leftNode = helper(list, left, mid - 1);
        TreeNode root = new TreeNode(list.get(0).val);
        root.left = leftNode;
        list.set(0, list.get(0).next);
        root.right = helper(list, mid + 1, right);
        return root;
    }
}
