package tk.zhangh.leetcode.easy;

import tk.zhangh.leetcode.TreeNode;

/**
 * Created by ZhangHao on 2017/5/9.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);
        return root;
    }
}
