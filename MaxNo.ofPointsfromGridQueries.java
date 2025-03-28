class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int k = queries.length;
        int[] answer = new int[k];

        Integer[] qIndices = new Integer[k];
        for (int i = 0; i < k; i++) {
            qIndices[i] = i;
        }

        Arrays.sort(qIndices, Comparator.comparingInt(i -> queries[i]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); 
        pq.offer(new int[]{grid[0][0], 0, 0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int points = 0;
        int qIndex = 0;

        while (qIndex < k) {
            int currentQueryIndex = qIndices[qIndex];
            int currentQueryValue = queries[currentQueryIndex];

            while (!pq.isEmpty() && pq.peek()[0] < currentQueryValue) {
                int[] current = pq.poll();
                int val = current[0];
                int r = current[1];
                int c = current[2];
                points++;

                int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if (newR >= 0 && newR < m && newC >= 0 && newC < n && !visited[newR][newC]) {
                        visited[newR][newC] = true;
                        pq.offer(new int[]{grid[newR][newC], newR, newC});
                    }
                }
            }
            answer[currentQueryIndex] = points;
            qIndex++;
        }

        return answer;
    }
}

        
