class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n);

        while (low < high) {
            int mid = (low + high + 1) / 2;

            if (isPossible(prefix, mid, threshold, m, n)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean isPossible(int[][] prefix, int k, int threshold, int m, int n) {
        for (int i = k; i <= m; i++) {
            for (int j = k; j <= n; j++) {
                int sum = prefix[i][j]
                        - prefix[i - k][j]
                        - prefix[i][j - k]
                        + prefix[i - k][j - k];

                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
