package tk.zhangh.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/4/14.
 */
public class PermutationSequence {
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

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(4, 17));
    }
}
