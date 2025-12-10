class Solution {
    static final long MOD = 1_000_000_007;

    public int countPermutations(int[] complexity) {
        int n = complexity.length;

        long result = 1;

        for (int i = 1; i < n; i++) {
            int count = 0;

            for (int j = 0; j < i; j++) {
                if (complexity[j] < complexity[i]) {
                    count++;
                }
            }

            if (count == 0) return 0;

            result = (result * count) % MOD;
        }

        return (int) result;
    }
}
