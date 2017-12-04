package tk.zhangh.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ZhangHao on 2017/12/4.
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 广搜
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();  // 弹出，处理当前行
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);  // 加入下一行，待处理数据
                }
                if (head.right != null) {
                    queue.offer(head.right);  // 加入下一行，待处理数据
                }
            }
            result.add(level);
        }
        return result;
    }
}
