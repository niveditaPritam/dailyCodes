class Solution {
public:
    static const bool cmpY(vector<int> &a, vector<int> &b) {
        if (a[1] != b[1]) return a[1] < b[1];
        return a[3] < b[3];
    }
    static const bool cmpX(vector<int> &a, vector<int> &b) {
        if (a[0] != b[0]) return a[0] < b[0];
        return a[2] < b[2];
    }
    bool checkValidCuts(int sz, vector<vector<int>>& rectangles) {
        int n = rectangles.size();
        sort(rectangles.begin(), rectangles.end(), cmpY);
        int cnt = 0;
        int l = 0, r = 1;
        while (r < n) {
            while (rectangles[l][3] <= rectangles[r][1]) {
                l += 1;
            }
            cnt += l == r;
            if (cnt == 2) return true;
            r += 1;
        }

        sort(rectangles.begin(), rectangles.end(), cmpX);
        cnt = 0;
        l = 0, r = 1;
        while (r < n) {
            while (l < r && rectangles[l][0] < rectangles[r][0] && rectangles[l][2] <= rectangles[r][0]) {
                l += 1;
            }
            cnt += (l == r);
            if (cnt == 2) return true;
            r += 1;
        }
        return false;
    }
};
