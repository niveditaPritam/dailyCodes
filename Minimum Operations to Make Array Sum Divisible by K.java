class Solution {
    public int minOperations(int[] nums, int k) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int rem = (int)(sum % k);

        if (rem == 0) return 0;

        return rem;    
    }
}
