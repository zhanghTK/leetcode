package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.TreeNode;

/**
 * Created by ZhangHao on 2017/5/8.
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root, true) + 1;
        int right = getHeight(root, false) + 1;

        if (left == right) {
            return (2 << (left - 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int getHeight(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        TreeNode child = isLeft ? root.left : root.right;
        while (child != null) {
            height++;
            child = isLeft ? child.left : child.right;
        }
        return height;
    }
}
