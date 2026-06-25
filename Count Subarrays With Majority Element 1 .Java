class Solution {

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int idx = 1;
        for (int x : sorted) {
            if (!rank.containsKey(x)) {
                rank.put(x, idx++);
            }
        }

        Fenwick bit = new Fenwick(idx + 2);

        long ans = 0;

        bit.update(rank.get(prefix[0]), 1);

        for (int i = 1; i <= n; i++) {
            int r = rank.get(prefix[i]);

            ans += bit.query(r - 1);

            bit.update(r, 1);
        }

        return (int) ans;
    }
}
