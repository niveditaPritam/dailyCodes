class Solution {
    public int repeatedNTimes(int[] nums) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1; 
    }
}
