class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }

        int startCost = (grid[0][0] == 0) ? 0 : 1;
        if (startCost <= k) {
            dp[0][0][startCost] = grid[0][0];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = grid[i][j];
                int cost = (value == 0) ? 0 : 1;

                for (int c = cost; c <= k; c++) {

                    if (i > 0 && dp[i - 1][j][c - cost] != -1) {
                        dp[i][j][c] = Math.max(dp[i][j][c],
                                dp[i - 1][j][c - cost] + value);
                    }

                    if (j > 0 && dp[i][j - 1][c - cost] != -1) {
                        dp[i][j][c] = Math.max(dp[i][j][c],
                                dp[i][j - 1][c - cost] + value);
                    }
                }
            }
        }

        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]);
        }

        return ans;
    }
}
