package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangHao on 2017/4/20.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight)
            return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = map.get(root.val);
        root.left = helper(preorder, preLeft + 1, index - inLeft + preLeft, inorder, inLeft, index - 1);
        root.right = helper(preorder, preLeft + index - inLeft + 1, preRight, inorder, index + 1, inRight);
        return root;
    }
}
