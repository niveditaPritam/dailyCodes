class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        int n = nums.size();
        int min_ops = n / 3 + (n % 3 != 0); // Maximum possible operations

        for (int k = 0; k <= n / 3; ++k) {
            unordered_set<int> distinct_elements;
            int remaining_elements = n - 3 * k;
            bool distinct = true;

            for (int i = k * 3; i < n; ++i) {
                if (distinct_elements.count(nums[i])) {
                    distinct = false;
                    break;
                }
                distinct_elements.insert(nums[i]);
            }

            if (distinct) {
                min_ops = min(min_ops, k);
            }
        }

        return min_ops;
    }
};

        
