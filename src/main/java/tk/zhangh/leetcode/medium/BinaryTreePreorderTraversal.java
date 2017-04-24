package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/4/24.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}
