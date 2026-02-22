class Solution {
    public int binaryGap(int n) {
        int lastIndex = -1;  
        int maxDistance = 0;  
        int position = 0;     
        
        while (n > 0) {
            if ((n & 1) == 1) {   
                if (lastIndex != -1) {
                    maxDistance = Math.max(maxDistance, position - lastIndex);
                }
                lastIndex = position;
            }
            n = n >> 1;   
            position++;
        }
        
        return maxDistance;
    }
}
