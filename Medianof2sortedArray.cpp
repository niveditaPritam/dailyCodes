#include <vector>
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ans;
        int i = 0, j = 0;
        int totalSize = nums1.size() + nums2.size();
        int n = totalSize / 2;

        while (i < nums1.size() && j < nums2.size() && ans.size() <= n) {
            if (nums1[i] > nums2[j]) {
                ans.push_back(nums2[j]);
                j++;
            } else {
                ans.push_back(nums1[i]);
                i++;
            }
        }

        while (i < nums1.size() && ans.size() <= n) {
            ans.push_back(nums1[i]);
            i++;
        }

        while (j < nums2.size() && ans.size() <= n) {
            ans.push_back(nums2[j]);
            j++;
        }

        if (totalSize % 2 == 0) { 
            return (double)(ans[n] + ans[n - 1]) / 2;
        } else { 
            return ans[n];
        }
    }
};
