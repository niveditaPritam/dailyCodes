class Solution {
    public int minMirrorPairDistance(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (map.containsKey(num)) {
                res = Math.min(res, i - map.get(num));
            }

            int rev = reverseTheNumber(num);

            map.put(rev, i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int reverseTheNumber(int n) {

        int ans = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            ans = ans * 10 + lastDigit;
            n /= 10;
        }

        return ans;
    }
}
