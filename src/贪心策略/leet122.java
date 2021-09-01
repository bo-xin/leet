package 贪心策略;
/*
给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class leet122 {
    public int maxProfit(int[] prices) {
        int maxProfiles = 0;
        for (int i = 0; i <prices.length-1 ; i++) {
            if(prices[i+1] > prices[i] ){
                maxProfiles += prices[i+1] - prices[i];
            }
        }
        return maxProfiles;
    }
}
