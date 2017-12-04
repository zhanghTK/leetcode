package tk.zhangh.leetcode.sort;

/**
 * 插入排序
 * Created by ZhangHao on 2017/12/4.
 */
public class InsertSort implements Sort {
    public static void main(String[] args) {
        new InsertSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        // 将数组分为有序和无序两个区间，遍历依此将无序区间的元素插入有序区间
        for (int insertIndex = 1; insertIndex < data.length; insertIndex++) {
            // 遍历有序区间，插入元素
            for (int i = insertIndex - 1; i >= 0 && data[i] > data[i + 1]; i--) {
                swap(data, i, i + 1);
            }
        }
    }
}
