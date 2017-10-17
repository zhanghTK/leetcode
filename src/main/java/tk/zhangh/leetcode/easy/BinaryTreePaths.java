package tk.zhangh.leetcode.easy;

import tk.zhangh.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/5/10.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new LinkedList<>();
        if (root != null) {
            findPaths(root, String.valueOf(root.val), results);
        }
        return results;
    }

    private void findPaths(TreeNode n, String result, List<String> results) {
        if (n.left == null && n.right == null) {
            results.add(result);
        }
        if (n.left != null) {
            findPaths(n.left, result + "->" + n.left.val, results);
        }
        if (n.right != null) {
            findPaths(n.right, result + "->" + n.right.val, results);
        }
    }
}
