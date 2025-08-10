 class Solution {
    public boolean reorderedPowerOf2(int N) {
        char s[] = Integer.toString(N).toCharArray();
        int len = s.length;
        Arrays.sort(s);

        for(int i=0;i<31;i++) {
            int power= (int)Math.pow(2,i);
            char pow[] = Integer.toString(power).toCharArray();
            int powLen = pow.length;
            if(powLen>len)
                return false;
            else if(powLen<len)
                continue;
            
            Arrays.sort(pow);
            if(Arrays.equals(pow,s))
                return true;
        }
        return false;
    }
}

 
