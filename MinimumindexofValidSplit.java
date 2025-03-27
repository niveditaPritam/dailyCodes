import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        if (n < 2) {
            return -1;
        }

        Map<Integer, Integer> countAll = new HashMap<>();
        int dominant = -1;
        int maxCountAll = 0;
        for (int num : nums) {
            countAll.put(num, countAll.getOrDefault(num, 0) + 1);
            if (countAll.get(num) > maxCountAll) {
                maxCountAll = countAll.get(num);
                dominant = num;
            }
        }

        if (maxCountAll <= n / 2) { 
            return -1;
        }

        Map<Integer, Integer> countLeft = new HashMap<>();
        int countDominantLeft = 0;
        for (int i = 0; i < n - 1; i++) {
            int currentNum = nums.get(i); 
            countLeft.put(currentNum, countLeft.getOrDefault(currentNum, 0) + 1);
            if (currentNum == dominant) {
                countDominantLeft++;
            }

            if (countDominantLeft > (i + 1) / 2) {
                int countDominantRight = maxCountAll - countDominantLeft;
                if (countDominantRight > (n - 1 - i) / 2) {
                    return i;
                }
            }
        }

        return -1;
    }
}
