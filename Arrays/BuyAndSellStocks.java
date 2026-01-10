class Solution {
    public int maxProfit(int[] prices) {
       int min=prices[0],max=0;
        for(int i=1;i<prices.length;i++){
            int cost=prices[i]-min;
            max=Math.max(max,cost);
            min=Math.min(min,prices[i]);
        }
        return max;
    }
}
