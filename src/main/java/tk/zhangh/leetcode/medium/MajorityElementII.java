package tk.zhangh.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/5/9.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int counter1 = 1, counter2 = 0, candidate1 = nums[0], candidate2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                counter1++;
            } else if (num == candidate2) {
                counter2++;
            } else if (counter1 != 0 && counter2 != 0) {
                counter1--;
                counter2--;
            } else {
                if (counter1 == 0) {
                    candidate1 = num;
                    counter1 = 1;
                } else {
                    candidate2 = num;
                    counter2 = 1;
                }
            }
        }
        counter1 = 0;
        counter2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                counter1++;
            } else if (num == candidate2) {
                counter2++;
            }
        }
        if (counter1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (counter2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;
    }
}
