class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> currentCombination;
        findCombinations(candidates, target, 0, currentCombination, result);
        return result;
    }

private:
    void findCombinations(vector<int>& candidates, int target, int start, vector<int>& currentCombination, vector<vector<int>>& result) {
        if (target == 0) {
            result.push_back(currentCombination);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.size(); ++i) {
            currentCombination.push_back(candidates[i]);
            findCombinations(candidates, target - candidates[i], i, currentCombination, result);
            currentCombination.pop_back();
        }
        
    }
};
