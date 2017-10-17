package tk.zhangh.leetcode.easy;

import tk.zhangh.leetcode.TreeNode;

/**
 * Created by ZhangHao on 2017/4/20.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(num[(start + end) / 2]);
        root.left = buildTree(num, start, (start + end) / 2 - 1);
        root.right = buildTree(num, (start + end) / 2 + 1, end);
        return root;
    }
}
