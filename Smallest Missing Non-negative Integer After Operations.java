class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> remainderCount = new HashMap<>();

        for (int num : nums) {
            int rem = ((num % value) + value) % value;
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }

        int i = 0;
        while (true)  {
            int rem = i % value;
            if (!remainderCount.containsKey(rem) || remainderCount.get(rem) == 0) {
                return i;
            }
            remainderCount.put(rem, remainderCount.get(rem) - 1);
            i++;
        }
        
    }
}
