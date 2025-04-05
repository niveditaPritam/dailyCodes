class Solution {
    public int subsetXORSum(int[] nums) {
                int totalXORSum = 0;
        int n = nums.length;

        for (int i = 0; i < (1 << n); i++) {
            int currentXORSum = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j) % 2 == 1) {
                    currentXORSum ^= nums[j];
                }
            }
            totalXORSum += currentXORSum;
        }

        return totalXORSum;
    }
}

        
