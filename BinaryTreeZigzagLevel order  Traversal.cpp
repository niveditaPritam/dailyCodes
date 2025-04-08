class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (root == NULL) return result;
        queue<TreeNode*> q;
        q.push(root);
        bool leftToRight = true;
        while (!q.empty()) {
            int size = q.size();
            vector<int> ans(size);
            for (int i = 0; i < size; i++) {
                TreeNode* frontNode = q.front();
                q.pop();
                int index = (leftToRight) ? i : (size - i - 1);
                ans[index] = frontNode->val;
                if (frontNode->left) q.push(frontNode->left);
                if (frontNode->right) q.push(frontNode->right);
            }
            result.push_back(ans);
            leftToRight = !leftToRight;
        }
        return result;
    }
};












