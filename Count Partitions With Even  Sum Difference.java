class Solution {
    public int countPartitions(int[] nums) {
        long total = 0;
        for (int num : nums) total += num;

        if ((total & 1) == 1) return 0;

        return nums.length - 1;   
    }
}
