class Solution {
    static final int NEG = -1_000_000_000;

    List<Integer>[] tree;
    int[] present, future;
    int budget;

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.present = present;
        this.future = future;
        this.budget = budget;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        for (int[] h : hierarchy) {
            int boss = h[0] - 1;
            int emp = h[1] - 1;
            tree[boss].add(emp);
        }

        int[][][] dp = dfs(0);
        int ans = 0;
        for (int s = 0; s <= 1; s++) {
            for (int b = 0; b <= budget; b++) {
                ans = Math.max(ans, dp[s][b]);
            }
        }
        return ans;
    }

    int[][] dfs(int u) {
        int[][] dp = new int[2][budget + 1];
        for (int s = 0; s < 2; s++) Arrays.fill(dp[s], NEG);
        dp[0][0] = dp[1][0] = 0;

        for (int v : tree[u]) {
            int[][] child = dfs(v);
            int[][] ndp = new int[2][budget + 1];
            for (int s = 0; s < 2; s++) Arrays.fill(ndp[s], NEG);

            for (int s = 0; s < 2; s++) {
                for (int i = 0; i <= budget; i++) {
                    if (dp[s][i] == NEG) continue;
                    for (int j = 0; j + i <= budget; j++) {
                        if (child[s][j] == NEG) continue;
                        ndp[s][i + j] = Math.max(
                            ndp[s][i + j],
                            dp[s][i] + child[s][j]
                        );
                    }
                }
            }
            dp = ndp;
        }

        int profit = future[u] - present[u];
        if (profit >= 0) {
            int cost = present[u];
            for (int b = budget; b >= cost; b--) {
                dp[0][b] = Math.max(dp[0][b], dp[1][b - cost] + profit);
            }

            int dcost = present[u] / 2;
            for (int b = budget; b >= dcost; b--) {
                dp[1][b] = Math.max(dp[1][b], dp[0][b - dcost] + profit);
            }
        }

        return dp;
    }
}
