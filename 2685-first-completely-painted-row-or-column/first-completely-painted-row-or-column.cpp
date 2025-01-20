class Solution {
public:
    int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {
        const int n = mat.size();
        const int m = mat[0].size();
        vector<pair<int, int>> v(n * m);
        for(int i = 0; i < n; ++i) for(int j = 0; j < m; ++j){
            v[mat[i][j]-1] = {i, j};
        }

        vector<int> rows(n), columns(m);

        for(int i = 0; i < arr.size(); ++i){
            auto &[x, y] = v[arr[i] - 1];
            if(++rows[x] == m || ++columns[y] == n) return i;
        }

        return -1;
    }
};