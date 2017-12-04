package tk.zhangh.leetcode.tree;

/**
 * Created by ZhangHao on 2017/12/4.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "val:" + val;
    }
}
