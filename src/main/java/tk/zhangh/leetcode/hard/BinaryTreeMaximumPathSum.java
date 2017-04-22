package tk.zhangh.leetcode.hard;

import tk.zhangh.leetcode.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.
 * Created by ZhangHao on 2017/4/22.
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = new int[]{root.val};
        maxPathSumDfs(root, result);
        return result[0];
    }

    private int maxPathSumDfs(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSumDfs(root.left, result);
        int right = maxPathSumDfs(root.right, result);
        int cur = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
        if (cur > result[0]) {
            result[0] = cur;
        }
        return root.val + Math.max(left, Math.max(right, 0));
    }
}
