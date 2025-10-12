class Solution {
    static final int MOD = 1_000_000_007;
    long result = 0;

    public int magicalSum(int m, int k, int[] nums) {
        backtrack(nums, m, k, 0, 0, 1L);
        return (int)(result % MOD);
    }

    private void backtrack(int[] nums, int m, int k, int index, int mask, long product) {
        if (index == m) {
            if (Integer.bitCount(mask) == k) {
                result = (result + product) % MOD;
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            backtrack(nums, m, k, index + 1, mask | (1 << i), (product * nums[i]) % MOD);
        }
    }
}
