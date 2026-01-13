class Solution {
    public double separateSquares(int[][] squares) {

        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }

        double totalArea = 0.0;
        for (int[] s : squares) {
            totalArea += (double) s[2] * s[2];
        }

        for (int i = 0; i < 80; i++) { 
            double mid = (low + high) / 2.0;
            double belowArea = 0.0;

            for (int[] s : squares) {
                double y = s[1];
                double l = s[2];

                if (mid <= y) {
                    continue;
                } else if (mid >= y + l) {
                    belowArea += l * l;
                } else {
                    belowArea += (mid - y) * l;
                }
            }

            if (belowArea * 2 < totalArea) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
