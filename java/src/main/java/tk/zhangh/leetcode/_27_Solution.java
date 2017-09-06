package tk.zhangh.leetcode;

/**
 * Remove Element
 * Created by ZhangHao on 2017/9/6.
 */
public class _27_Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int end = nums.length - 1;
        while(i <= end){
            if(nums[i] == val){
                nums[i] = nums[end--];
            } else {
                i++;
            }
        }
        return end + 1;
    }
}
