class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0L) + p);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n];
        dp[0] = map.get(keys.get(0));

        for (int i = 1; i < n; i++) {
            long currVal = map.get(keys.get(i));
            int j = i - 1;

            while (j >= 0 && keys.get(i) - keys.get(j) <= 2) {
                j--;
            }

            long include = currVal + (j >= 0 ? dp[j] : 0);
            long exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }

        return dp[n - 1];  
    }
}
