package tk.zhangh.leetcode.tree;

import java.util.Stack;

/**
 * Created by ZhangHao on 2017/12/4.
 */
public class PreOrder implements VisitTree {

    @Override
    public void recursionVisit(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        recursionVisit(root.left);
        recursionVisit(root.right);
    }

    @Override
    public void traversalVisit(TreeNode root) {
        Stack<TreeNode> treeStack = new Stack<>();
        if (root == null) {
            return;
        }
        treeStack.push(root);
        while (!treeStack.isEmpty()) {
            TreeNode curNode = treeStack.pop();
            if (curNode != null) {
                System.out.print(curNode.val + " ");
                treeStack.push(curNode.right);
                treeStack.push(curNode.left);
            }
        }
    }
}
