class Solution {
    public boolean checkOnesSegment(String s) {
        boolean foundZero = false;

        for(char c : s.toCharArray()) {
            if(c == '0') {
                foundZero = true;
            }
            if(c == '1' && foundZero) {
                return false;
            }
        }

        return true;
    }
}
