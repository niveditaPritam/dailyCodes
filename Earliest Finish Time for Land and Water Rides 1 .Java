class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int landEnd = landStartTime[i] + landDuration[i];
                int waterStart = Math.max(landEnd, waterStartTime[j]);
                int finish1 = waterStart + waterDuration[j];

                int waterEnd = waterStartTime[j] + waterDuration[j];
                int landStart = Math.max(waterEnd, landStartTime[i]);
                int finish2 = landStart + landDuration[i];

                ans = Math.min(ans, Math.min(finish1, finish2));
            }
        }

        return ans;
    }
}
