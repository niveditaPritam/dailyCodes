class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 1;
        long minWorker = Integer.MAX_VALUE;

        for (int t : workerTimes) {
            minWorker = Math.min(minWorker, t);
        }

        // maximum time if fastest worker does all work
        long right = minWorker * (long) mountainHeight * (mountainHeight + 1) / 2;

        long ans = right;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (canFinish(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canFinish(long time, int mountainHeight, int[] workerTimes) {

        long totalHeightReduced = 0;

        for (int t : workerTimes) {

            long k = (long)((Math.sqrt(1 + (8.0 * time) / t) - 1) / 2);

            totalHeightReduced += k;

            if (totalHeightReduced >= mountainHeight) {
                return true;
            }
        }

        return false;
    }
}
