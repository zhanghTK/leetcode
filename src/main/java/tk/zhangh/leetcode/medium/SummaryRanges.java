package tk.zhangh.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/5/9.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new LinkedList<>();
        if (nums.length == 0) {
            return results;
        }
        for (int i = 0; i < nums.length; ) {
            int range = 1;
            while (i + range < nums.length && (nums[i + range] - nums[i]) == range) {
                range++;
            }
            StringBuilder result = new StringBuilder().append(nums[i]);
            if (range > 1) {
                result.append("->").append(nums[i + range - 1]);
            }
            results.add(result.toString());
            i += range;
        }
        return results;
    }
}
