package tk.zhangh.leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutation Sequence
 * Created by ZhangHao on 2017/9/14.
 */
public class Solution60 {
    // 找规律
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--;
        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod = mod * i;
        }
        String result = "";
        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            int curIndex = k / mod;
            k = k % mod;
            result += nums.get(curIndex);
            nums.remove(curIndex);
        }
        return result;
    }
}
