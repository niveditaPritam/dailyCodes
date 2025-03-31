import java.util.*;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1 || k == n) {
            return 0;
        }

        List<Integer> adjacentSums = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            adjacentSums.add(weights[i] + weights[i + 1]);
        }

        Collections.sort(adjacentSums);

        long minScore = weights[0] + weights[n - 1];
        long maxScore = minScore; 

        for (int i = 0; i < k - 1; i++) {
            minScore += adjacentSums.get(i); 
            maxScore += adjacentSums.get(adjacentSums.size() - 1 - i); 
        }

        return maxScore - minScore;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] weights1 = {1, 3, 5, 1};
        int k1 = 2;
        long result1 = solution.putMarbles(weights1, k1);
        System.out.println("Example 1 Output: " + result1); 

        int[] weights2 = {1, 3, 5, 1, 8};
        int k2 = 3;
        long result2 = solution.putMarbles(weights2, k2);
        System.out.println("Example 2 Output: " + result2);
    }
}
