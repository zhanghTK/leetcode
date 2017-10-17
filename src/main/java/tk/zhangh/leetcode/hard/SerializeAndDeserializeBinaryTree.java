package tk.zhangh.leetcode.hard;

import tk.zhangh.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ZhangHao on 2017/5/16.
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if (parent != null) {
                result.append(String.valueOf(parent.val)).append(",");
                queue.add(parent.left);
                queue.add(parent.right);
            } else {
                result.append("#,");
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodeList = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodeList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if (parent == null) {
                continue;
            }
            if (!nodeList[i].equals("#")) {
                parent.left = new TreeNode(Integer.parseInt(nodeList[i]));
                queue.offer(parent.left);
            } else {
                parent.left = null;
                queue.offer(null);
            }
            i++;

            if (!nodeList[i].equals("#")) {
                parent.right = new TreeNode(Integer.parseInt(nodeList[i]));
                queue.offer(parent.right);
            } else {
                parent.right = null;
                queue.offer(null);
            }
            i++;
        }
        return root;
    }
}
