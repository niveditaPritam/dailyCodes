class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] inc = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1))
                inc[i] = inc[i - 1] + 1;
            else
                inc[i] = 1;
        }
        int res = 0;
        int left = 1, right = n / 2;
        while (left <= right) {
            int k = (right + left) / 2;
            boolean this_k_is_fine = false;
            for (int i = 0; i <= n - 2 * k; i++) {
                int end1 = i + k - 1;
                int end2 = end1 + k;
                if(inc[end1] >= k && inc[end2] >= k){
                    left = k+1;
                    res = Math.max(res,k);
                    this_k_is_fine = true;
                    break;
                }
            }
            if(!this_k_is_fine){
                right = k-1;
            }
        }
        return res;
    }
}
