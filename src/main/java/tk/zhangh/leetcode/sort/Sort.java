package tk.zhangh.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 排序接口
 * 提供排序使用的基本方法支持
 * Created by ZhangHao on 2017/4/26.
 */
public interface Sort {
    /**
     * 从小到大排序
     *
     * @param data 待排序数组
     */
    void sort(int data[]);

    /**
     * 交换数组两个元素
     *
     * @param data   带交换元素所在数据
     * @param index1 元素1所在位置
     * @param index2 元素2所在位置
     */
    default void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    /**
     * 测试排序
     * 1. 初始化随机数数组
     * 2. 排序
     * 3. 验证排序结果
     */
    default void testSort() {
        int[] nums = initData();
        sort(nums);
        System.out.println(this.getClass().getSimpleName() + "\t:\t" + Arrays.toString(nums));
        validate(nums);
    }

    /**
     * 初始化随机数组一个大小为20的随机数数组
     *
     * @return 随机数组
     */
    default int[] initData() {
        int[] data = new int[20];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(10000);
        }
        System.out.println("InitArray\t:\t" + Arrays.toString(data));
        return data;
    }

    /**
     * 验证数组排序结果
     *
     * @param data 待验证的有序结果
     */
    default void validate(int[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i] < data[i - 1]) {
                throw new RuntimeException("validate fail:" + data[i] + " >= " + data[i - 1]);
            }
        }
    }
}
