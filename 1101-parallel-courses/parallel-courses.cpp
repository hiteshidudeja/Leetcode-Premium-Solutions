class Solution {
public:
    int minimumSemesters(int n, vector<vector<int>>& relations) {
        vector<int>inDegrees(n+1, 0);
        vector<vector<int>>adjList(n+1);
        for(auto relation : relations){
            int a = relation[0]; int b = relation[1];
            adjList[a].push_back(b);
            inDegrees[b]++;
        }

        queue<int>q;  vector<bool>visited(n+1 , false);

        for(int i = 1; i<=n; i++){
            if(inDegrees[i] == 0) {
                q.push(i);
            }
        }

        if(q.empty()) return -1; int courses = 0;

    
        while(!q.empty()){
            int sz = q.size();
            while(sz--){
                int course = q.front();
                visited[course] = true;
                q.pop();
                for(auto nxtCourse: adjList[course]){
                    inDegrees[nxtCourse]--;
                    if(inDegrees[nxtCourse] == 0) q.push(nxtCourse);
                }
            }

            courses++;
        }

        for(int i = 1; i <= n; i++){
            if(!visited[i]) return -1;
        }

        return courses;
    }
};