class Solution {
    public int possibleStringCount(String word, int k) {
        final int mod = 1_000_000_007;
        List<Integer> cnt = new ArrayList<>();
        long total = 1;
        int n = word.length();
        for (int i = 0; i < n; ){
            int j = i;
            while ( i < n){
                if (word.charAt(i) != word.charAt(j))
                    break;
                i++;
            }
            int len = i - j;
            if (len > 0){
                cnt.add(len - 1);
                total = total * len % mod;
            }
            k--;
        }
        if (k <= 0){
            return (int) total;
        }
        long[] dp = new long[k];
        dp[0] = 1;
        for (int c : cnt){
            for (int i = 1; i < k; i++){
                dp[i] = (dp[i] + dp[i - 1]) % mod;
            }
            for (int i = k - 1; i > c; i--){
                dp[i] = (dp[i] - dp[i - c - 1] + mod) % mod;
            }
        }
        for (int i = 1; i < k; i++){
            dp[i] = (dp[i] + dp[i - 1]) % mod;
        }
        long ans = (total - dp[k - 1] + mod) % mod;
        return (int) ans;
    }
}
