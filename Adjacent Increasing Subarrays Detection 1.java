class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int count = 1;

        int[] inc = new int[n];
        inc[0] = 1;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }

        for (int i = k; i < n; i++) {
            if (inc[i - 1] >= k && inc[i + k - 1 < n ? i + k - 1 : n - 1] >= k) {
                if (i + k - 1 < n) {
                    boolean ok = true;
                    for (int j = i + 1; j < i + k && j < n; j++) {
                        if (nums.get(j) <= nums.get(j - 1)) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) return true;
                }
            }
        }
        return false;    
    }
}
