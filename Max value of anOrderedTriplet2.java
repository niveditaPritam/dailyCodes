class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        long maxVal = 0;

        for (int j = 1; j < n - 1; j++) {
            int maxLeftDiff = 0;
            for (int i = 0; i < j; i++) {
                maxLeftDiff = Math.max(maxLeftDiff, nums[i] - nums[j]);
            }

            for (int k = j + 1; k < n; k++) {
                long currentVal = (long) maxLeftDiff * nums[k];
                maxVal = Math.max(maxVal, currentVal);
            }
        }

        return maxVal;
    }
}


        
