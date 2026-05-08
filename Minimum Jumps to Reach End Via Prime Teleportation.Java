class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        if (max >= 0) isPrime[0] = false;
        if (max >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int i = q.poll();

                if (i == n - 1) return steps;

                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }

                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }

                int val = nums[i];
                if (isPrime[val]) {
                    for (int multiple = val; multiple <= max; multiple += val) {
                        if (map.containsKey(multiple)) {
                            for (int idx : map.get(multiple)) {
                                if (!visited[idx]) {
                                    visited[idx] = true;
                                    q.offer(idx);
                                }
                            }
                        }
                    }
                    isPrime[val] = false;
                }
            }

            steps++;
        }

        return -1;
    }
}
