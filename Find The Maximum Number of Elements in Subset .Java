class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            int freq=map.getOrDefault(i,0)+1;
            map.put(i,freq);
        }
        int ans=1;
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        if(map.containsKey(1)){
            int freq=map.get(1);
            if(freq%2==0) ans=freq-1;
            else ans=freq;
        }
        for(int i=0;i<n;i++){
            if(nums[i]==1) continue;
            if(!set.contains(nums[i])){
                int c=1;
                int x=nums[i];
                while(map.getOrDefault(x,0)>=2){    
                    set.add(x);
                    x=x*x;
                    c+=2;
                }
                if(map.containsKey(x)) ans=Math.max(ans,c);
                else ans=Math.max(ans,c-2);
                
            }
        }
        return ans;
    }
}
