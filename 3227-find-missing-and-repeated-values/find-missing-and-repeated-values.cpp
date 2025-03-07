class Solution {
public:
    vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<int>result;
        vector<int>frequency(n * n + 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int num = grid[i][j];
                frequency[num]++;
                if(frequency[num] > 1) result.push_back(num);
            }
        }

        for(int i = 1; i <= n* n; i++){
            if(frequency[i] == 0){
                result.push_back(i); break;
            }
        }

        return result;
    }
};