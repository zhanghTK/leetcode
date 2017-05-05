package tk.zhangh.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ZhangHao on 2017/5/4.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            int[] seq = new int[numCourses];
            for (int i = 0; i < seq.length; i++) {
                seq[i] = i;
            }
            return seq;
        }
        int[] seq = new int[numCourses];
        int c = 0;
        // 记录每个course的prerequisites的数量
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            pCounter[prerequisites[i][0]]++;
        }
        // 用队列记录可以直接访问的course
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) {
                queue.add(i);
            }
        }
        // 取出队列的course，判断
        int numNoPre = queue.size();
        while (!queue.isEmpty()) {
            int top = queue.remove();
            // 保存结果 +_+
            seq[c++] = top;
            for (int i = 0; i < prerequisites.length; i++) {
                // 该course是某个course的prerequisites
                if (prerequisites[i][1] == top) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        if (numNoPre != numCourses) {
            return new int[]{};
        }
        return seq;
    }
}
