class Solution {
    public long minTime(int[] wizard, int[] potions) {
        int n = wizard.length;
        int m = potions.length;

        long prev[] = new long[n];  
        
        prev[0] = potions[0] * wizard[0];

        for(int i=1; i<n; i++) {
            prev[i] = prev[i-1] + potions[0]*wizard[i];
        }

        for(int i=1; i<m; i++) {
            long timetaken[] = new long[n];

            long presum[] = new long[n];

            long maxtimetostart = prev[0];

            for(int j=0; j<n; j++) {
                int time = potions[i]*wizard[j];

                timetaken[j] = time;
                presum[j] = j==0 ? time : presum[j-1] + time;

                maxtimetostart = j==0 ? maxtimetostart : Math.max(maxtimetostart, prev[j]-presum[j-1]);
            }

            prev[0] = maxtimetostart + timetaken[0];
            for(int j=1; j<n; j++) {
                prev[j] = prev[j-1] + timetaken[j];
            }
        }

        return prev[n-1];

    }
}
