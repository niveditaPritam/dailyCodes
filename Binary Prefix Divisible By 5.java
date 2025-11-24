class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int currentValue = 0;

        for (int bit : nums) {
            currentValue = (currentValue * 2 + bit) % 5;

            result.add(currentValue == 0);
        }
        return result;    
    }
}
