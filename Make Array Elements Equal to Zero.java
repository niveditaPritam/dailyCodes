class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (isValid(nums.clone(), i, 1)) ans++;
                if (isValid(nums.clone(), i, -1)) ans++;
            }
        }

        return ans;   
    }

    private boolean isValid(int[] nums, int curr, int dir) {
        int n = nums.length;

        while (curr >= 0 && curr < n) {
            if (nums[curr] == 0) {
                curr += dir;
            } else {
                nums[curr]--;
                dir *= -1;
                curr += dir;
            }
        }

        for (int x : nums) {
            if (x != 0) return false;
        }

        return true;
    }
}
