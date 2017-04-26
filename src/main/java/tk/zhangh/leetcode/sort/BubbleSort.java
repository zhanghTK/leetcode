package tk.zhangh.leetcode.sort;

/**
 * 冒泡排序
 * Created by ZhangHao on 2017/4/26.
 */
public class BubbleSort implements Sort {
    public static void main(String[] args) {
        int a[] = {8, 2, 3, 4, 3, 6, 6, 3, 9};

        System.out.printf("before sort:");
        printArray(a);

//        bucketSort(a, 10);
        new BubbleSort().sort(a);

        System.out.printf("after  sort:");
        printArray(a);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) System.out.printf("%d ", num);
        System.out.printf("\n");
    }

    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}
