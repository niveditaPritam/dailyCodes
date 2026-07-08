class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 100001;
    private static final long[] pow10 = new long[MAX];

    static {
        pow10[0] = 1;
        for (int i = 1; i < MAX; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] sumDigits = new int[n + 1];

        int[] nonZeroCount = new int[n + 1];

        long[] prefixNum = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            int digit = s.charAt(i - 1) - '0';

            sumDigits[i] = sumDigits[i - 1] + digit;
            nonZeroCount[i] = nonZeroCount[i - 1] + (digit > 0 ? 1 : 0);

            if (digit > 0) {
                prefixNum[i] = (prefixNum[i - 1] * 10 + digit) % MOD;
            } else {
                prefixNum[i] = prefixNum[i - 1];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int cnt = nonZeroCount[r + 1] - nonZeroCount[l];
            int sum = sumDigits[r + 1] - sumDigits[l];

            long x = (prefixNum[r + 1]
                    - (prefixNum[l] * pow10[cnt]) % MOD
                    + MOD) % MOD;

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}
