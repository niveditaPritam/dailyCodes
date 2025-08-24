class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int count = 0;
        boolean seezero = false;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                seezero = true;
                int left = 0;
                int right = 0;

                int l = i -1;
                while(l >= 0 && nums[l] == 1){
                    left++;
                    l--;
                }

                int r = i + 1;
                while(r < n && nums[r] == 1){
                    right++;
                    r++;
                }
                count = Math.max(count, left + right);
            }
            
        }
        
        
        return seezero ? count : n-1;
    }
}
