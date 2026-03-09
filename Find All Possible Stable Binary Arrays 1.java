class Solution {

    int MOD = 1000000007;
    Integer[][][][] dp;

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new Integer[zero + 1][one + 1][2][limit + 1];
        return dfs(zero, one, limit, -1, 0);
    }

    private int dfs(int zero, int one, int limit, int last, int count) {

        if (zero == 0 && one == 0) return 1;

        if (last != -1 && dp[zero][one][last][count] != null)
            return dp[zero][one][last][count];

        long ans = 0;

        if (zero > 0) {
            if (last != 0) {
                ans += dfs(zero - 1, one, limit, 0, 1);
            } else if (count < limit) {
                ans += dfs(zero - 1, one, limit, 0, count + 1);
            }
        }

        if (one > 0) {
            if (last != 1) {
                ans += dfs(zero, one - 1, limit, 1, 1);
            } else if (count < limit) {
                ans += dfs(zero, one - 1, limit, 1, count + 1);
            }
        }

        ans %= MOD;

        if (last != -1)
            dp[zero][one][last][count] = (int) ans;

        return (int) ans;
    }
}
