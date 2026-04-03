class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int[][] z = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            z[i][0] = robots[i];
            z[i][1] = distance[i];
        }
        
        Arrays.sort(z, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(walls);

        int left = 0, right = 0, ri = 0;

        for (int i = 0; i < n; i++) {
            int robot = z[i][0];
            int dist = z[i][1];

            int prev = i == 0 ? 0 : z[i - 1][0];
            int nxt = i == n - 1 ? Integer.MAX_VALUE : z[i + 1][0];

            int l = lowerBound(walls, Math.max(prev + 1, robot - dist));
            int ml = upperBound(walls, robot);
            int mr = lowerBound(walls, robot);
            int r = upperBound(walls, Math.min(nxt - 1, robot + dist));

            int newLeft = Math.max(left + ml - l, right + ml - Math.max(l, ri));
            int newRight = Math.max(left, right) + r - mr;

            left = newLeft;
            right = newRight;
            ri = r;
        }

        return Math.max(left, right);
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
