class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int fir=-1,sec=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums [i-1]){
                if(fir==-1) fir=nums[i];
                else sec=nums[i];
            }
        }
        return new int[]{fir,sec};    
    }
}
