package tk.zhangh.leetcode.hard;

/**
 * Created by ZhangHao on 2017/4/21.
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        // 当前到达第i天，最多进行j次交易，最好的利润是多少
        // global[i][j]=max(local[i][j],global[i-1][j])
        // 当前到达第i天，最多进行2次交易，最好的利润是多少
        // global[i][j]=max(local[i][j],global[i-1][j])
        int[] global = new int[3];
        // 当前到达第i天，最多进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少
        // local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)
        // 当前到达第i天，最多进行2次交易，并且最后一次交易在当天卖出的最好的利润是多少
        // local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)
        int[] local = new int[3];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = 2; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[2];
    }
}
