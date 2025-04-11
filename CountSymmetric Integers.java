class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSymmetric(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        int mid = n / 2;
        int leftSum = 0;
        for (int i = 0; i < mid; i++) {
            leftSum += s.charAt(i) - '0';
        }
        int rightSum = 0;
        for (int i = mid; i < n; i++) {
            rightSum += s.charAt(i) - '0';
        }
        return leftSum == rightSum;
    }
}
