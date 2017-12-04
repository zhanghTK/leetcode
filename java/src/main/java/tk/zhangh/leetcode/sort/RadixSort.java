package tk.zhangh.leetcode.sort;

/**
 * Created by ZhangHao on 2017/12/4.
 */
public class RadixSort implements Sort {
    public static void main(String[] args) {
        new RadixSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        int max = getMax(data);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            radixSort(data, exp);
        }

    }

    private void radixSort(int[] nums, int exp) {
        int[] helpArray = new int[nums.length];
        int[] buckets = new int[10];
        for (int num : nums) {
            buckets[(num / exp) % 10]++;
        }
        // buckets[i]表示当前位值（如个/十/百...位数）小于等于i的共有多少位
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            helpArray[buckets[(nums[i] / exp) % 10] - 1] = nums[i];
            buckets[(nums[i] / exp) % 10]--;
        }
        System.arraycopy(helpArray, 0, nums, 0, nums.length);
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
