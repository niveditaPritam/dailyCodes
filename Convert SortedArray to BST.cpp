class Solution { 
public:
    TreeNode* bst(vector<int>& nums, int left, int right) {
        if (left > right) return NULL;
        
        int mid = (left + right) / 2;

        TreeNode* root = new TreeNode(nums[mid]);

        root->left = bst(nums, left, mid - 1);
        root->right = bst(nums, mid + 1, right);

        return root;
    }

    TreeNode* sortedArrayToBST(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) return NULL;

        return bst(nums, 0, n - 1);
    }
};
