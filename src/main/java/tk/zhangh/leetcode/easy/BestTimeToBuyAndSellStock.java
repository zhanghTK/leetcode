package tk.zhangh.leetcode.easy;

/**
 * Created by ZhangHao on 2017/4/21.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            min = price < min ? price : min;
            profit = (price - min) > profit ? price - min : profit;
        }
        return profit;
    }
}
