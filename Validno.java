class Solution {
    public boolean isNumber(String s) {
        s = s.trim(); 
        boolean num = false, exp = false, dot = false;
        int i = 0, n = s.length();

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            num = true;
            i++;
        }

        if (i < n && s.charAt(i) == '.') {
            dot = true;
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                num = true;
                i++;
            }
        }

        if (i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            if (!num) return false;
            exp = true;
            num = false;
            i++;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            while (i < n && Character.isDigit(s.charAt(i))) {
                num = true;
                i++;
            }
            if (!num) return false;
        }

        return num && i == n;
    }
}
