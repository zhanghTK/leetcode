package tk.zhangh.leetcode.sort;

import java.util.Arrays;

/**
 * Created by ZhangHao on 2017/4/26.
 */
public class SortTest {
    private static final Sort[] SORTS;

    static {
        SORTS = new Sort[]{
                new BubbleSort(),
                new BucketSort(),
                new HeapSort(),
                new InsertSort(),
                new MergeSort(),
                new QuickSort(),
                new RadixSort(),
                new QuickSort(),
                new SelectSort(),
                new ShellSort()
        };
    }

    public static void main(String[] args) {
        sort();
    }

    private static void sort() {
        int[] nums = SORTS[0].initData();
        for (Sort sort : SORTS) {
            int[] ints = Arrays.copyOf(nums, nums.length);
            sort.sort(ints);
            System.out.println(sort.getClass().getSimpleName() + "\t:\t" + Arrays.toString(ints));
        }
    }
}
