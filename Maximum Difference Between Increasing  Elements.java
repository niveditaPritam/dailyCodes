class Solution {
    public int maximumDifference(int[] nums) {
        int min_val = nums[0];
        int max_diff = -1;
        for (int i = 1; i < nums.length; ++i) {
            int num = nums[i];
            if (num > min_val)
                max_diff = Math.max(max_diff, num - min_val);
            else
                min_val = num;
        }
        return max_diff;
    }
}
