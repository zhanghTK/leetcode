package tk.zhangh.leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Gray Code
 * Created by ZhangHao on 2017/9/21.
 */
public class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        for (int i = 0; i < n; i++) {
            int highestBit = 1 << i;
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + highestBit);
            }
        }
        return res;
    }
}
