class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int maxValueSoFar = 0;
        int answer = 0;

        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            int value = event[2];

            while (!pq.isEmpty() && pq.peek()[0] < start) {
                maxValueSoFar = Math.max(maxValueSoFar, pq.poll()[1]);
            }

            answer = Math.max(answer, maxValueSoFar + value);

            pq.offer(new int[]{end, value});
        }

        return answer;
    }
}
