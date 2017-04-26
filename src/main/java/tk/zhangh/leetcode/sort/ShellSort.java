package tk.zhangh.leetcode.sort;

/**
 * 希尔排序
 * Created by ZhangHao on 2017/4/26.
 */
public class ShellSort implements Sort {
    public static void main(String[] args) {
        int i;
        int a[] = {8, 2, 3, 4, 3, 6, 6, 3, 9};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        new ShellSort().sort(a);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

    @Override
    public void sort(int[] nums) {
        for (int increment = nums.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < nums.length; i++) {
                int temp = nums[i];
                int j;
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < nums[j]) {
                        nums[j + increment] = nums[j];
                    } else {
                        break;
                    }
                }
                nums[j + increment] = temp;
            }
        }
    }
}
