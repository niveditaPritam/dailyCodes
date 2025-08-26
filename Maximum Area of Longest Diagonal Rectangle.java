class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagSq = 0;
        int maxArea = 0;

        for (int[] d : dimensions) {
            int l = d[0], w = d[1];
            int diagSq = l*l + w*w;
            int area = l * w;

            if (diagSq > maxDiagSq) {
                maxDiagSq = diagSq;
                maxArea = area;
            } else if (diagSq == maxDiagSq) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
