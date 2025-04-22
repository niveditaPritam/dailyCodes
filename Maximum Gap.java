class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        if (maxVal == minVal) {
            return 0;
        }

        int gap = (int) Math.ceil((double) (maxVal - minVal) / (n - 1));
        int[] bucketsMin = new int[n - 1];
        int[] bucketsMax = new int[n - 1];
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);

        for (int num : nums) {
            if (num == minVal || num == maxVal) {
                continue;
            }
                        int bucketIndex = (num - minVal) / gap;
            bucketsMin[bucketIndex] = Math.min(bucketsMin[bucketIndex], num);
            bucketsMax[bucketIndex] = Math.max(bucketsMax[bucketIndex], num);
        }

        int maxGap = 0;
        int previous = minVal;
        for (int i = 0; i < n - 1; i++) {
            if (bucketsMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketsMin[i] - previous);
            previous = bucketsMax[i];
        }
        maxGap = Math.max(maxGap, maxVal - previous);

        return maxGap;
    }
}




        
    
