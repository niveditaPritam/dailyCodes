class Solution {
public:
    vector<int> getRow(int rowIndex){
        vector<int>last_row ={1};
        for(int i=1;i<=rowIndex;i++){
            vector<int>curr(i+1,1);
            for (int j = 1; j<i; j++){
                curr[j] = last_row[j] +last_row[j-1];
            }
            last_row = curr;
        }
        return last_row;
        
    }
};
