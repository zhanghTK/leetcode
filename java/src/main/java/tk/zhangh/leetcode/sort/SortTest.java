package tk.zhangh.leetcode.sort;

import java.util.Arrays;

/**
 * Created by ZhangHao on 2017/12/4.
 */
public class SortTest {
    private static Sort[] sorts;

    static {
        sorts = new Sort[]{
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
        int[] nums = sorts[0].initData();
        for (Sort sort : sorts) {
            int[] ints = Arrays.copyOf(nums, nums.length);
            sort.sort(ints);
            System.out.println(sort.getClass().getSimpleName() + "\t:\t" + Arrays.toString(ints));
        }
    }
}