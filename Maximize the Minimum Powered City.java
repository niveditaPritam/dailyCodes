class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] power = new long[n];

        long windowSum = 0;
        for (int i = 0; i < n; i++) {
            windowSum += stations[i];
            if (i - 2 * r - 1 >= 0) windowSum -= stations[i - 2 * r - 1];
            if (i - r >= 0) power[i - r] = windowSum;
        }

        for (int i = n - r; i < n; i++) {
            if (i >= 0 && i < n) {
                if (i - 2 * r - 1 >= 0) windowSum -= stations[i - 2 * r - 1];
                power[i] = windowSum;
            }
        }

        long left = 0, right = (long) 1e12, ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (canAchieve(power, r, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAchieve(long[] power, int r, int k, long x) {
        int n = power.length;
        long[] added = new long[n];
        long totalAdd = 0, windowAdd = 0;

        for (int i = 0; i < n; i++) {
            if (i - 2 * r - 1 >= 0) windowAdd -= added[i - 2 * r - 1];

            if (power[i] + windowAdd < x) {
                long need = x - (power[i] + windowAdd);
                totalAdd += need;
                if (totalAdd > k) return false;
                added[Math.min(n - 1, i + r)] += need;
                windowAdd += need;
            }
        }
        return true;
    }
}
