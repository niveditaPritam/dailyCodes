class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long MOD = 1_000_000_007;

        long[] dp = new long[n + 1];  
        long[] prefix = new long[n + 1]; 
        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < n; right++) {

            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[right]) {
                maxD.pollLast();
            }
            maxD.addLast(right);

            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[right]) {
                minD.pollLast();
            }
            minD.addLast(right);

            while (!maxD.isEmpty() && !minD.isEmpty() && 
                   nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {
                if (maxD.peekFirst() == left) maxD.pollFirst();
                if (minD.peekFirst() == left) minD.pollFirst();
                left++;
            }

            long ways = prefix[right] - (left > 0 ? prefix[left - 1] : 0);
            ways = (ways % MOD + MOD) % MOD;

            dp[right + 1] = ways;
            prefix[right + 1] = (prefix[right] + ways) % MOD;
        }

        return (int)(dp[n] % MOD);
    }
}
