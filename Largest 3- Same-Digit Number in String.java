class Solution {
    public String largestGoodInteger(String num) {
        char largest = 0;
        for(int i = 1 ;i<num.length()-1;i++){
                if(num.charAt(i)==num.charAt(i-1) && num.charAt(i)== num.charAt(i+1)){
                    if(largest<num.charAt(i)){
                        largest = num.charAt(i);
                    }
                }
        }
       String s = String.valueOf(largest).repeat(3);
       if (largest == 0) return "";
        return s;   
    }
}
