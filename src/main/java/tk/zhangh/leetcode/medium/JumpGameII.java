package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/4/11.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int step = 0;
        int lastStartIndex = 0;
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > lastStartIndex) {
                lastStartIndex = reach;
                ++step;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        return step;
    }
}
