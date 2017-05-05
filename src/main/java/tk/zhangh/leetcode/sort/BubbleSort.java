package tk.zhangh.leetcode.sort;

/**
 * 冒泡排序
 * Created by ZhangHao on 2017/4/26.
 */
public class BubbleSort implements Sort {
    public static void main(String[] args) {
        new BucketSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    swap(data, i, j);
                }
            }
        }
    }
}
