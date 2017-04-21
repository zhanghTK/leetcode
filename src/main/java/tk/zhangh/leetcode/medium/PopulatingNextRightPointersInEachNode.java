package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.TreeLinkNode;

/**
 * Created by ZhangHao on 2017/4/21.
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }
        root.left.next = root.right;
        root.right.next = root.next == null ? null : root.next.left;
        connect(root.left);
        connect(root.right);
    }
}
