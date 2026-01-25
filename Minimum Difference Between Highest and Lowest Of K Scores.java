class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        for(int i = k; i <= nums.length; i++) {
            if(nums[i - 1] - nums[i - k] < minDifference) {
                minDifference = nums[i - 1] - nums[i - k];
            }
        }
        return minDifference;
    }
}
