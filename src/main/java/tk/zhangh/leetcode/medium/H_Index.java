package tk.zhangh.leetcode.medium;

import java.util.Arrays;

/**
 * Created by ZhangHao on 2017/5/11.
 */
public class H_Index {
    // https://segmentfault.com/a/1190000003794831
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            int currH = Math.min(citations[i], citations.length - i);
            h = currH > h ? currH : h;
        }
        return h;
    }
}
