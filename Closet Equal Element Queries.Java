class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int q : queries) {
            int val = nums[q];
            List<Integer> list = map.get(val);

            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(list, q);

            int size = list.size();

            int prev = list.get((idx - 1 + size) % size);
            int next = list.get((idx + 1) % size);

            int distPrev = Math.min(Math.abs(q - prev), n - Math.abs(q - prev));
            int distNext = Math.min(Math.abs(q - next), n - Math.abs(q - next));

            result.add(Math.min(distPrev, distNext));
        }

        return result;
    }
}
