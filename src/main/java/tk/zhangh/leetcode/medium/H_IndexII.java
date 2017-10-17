package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/5/11.
 */
public class H_IndexII {
    public int hIndex(int[] citations) {
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            int currH = Math.min(citations[i], citations.length - i);
            h = currH > h ? currH : h;
        }
        return h;
    }
}
