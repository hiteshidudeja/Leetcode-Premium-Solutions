class Solution {
public:
    int minimumDistance(int n, vector<vector<int>>& edges, int s, vector<int>& marked) {

        vector<vector<pair<int, int>>>graph(n);
        for(auto &edge : edges){
            int u = edge[0]; int v = edge[1]; int w = edge[2];
            graph[u].push_back({v, w});
        }
        vector<int>distance(n, INT_MAX);
        distance[s] = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>>pq;

        pq.push({0, s});

        while(!pq.empty()){
            auto [dist, node] = pq.top(); pq.pop();
            if(distance[node] != dist) continue;

            for(auto &x : graph[node]){
                if(distance[x.first] > dist + x.second){
                    distance[x.first] = dist + x.second;
                    pq.push({distance[x.first], x.first});
                }
            }
        }

        int result = INT_MAX;

        for(auto &node : marked){
            result = min(result, distance[node]);
        }

        return result == INT_MAX ? -1 : result;
    }
};