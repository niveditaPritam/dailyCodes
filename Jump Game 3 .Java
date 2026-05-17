class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            if (arr[curr] == 0) return true;
            
            if (visited[curr]) continue;
            visited[curr] = true;
            
            int forward = curr + arr[curr];
            if (forward < n) {
                queue.offer(forward);
            }
            
            int backward = curr - arr[curr];
            if (backward >= 0) {
                queue.offer(backward);
            }
        }
        
        return false;
    }
}
