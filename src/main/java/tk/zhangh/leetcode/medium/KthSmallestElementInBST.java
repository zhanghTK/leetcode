package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.TreeNode;

import java.util.Stack;

/**
 * Created by ZhangHao on 2017/5/9.
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        while (root != null) {
            s.push(root);
            root = root.left;
        }
        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            if (curr.right != null) {
                curr = curr.right;
                while (curr != null) {
                    s.push(curr);
                    curr = curr.left;
                }
            }
        }
        return 0;
    }
}
