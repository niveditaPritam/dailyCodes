class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long mod = 1_000_000_007;

        HashMap<Integer, Integer> right = new HashMap<>();
        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0) + 1);
        }

        HashMap<Integer, Integer> left = new HashMap<>();
        long count = 0;

        for (int j = 0; j < n; j++) {
            int mid = nums[j];

            right.put(mid, right.get(mid) - 1);

            int target = mid * 2;

            long leftCount = left.getOrDefault(target, 0);
            long rightCount = right.getOrDefault(target, 0);

            count = (count + (leftCount * rightCount) % mod) % mod;

            left.put(mid, left.getOrDefault(mid, 0) + 1);
        }

        return (int) count;
    }
}
