class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        ArrayList<Integer> freeTime = new ArrayList<>();
        freeTime.add(startTime[0]);
        for (int i = 1; i < n; i++) {
            freeTime.add(startTime[i] - endTime[i - 1]);
        }
        freeTime.add(eventTime - endTime[n - 1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[1], a[1]);
            }
        });
        int m = freeTime.size();
        for (int i = 0; i < m; i++) {
            pq.offer(new int[] { i, freeTime.get(i) });
        }
        int ans = 0;
        for (int i = 0; i < m - 1; i++) {
            int meetingTime = endTime[i] - startTime[i];
            int firstIdx = pq.peek()[0];
            int firstVal = pq.poll()[1];
            int secondIdx = pq.peek()[0];
            int secondVal = pq.poll()[1];
            int freeTimes = freeTime.get(i) + freeTime.get(i + 1);
            if ((firstIdx == i && secondIdx == i + 1) || (firstIdx == i + 1 && secondIdx == i)) {
                if (pq.peek()[1] >= meetingTime) {
                    ans = Math.max(ans, freeTimes + meetingTime);
                } else {
                    ans = Math.max(ans, freeTimes);
                }
            } else {
                if(firstIdx == i || firstIdx == i+1){
                    if(secondVal >= meetingTime){
                        ans = Math.max(ans, freeTimes + meetingTime);
                    }
                    else{
                        ans = Math.max(ans, freeTimes);
                    }
                }
                else{
                    if(firstVal >= meetingTime){
                        ans = Math.max(ans, freeTimes + meetingTime);
                    }
                    else{
                        ans = Math.max(ans, freeTimes);
                    }
                }
            }
            pq.offer(new int[] { firstIdx, firstVal });
            pq.offer(new int[] { secondIdx, secondVal });
        }
        return ans;
    }
}
