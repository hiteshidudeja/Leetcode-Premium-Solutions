class TreeAncestor {
private:
    vector<vector<int>>v;
public:

    TreeAncestor(int n, vector<int>& parent) {
        v.assign(16, vector<int>(n, -1));
        for(int i = 0; i < n; i++){
            v[0][i] = parent[i];
        }

        for(int i = 1; i < 16; i++){
            for(int j = 0; j < n; j++){
                if(v[i - 1][j] != -1)
                    v[i][j] = v[i - 1][v[i - 1][j]];
            }
        }
    }
    
    // k <= 1e4
    // 1e4 < 2^10 . 2^4 = 2 ^14
    int getKthAncestor(int node, int k) {
        int result = node;
        for(int i = 0; i < 16; i++){
            if(k & 1){
                if(result != -1)
                    result = v[i][result];
                else return result;
            }

            k >>= 1;
        }

        return result;
    }
};

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor* obj = new TreeAncestor(n, parent);
 * int param_1 = obj->getKthAncestor(node,k);
 */