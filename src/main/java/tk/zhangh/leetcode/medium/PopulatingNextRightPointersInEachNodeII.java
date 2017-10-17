package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.TreeLinkNode;

/**
 * Created by ZhangHao on 2017/4/21.
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode lastHead = root;
        TreeLinkNode pre = null;
        TreeLinkNode curHead = null;
        while (lastHead != null) {
            TreeLinkNode lastCur = lastHead;
            while (lastCur != null) {
                if (lastCur.left != null) {
                    if (curHead == null) {
                        pre = curHead = lastCur.left;
                    } else {
                        pre = pre.next = lastCur.left;
                    }
                }
                if (lastCur.right != null) {
                    if (curHead == null) {
                        pre = curHead = lastCur.right;
                    } else {
                        pre = pre.next = lastCur.right;
                    }
                }
                lastCur = lastCur.next;
            }
            lastHead = curHead;
            curHead = null;
        }
    }
}
