class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        Map<String, List<int[]>> slopeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;

                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = 1;
                }

                String key = dx + "," + dy;
                slopeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        long total = 0;

        for (List<int[]> segs : slopeMap.values()) {
            int k = segs.size();
            if (k < 2) continue;

            long combinations = (long) k * (k - 1) / 2;

            int[] freq = new int[n];
            for (int[] s : segs) {
                freq[s[0]]++;
                freq[s[1]]++;
            }

            long bad = 0;
            for (int count : freq) {
                if (count > 1)
                    bad += (long) count * (count - 1) / 2;
            }

            total += (combinations - bad);
        }

        return (int) total;
    }

    private int gcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }
}
