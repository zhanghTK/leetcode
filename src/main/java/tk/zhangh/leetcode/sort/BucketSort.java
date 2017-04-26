package tk.zhangh.leetcode.sort;

/**
 * 桶排序
 * Created by ZhangHao on 2017/4/26.
 */
public class BucketSort implements Sort {
    public static void main(String[] args) {
        int a[] = {8, 2, 3, 4, 3, 6, 6, 3, 9};

        System.out.printf("before sort:");
        printArray(a);

//        bucketSort(a, 10);
        new BucketSort().sort(a);

        System.out.printf("after  sort:");
        printArray(a);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) System.out.printf("%d ", num);
        System.out.printf("\n");
    }

    @Override
    public void sort(int[] nums) {
        if (nums == null) {
            return;
        }
        int[] buckets = new int[Integer.MAX_VALUE / 4];
        for (int num : nums) {
            buckets[num]++;
        }
        for (int i = 0, j = 0; i < buckets.length; i++) {
            while ((buckets[i]--) > 0) {
                nums[j++] = i;
            }
        }
    }
}
