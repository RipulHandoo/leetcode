class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<prices.length;i++) {
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i] - min);
        }
        return max;
    }
}
