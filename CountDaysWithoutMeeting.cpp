class Solution {
public:
    int countDays(int days, vector<vector<int>>& nums) {
        int unvisited = 0;
        vector <bool> visited(days,false);
        for (int i = 0 ; i < nums.size() ;i++) {
            for (int j = nums[i][0] ; j <= nums[i][1] ;j++) {
                visited[j-1] = true; // marking days
            }
        }
        int unmarked = 0;
        for (int i = 0 ; i < visited.size();i++)
        if (!visited[i]) unmarked++; // unmarked days left
        return unmarked;
    }
};
