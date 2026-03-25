class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int totalSum = 0;

        for (int[] row : grid) {
            for (int val : row) {
                totalSum += val;
            }
        }

        int prefixSum = 0;
        for (int i = 0; i < m - 1; i++) { 
            for (int j = 0; j < n; j++) {
                prefixSum += grid[i][j];
            }
            if (prefixSum == totalSum - prefixSum) {
                return true;
            }
        }

        prefixSum = 0;
        for (int j = 0; j < n - 1; j++) { 
            for (int i = 0; i < m; i++) {
                prefixSum += grid[i][j];
            }
            if (prefixSum == totalSum - prefixSum) {
                return true;
            }
        }

        return false;
    }
}
