class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int n = events.length;
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(0, k, events, dp);
    }

    private int dfs(int i, int k, int[][] events, int[][] dp) {
        if (i == events.length || k == 0) {
            return 0;
        } 

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        int skip = dfs(i + 1, k, events, dp);

        int next = binarySearch(events, events[i][1]);
        int take = events[i][2] + dfs(next, k - 1, events, dp);

        return dp[i][k] = max(skip, take);
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    private int binarySearch(int[][] events, int endTime) {
        int l = 0, h = events.length;
        while (l < h) {
            int m = (l + h) / 2;
            if (events[m][0] > endTime) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
