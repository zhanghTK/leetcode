package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangHao on 2017/4/20.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR) {
        if (inL > inR || postL > postR) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postR]);
        int index = map.get(root.val);
        root.left = helper(inorder, postorder, inL, index - 1, postL, postL + index - inL - 1);
        root.right = helper(inorder, postorder, index + 1, inR, postR - (inR - index), postR - 1);
        return root;
    }
}
