class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];
        
        max[0][0] = min[0][0] = grid[0][0];
        
        for (int j = 1; j < n; j++) {
            max[0][j] = max[0][j - 1] * grid[0][j];
            min[0][j] = max[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            max[i][0] = max[i - 1][0] * grid[i][0];
            min[i][0] = max[i][0];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long a = max[i - 1][j];
                long b = min[i - 1][j];
                long c = max[i][j - 1];
                long d = min[i][j - 1];
                
                long val = grid[i][j];
                
                long maxVal = Math.max(
                    Math.max(a * val, b * val),
                    Math.max(c * val, d * val)
                );
                
                long minVal = Math.min(
                    Math.min(a * val, b * val),
                    Math.min(c * val, d * val)
                );
                
                max[i][j] = maxVal;
                min[i][j] = minVal;
            }
        }
        
        long result = max[m - 1][n - 1];
        
        if (result < 0) return -1;
        
        return (int)(result % 1000000007);
    }
}
