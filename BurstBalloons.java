class Solution {
    public int maxCoins(int[] nums) {
        int n= nums.length;
        int[] paddedNums = new int[n + 2];
        paddedNums[0] = 1;
        paddedNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            paddedNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], 
                                        paddedNums[i - 1] * paddedNums[k] * paddedNums[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }

        return dp[1][n];
    }
}

