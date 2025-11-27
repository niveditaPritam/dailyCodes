class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);

        long prefix = 0;
        long ans = Long.MIN_VALUE;

        minPrefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix += nums[i];

            int mod = (i + 1) % k;

            if (minPrefix[mod] != Long.MAX_VALUE)
                ans = Math.max(ans, prefix - minPrefix[mod]);

            minPrefix[mod] = Math.min(minPrefix[mod], prefix);
        }

        return ans;   
    }
}
