package tk.zhangh.leetcode.sort;

/**
 * 基数排序
 * Created by ZhangHao on 2017/4/26.
 */
public class RadixSort implements Sort {
    public static void main(String[] args) {
        int i;
        int a[] = {8, 2, 3, 4, 3, 6, 6, 3, 9};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        new RadixSort().sort(a);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

    @Override
    public void sort(int[] nums) {
        for (int exp = 1; getMax(nums) / exp > 0; exp *= 10) {
            sort(nums, exp);
        }
    }

    private void sort(int[] nums, int exp) {
        int[] output = new int[nums.length];
        int[] buckets = new int[10];
        for (int num : nums) {
            buckets[(num / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            output[buckets[(nums[i] / exp) % 10] - 1] = nums[i];
            buckets[(nums[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, nums, 0, nums.length);
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
