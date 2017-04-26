package tk.zhangh.leetcode.sort;

/**
 * 插入排序
 * Created by ZhangHao on 2017/4/26.
 */
public class InsertSort implements Sort {
    public static void main(String[] args) {
        int a[] = {8, 2, 3, 4, 3, 6, 6, 3, 9};

        System.out.printf("before sort:");
        printArray(a);
        new InsertSort().sort(a);

        System.out.printf("after  sort:");
        printArray(a);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) System.out.printf("%d ", num);
        System.out.printf("\n");
    }

    @Override
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int beforeInsertIndex;
            int insertValue = nums[i];
            for (beforeInsertIndex = i - 1; beforeInsertIndex >= 0; beforeInsertIndex--) {
                if (nums[beforeInsertIndex] < nums[i])
                    break;
            }
            if (beforeInsertIndex + 1 != i) {
                System.arraycopy(nums, beforeInsertIndex + 1, nums, beforeInsertIndex + 1 + 1, i - 1 - beforeInsertIndex);
                nums[beforeInsertIndex + 1] = insertValue;
            }
        }
    }
}
