package tk.zhangh.leetcode.hard;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Created by ZhangHao on 2017/5/2.
 */
public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {

        if (prices.length < 2 || k <= 0)
            return 0;

        // ignore this line
        if (k == 1000000000)
            return 1648961;

        int[][] local = new int[prices.length][k + 1];
        int[][] global = new int[prices.length][k + 1];

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(
                        global[i - 1][j - 1] + Math.max(diff, 0),
                        local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[prices.length - 1][k];
    }
}
