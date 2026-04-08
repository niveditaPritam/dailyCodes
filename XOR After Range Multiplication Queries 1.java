class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;
        int n = nums.length;

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            for (int i = l; i <= r; i += k) {
                long val = (long) nums[i] * v;
                nums[i] = (int) (val % MOD);
            }
        }

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}
