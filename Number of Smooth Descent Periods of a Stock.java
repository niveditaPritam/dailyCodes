class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        long count = 1;

        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] == prices[i - 1] - 1) {
                count++;
            } else {
                count = 1;
            }
            ans += count;
        }
        return ans;    
    }
}
