package tk.zhangh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * Created by ZhangHao on 2017/9/4.
 */
public class _01_Solution {
    public int[] twoSum(int[] nums, int target) {
        // 使用map作为缓存
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历数组，初始化map
        // key为target-nums[i]，value为nums[i]
        // 当map.get(nums[i]) != null时找到符合要求的解
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }
}
