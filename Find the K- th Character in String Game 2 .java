class Solution {
    public char kthCharacter(long k, int[] operations) {
        StringBuilder s = new StringBuilder("a");

        for (int op : operations) {
            int len = s.length();
            if (op == 0) {
                // Append the current string to itself
                s.append(s);
            } else {
                // Append incremented version of string
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    char next = (char) ((s.charAt(i) - 'a' + 1) % 26 + 'a');
                    temp.append(next);
                }
                s.append(temp);
            }
            if (s.length() >= k) break;
        }

        return s.charAt((int)k - 1);
    }
}
