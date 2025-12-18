class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + prices[i];
        }

        long maxProfit = baseProfit;
        int half = k / 2;

        for (int start = 0; start + k <= n; start++) {
            int mid = start + half;
            int end = start + k;

            long oldContribution = 0;
            for (int i = start; i < end; i++) {
                oldContribution += (long) strategy[i] * prices[i];
            }

            long newContribution = prefix[end] - prefix[mid];

            long newProfit = baseProfit - oldContribution + newContribution;
            maxProfit = Math.max(maxProfit, newProfit);
        }

        return maxProfit;
    }
}
