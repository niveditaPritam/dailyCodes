class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sndex = s.length() - 1, tndex = t.length() - 1;
        int sBack = 0, tBack = 0;
        
        while(sndex >= 0 || tndex >= 0) {
            while(sndex >= 0 && (s.charAt(sndex) == '#' || sBack > 0)) {
                if(s.charAt(sndex) == '#') {
                    sBack++;
                } else if(sBack > 0){
                    sBack--;
                }
                sndex--;
            }
            while(tndex >= 0 && (t.charAt(tndex) == '#' || tBack > 0)) {
                if(t.charAt(tndex) == '#') {
                    tBack++;
                } else if(tBack > 0){
                    tBack--;
                }
                tndex--;
            }
            if(sndex >= 0 && tndex >= 0) {
                if(s.charAt(sndex) != t.charAt(tndex))
                    return false;
            } else if(sndex >= 0 || tndex >= 0){
            //one of strings has left over character not consumed
                return false;
            } 
            sndex--;
            tndex--;
        }

        return true;
    }
}
