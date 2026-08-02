class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buying = Integer.MAX_VALUE;
        int curr_profit = 0;
        int i = 0;

        while (i < prices.length) {
            buying = Math.min(buying, prices[i]);

            if (prices[i] > buying) {
                curr_profit = prices[i] - buying;
            }

            profit = Math.max(profit, curr_profit);
            i++;
        }

        return profit;
    }
}
