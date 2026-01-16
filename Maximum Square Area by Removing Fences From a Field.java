class Solution {
    private static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[1] = m;
        v[0] = 1;
        v[1] = n;

        for (int i = 0; i < hFences.length; i++)
            h[i + 2] = hFences[i];

        for (int i = 0; i < vFences.length; i++)
            v[i + 2] = vFences[i];

        Arrays.sort(h);
        Arrays.sort(v);

        Set<Integer> hGaps = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                hGaps.add(h[j] - h[i]);
            }
        }

        long maxSide = 0;

        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int gap = v[j] - v[i];
                if (hGaps.contains(gap)) {
                    maxSide = Math.max(maxSide, gap);
                }
            }
        }

        if (maxSide == 0) return -1;

        return (int) ((maxSide * maxSide) % MOD);
    }
}
