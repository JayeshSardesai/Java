class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            int profit = prices[i] - buy;
            maxProfit = Math.max(maxProfit, profit);
            buy = profit < 0?prices[i]:buy;
        }
        return maxProfit;
    }
}
