package tk.zhangh.leetcode.medium;

import java.util.Arrays;

/**
 * Created by ZhangHao on 2017/5/8.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int dup;
        if (C < E || G < A || D < F || H < B) {
            dup = 0;
        } else {
            int[] x = {A, C, E, G};
            int[] y = {B, D, F, H};
            Arrays.sort(x);
            Arrays.sort(y);
            dup = (x[2] - x[1]) * (y[2] - y[1]);
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - dup;
    }
}
