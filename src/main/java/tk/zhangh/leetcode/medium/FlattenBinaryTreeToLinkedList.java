package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/4/20.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        List<TreeNode> pre = new ArrayList<>();
        pre.add(null);
        flatten(root, pre);
    }

    private void flatten(TreeNode root, List<TreeNode> pre) {
        if (root == null) {
            return;
        }
        TreeNode right = root.right;
        if (pre.get(0) != null) {
            pre.get(0).left = null;
            pre.get(0).right = root;
        }
        pre.set(0, root);
        flatten(root.left, pre);
        flatten(right, pre);
    }
}
