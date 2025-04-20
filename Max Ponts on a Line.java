class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int maxPoints = 2; 

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int currentPoints = 2; 

                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        if (isOnSameLine(points[i], points[j], points[k])) {
                            currentPoints++;
                        }
                    }
                }

                                maxPoints = Math.max(maxPoints, currentPoints);
            }
        }

        return maxPoints;
    }

    private boolean isOnSameLine(int[] p1, int[] p2, int[] p3) {
        return (p2[1] - p1[1]) * (p3[0] - p1[0]) == (p3[1] - p1[1]) * (p2[0] - p1[0]);
    }
}



