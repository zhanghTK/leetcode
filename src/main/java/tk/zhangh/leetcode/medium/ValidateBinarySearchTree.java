package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * 1. The left subtree of a node contains only nodes with keys less than the node's key.
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3. Both the left and right subtrees must also be binary search trees.
 * Created by ZhangHao on 2017/4/19.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return root == null || helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);

    }

    private boolean helper(TreeNode root, double low, double high) {
        return !(root.val <= low || root.val >= high) && !(root.left != null && !helper(root.left, low, root.val)) && !(root.right != null && !helper(root.right, root.val, high));
    }
}
