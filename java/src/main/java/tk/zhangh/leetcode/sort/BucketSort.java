package tk.zhangh.leetcode.sort;

/**
 * 桶排序
 * Created by ZhangHao on 2017/12/4.
 */
public class BucketSort implements Sort {
    @Override
    public void sort(int[] data) {
        int[] buckets = new int[Integer.MAX_VALUE / 4];
        for (int num : data) {
            buckets[num]++;
        }
        for (int i = 0, j = 0; i < buckets.length; i++) {
            while ((buckets[i]--) > 0) {
                data[j++] = i;
            }
        }
    }
}
