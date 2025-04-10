class Solution {
public:
    bool b = false; 

    void preorder(int s, int targetSum, TreeNode* root) {
        if (!root) return; 

        s += root->val;

        if (!root->left && !root->right) {
            if (s == targetSum) {
                b = true; 
            }
        }

        preorder(s, targetSum, root->left);
        preorder(s, targetSum, root->right);
    }

    bool hasPathSum(TreeNode* root, int targetSum) {
        int s =0;
        preorder(s, targetSum, root); 
        return b; 
    }
};
