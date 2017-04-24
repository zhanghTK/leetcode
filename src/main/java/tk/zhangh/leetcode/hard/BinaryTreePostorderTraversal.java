package tk.zhangh.leetcode.hard;

import tk.zhangh.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/4/24.
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}
