package tk.zhangh.leetcode.easy;

import tk.zhangh.leetcode.TreeNode;

/**
 * Created by ZhangHao on 2017/4/20.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
