package tk.zhangh.leetcode.sort;

/**
 * 插入排序
 * Created by ZhangHao on 2017/4/26.
 */
public class InsertSort implements Sort {
    public static void main(String[] args) {
        new InsertSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        for (int insertIndex = 1; insertIndex < data.length; insertIndex++) {
            for (int beforeInsertIndex = insertIndex - 1;
                 beforeInsertIndex >= 0 && data[beforeInsertIndex] > data[beforeInsertIndex + 1];
                 beforeInsertIndex--) {
                swap(data, beforeInsertIndex, beforeInsertIndex + 1);
            }
        }
    }
}
