package tk.zhangh.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * [0,1]:0的先决条件是1
 * Created by ZhangHao on 2017/5/4.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            for (int i = 0; i < prerequisites.length; i++) {
                // 该course是某个course的prerequisites
                if (prerequisites[i][1] == top) {
//                    pCounter[prerequisites[i][0]]--;
                    if (--pCounter[prerequisites[i][0]] == 0) {
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numNoPre == numCourses;
    }
}
