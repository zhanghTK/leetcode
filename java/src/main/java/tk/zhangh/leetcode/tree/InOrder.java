package tk.zhangh.leetcode.tree;

import java.util.Stack;

/**
 * Created by ZhangHao on 2017/12/4.
 */
public class InOrder implements VisitTree {

    @Override
    public void recursionVisit(TreeNode root) {
        if (root == null) {
            return;
        }
        recursionVisit(root.left);
        System.out.print(root.val + " ");
        recursionVisit(root.right);
    }

    @Override
    public void traversalVisit(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.empty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            System.out.print(curNode.val + " ");
            curNode = curNode.right;
        }
    }
}
