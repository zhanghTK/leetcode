package tk.zhangh.leetcode._1_50;

/**
 * Jump Game II
 * Created by ZhangHao on 2017/9/12.
 */
public class _45_Solution {
    public int jump(int[] nums) {
        int step = 0;
        int lastReach = 0;  // 上次覆盖的最远范围
        int curReach = 0;  // 当前最远能覆盖的范围
        for (int i = 0; i < nums.length; i++) {
            if (lastReach < i) {
                // 进入了新范围
                // 超过上次覆盖的最远范围，需要跳一步
                lastReach = curReach;
                ++step;
            }
            curReach = Math.max(curReach, i + nums[i]);  // 更新最远覆盖范围
        }
        return step;
    }
}
