class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        
        for (int num : arr1) {
            String s = String.valueOf(num);
            String prefix = "";
            
            for (char c : s.toCharArray()) {
                prefix += c;
                set.add(prefix);
            }
        }
        
        int maxLength = 0;
        
        for (int num : arr2) {
            String s = String.valueOf(num);
            String prefix = "";
            
            for (char c : s.toCharArray()) {
                prefix += c;
                if (set.contains(prefix)) {
                    maxLength = Math.max(maxLength, prefix.length());
                } else {
                    break; 
                }
            }
        }
        
        return maxLength;
    }
}
