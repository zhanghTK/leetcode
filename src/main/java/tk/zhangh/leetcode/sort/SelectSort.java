package tk.zhangh.leetcode.sort;

/**
 * 选择排序
 * Created by ZhangHao on 2017/4/26.
 */
public class SelectSort implements Sort {
    public static void main(String[] args) {
        int i;
        int a[] = {8, 2, 3, 4, 3, 6, 6, 3, 9};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        new SelectSort().sort(a);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int k = i;
            for (int j = k + 1; j < nums.length; j++) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            if (i != k) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
    }
}
