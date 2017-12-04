package tk.zhangh.leetcode.tree;

import java.util.Stack;

/**
 * Created by ZhangHao on 2017/12/4.
 */
public class PostOrder implements VisitTree {
    @Override
    public void recursionVisit(TreeNode root) {
        if (root == null) {
            return;
        }
        recursionVisit(root.left);
        recursionVisit(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 每次访问孩子，需要判断上次访问的是左孩子还是右孩子
     * 左孩子：先访问右孩子，再访问根
     * 右孩子：直接访问根
     */
    @Override
    public void traversalVisit(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        TreeNode lastVisitNode = null;

        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }

        while (!stack.empty()) {
            curNode = stack.pop();
            if (curNode.right != null && curNode.right != lastVisitNode) {
                // 右孩子不为空，且右孩子未被访问
                // 则处理右孩子
                stack.push(curNode);
                curNode = curNode.right;
                while (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                }
            } else {
                // 右孩子为空，或右孩子已被访问
                // 则访问根
                System.out.print(curNode.val + " ");
                lastVisitNode = curNode;
            }
        }
    }
}
