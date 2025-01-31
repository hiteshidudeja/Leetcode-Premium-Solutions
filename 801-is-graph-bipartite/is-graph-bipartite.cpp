class Solution {
private: 
    bool checkIfBipartite(int i, vector<vector<int>>& graph, vector<int>&color){
        queue<int>q;
        q.push(i); 
        color[i] = 1;
        while(!q.empty()){
            int front = q.front();
            q.pop();
            for(auto neighbour : graph[front]){
                if(color[neighbour] == color[front])
                    return false;
                if(color[neighbour] == -1)
                    {
                        color[neighbour] = 1 - color[front];
                        q.push(neighbour);
                    }
                }
            }
        
        return true;
        
    }
public:
    bool isBipartite(vector<vector<int>>& graph) {
        // colors array 
        int n = graph.size();
        vector<int>color(n, -1);
        for(int i = 0; i < n; i++){
            if(color[i] ==  -1 ){
                if(!checkIfBipartite(i, graph, color)) return false;
            }
        }

        return true;
        
    }
};