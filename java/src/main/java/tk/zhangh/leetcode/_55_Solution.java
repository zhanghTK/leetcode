package tk.zhangh.leetcode;

/**
 * Jump Game
 * Created by ZhangHao on 2017/9/12.
 */
public class _55_Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        for (int reach = 0;
             i < nums.length && // 不越界
                     i <= reach; // 可以继续跳
             i++) {
            reach = Math.max(
                    i + nums[i], // 局部最优解
                    reach);  // 全局最优解
        }
        return i == nums.length;
    }
}
