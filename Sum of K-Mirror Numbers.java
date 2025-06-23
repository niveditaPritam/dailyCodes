class Solution {
    public long kMirror(int k, int n) {
        int count = 0;
        long sum = 0;
        int len = 1;

        while (count < n) {
        
            for (int type = 0; type < 2 && count < n; type++) {
                for (long half = (long)Math.pow(10, len - 1); half < (long)Math.pow(10, len) && count < n; half++) {
                    String halfStr = Long.toString(half);
                    StringBuilder sb = new StringBuilder(halfStr);
                    if (type == 0) sb.deleteCharAt(sb.length() - 1); 
                    String fullStr = halfStr + sb.reverse().toString();
                    long num = Long.parseLong(fullStr);

                    if (isPalindrome(toBaseK(num, k))) {
                        sum += num;
                        count++;
                    }
                }
            }
            len++;
        }
        return sum;
    }

    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
