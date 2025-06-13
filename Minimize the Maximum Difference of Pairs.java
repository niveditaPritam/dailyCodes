import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums); 
        int n = nums.length;

        int low = 0, high = nums[n - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int total_pairs = 0;

            for (int i = 0; i < n - 1; ) {
                if (Math.abs(nums[i] - nums[i + 1]) <= mid) {
                    total_pairs++;
                    i += 2; 
                } else {
                    i++; 
                }
            }

            if (total_pairs >= p) {
                high = mid; 
            } else {
                low = mid + 1; 
            }
        }

        return low;
    }
}
